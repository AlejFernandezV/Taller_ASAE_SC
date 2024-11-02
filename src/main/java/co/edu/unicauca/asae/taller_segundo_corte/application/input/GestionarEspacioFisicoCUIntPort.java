package co.edu.unicauca.asae.taller_segundo_corte.application.input;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;

public interface GestionarEspacioFisicoCUIntPort {
    public EspacioFisico crear(EspacioFisico prmEspacioFisico);
    public EspacioFisico eliminar(int id);
    public EspacioFisico buscarPorId(int id);
    public List<EspacioFisico> listar();
}
