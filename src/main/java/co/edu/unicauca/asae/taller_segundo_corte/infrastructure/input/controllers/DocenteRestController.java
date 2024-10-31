package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.DocenteCreadoDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers.DocenteDTOToModelMapper;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DocenteRestController {
    
    @Autowired
    private GestionarDocenteCUIntPort objGestionardocentesCUInt;

    @Autowired
    private DocenteDTOToModelMapper objMapper;

    @PostMapping("/docentes")
    public DocenteCreadoDTOResponse epPostDocente(@RequestBody DocenteDTORequest docenteData) {
        Docente objDocenteCrear = this.objMapper.mappingDocenteDTORequestToDocenteModel(docenteData);
        Docente objDocenteCreado = this.objGestionardocentesCUInt.crear(objDocenteCrear);
        return this.objMapper.mappingDocenteDTOResponse(HttpStatus.CREATED.value(), objDocenteCreado, new Date());
    }
    
}
