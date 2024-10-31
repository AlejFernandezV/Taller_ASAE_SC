package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.formatter;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadYaExisteException;

@Service
public class FormateadorResultadosFranjaHorariaImplAdapter implements FormateadorResultadosFranjaHorariaIntPort{

    @Override
    public FranjaHoraria preparaRespuestaFallidaCrearFranjaHoraria(String error) {
        throw new EntidadYaExisteException(error);
    }

    @Override
    public List<FranjaHoraria> preparaRespuestaFallidaListarFranjasHorarias(String error) {
        throw new EntidadNoExisteException(error);
    }
    
}
