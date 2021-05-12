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

public class GrupoControllerTest extends AbstractTest {
	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test 
	public void save() throws Exception {
		GrupoResource res = new GrupoResource(3L);
		res.setEntidad(new EntidadResource(1L));
		res.setNombre("Nuevo grupo");
		res.setFechaCreacion(new Date());
		res.setFechaModificacion(new Date());
		
		 String inputJson = super.mapToJson(res);
		
		String uri = "/api/v1/grupos/save";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
		        .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      
	}
	
	@Test
	public void get() throws Exception {
		String uri = "/api/v1/grupos/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      GrupoResource gr = super.mapFromJson(content,GrupoResource.class);
	      assertEquals(gr.getNombre(), "Responsable tecnico");
	}
}
