package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse;

import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaCreadaDTOResponse {
    private int code;
    private int id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Date createdAt;
}
