package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    @Autowired
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    
    @Autowired
    private final FormateadorResultadosIntPort objFormateadorResultados;

    @Override
    public Docente crear(Docente prmDocente) {
        if(this.objGestionarDocenteGateway.existeDocentePorCorreo(prmDocente.getCorreo())){
            throw this.objFormateadorResultados.preparaRespuestaFallida("Error, el docente con esa información ya esta creado");
        }
        return this.objGestionarDocenteGateway.guardar(prmDocente);
    }    
}
