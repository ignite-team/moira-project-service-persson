package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Persona;

public class EntidadAssembler {

	private EntidadAssembler() {

	}

	public static final Entidad buildFromResource(EntidadResource resource) {
		if(resource == null)
			return null;
		
		final Entidad entidad = new Entidad(resource.getId());
		entidad.setCodigo(resource.getCodigo());
		entidad.setFechaCreacion(resource.getFechaCreacion());
		entidad.setFechaModificacion(resource.getFechaModificacion());
		entidad.setId(resource.getId());
		entidad.setNombre(resource.getNombre());
		entidad.setPadre(EntidadAssembler.buildFromResource(resource.getPadre()));
		entidad.setPersonas(Set.copyOf(PersonaAssembler.buildFromResources(Lists.newArrayList(resource.getPersonas()))));
		entidad.setGrupos(Set.copyOf(GrupoAssembler.buildFromResources(Lists.newArrayList(resource.getGrupos()))));
		entidad.setEntidades(Set.copyOf(EntidadAssembler.buildFromResources(Lists.newArrayList(resource.getEntidades()))));
		
		
		return entidad;
	}
	
	public static final List<Entidad> buildFromResources(List<EntidadResource> resource) {
		return resource.stream().map(p -> EntidadAssembler.buildFromResource(p)).collect(Collectors.toList());
	}

	public static final EntidadResource buildFromEntity(Entidad entidad) {
		if (entidad == null)
			return null;

		final EntidadResource res = new EntidadResource(entidad.getId());
		res.setNombre(entidad.getNombre());
		res.setCodigo(entidad.getCodigo());
		res.setFechaCreacion(entidad.getFechaCreacion());
		res.setFechaModificacion(entidad.getFechaModificacion());
		res.setPadre(EntidadAssembler.buildFromEntity(entidad.getPadre()));

		return res;
	}
	

}
