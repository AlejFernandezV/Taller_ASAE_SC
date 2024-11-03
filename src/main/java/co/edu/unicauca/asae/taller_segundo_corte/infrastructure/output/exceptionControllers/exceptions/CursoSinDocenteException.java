package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions;

public class CursoSinDocenteException extends RuntimeException {
    public CursoSinDocenteException(String message) {
        super(message);
    }
}
