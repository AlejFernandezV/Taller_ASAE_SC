package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface GestionarFranjaHorariaGatewayIntPort {
    public FranjaHoraria guardar(FranjaHoraria prmFranjaHoraria);
    public Iterable<FranjaHoraria> listar();
    public Iterable<FranjaHoraria> listarPorDocente(int prmIdDocente);
}
