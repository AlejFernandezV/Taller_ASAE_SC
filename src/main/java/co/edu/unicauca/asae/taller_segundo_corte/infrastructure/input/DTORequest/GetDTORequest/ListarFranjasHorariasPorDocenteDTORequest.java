package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.GetDTORequest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarFranjasHorariasPorDocenteDTORequest {
    @NotNull(message="{franja_horaria.idDocente.null}")
    @Positive(message="{franja_horaria.idDocente.positive}")
    private int idDocente;
}
