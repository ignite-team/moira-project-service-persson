package es.ozona.moira.project.process.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "per_miembro")
public class Miembro implements Serializable {
	@Id
	@Column(name = "id_miembro")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;
	
	@Column(name = "fecha_baja")
	private Date fechaBaja;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	public Miembro() {
		super();
	}
	
	
	public Miembro(Long id) {
		super();
		this.id = id;
	}
	
	public Miembro(@NotNull Persona persona, @NotNull Grupo grupo, Date fechaAlta, Date fechaBaja, Date fechaCreacion,
			Date fechaModificacion) {
		super();
		this.persona = persona;
		this.grupo = grupo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}


	public Miembro(Long id, @NotNull Persona persona, @NotNull Grupo grupo, Date fechaAlta, Date fechaBaja,
			Date fechaCreacion, Date fechaModificacion) {
		super();
		this.id = id;
		this.persona = persona;
		this.grupo = grupo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
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
	
	
}
