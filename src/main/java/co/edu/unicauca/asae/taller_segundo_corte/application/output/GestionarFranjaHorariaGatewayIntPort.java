package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface GestionarFranjaHorariaGatewayIntPort {

    public boolean docenteDisponibilidad();
    public boolean existeFHPorEspacioFisico(String dia, LocalTime horaInicio, LocalTime horaFin, int idDocente);

    public FranjaHoraria guardar(FranjaHoraria prmFranjaHoraria);
    public Iterable<FranjaHoraria> listar();
    public Iterable<FranjaHoraria> listarPorDocente(int prmIdDocente);
}
