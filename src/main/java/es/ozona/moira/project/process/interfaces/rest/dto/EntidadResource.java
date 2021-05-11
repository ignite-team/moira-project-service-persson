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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;


public class EntidadResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5763452524387389593L;

	@Id
	private Long id;
	
	@NotEmpty
	private String codigo;

	@NotEmpty
	private String nombre;

	private Date fechaCreacion;

	private Date fechaModificacion;
	
	private EntidadResource padre;
	
	private Set<EntidadResource> entidades = new HashSet<EntidadResource>(0);
	
	private Set<PersonaResource> personas = new HashSet<PersonaResource>(0);
	
	private Set<GrupoResource> grupos = new HashSet<GrupoResource>(0);

	public EntidadResource() {
		super();
	}

	public EntidadResource(Long id) {
		super();
		this.id = id;
	}

	public EntidadResource(@NotEmpty String ozona, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion,
			EntidadResource padre, Set<EntidadResource> entidades, Set<PersonaResource> personas, Set<GrupoResource> grupos) {
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

	public EntidadResource(Long id, @NotEmpty String ozona, @NotEmpty String nombre, Date fechaCreacion, Date fechaModificacion,
			EntidadResource padre, Set<EntidadResource> entidades, Set<PersonaResource> personas, Set<GrupoResource> grupos) {
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public EntidadResource getPadre() {
		return padre;
	}

	public void setPadre(EntidadResource padre) {
		this.padre = padre;
	}

	public Set<EntidadResource> getEntidades() {
		return entidades;
	}

	public void setEntidades(Set<EntidadResource> entidades) {
		this.entidades = entidades;
	}

	public Set<PersonaResource> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<PersonaResource> personas) {
		this.personas = personas;
	}

	public Set<GrupoResource> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<GrupoResource> grupos) {
		this.grupos = grupos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
}
