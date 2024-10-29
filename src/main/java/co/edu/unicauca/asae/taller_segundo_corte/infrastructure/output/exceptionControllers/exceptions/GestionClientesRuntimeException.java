package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class GestionClientesRuntimeException extends RuntimeException{
    protected CodigoError codigoError;
    public abstract String formatException();
}
