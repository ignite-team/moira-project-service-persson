package es.ozona.moira.project.process.interfaces.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Miembro;
import es.ozona.moira.project.process.model.entities.Persona;


public class GrupoResource implements Serializable{


	@Id
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	private Date fechaCreacion;
	
	private Date fechaModificacion;
	
	private Set<MiembroResource> miembros = new HashSet(0);
	
	@NotNull
	private EntidadResource entidad;

	public GrupoResource() {
		super();
	}

	public GrupoResource(Long id) {
		super();
		this.id = id;
	}

	public GrupoResource(@NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion, Set<MiembroResource> miembro,
			@NotNull EntidadResource entidad) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.miembros = miembro;
		this.entidad = entidad;
	}

	public GrupoResource(Long id, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion, Set<MiembroResource> miembro,
			@NotNull EntidadResource entidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.miembros = miembro;
		this.entidad = entidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<MiembroResource> getMiembros() {
		return miembros;
	}

	public void setMiembros(Set<MiembroResource> miembros) {
		this.miembros = miembros;
	}

	public EntidadResource getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadResource entidad) {
		this.entidad = entidad;
	}

}
