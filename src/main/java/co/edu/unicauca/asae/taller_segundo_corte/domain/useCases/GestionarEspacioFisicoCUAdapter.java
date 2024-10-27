package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisico{

    @Autowired
    private final GestionarEspacioFisicoGatewayIntPort objEspacioFisicoGateway;

    @Override
    public Iterable<EspacioFisico> listar() {
        return this.objEspacioFisicoGateway.listar();
    }
    
}