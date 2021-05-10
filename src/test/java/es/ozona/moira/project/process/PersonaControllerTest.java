package es.ozona.moira.project.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.ozona.moira.project.process.infrastructure.repositories.PersonaRepository;
import es.ozona.moira.project.process.interfaces.rest.PersonaController;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;

@SpringBootTest
public class PersonaControllerTest {

	@Autowired
	public PersonaController personaController;
	
	@MockBean
	public PersonaRepository personaRepository;
	
	Date date;
	
	@BeforeEach
	public void setup() {
		Grupo gr = new Grupo(1L, "Administrador", new Date(), new Date());
		Entidad ent = new Entidad("Ozona", new Date(), new Date());
		ent.setId(1L);
		date = new Date();
		Persona pers = new Persona("nombre", "telefono", "correo", true, date, date, null, ent, Set.of(gr));
		pers.setId(1L);
		personaRepository.save(pers);
		Mockito.when(personaRepository.findByEntidadAndGrupos(Mockito.any(), Mockito.any())).thenReturn(List.of(pers));
	}
	
	@Test
	public void HttpOkNotResults() throws Exception {
		ResponseEntity<List<PersonaResource>> response = personaController.list(1L, 1L);
				
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void CorrectContent() throws Exception {
		ResponseEntity<List<PersonaResource>> response = personaController.list(1L, 1L);
		List<PersonaResource> content = response.getBody();
		PersonaResource persona = content.get(0);
		
		assertTrue(content.size()==1);
		assertEquals(persona.getNombre(), "nombre");
		assertEquals(persona.getTelefono(), "telefono");
		assertEquals(persona.getCorreo(), "correo");
		assertEquals(persona.getFechaRegistro(), date);
		assertEquals(persona.getFechaModificacion(), date);
		assertEquals(persona.getFechaBaja(), null);
		assertEquals(persona.getEntidad().getId(), 1L);
		assertEquals(persona.getGrupos().size() ,1);
	}
}
