package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers;

import java.util.Date;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.DocenteCreadoDTOResponse;

@Mapper(componentModel="spring")
public interface DocenteDTOToModelMapper {
    Docente mappingDocenteDTORequestToDocenteModel(DocenteDTORequest docenteRequest);

    // @Mapping(target="code",source="code")
    // @Mapping(target="isCreated",source="isCreated")
    // @Mapping(target="createdAt",source="createdAt")
    DocenteCreadoDTOResponse mappingDocenteDTOResponse(int code, boolean isCreated, Date createdAt);
}
