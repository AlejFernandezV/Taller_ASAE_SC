package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.EspacioFisicoDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.ListarEspaciosFisicosDTOResponse;

@Mapper(componentModel="spring")
public interface EspacioFisicoDTOToModelMapper {
    ListarEspaciosFisicosDTOResponse mappingEspaciosFisicosResponse(int code, List<EspacioFisicoDTOResponse> results);
    List<EspacioFisicoDTOResponse> mappingListEspacioFisicoModelToEspacioFisicoDTOResponse(List<EspacioFisico> lstEspaciosFisicos); 
}
