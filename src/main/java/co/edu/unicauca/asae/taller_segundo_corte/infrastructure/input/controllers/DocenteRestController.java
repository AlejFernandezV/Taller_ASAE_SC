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
    
    @DeleteMapping("/docentes/{id}")
    public DocenteCreadoDTOResponse eliminar(@PathVariable @Min(1) int id) {
        Docente objDocenteEliminado = this.objGestionardocentesCUInt.eliminar(id);
        return this.objMapper.mappingDocenteDTOResponse(HttpStatus.OK.value(), objDocenteEliminado, new Date());
    }

     @GetMapping("/docentes/{id}")
    public DocenteCreadoDTOResponse epGetDocentePorID(@PathVariable @Min(1) int id) {
        Docente objDocente = this.objGestionardocentesCUInt.buscarPorId(id);
        return this.objMapper.mappingDocenteDTOResponse(objDocente);
    }

    @GetMapping("/docentes")
    public List<DocenteCreadoDTOResponse> epGetAllDocentes() {
        List<Docente> lstDocentes = this.objGestionardocentesCUInt.listar();
        return this.objMapper.mappingListDocenteModelToDocenteCreadoDTOResponse(lstDocentes);
    }
}
