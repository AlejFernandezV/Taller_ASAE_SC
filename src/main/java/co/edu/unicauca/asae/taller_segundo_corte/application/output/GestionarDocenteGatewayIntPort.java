package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface GestionarDocenteGatewayIntPort {
    public boolean existeDocentePorCorreo(String prmCorreo);
    public List<Docente> listar();
    public Docente guardar(Docente prmDocente);
    public Docente eliminar(Docente objDocente);
    public Docente buscarPorId(int id);
}
