package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.CursoEntity;

public interface CursoRepository extends CrudRepository<CursoEntity, Integer> {
    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM CursoEntity c JOIN c.lstDocentes d WHERE c.id = :cursoId")
    boolean existsByIdAndHasDocentes(@Param("cursoId") int cursoId);
}
