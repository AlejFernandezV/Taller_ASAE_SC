package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.DocenteEntity;

public interface  DocenteRepository extends  JpaRepository <DocenteEntity, Integer>{
    
}
