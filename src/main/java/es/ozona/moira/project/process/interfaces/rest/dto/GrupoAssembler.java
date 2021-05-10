package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import es.ozona.moira.project.process.model.entities.Grupo;


public class GrupoAssembler {

	private GrupoAssembler() {}
	
	public static GrupoResource buildFromEntity(Grupo grupo) {
		if (grupo == null)
			return null;
		
		final GrupoResource res = new GrupoResource(grupo.getId());
		res.setNombre(grupo.getNombre());
		res.setFechaCreacion(grupo.getFechaCreacion());
		res.setFechaModificacion(grupo.getFechaModificacion());
		res.setPersonas(grupo.getPersonas());
		
		return res;
	}
	
	public static final List<GrupoResource> buildFromEntities(List<Grupo> grupos) {
		return grupos.stream().map(g -> GrupoAssembler.buildFromEntity(g)).collect(Collectors.toList());
	}
}
