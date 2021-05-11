package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Miembro;

public class MiembroAssembler {
	
	public static Miembro buildFromResource(MiembroResource resource) {
		if(resource == null)
			return null;
		
		final Miembro miembro = new Miembro(resource.getId());
		miembro.setFechaAlta(resource.getFechaAlta());
		miembro.setFechaBaja(resource.getFechaBaja());
		miembro.setFechaCreacion(resource.getFechaCreacion());
		miembro.setFechaModificacion(resource.getFechaModificacion());
		miembro.setGrupo(GrupoAssembler.buildFromResource(resource.getGrupo()));
		miembro.setPersona(PersonaAssembler.buildFromResource(resource.getPersona()));
		
		return miembro;
	}
	
	public static List<Miembro> buildFromResources(List<MiembroResource> resources){
		return resources.stream().map(s -> MiembroAssembler.buildFromResource(s)).collect(Collectors.toList());
	}

	public static MiembroResource buildFromEntity(Miembro miembro) {
		if (miembro == null)
			return null;
		
		final MiembroResource res = new MiembroResource(miembro.getId());
		res.setFechaCreacion(miembro.getFechaCreacion());
		res.setFechaModificacion(miembro.getFechaModificacion());
		res.setFechaAlta(miembro.getFechaAlta());
		res.setFechaBaja(miembro.getFechaBaja());
		
		return res;
	}
	
	public static final List<MiembroResource> buildFromEntities(List<Miembro> miembros) {
		return miembros.stream().map(m ->MiembroAssembler.buildFromEntity(m)).collect(Collectors.toList());
	}
}
