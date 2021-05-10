package es.ozona.moira.project.process.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ozona.moira.project.process.model.entities.Entidad;



@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {

}
