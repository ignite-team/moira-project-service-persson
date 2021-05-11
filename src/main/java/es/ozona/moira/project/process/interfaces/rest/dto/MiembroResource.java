package es.ozona.moira.project.process.interfaces.rest.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;

public class MiembroResource {
	@Id
	private Long id;
	
	@NotNull
	private PersonaResource persona;
	
	@NotNull
	private GrupoResource grupo;
	
	private Date fechaAlta;
	
	private Date fechaBaja;
	
	private Date fechaCreacion;
	
	private Date fechaModificacion;

	public MiembroResource() {
		super();
	}
	
	
	public MiembroResource(Long id) {
		super();
		this.id = id;
	}
	
	public MiembroResource(@NotNull PersonaResource persona, @NotNull GrupoResource grupo, Date fechaAlta, Date fechaBaja, Date fechaCreacion,
			Date fechaModificacion) {
		super();
		this.persona = persona;
		this.grupo = grupo;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}


	public MiembroResource(Long id, @NotNull PersonaResource persona, @NotNull GrupoResource grupo, Date fechaAlta, Date fechaBaja,
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

	public PersonaResource getPersona() {
		return persona;
	}


	public void setPersona(PersonaResource persona) {
		this.persona = persona;
	}


	public GrupoResource getGrupo() {
		return grupo;
	}


	public void setGrupo(GrupoResource grupo) {
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
