package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocenteDTORequest {
    @NotBlank(message="{docente.nombre.blank}")
    @Size(max=50)
    private String nombre;
    
    @NotBlank(message="{docente.apellido.blank}")
    @Size(max=50)
    private String apellido;

    @NotBlank(message="{docente.email.blank}")
    @Size(max=50, message="{docente.email.size}")
    @Email(message="{docente.email.email}")
    private String correo;

    @NotNull(message="{docente.oficina.null}")
    @Valid
    private OficinaDTORequest objOficina;
}
