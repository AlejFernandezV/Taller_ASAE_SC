package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class EspacioFisicoDTORequest {
    @NotBlank(message = "{espacio_fisico.nombre.blank}")
    private String nombre;
    
    @NotBlank(message = "{espacio_fisico.capacidad.blank}")
    private String capacidad;
}
