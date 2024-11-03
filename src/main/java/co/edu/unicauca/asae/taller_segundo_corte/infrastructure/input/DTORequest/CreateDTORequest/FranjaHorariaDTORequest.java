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
    @NotBlank(message="Pendiente")
    @Size(max=20, message="Pendiente")
    private String dia;
    
    @NotNull(message="Pendiente")
    private LocalTime horaInicio;
    @NotNull(message="Pendiente")
    private LocalTime horaFin;
    
    @NotNull(message="Pendiente")
    @Positive()
    private int idCurso;

    @NotNull(message="Pendiente")
    @Positive()
    private int idEspacioFisico;

}
