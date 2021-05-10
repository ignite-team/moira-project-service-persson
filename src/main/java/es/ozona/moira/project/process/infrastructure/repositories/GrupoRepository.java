package es.ozona.moira.project.process.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ozona.moira.project.process.model.entities.Grupo;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

}
