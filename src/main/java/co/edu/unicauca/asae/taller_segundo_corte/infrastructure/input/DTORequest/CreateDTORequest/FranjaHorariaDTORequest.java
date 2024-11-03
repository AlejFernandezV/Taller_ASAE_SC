package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class FranjaHorariaDTORequest {
    @NotBlank(message="Pendiente")
    @Size(max=20, message="Pendiente")
    private String dia;
    
    @NotBlank(message="Pendiente")
    private LocalTime horaInicio;
    @NotBlank(message="Pendiente")
    private LocalTime horaFin;
    
    @NotNull(message="Pendiente")
    @Positive()
    private int idEspacioFisico;

    @NotNull(message="Pendiente")
    @Positive()
    private int idCurso;
}
