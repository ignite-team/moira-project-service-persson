package es.ozona.moira.project.process.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ozona.moira.project.process.model.entities.Entidad;
import es.ozona.moira.project.process.model.entities.Grupo;
import es.ozona.moira.project.process.model.entities.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

	List<Persona> findByEntidadAndGrupos(Entidad entidad, Grupo grupo);
}
