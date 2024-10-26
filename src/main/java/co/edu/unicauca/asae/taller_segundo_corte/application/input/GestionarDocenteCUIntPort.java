package co.edu.unicauca.asae.taller_segundo_corte.application.input;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface GestionarDocenteCUIntPort {
    public Docente crear(Docente prmDocente);
    public Iterable<Docente> listar();
}
