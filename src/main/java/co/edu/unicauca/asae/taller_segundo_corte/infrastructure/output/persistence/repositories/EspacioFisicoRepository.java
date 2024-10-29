package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.EspacioFisicoEntity;

public interface EspacioFisicoRepository extends JpaRepository<EspacioFisicoEntity, Integer> {
    List<EspacioFisico> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, String capacidad);
}
