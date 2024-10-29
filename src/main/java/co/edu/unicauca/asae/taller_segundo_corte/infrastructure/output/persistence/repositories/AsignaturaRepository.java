package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.AsignaturaEntity;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer> {

}
