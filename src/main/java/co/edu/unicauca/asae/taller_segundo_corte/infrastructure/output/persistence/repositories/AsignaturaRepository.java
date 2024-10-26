package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.AsignaturaEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer> {

}
