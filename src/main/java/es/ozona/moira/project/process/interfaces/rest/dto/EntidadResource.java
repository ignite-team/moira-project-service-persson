package es.ozona.moira.project.process.interfaces.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class EntidadResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5763452524387389593L;

	@NotNull
	private Long id;

	@NotEmpty
	private String nombre;

	private Date fechaCreacion;

	private Date fechaModificacion;


	public EntidadResource() {

	}

	public EntidadResource(String nombre, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public EntidadResource(Long idEntidad) {
		this.setId(idEntidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
