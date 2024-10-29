package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface GestionarDocenteGatewayIntPort {
    public boolean existeDocentePorCorreo(String prmCorreo);
    
    public Docente guardar(Docente prmDocente);
}
