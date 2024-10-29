package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaIntPort{

    @Autowired
    private final GestionarFranjaHorariaGatewayIntPort objFranjaHorariaGateway;

    @Autowired
    private final FormateadorResultadosIntPort objFormateadorResultados;

    @Override
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria) {

        if(!this.objFranjaHorariaGateway.isEspacioFisicoDisponibleParaFH(
                prmFranjaHoraria.getDia(), 
                prmFranjaHoraria.getHoraInicio(), 
                prmFranjaHoraria.getHoraFin(), 
                prmFranjaHoraria.getObjEspacioFisico().getId())
        ){
            throw this.objFormateadorResultados.preparaRespuestaFallida("Error! El espacio físico no está disponible en esta franja horaria");
        }        


        for(Docente objDocente: prmFranjaHoraria.getObjCurso().getLstDocentes()){
            if(this.objFranjaHorariaGateway.isDocenteDisponibleParaFH(
                    prmFranjaHoraria.getDia(), 
                    prmFranjaHoraria.getHoraInicio(), 
                    prmFranjaHoraria.getHoraFin(), 
                    objDocente.getId()
                )
            ){
                throw this.objFormateadorResultados.preparaRespuestaFallida("Error! El docente con id "+objDocente.getId()+" no está disponible para esta franja horaria");
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
