package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.EspacioFisicoDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.ListarEspaciosFisicosDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers.EspacioFisicoDTOToModelMapper;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspacioFisicoRestController {
    
    @Autowired
    private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUIntPort;
    @Autowired
    private final EspacioFisicoDTOToModelMapper objMapper;

    
    @GetMapping("/espacios_fisicos")
    public ListarEspaciosFisicosDTOResponse edGetAllEspaciosFisicos() {
        List<EspacioFisico> listEspacioFisicoEncontrada = this.objGestionarEspacioFisicoCUIntPort.listar();

        if(listEspacioFisicoEncontrada.isEmpty()){
            return this.objMapper.mappingEspaciosFisicosResponse(HttpStatus.BAD_REQUEST.value(), null); 
        }

        List<EspacioFisicoDTOResponse> listEspacioFisicoRespuesta = this.objMapper.mappingListEspacioFisicoModelToEspacioFisicoDTOResponse(listEspacioFisicoEncontrada);
        return this.objMapper.mappingEspaciosFisicosResponse(HttpStatus.OK.value(), listEspacioFisicoRespuesta);
    }
    
}
