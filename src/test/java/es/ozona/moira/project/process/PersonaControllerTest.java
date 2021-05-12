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
