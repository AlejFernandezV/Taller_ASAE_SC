package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOResponse {
    private int code;
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
}
