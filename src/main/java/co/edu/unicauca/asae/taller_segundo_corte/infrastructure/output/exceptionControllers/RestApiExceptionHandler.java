package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.CodigoError;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.CursoNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.CursoSinDocenteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.Error;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.ErrorUtils;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.HoraFinMenorQueInicioException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.ReglaDeNegocioException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(final HttpServletRequest req, final Exception ex, final Locale locale) {
        final Error error = ErrorUtils
                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                        CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntidadYaExisteException.class)
    public ResponseEntity<Error> handleEntidadYaExisteException(
            final HttpServletRequest req, final EntidadYaExisteException ex) {
        final Error error = ErrorUtils.crearError(
                CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                ex.getMessage(),
                HttpStatus.CONFLICT.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntidadNoExisteException.class)
    public ResponseEntity<Error> handleEntidadNoExisteException(
            final HttpServletRequest req, final EntidadNoExisteException ex) {
        final Error error = ErrorUtils.crearError(
                CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                String.format("%s, %s", CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(), ex.getMessage()),
                HttpStatus.NOT_FOUND.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReglaDeNegocioException.class)
    public ResponseEntity<Error> handleReglaDeNegocioException(
            final HttpServletRequest req, final ReglaDeNegocioException ex, final Locale locale) {
        final Error error = ErrorUtils.crearError(
                CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                ex.formatException(),
                HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campo = ((FieldError) error).getField();
            String mensajeDeError = error.getDefaultMessage();
            errores.put(campo, mensajeDeError);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HoraFinMenorQueInicioException.class)
    public ResponseEntity<Error> handleHoraFinMenorQueInicioException(
            final HttpServletRequest req, final HoraFinMenorQueInicioException ex) {
        final Error error = ErrorUtils.crearError(
                CodigoError.HORA_FIN_MENOR_QUE_INICIO.getCodigo(),
                CodigoError.HORA_FIN_MENOR_QUE_INICIO.getLlaveMensaje(),
                HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CursoSinDocenteException.class)
    public ResponseEntity<Error> handleCursoSinDocenteException(
            final HttpServletRequest req, final CursoSinDocenteException ex) {
        final Error error = ErrorUtils.crearError(
                CodigoError.CURSO_SIN_DOCENTE.getCodigo(),
                CodigoError.CURSO_SIN_DOCENTE.getLlaveMensaje(),
                HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CursoNoExisteException.class)
    public ResponseEntity<Error> handleCursoNoExisteException(
            final HttpServletRequest req, final CursoNoExisteException ex) {
        final Error error = ErrorUtils.crearError(
                CodigoError.CURSO_NO_EXISTE.getCodigo(),
                CodigoError.CURSO_NO_EXISTE.getLlaveMensaje(),
                HttpStatus.BAD_REQUEST.value())
                .setUrl(req.getRequestURL().toString())
                .setMetodo(req.getMethod());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
}
