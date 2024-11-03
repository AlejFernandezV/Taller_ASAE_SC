package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {
    ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
    ENTIDAD_YA_EXISTE("GC-0002", "ERROR ENTIDAD YA EXISTE"),
    ENTIDAD_NO_ENCONTRADA("GC-0003", "Entidad no encontrada"),
    VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "Regla de negocio violada"),
    CREDENCIALES_INVALIDAS("GC-0005", "Error al iniciar sesión, compruebe sus credenciales y vuelva a intentarlo"),
    USUARIO_DESHABILITADO("GC-0006",
                    "El usuario no ha sido verificado, por favor revise su correo para verificar su cuenta"),
    HORA_FIN_MENOR_QUE_INICIO("GC-0007", "La hora de fin es menor o igual a la hora de inicio"),
    CURSO_SIN_DOCENTE("GC-0008", "No se puede crear la franja horaria sin docentes asignados al curso"),
    CURSO_NO_EXISTE("GC-0009", "No se puede crear la franja horaria porque el curso no existe");
    

    private final String codigo;
    private final String llaveMensaje; 
}
