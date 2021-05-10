package es.ozona.moira.project.process.interfaces.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;


public class PersonaResource implements Serializable {

	@NotNull
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	private String correo;
	
	@NotNull
	private Boolean activo;
	
	private Date fechaRegistro;
	
	private Date fechaModificacion;
	
	private Date fechaBaja;
	
	@NotNull
	private Entidad entidad;
	
	private Set<Grupo> grupos;

	public PersonaResource() {
		super();
	}
	
	public PersonaResource(Long id) {
		this.id = id;
	}

	public PersonaResource(@NotEmpty String nombre, @NotEmpty String telefono, @NotEmpty String correo,
			@NotNull Boolean activo, Date fechaRegistro, Date fechaModificacion, Date fechaBaja,
			@NotNull Entidad entidad, Set<Grupo> grupos) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
		this.fechaRegistro = fechaRegistro;
		this.fechaModificacion = fechaModificacion;
		this.fechaBaja = fechaBaja;
		this.entidad = entidad;
		this.grupos = grupos;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
