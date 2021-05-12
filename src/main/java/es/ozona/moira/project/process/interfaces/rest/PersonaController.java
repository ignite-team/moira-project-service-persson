package es.ozona.moira.project.process.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.ozona.moira.project.process.infrastructure.repositories.PersonaRepository;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaAssembler;
import es.ozona.moira.project.process.interfaces.rest.dto.PersonaResource;
import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;
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
@Api(value = "Persona Service API.", tags = "API de personas")
@SwaggerDefinition(tags = { @Tag(name = "API de personas.", description = "Operaciones para consulta y gestión de personas.") })
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@PutMapping("/personas/save")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Guarda la persona dada.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<PersonaResource> save(@RequestBody(required = true) PersonaResource persona) {
		if(persona == null)
			return ResponseEntity.badRequest().build();
		
		Persona per = PersonaAssembler.buildFromResource(persona);
		
		Persona result = personaRepository.save(per);
		
		return ResponseEntity.ok(PersonaAssembler.buildFromEntity(result));
	}
	
	@GetMapping("/personas/search")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Lista las personas de un grupo.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<List<PersonaResource>> list(@ApiParam(required = true) @RequestParam(name = "identidad", defaultValue = "1") Long idEntidad,
			@ApiParam(required = false) @RequestParam(name = "idgrupo", required = true) Long idGrupo) {

		Grupo grupo = new Grupo(idGrupo);
		Entidad entidad = new Entidad(idEntidad);
		
		List<PersonaResource> resource = PersonaAssembler.buildFromEntities(personaRepository.findByEntidadAndMiembros_Grupo(entidad, grupo));

		return ResponseEntity.ok(resource);

	}
	
	@GetMapping("/personas/searchByEntidad")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Lista las personas de un grupo.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<List<PersonaResource>> listByEntidad(@ApiParam(required = true) @RequestParam(name = "identidad", defaultValue = "1") Long idEntidad) {

		Entidad entidad = new Entidad(idEntidad);
		
		List<PersonaResource> resource = PersonaAssembler.buildFromEntities(personaRepository.findByEntidad(entidad));

		return ResponseEntity.ok(resource);

	}
	
	@GetMapping("/personas/searchByGrupo")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Lista las personas de un grupo.", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = PersonaResource.class), @ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<List<PersonaResource>> listByGrupo(@ApiParam(required = true) @RequestParam(name = "idgrupo", required = true) Long idGrupo) {

		Grupo grupo = new Grupo(idGrupo);
		
		List<PersonaResource> resource = PersonaAssembler.buildFromEntities(personaRepository.findByMiembros_Grupo(grupo));

		return ResponseEntity.ok(resource);

	}
}
