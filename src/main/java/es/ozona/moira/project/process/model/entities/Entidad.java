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


@Entity
@Table(name = "ent_entidad")
public class Entidad implements Serializable {

	private static final long serialVersionUID = -5175060655767574295L;

	@Id
	@Column(name = "id_entidad")
	private Long id;
	
	@NotEmpty
	@Column
	private String codigo;

	@NotEmpty
	@Column
	private String nombre;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_entidad_padre")
	private Entidad padre;
	
	@OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Entidad> entidades = new HashSet<Entidad>(0);
	
	@OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Persona> personas = new HashSet<Persona>(0);
	
	@OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Grupo> grupos = new HashSet<Grupo>(0);

	public Entidad() {
		super();
	}

	public Entidad(Long id) {
		super();
		this.id = id;
	}

	public Entidad(@NotEmpty String ozona, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion,
			Entidad padre, Set<Entidad> entidades, Set<Persona> personas, Set<Grupo> grupos) {
		super();
		this.codigo = ozona;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.padre = padre;
		this.entidades = entidades;
		this.personas = personas;
		this.grupos = grupos;
	}

	public Entidad(Long id, @NotEmpty String ozona, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion,
			Entidad padre, Set<Entidad> entidades, Set<Persona> personas, Set<Grupo> grupos) {
		super();
		this.id = id;
		this.codigo = ozona;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.padre = padre;
		this.entidades = entidades;
		this.personas = personas;
		this.grupos = grupos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOzona() {
		return codigo;
	}

	public void setOzona(String ozona) {
		this.codigo = ozona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Entidad getPadre() {
		return padre;
	}

	public void setPadre(Entidad padre) {
		this.padre = padre;
	}

	public Set<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(Set<Entidad> entidades) {
		this.entidades = entidades;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
