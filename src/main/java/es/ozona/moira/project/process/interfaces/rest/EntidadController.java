package es.ozona.moira.project.process.interfaces.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.ozona.moira.project.process.infrastructure.repositories.EntidadRepository;
import es.ozona.moira.project.process.interfaces.rest.dto.EntidadAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.EntidadResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Entidad Service API.", tags = "API de entidades")
@SwaggerDefinition(tags = { @Tag(name = "API de entidades.", description = "Operaciones para gestión de entidades.") })
public class EntidadController {
	
	@Autowired
	public EntidadRepository entidadRepository;
	
	@PutMapping("/entidades/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Guarda la entidad dada.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED", response = EntidadResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<EntidadResource> save(@RequestBody(required = true) EntidadResource entidad) {
		if(entidad == null)
			return ResponseEntity.badRequest().build();
		
		Entidad ent = EntidadAssembler.buildFromResource(entidad);
		
		Entidad result = entidadRepository.save(ent);
		
		return ResponseEntity.created(URI.create("/personas/" + result.getId())).build();
	}
	
	@GetMapping("/entidades/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Obten entidad por id.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "Not Found") })
	public ResponseEntity<EntidadResource> get(@ApiParam(required = true) @PathVariable(required = true) Long id) {
		
		Entidad entidad = entidadRepository.findById(id).get();
		
		if(entidad == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(EntidadAssembler.buildFromEntity(entidad));

	}
}
