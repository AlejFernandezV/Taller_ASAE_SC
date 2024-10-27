package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.FranjaHorariaEntity;

public interface FranjaHorariaRepository extends CrudRepository<FranjaHorariaEntity, Integer> {
    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FranjaHorariaEntity f " +
           "JOIN f.objEspacioFisico e " +
           "WHERE e.id = :espacioFisicoId AND f.dia = :dia " +
           "AND ((f.horaInicio <= :horaFin AND f.horaFin >= :horaInicio))")
    boolean isEspacioFisicoOcupado(@Param("dia") String dia,
                                   @Param("horaInicio") LocalTime horaInicio,
                                   @Param("horaFin") LocalTime horaFin,
                                   @Param("espacioFisicoId") int espacioFisicoId);

    @Query( value = "SELECT CASE WHEN COUNT(fh) > 0 THEN true ELSE false END " +
            "FROM franja_horaria fh " +
            "JOIN curso c ON fh.curso_id = c.curso_id " +
            "JOIN curso_docente cd ON c.curso_id = cd.curso_id " +
            "JOIN docente d ON cd.docente_id = d.docente_id " +
            "WHERE d.docente_id = :docenteId AND fh.dia = :dia " +
            "AND ((fh.hora_inicio <= :horaFin AND fh.hora_fin >= :horaInicio))", 
            nativeQuery = true)
    boolean isDocenteOcupado(   @Param("dia") String dia,
                                @Param("horaInicio") LocalTime horaInicio,
                                @Param("horaFin") LocalTime horaFin,
                                @Param("docenteId") int docenteId);

}
