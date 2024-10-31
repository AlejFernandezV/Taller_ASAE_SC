package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.FranjaHorariaDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.FranjaHorariaCreadaDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.ListarFranjasHorariasDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers.FranjaHorariaDTOToModelMapper;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FranjaHorariaRestController {
    
    @Autowired
    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUIntPort;
    @Autowired
    private final FranjaHorariaDTOToModelMapper objMapper;

    @PostMapping("/franjas_horarias")
    public FranjaHorariaCreadaDTOResponse epPostFranjaHoraria(@RequestBody FranjaHorariaDTORequest franjaHorariaData) {
        FranjaHoraria objFranjaHorariaCrear = this.objMapper.mappingFranjaHorariaDTOReqToFranjaHorariaModel(franjaHorariaData);
        FranjaHoraria objFranjaHorariaCreado = this.objGestionarFranjaHorariaCUIntPort.crear(objFranjaHorariaCrear);
        if(objFranjaHorariaCreado==null){
            return this.objMapper.mappingFranjaHorariaDTOResponse(HttpStatus.BAD_REQUEST.value(), false, null);
        }
        return this.objMapper.mappingFranjaHorariaDTOResponse(HttpStatus.CREATED.value(), true, new Date());
    }
    
    @GetMapping("/franjas_horarias")
    public ListarFranjasHorariasDTOResponse epGetAllFranjasHorarias(@RequestParam FranjaHorariaDTORequest franjaHorariaData) {
        List<FranjaHoraria> lstFranjasHorariasObtenidas = this.objGestionarFranjaHorariaCUIntPort.listar();
        if(lstFranjasHorariasObtenidas.isEmpty()){
            return this.objMapper.mappingFranjasHorariasDTOResponse(HttpStatus.BAD_REQUEST.value(), null);
        }
        return this.objMapper.mappingFranjasHorariasDTOResponse(HttpStatus.OK.value(), this.objMapper.mappingListFranjaHorariaModelToListFranjaHorariaDTOResponse(lstFranjasHorariasObtenidas));
    }
    
    @GetMapping("/franjas_horarias/{idDocente}")
    public ListarFranjasHorariasDTOResponse epGetAllFranjasHorariasPorDocente(@PathVariable @Min(1) int idDocente) {
        List<FranjaHoraria> lstFranjasHorariasObtenidas = this.objGestionarFranjaHorariaCUIntPort.listarPorDocente(idDocente);
        if(lstFranjasHorariasObtenidas.isEmpty()){
            return this.objMapper.mappingFranjasHorariasDTOResponse(HttpStatus.BAD_REQUEST.value(), null);
        }
        return this.objMapper.mappingFranjasHorariasDTOResponse(HttpStatus.OK.value(), this.objMapper.mappingListFranjaHorariaModelToListFranjaHorariaDTOResponse(lstFranjasHorariasObtenidas));
    }
}
