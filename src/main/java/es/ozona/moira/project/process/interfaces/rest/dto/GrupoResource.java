package es.ozona.moira.project.process.interfaces.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import es.ozona.moira.project.process.model.entities.Persona;


public class GrupoResource implements Serializable{

	@NotNull
	private Long id;
	
	@NotEmpty
	private String nombre;

	private Date fechaCreacion;
	
	private Date fechaModificacion;
	
	private Set<Persona> personas;

	public GrupoResource() {
		super();
	}

	public GrupoResource(Long id) {
		this.id = id;
	}

	public GrupoResource(@NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion, Set<Persona> personas) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.personas = personas;
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

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	
}
