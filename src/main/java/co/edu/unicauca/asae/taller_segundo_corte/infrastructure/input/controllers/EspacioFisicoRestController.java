package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.EspacioFisicoDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.EspacioFisicoCreadoDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers.EspacioFisicoDTOToModelMapper;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspacioFisicoRestController {
    
    @Autowired
    private GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUIntPort;
    @Autowired
    private EspacioFisicoDTOToModelMapper objMapper;

    @PostMapping("/espacios_fisicos")
    public EspacioFisicoCreadoDTOResponse epPostEspacioFisico(@RequestBody EspacioFisicoDTORequest espacioFisicoData) {
        EspacioFisico objEspacioFisicoCrear = this.objMapper.mappingEspacioFisicoDTORequestToEspacioFisicoModel(espacioFisicoData);
        EspacioFisico objEspacioFisicoCreado = this.objGestionarEspacioFisicoCUIntPort.crear(objEspacioFisicoCrear);
        return this.objMapper.mappingEspacioFisicoDTOResponse(HttpStatus.CREATED.value(), objEspacioFisicoCreado, new Date());
    }

    @DeleteMapping("/espacios_fisicos/{id}")
    public EspacioFisicoCreadoDTOResponse eliminar(@PathVariable @Min(1) int id) {
        EspacioFisico objEspacioFisicoEliminado = this.objGestionarEspacioFisicoCUIntPort.eliminar(id);
        return this.objMapper.mappingEspacioFisicoDTOResponse(HttpStatus.OK.value(), objEspacioFisicoEliminado, new Date());
    }

    @GetMapping("/espacios_fisicos/{id}")
    public EspacioFisicoCreadoDTOResponse epGetEspacionFisicoPorId(@PathVariable @Min(1) int id) {
        EspacioFisico objEspacioFisico = this.objGestionarEspacioFisicoCUIntPort.buscarPorId(id);
        return this.objMapper.mappingEspacioFisicoDTOResponse(objEspacioFisico);
    }

    @GetMapping("/espacios_fisicos")
    public List<EspacioFisicoCreadoDTOResponse> edGetAllEspaciosFisicos() {
        List<EspacioFisico> listEspacioFisicoEncontrada = this.objGestionarEspacioFisicoCUIntPort.listar();
        return this.objMapper.mappingListEspacioFisicoModelToEspacioFisicoDTOResponse(listEspacioFisicoEncontrada);
    }
    
}
