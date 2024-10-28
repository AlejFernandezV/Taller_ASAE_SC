package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.FranjaHorariaDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.FranjaHorariaDTOResponse;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.GetDTOResponse.ListarFranjasHorariasDTOResponse;

@Mapper(componentModel="spring")
public interface FranjaHorariaDTOToModelMapper {

    @Mapping(target="objEspacioFisico.id", source="idEspacioFisico")
    @Mapping(target="objCurso.id", source="idCurso")
    FranjaHoraria mappingFranjaHorariaDTOReqToFranjaHorariaModel(FranjaHorariaDTORequest FHReq);

    ListarFranjasHorariasDTOResponse mappingFranjasHorariasDTOResponse(int code, List<FranjaHorariaDTOResponse> results);
}
