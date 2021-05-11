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
import es.ozona.moira.project.process.model.entities.Miembro;


public class PersonaResource implements Serializable {
	@Id
	private Long id;
	
	@NotEmpty
	private String nombre_completo;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellidos;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	private String correo;
	
	@NotNull
	private Boolean activo;
	
	private Date fechaCreacion;
	
	private Date fechaModificacion;
	
	private Date fechaBaja;
	
	@NotNull
	private EntidadResource entidad;
	
	private Set<MiembroResource> miembros = new HashSet<>(0);

	public PersonaResource() {
		super();
	}

	public PersonaResource(Long id) {
		super();
		this.id = id;
	}

	public PersonaResource(@NotEmpty String nombre_completo, @NotEmpty String nombre, @NotEmpty String apellidos,
			@NotEmpty String telefono, @NotEmpty String correo, @NotNull Boolean activo, Date fechaCreacion,
			Date fechaModificacion, Date fechaBaja, @NotNull EntidadResource entidad, Set<MiembroResource> miembro) {
		super();
		this.nombre_completo = nombre_completo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaBaja = fechaBaja;
		this.entidad = entidad;
		this.miembros = miembro;
	}

	public PersonaResource(Long id, @NotEmpty String nombre_completo, @NotEmpty String nombre, @NotEmpty String apellidos,
			@NotEmpty String telefono, @NotEmpty String correo, @NotNull Boolean activo, Date fechaCreacion,
			Date fechaModificacion, Date fechaBaja, @NotNull Entidad entidadResource, Set<MiembroResource> miembro) {
		super();
		this.id = id;
		this.nombre_completo = nombre_completo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.fechaBaja = fechaBaja;
		this.entidad = entidad;
		this.miembros = miembro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public EntidadResource getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadResource entidad) {
		this.entidad = entidad;
	}

	public Set<MiembroResource> getMiembros() {
		return miembros;
	}

	public void setMiembros(Set<MiembroResource> miembros) {
		this.miembros = miembros;
	}
	
}
