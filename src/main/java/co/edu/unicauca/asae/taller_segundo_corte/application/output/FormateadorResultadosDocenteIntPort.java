package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface FormateadorResultadosDocenteIntPort {
    public Docente preparaRespuestaFallidaCrearDocente(String error);
}
