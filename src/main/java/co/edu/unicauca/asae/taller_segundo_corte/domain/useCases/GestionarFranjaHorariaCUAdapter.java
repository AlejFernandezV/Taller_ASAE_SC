package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.CursoNoExisteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.CursoSinDocenteException;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.exceptionControllers.exceptions.HoraFinMenorQueInicioException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort{

    @Autowired
    private GestionarFranjaHorariaGatewayIntPort objFranjaHorariaGateway;

    @Autowired
    private GestionarCursoGatewayIntPort objCursoGateway;

    @Autowired
    private FormateadorResultadosFranjaHorariaIntPort objFormateadorResultados;

    @Override
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria) {
        validarHoraFinMayorQueInicio(prmFranjaHoraria);
        validarCursoExiste(prmFranjaHoraria);
        validarCursoTieneDocentes(prmFranjaHoraria);
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

    private void validarHoraFinMayorQueInicio(FranjaHoraria franjaHoraria) {
        LocalTime horaInicio = franjaHoraria.getHoraInicio();
        LocalTime horaFin = franjaHoraria.getHoraFin();
        
        if (horaFin.isBefore(horaInicio) || horaFin.equals(horaInicio)) {
            throw new HoraFinMenorQueInicioException("franja_horaria.hora_fin.menor");
        }
    }

    private void validarCursoTieneDocentes(FranjaHoraria franjaHoraria) {
        if (!this.objCursoGateway.cursoTieneDocente(franjaHoraria.getObjCurso().getId())) {
            throw new CursoSinDocenteException("franja_horaria.curso.sin_docente");
        }
    }

    private void validarCursoExiste(FranjaHoraria franjaHoraria) {
        if (!this.objCursoGateway.cursoExiste(franjaHoraria.getObjCurso().getId())) {
            throw new CursoNoExisteException("franja_horaria.curso.no_existe");
        }
    }
    
}
