package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import org.springframework.web.server.ResponseStatusException;

public interface FormateadorResultadosIntPort {
    public ResponseStatusException preparaRespuestaFallida(String error);
}
