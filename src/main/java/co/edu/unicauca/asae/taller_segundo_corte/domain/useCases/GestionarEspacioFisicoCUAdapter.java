package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosEspacioFisicoIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort{

    @Autowired
    private GestionarEspacioFisicoGatewayIntPort objEspacioFisicoGateway;

    @Autowired
    private FormateadorResultadosEspacioFisicoIntPort objFormatter;
    
    @Override
    public List<EspacioFisico> listar() {
        List<EspacioFisico> lstEspaciosFisicos = this.objEspacioFisicoGateway.listar(); 
        return lstEspaciosFisicos.isEmpty() ? this.objFormatter.preparaRespuestaFallidaListarEspaciosFisicos("No hay espacios físicos que listar") : lstEspaciosFisicos;  
    }
    
}