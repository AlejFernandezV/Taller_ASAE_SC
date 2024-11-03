package co.edu.unicauca.asae.taller_segundo_corte.domain.models;

import java.util.ArrayList;
import java.util.List;

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
public class Curso {
    private int id;
    private String nombre;
    private List<Docente> lstDocentes = new ArrayList<>();
}
