package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.DocenteEntity;

public interface  DocenteRepository extends  CrudRepository <DocenteEntity, Integer>{
    
}
