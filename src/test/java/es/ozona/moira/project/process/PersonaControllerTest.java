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
import org.junit.Before;
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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.ozona.moira.project.process.infrastructure.repositories.PersonaRepository;
import es.ozona.moira.project.process.interfaces.rest.PersonaController;
import es.ozona.moira.project.process.interfaces.rest.dto.EntidadResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;

//@Sql({"data/data.sql"})
public class PersonaControllerTest extends AbstractTest{	
	
	@Override
	@BeforeEach
	public void setUp() {
	   super.setUp();
	}
	
	@Test 
	public void save() throws Exception {
		PersonaResource res = new PersonaResource(4L);
		res.setNombre("Alberto");
		res.setApellidos("Perez");
		res.setNombre_completo("Alberto Perez");
		res.setCorreo("alberto.perez@ozona.es");
		res.setTelefono("666666666");
		res.setActivo(true);
		res.setFechaBaja(null);
		res.setFechaCreacion(new Date());
		res.setFechaModificacion(new Date());
		res.setEntidad(new EntidadResource(1L));
		
		 String inputJson = super.mapToJson(res);
		
		String uri = "/api/v1/personas/save";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
		        .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      
	}
	
	@Test
	public void get() throws Exception {
		String uri = "/api/v1/personas/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      PersonaResource persona = super.mapFromJson(content, PersonaResource.class);
	      assertEquals(persona.getNombre_completo(), "Juan Marino");
	}
	
	@Test
	public void getByEntidadAndGrupo() throws Exception {
		String uri = "/api/v1/personas/search?identidad=1&idgrupo=1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println();
	      PersonaResource[] personaList = super.mapFromJson(content, PersonaResource[].class);
	      assertTrue(personaList.length > 0);
	}
	
	@Test
	public void getByGrupo() throws Exception {
		String uri = "/api/v1/personas/searchByGrupo?idgrupo=1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println();
	      PersonaResource[] personaList = super.mapFromJson(content, PersonaResource[].class);
	      assertTrue(personaList.length > 0);
	}
	
	@Test
	public void getByEntidad() throws Exception {
		String uri = "/api/v1/personas/searchByEntidad?identidad=1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println();
	      PersonaResource[] personaList = super.mapFromJson(content, PersonaResource[].class);
	      assertTrue(personaList.length > 0);
	}
}
