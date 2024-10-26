package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHoraria {
    private int id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
