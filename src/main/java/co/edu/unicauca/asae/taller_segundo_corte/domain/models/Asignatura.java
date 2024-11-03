package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

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
public class Asignatura {
    private int id;
    private String nombre;
    private String codigo;
}
