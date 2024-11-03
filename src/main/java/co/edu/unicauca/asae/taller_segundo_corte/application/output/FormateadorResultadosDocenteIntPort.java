package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface FormateadorResultadosDocenteIntPort {
    public Docente preparaRespuestaFallidaCrearDocente(String error);
    public Docente preparaRespuestaFallidaEliminarDocente(String error);
    public Docente preparaRespuestaFallidaMostrarDocente(String error);
    public List<Docente> preparaRespuestaFallidaListarDocentes(String error);
}
