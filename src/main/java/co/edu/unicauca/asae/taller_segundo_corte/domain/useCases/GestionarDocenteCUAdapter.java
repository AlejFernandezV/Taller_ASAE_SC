package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    @Autowired
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway; 

    @Override
    public Docente crear(Docente prmDocente) {
        if(this.objGestionarDocenteGateway.existeDocentePorCorreo(prmDocente.getCorreo())){
            return null;
        }
        return this.objGestionarDocenteGateway.guardar(prmDocente);
    }

    @Override
    public Iterable<Docente> listar() {
        return this.objGestionarDocenteGateway.listar();
    }
    
}
