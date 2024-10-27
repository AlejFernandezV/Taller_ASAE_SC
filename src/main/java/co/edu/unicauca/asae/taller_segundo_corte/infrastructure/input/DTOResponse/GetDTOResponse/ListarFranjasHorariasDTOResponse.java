package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.FranjaHorariaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarFranjasHorariasDTOResponse {
    private int code;
    private List<FranjaHorariaEntity> results;
}
