package co.edu.unicauca.asae.taller_segundo_corte.application.input;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;

public interface GestionarDocenteCUIntPort {
    public Docente crear(Docente prmDocente);
    public Docente eliminar(int id);
    public Docente buscarPorId(int id);
    public List<Docente> listar();
}
