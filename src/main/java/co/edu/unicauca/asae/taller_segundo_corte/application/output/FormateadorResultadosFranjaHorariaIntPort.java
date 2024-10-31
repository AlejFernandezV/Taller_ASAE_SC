package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public interface FormateadorResultadosFranjaHorariaIntPort {
    public FranjaHoraria preparaRespuestaFallidaCrearFranjaHoraria(String error);
    public List<FranjaHoraria> preparaRespuestaFallidaListarFranjasHorarias(String error);
}
