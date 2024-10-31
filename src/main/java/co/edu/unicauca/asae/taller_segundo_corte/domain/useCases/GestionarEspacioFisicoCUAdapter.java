package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort{

    @Autowired
    private final GestionarEspacioFisicoGatewayIntPort objEspacioFisicoGateway;

    @Override
    public List<EspacioFisico> listar() {
        return this.objEspacioFisicoGateway.listar();
    }
    
}