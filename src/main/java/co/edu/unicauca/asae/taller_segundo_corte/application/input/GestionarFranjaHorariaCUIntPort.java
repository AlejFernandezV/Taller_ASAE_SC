package co.edu.unicauca.asae.taller_segundo_corte.application.input;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface GestionarFranjaHorariaCUIntPort {
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria);
    public List<FranjaHoraria> listar();
    public List<FranjaHoraria> listarPorDocente(int prmIdDocente);
}
