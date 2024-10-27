package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoceteDTORequest {
    @NotBlank(message="Pendiente")
    @Size(max=50)
    private String nombre;
    
    @NotBlank(message="Pendiente")
    @Size(max=50)
    private String apellido;

    @NotBlank(message="Pendiente")
    @Size(max=50)
    @Email(message="Pendiente")
    private String correo;
}
