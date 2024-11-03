package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosEspacioFisicoIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort{

    @Autowired
    private GestionarEspacioFisicoGatewayIntPort objEspacioFisicoGateway;

    @Autowired
    private FormateadorResultadosEspacioFisicoIntPort objFormatter;
    
    @Override
    public EspacioFisico crear(EspacioFisico prmEspacioFisico) {
        List<EspacioFisico> espaciosFisicos = this.objEspacioFisicoGateway.listar();
        boolean existeNombre = espaciosFisicos.stream()
                .anyMatch(ef -> ef.getNombre().equalsIgnoreCase(prmEspacioFisico.getNombre()));
        
        if (existeNombre) {
            return objFormatter.preparaRespuestaFallidaCrearEspacioFisico(
                "Ya existe un espacio físico con el nombre: " + prmEspacioFisico.getNombre());
        }
        
        return this.objEspacioFisicoGateway.guardar(prmEspacioFisico);
    }
    
    @Override
    public EspacioFisico eliminar(int id) {
        EspacioFisico objEspacioFisico = this.objEspacioFisicoGateway.buscarPorId(id);
        if (objEspacioFisico == null) {
            return this.objFormatter.preparaRespuestaFallidaEliminarEspacioFisico("El espacio Fisico no existe");
        }
        return this.objEspacioFisicoGateway.eliminar(objEspacioFisico);
    }

    @Override
    public EspacioFisico buscarPorId(int id) {
        EspacioFisico objEspacioFisico = this.objEspacioFisicoGateway.buscarPorId(id);
        if (objEspacioFisico == null) {
            return this.objFormatter.preparaRespuestaFallidaMostrarEspacioFisico("No existe un espacio físico con el ID: " + id);
        }
        return objEspacioFisico;
    }

    @Override
    public List<EspacioFisico> listar() {
        List<EspacioFisico> lstEspaciosFisicos = this.objEspacioFisicoGateway.listar(); 
        return lstEspaciosFisicos.isEmpty() ? this.objFormatter.preparaRespuestaFallidaListarEspaciosFisicos("No hay espacios físicos que listar") : lstEspaciosFisicos;  
    }
    
}