package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente extends Persona{
    private Oficina objOficina;
}
