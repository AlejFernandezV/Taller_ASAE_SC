package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.formatter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosIntPort;

@Service
public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort{

    @Override
    public ResponseStatusException preparaRespuestaFallida(String error) {
        return new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
    
}
