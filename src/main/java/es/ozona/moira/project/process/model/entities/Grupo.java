package es.ozona.moira.project.process.model.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "per_grupo")
public class Grupo {
	
	@Id
	@Column(name = "id_grupo")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToMany(mappedBy = "grupos")
	private Set<Persona> personas;

	public Grupo() {
		super();
	}

	public Grupo(Long id) {
		super();
		this.id = id;
	}	
	
	public Grupo(Long id, String nombre, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Grupo(String nombre, Date fechaCreacion, Date fechaModificacion, Set<Persona> personas) {
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
