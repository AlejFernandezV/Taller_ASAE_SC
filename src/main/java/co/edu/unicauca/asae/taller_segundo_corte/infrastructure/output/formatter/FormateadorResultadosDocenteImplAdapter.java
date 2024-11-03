package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.formatter;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosDocenteIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadYaExisteException;

@Service
public class FormateadorResultadosDocenteImplAdapter implements FormateadorResultadosDocenteIntPort{

    @Override
    public Docente preparaRespuestaFallidaCrearDocente(String error) {
        throw new EntidadYaExisteException(error);
    }

    @Override
    public Docente preparaRespuestaFallidaEliminarDocente(String error) {
        throw new EntidadNoExisteException(error);
    }

    @Override
    public List <Docente> preparaRespuestaFallidaListarDocentes(String error) {
        throw new EntidadNoExisteException(error);
    }

    @Override
    public Docente preparaRespuestaFallidaMostrarDocente(String error) {
        throw new EntidadNoExisteException(error);
    }
    
}
