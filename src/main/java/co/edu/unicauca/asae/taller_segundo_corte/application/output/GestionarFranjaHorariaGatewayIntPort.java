package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface GestionarFranjaHorariaGatewayIntPort {

    public boolean isDocenteDisponibleParaFH(String dia, LocalTime horaInicio, LocalTime horaFin, int idDocente);
    public boolean isEspacioFisicoDisponibleParaFH(String dia, LocalTime horaInicio, LocalTime horaFin, int idEspacioFisico);
    
    public FranjaHoraria guardar(FranjaHoraria prmFranjaHoraria);
    public List<FranjaHoraria> listar();
    public List<FranjaHoraria> listarPorDocente(int prmIdDocente);
}
