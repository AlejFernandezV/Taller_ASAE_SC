package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions;


public class HoraFinMenorQueInicioException extends RuntimeException  {
    public HoraFinMenorQueInicioException(String message) {
        super(message);
    }
}
