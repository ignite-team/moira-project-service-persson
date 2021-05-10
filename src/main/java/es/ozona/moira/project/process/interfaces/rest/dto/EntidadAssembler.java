package es.ozona.moira.project.process.interfaces.rest.dto;

import es.ozona.moira.project.process.model.entities.Entidad;

public class EntidadAssembler {

	private EntidadAssembler() {

	}

	public static final Entidad buildFromResource() {
		return null;
	}

	public static final EntidadResource buildFromEntity(Entidad entidad) {
		if (entidad == null)
			return null;

		final EntidadResource res = new EntidadResource(entidad.getId());
		res.setNombre(entidad.getNombre());
		res.setFechaCreacion(entidad.getFechaCreacion());
		res.setFechaModificacion(entidad.getFechaModificacion());

		return res;
	}

}
