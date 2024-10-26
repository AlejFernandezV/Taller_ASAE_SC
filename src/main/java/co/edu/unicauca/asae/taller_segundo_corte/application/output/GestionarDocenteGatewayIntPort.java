package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface GestionarDocenteGatewayIntPort {
    public Docente guardar(Docente prmDocente);
    public Iterable<Docente> listar();
}
