package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;

public interface FormateadorResultadosEspacioFisicoIntPort {
    public EspacioFisico preparaRespuestaFallidaCrearEspacioFisico(String error);
    public List<EspacioFisico> preparaRespuestaFallidaListarEspaciosFisicos(String error);
}
