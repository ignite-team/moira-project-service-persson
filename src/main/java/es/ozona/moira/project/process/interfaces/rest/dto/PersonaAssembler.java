package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import es.ozona.moira.project.process.model.entities.Persona;


public class PersonaAssembler {

	private PersonaAssembler() {}
	
	public static PersonaResource buildFromEntity(Persona persona) {
		if (persona == null)
			return null;
		
		final PersonaResource res = new PersonaResource(persona.getId());
		res.setActivo(persona.getActivo());
		res.setCorreo(persona.getCorreo());
		res.setEntidad(EntidadAssembler.buildFromEntity(persona.getEntidad()));
		res.setFechaBaja(persona.getFechaBaja());
		res.setFechaModificacion(persona.getFechaModificacion());
		res.setFechaRegistro(persona.getFechaRegistro());
		res.setGrupos(new HashSet<>(GrupoAssembler.buildFromEntities(new ArrayList<>(persona.getGrupos()))));
		res.setNombre(persona.getNombre());
		res.setTelefono(persona.getTelefono());
		
		return res;
	}
	
	public static final List<PersonaResource> buildFromEntities(List<Persona> personas) {
		return personas.stream().map(p -> PersonaAssembler.buildFromEntity(p)).collect(Collectors.toList());
	}
	
}
