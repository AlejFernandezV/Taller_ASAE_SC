package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers;

import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.EspacioFisicoDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.EspacioFisicoCreadoDTOResponse;

@Mapper(componentModel="spring")
public interface EspacioFisicoDTOToModelMapper {
    
    EspacioFisico mappingEspacioFisicoDTORequestToEspacioFisicoModel(EspacioFisicoDTORequest espacioFisicoRequest);
    
    EspacioFisicoCreadoDTOResponse mappingEspacioFisicoDTOResponse(int code, EspacioFisico espacioFisico, Date timestamp);
    
    EspacioFisicoCreadoDTOResponse mappingEspacioFisicoDTOResponse(EspacioFisico espacioFisico);
    
    public List<EspacioFisicoCreadoDTOResponse> mappingListEspacioFisicoModelToEspacioFisicoDTOResponse(List<EspacioFisico> lstEspaciosFisicos);
}
