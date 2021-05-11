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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "per_persona")
public class Persona implements Serializable{
	@Id
	@Column(name = "id_persona")
	private Long id;
	
	@NotEmpty
	@Column
	private String nombre_completo;
	
	@NotEmpty
	@Column
	private String nombre;
	
	@NotEmpty
	@Column
	private String apellidos;
	
	@NotEmpty
	@Column
	private String telefono;
	
	@NotEmpty
	@Column
	private String correo;
	
	@NotNull
	@Column
	private Boolean activo;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name = "fecha_baja")
	private Date fechaBaja;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_entidad")
	private Entidad entidad;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Miembro> miembros = new HashSet<>(0);

	public Persona() {
		super();
	}

	public Persona(Long id) {
		super();
		this.id = id;
	}

	public Persona(@NotEmpty String nombre_completo, @NotEmpty String nombre, @NotEmpty String apellidos,
			@NotEmpty String telefono, @NotEmpty String correo, @NotNull Boolean activo, Date fechaCreacion,
			Date fechaModificacion, Date fechaBaja, @NotNull Entidad entidad, Set<Miembro> miembro) {
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

	public Persona(Long id, @NotEmpty String nombre_completo, @NotEmpty String nombre, @NotEmpty String apellidos,
			@NotEmpty String telefono, @NotEmpty String correo, @NotNull Boolean activo, Date fechaCreacion,
			Date fechaModificacion, Date fechaBaja, @NotNull Entidad entidad, Set<Miembro> miembro) {
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

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Set<Miembro> getMiembro() {
		return miembros;
	}

	public void setMiembro(Set<Miembro> miembro) {
		this.miembros = miembro;
	}

	
	
}
