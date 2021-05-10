package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import es.ozona.moira.project.process.model.entities.Persona;


public class PersonaAssembler {

	private PersonaAssembler() {}
	
	public static PersonaResource buildFromEntity(Persona persona) {
		if (persona == null)
			return null;
		
		final PersonaResource res = new PersonaResource(persona.getId());
		res.setActivo(persona.getActivo());
		res.setCorreo(persona.getCorreo());
		res.setEntidad(persona.getEntidad());
		res.setFechaBaja(persona.getFechaBaja());
		res.setFechaModificacion(persona.getFechaModificacion());
		res.setFechaRegistro(persona.getFechaRegistro());
		res.setGrupos(persona.getGrupos());
		res.setNombre(persona.getNombre());
		res.setTelefono(persona.getTelefono());
		
		return res;
	}
	
	public static final List<PersonaResource> buildFromEntities(List<Persona> personas) {
		return personas.stream().map(p -> PersonaAssembler.buildFromEntity(p)).collect(Collectors.toList());
	}
	
}
