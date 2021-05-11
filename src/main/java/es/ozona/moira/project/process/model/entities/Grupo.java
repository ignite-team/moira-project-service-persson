package es.ozona.moira.project.process.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "per_grupo")
public class Grupo implements Serializable{
	
	@Id
	@Column(name = "id_grupo")
	private Long id;
	
	@NotEmpty
	@Column
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Miembro> miembros = new HashSet(0);
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_entidad")
	private Entidad entidad;

	public Grupo() {
		super();
	}

	public Grupo(Long id) {
		super();
		this.id = id;
	}

	public Grupo(@NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion, Set<Miembro> miembro,
			@NotNull Entidad entidad) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.miembros = miembro;
		this.entidad = entidad;
	}

	public Grupo(Long id, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion, Set<Miembro> miembro,
			@NotNull Entidad entidad) {
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

	public Set<Miembro> getMiembro() {
		return miembros;
	}

	public void setMiembro(Set<Miembro> miembro) {
		this.miembros = miembro;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	
}
