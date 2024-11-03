package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse;

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
public class EspacioFisicoDTOResponse {
    private int code;
    private int id;
    private String nombre;
    private String capacidad;
}
