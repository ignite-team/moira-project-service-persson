package es.ozona.moira.project.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.ozona.moira.project.process.interfaces.rest.dto.EntidadResource;

public class EntidadControllerTest extends AbstractTest{

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test 
	public void save() throws Exception {
		EntidadResource res = new EntidadResource(3L);
		res.setPadre(null);
		res.setCodigo("new_ozona");
		res.setNombre("New_Ozona");
		res.setFechaCreacion(new Date());
		res.setFechaModificacion(new Date());
		
		 String inputJson = super.mapToJson(res);
		
		String uri = "/api/v1/entidades/save";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
		        .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      
	}
	
	@Test
	public void get() throws Exception {
		String uri = "/api/v1/entidades/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      EntidadResource ent = super.mapFromJson(content,EntidadResource.class);
	      assertEquals(ent.getNombre(), "Ozona");
	}
}
