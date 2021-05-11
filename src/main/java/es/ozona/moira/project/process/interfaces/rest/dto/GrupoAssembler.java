package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import es.ozona.moira.project.process.model.entities.Grupo;


public class GrupoAssembler {

	private GrupoAssembler() {}
	
	public static Grupo buildFromResource(GrupoResource resource) {
		if(resource == null)
			return null;
		
		final Grupo grupo = new Grupo(resource.getId());
		grupo.setEntidad(EntidadAssembler.buildFromResource(resource.getEntidad()));
		grupo.setFechaCreacion(resource.getFechaCreacion());
		grupo.setFechaModificacion(resource.getFechaModificacion());
		grupo.setNombre(resource.getNombre());
		grupo.setMiembro(Set.copyOf(MiembroAssembler.buildFromResources(Lists.newArrayList(resource.getMiembros()))));
		
		return grupo;
	}
	
	public static List<Grupo> buildFromResources(List<GrupoResource> resources){
		return resources.stream().map(g -> GrupoAssembler.buildFromResource(g)).collect(Collectors.toList());
	}
	
	public static GrupoResource buildFromEntity(Grupo grupo) {
		if (grupo == null)
			return null;
		
		final GrupoResource res = new GrupoResource(grupo.getId());
		res.setNombre(grupo.getNombre());
		res.setFechaCreacion(grupo.getFechaCreacion());
		res.setFechaModificacion(grupo.getFechaModificacion());
		
		return res;
	}
	
	public static final List<GrupoResource> buildFromEntities(List<Grupo> grupos) {
		return grupos.stream().map(g -> GrupoAssembler.buildFromEntity(g)).collect(Collectors.toList());
	}
}
