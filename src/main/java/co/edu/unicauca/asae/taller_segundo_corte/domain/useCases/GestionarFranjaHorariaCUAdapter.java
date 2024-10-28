package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaIntPort{

    @Autowired
    private final GestionarFranjaHorariaGatewayIntPort objFranjaHorariaGateway;

    @Override
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria) {


        for(Docente objDocente: prmFranjaHoraria.getObjCurso().getLstDocentes()){
            if(this.objFranjaHorariaGateway.existeFHPorEspacioFisico(
                    prmFranjaHoraria.getDia(), 
                    prmFranjaHoraria.getHoraInicio(), 
                    prmFranjaHoraria.getHoraFin(), 
                    objDocente.getId()
                )
            ){
                return null;
            }  
        }
        return this.objFranjaHorariaGateway.guardar(prmFranjaHoraria);
    }

    @Override
    public Iterable<FranjaHoraria> listar() {
        return this.objFranjaHorariaGateway.listar();
    }

    @Override
    public Iterable<FranjaHoraria> listarPorDocente(int prmIdDocente) {
       return this.objFranjaHorariaGateway.listarPorDocente(prmIdDocente);
    }
    
}
