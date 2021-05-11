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

import es.ozona.moira.project.process.infrastructure.repositories.MiembroRepository;
import es.ozona.moira.project.process.interfaces.rest.dto.MiembroAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.MiembroResource;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Miembro;
import es.ozona.moira.project.process.model.entities.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Guarda el miembro dado.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MiembroResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<MiembroResource> save(@RequestBody(required = true) MiembroResource miembro) {
		if( miembro == null)
			return ResponseEntity.badRequest().build();
		
		Miembro mb = MiembroAssembler.buildFromResource(miembro);
		
		Miembro result =  miembroRepository.save(mb);
		
		return ResponseEntity.ok(MiembroAssembler.buildFromEntity(mb));
	}
}
