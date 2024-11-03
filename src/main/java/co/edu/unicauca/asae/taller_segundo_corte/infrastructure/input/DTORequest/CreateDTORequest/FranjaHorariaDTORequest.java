package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTORequest {
    @NotBlank(message="{franja_horaria.dia.blank}")
    @Size(max=20, message="Pendiente")
    private String dia;
    
    @NotNull(message="{franja_horaria.hora_inicio.blank}")
    private LocalTime horaInicio;
    @NotNull(message="{franja_horaria.hora_fin.blank}")
    private LocalTime horaFin;
    
    @NotNull(message="{franja_horaria.idDocente.null}")
    @Positive(message="{franja_horaria.idCurso.positive}")
    private Integer idCurso;

    @NotNull(message="{franja_horaria.idEspacioFisico.null}")
    @Positive(message="{franja_horaria.idEspacioFisico.positive}")
    private Integer idEspacioFisico;

}
