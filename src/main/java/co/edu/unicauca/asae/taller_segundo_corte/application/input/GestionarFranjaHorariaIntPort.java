package co.edu.unicauca.asae.taller_segundo_corte.application.input;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface GestionarFranjaHorariaIntPort {
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria);
    public Iterable<FranjaHoraria> listar();
    public Iterable<FranjaHoraria> listarPorDocente(int prmIdDocente);
}
