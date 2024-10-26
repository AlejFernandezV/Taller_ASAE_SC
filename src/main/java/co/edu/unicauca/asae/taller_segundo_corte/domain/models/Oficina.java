package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    private int id;
    private String nombre;
    private String ubicacion;
}
