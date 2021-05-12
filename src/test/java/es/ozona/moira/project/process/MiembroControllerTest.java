package es.ozona.moira.project.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.ozona.moira.project.process.interfaces.rest.dto.EntidadResource;
import es.ozona.moira.project.process.interfaces.rest.dto.GrupoResource;
import es.ozona.moira.project.process.interfaces.rest.dto.MiembroResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;

public class MiembroControllerTest extends AbstractTest{
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test 
	public void save() throws Exception {
		MiembroResource res = new MiembroResource(5L);
		res.setPersona(new PersonaResource(1L));
		res.setGrupo(new GrupoResource(1L));
		res.setFechaAlta(new Date());
		res.setFechaBaja(null);
		res.setFechaCreacion(new Date());
		res.setFechaModificacion(new Date());
		
		 String inputJson = super.mapToJson(res);
		
		String uri = "/api/v1/miembros/save";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
		        .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      
	}
	
	@Test
	public void get() throws Exception {
		String uri = "/api/v1/miembros/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      MiembroResource m = super.mapFromJson(content,MiembroResource.class);
	      assertEquals(m.getId(), 1);
	      assertEquals(m.getPersona().getId(), 1);
	      assertEquals(m.getGrupo().getId(), 1);
	}
}
