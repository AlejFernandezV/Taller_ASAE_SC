package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDTORequest {
    @NotBlank(message="{oficina.nombre.blank}")
    private String nombre;
    @NotBlank(message="{oficina.ubicacion.blank}")
    private String ubicacion;
}
