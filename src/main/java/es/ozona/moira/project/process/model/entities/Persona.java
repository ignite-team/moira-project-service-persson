package es.ozona.moira.project.process.model.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "per_persona")
public class Persona {
	@Id
	@Column(name = "id_persona")
	private Long id;
	
	@NotEmpty
	@Column
	private String nombre;
	
	@NotEmpty
	@Column
	private String telefono;
	
	@NotEmpty
	@Column
	private String correo;
	
	@NotNull
	@Column
	private Boolean activo;
	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "fecha_baja")
	private Date fechaBaja;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_entidad")
	private Entidad entidad;
	
	@ManyToMany
	@JoinTable(
		name = "per_miembro",
		joinColumns = @JoinColumn(name = "id_persona"),
		inverseJoinColumns = @JoinColumn(name = "id_grupo"))
	private Set<Grupo> grupos;

	public Persona() {
		super();
	}

	public Persona(Long id) {
		super();
		this.id = id;
	}
	
	

	public Persona(Long id, @NotEmpty String nombre, @NotEmpty String telefono, @NotEmpty String correo,
			@NotNull Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
	}

	public Persona(Long id, @NotEmpty String nombre, @NotEmpty String telefono, @NotEmpty String correo,
			@NotNull Boolean activo, Date fechaRegistro, Date fechaModificacion, Date fechaBaja,
			@NotNull Entidad entidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
		this.fechaRegistro = fechaRegistro;
		this.fechaModificacion = fechaModificacion;
		this.fechaBaja = fechaBaja;
		this.entidad = entidad;
	}

	public Persona(String nombre, String telefono, String correo, Boolean activo, Date fechaRegistro,
			Date fechaModificacion, Date fechaBaja, Entidad entidad, Set<Grupo> grupos) {
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
