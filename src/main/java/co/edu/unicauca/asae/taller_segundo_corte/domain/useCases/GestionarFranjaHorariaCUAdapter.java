package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort{

    @Autowired
    private GestionarFranjaHorariaGatewayIntPort objFranjaHorariaGateway;

    @Autowired
    private FormateadorResultadosFranjaHorariaIntPort objFormateadorResultados;

    @Override
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria) {

        if(!this.objFranjaHorariaGateway.isEspacioFisicoDisponibleParaFH(
                prmFranjaHoraria.getDia(), 
                prmFranjaHoraria.getHoraInicio(), 
                prmFranjaHoraria.getHoraFin(), 
                prmFranjaHoraria.getObjEspacioFisico().getId())
        ){
            return this.objFormateadorResultados.preparaRespuestaFallidaCrearFranjaHoraria("El espacio físico no está disponible en esta franja horaria");
        }        

        for(Docente objDocente: prmFranjaHoraria.getObjCurso().getLstDocentes()){
            if(this.objFranjaHorariaGateway.isDocenteDisponibleParaFH(
                    prmFranjaHoraria.getDia(), 
                    prmFranjaHoraria.getHoraInicio(), 
                    prmFranjaHoraria.getHoraFin(), 
                    objDocente.getId()
                )
            ){
                return this.objFormateadorResultados.preparaRespuestaFallidaCrearFranjaHoraria("El docente con id "+objDocente.getId()+" no está disponible para esta franja horaria");
            }  
        }
        
        return this.objFranjaHorariaGateway.guardar(prmFranjaHoraria);
    }

    @Override
    public List<FranjaHoraria> listar() {
        List<FranjaHoraria> results = this.objFranjaHorariaGateway.listar(); 
        return results.isEmpty() ? this.objFormateadorResultados.preparaRespuestaFallidaListarFranjasHorarias("No hay franjas horarias por listar") : results;
    }

    @Override
    public List<FranjaHoraria> listarPorDocente(int prmIdDocente) {
        List<FranjaHoraria> results = this.objFranjaHorariaGateway.listarPorDocente(prmIdDocente); 
        return results.isEmpty() ? this.objFormateadorResultados.preparaRespuestaFallidaListarFranjasHorarias("No hay franjas horarias por listar") : results;
    }
    
}
