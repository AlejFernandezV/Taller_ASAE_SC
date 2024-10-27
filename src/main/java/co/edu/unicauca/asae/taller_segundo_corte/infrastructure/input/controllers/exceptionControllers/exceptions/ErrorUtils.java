package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.controllers.exceptionControllers.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ErrorUtils {
    public static Error crearError(final String codigoError, final String llaveMensaje, final Integer codigoHttp) {
        final Error error = new Error();
        error.setCodigoError(codigoError);
        error.setMensaje(llaveMensaje);
        error.setCodigoHttp(codigoHttp);
        return error;
    }
}
