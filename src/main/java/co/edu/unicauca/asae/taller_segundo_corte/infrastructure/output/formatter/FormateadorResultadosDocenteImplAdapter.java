package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.formatter;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosDocenteIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadYaExisteException;

@Service
public class FormateadorResultadosDocenteImplAdapter implements FormateadorResultadosDocenteIntPort{

    @Override
    public Docente preparaRespuestaFallidaCrearDocente(String error) {
        throw new EntidadYaExisteException(error);
    }
    
}
