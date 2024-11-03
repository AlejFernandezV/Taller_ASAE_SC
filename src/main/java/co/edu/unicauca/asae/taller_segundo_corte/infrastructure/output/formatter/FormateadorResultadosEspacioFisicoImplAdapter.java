package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.formatter;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosEspacioFisicoIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadYaExisteException;

@Service
public class FormateadorResultadosEspacioFisicoImplAdapter implements FormateadorResultadosEspacioFisicoIntPort{

    @Override
    public EspacioFisico preparaRespuestaFallidaCrearEspacioFisico(String error) {
        throw new EntidadYaExisteException(error);
    }

     @Override
    public EspacioFisico preparaRespuestaFallidaEliminarEspacioFisico(String error) {
        throw new EntidadNoExisteException(error);
    }

 
    @Override
    public List<EspacioFisico> preparaRespuestaFallidaListarEspaciosFisicos(String error) {
        throw new EntidadNoExisteException(error);
    }

    @Override
    public EspacioFisico preparaRespuestaFallidaMostrarEspacioFisico(String error) {
        throw new EntidadNoExisteException(error);
    }

}
