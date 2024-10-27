package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.GetDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarFranjasHorariasPorDocenteDTORequest {
    private int idDocente;
}
