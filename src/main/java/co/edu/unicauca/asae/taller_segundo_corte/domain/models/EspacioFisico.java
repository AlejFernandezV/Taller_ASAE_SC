package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {
    private int id;

    @NotBlank(message="Pendiente")
    @Size(max=25)
    private String nombre;

    @NotBlank(message="Pendiente")
    private String capacidad;
}
