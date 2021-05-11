package es.ozona.moira.project.process.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.ozona.moira.project.process.infrastructure.repositories.GrupoRepository;
import es.ozona.moira.project.process.interfaces.rest.dto.GrupoAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.GrupoResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Grupo Service API.", tags = "API de grupos")
@SwaggerDefinition(tags = { @Tag(name = "API de grupos.", description = "Operaciones para gestión de grupos.") })
public class GrupoController {
	
	@Autowired
	public GrupoRepository grupoRepository;
	
	@PutMapping("/grupos/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Guarda el grupo dada.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = GrupoResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<GrupoResource> save(@RequestBody(required = true) GrupoResource grupo) {
		if(grupo == null)
			return ResponseEntity.badRequest().build();
		
		Grupo gr = GrupoAssembler.buildFromResource(grupo);
		
		Grupo result = grupoRepository.save(gr);
		
		return ResponseEntity.ok(GrupoAssembler.buildFromEntity(result));
	}
}
