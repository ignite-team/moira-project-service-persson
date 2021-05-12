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

import es.ozona.moira.project.process.infrastructure.repositories.MiembroRepository;
import es.ozona.moira.project.process.interfaces.rest.dto.GrupoAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.GrupoResource;
import es.ozona.moira.project.process.interfaces.rest.dto.MiembroAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.MiembroResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Miembro;
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
@Api(value = "Miembro Service API.", tags = "API de miembros")
@SwaggerDefinition(tags = { @Tag(name = "API de miembros.", description = "Operaciones para gestión de miembros.") })
public class MiembroController {
	
	@Autowired
	public MiembroRepository miembroRepository;
	
	@PutMapping("/miembros/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Guarda el miembro dado.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED", response = MiembroResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<MiembroResource> save(@RequestBody(required = true) MiembroResource miembro) {
		if( miembro == null)
			return ResponseEntity.badRequest().build();
		
		Miembro mb = MiembroAssembler.buildFromResource(miembro);
		
		Miembro result =  miembroRepository.save(mb);
		
		return ResponseEntity.created(URI.create("/miembros/" + result.getId())).build();
	}
	
	@GetMapping("/miembros/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Obten miembro por id.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "Not Found") })
	public ResponseEntity<MiembroResource> get(@ApiParam(required = true) @PathVariable(required = true) Long id) {
		
		Miembro miembro = miembroRepository.findById(id).get();
		
		if(miembro == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(MiembroAssembler.buildFromEntity(miembro));

	}
}
