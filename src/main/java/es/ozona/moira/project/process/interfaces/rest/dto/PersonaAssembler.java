package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import es.ozona.moira.project.process.model.entities.Persona;


public class PersonaAssembler {

	private PersonaAssembler() {}
	
	public static Persona buildFromResource(PersonaResource resource) {
		if(resource == null)
			return null;
		
		final Persona persona = new Persona(resource.getId());	
		persona.setActivo(resource.getActivo());
		persona.setApellidos(resource.getApellidos());
		persona.setCorreo(resource.getCorreo());
		persona.setEntidad(EntidadAssembler.buildFromResource(resource.getEntidad()));
		persona.setFechaBaja(resource.getFechaBaja());
		persona.setFechaCreacion(resource.getFechaCreacion());
		persona.setFechaModificacion(resource.getFechaModificacion());
		persona.setMiembro(Set.copyOf(MiembroAssembler.buildFromResources(Lists.newArrayList(resource.getMiembros()))));
		persona.setNombre(resource.getNombre());
		persona.setNombre_completo(resource.getNombre_completo());
		persona.setTelefono(resource.getTelefono());

		return persona;
	}
	
	public static List<Persona> buildFromResources(List<PersonaResource> resources) {
		return resources.stream().map(p -> PersonaAssembler.buildFromResource(p)).collect(Collectors.toList());
	}
	
	public static PersonaResource buildFromEntity(Persona persona) {
		PersonaResource res = buildFromEntityNonMembers(persona);
		res.setMiembros(Set.copyOf(MiembroAssembler.buildFromEntities(Lists.newArrayList(persona.getMiembro()))));
		
		return res;
	}
	
	public static PersonaResource buildFromEntityNonMembers(Persona persona) {
		if (persona == null)
			return null;
		
		final PersonaResource res = new PersonaResource(persona.getId());
		res.setNombre_completo(persona.getNombre_completo());
		res.setApellidos(persona.getApellidos());
		res.setActivo(persona.getActivo());
		res.setCorreo(persona.getCorreo());
		res.setEntidad(EntidadAssembler.buildFromEntity(persona.getEntidad()));
		res.setFechaBaja(persona.getFechaBaja());
		res.setFechaModificacion(persona.getFechaModificacion());
		res.setFechaCreacion(persona.getFechaCreacion());
		res.setNombre(persona.getNombre());
		res.setTelefono(persona.getTelefono());
		
		return res;
	}
	
	public static final List<PersonaResource> buildFromEntities(List<Persona> personas) {
		return personas.stream().map(p -> PersonaAssembler.buildFromEntity(p)).collect(Collectors.toList());
	}
	
}
