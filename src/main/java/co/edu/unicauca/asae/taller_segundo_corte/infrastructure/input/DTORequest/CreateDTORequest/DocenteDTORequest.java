package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
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
    @Email(message="{docente.emai.email}")
    private String correo;

    @NotNull(message="{docente.oficina.null}")
    private OficinaDTORequest objOficina;
}
