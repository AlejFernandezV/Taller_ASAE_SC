package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.GetDTORequest;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarFranjasHorariasPorDocenteDTORequest {
    @Positive(message="{franja_horaria.idDocente.positive}")
    private int idDocente;
}
