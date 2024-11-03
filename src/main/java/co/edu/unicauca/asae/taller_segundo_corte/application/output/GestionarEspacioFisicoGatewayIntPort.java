package co.edu.unicauca.asae.taller_segundo_corte.application.output;

import java.util.List;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;

public interface GestionarEspacioFisicoGatewayIntPort {
    public List<EspacioFisico> listar();
    public EspacioFisico guardar(EspacioFisico prmEspacioFisico);
    public boolean existeEspacioFisicoPorNombre(String nombre);
    public EspacioFisico eliminar(EspacioFisico objEspacioFisico);
    public EspacioFisico buscarPorId(int id);
}
