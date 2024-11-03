package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.mappers;

import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTORequest.CreateDTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse.DocenteCreadoDTOResponse;

@Mapper(componentModel="spring")
public interface DocenteDTOToModelMapper {

    Docente mappingDocenteDTORequestToDocenteModel(DocenteDTORequest docenteRequest);

    DocenteCreadoDTOResponse mappingDocenteDTOResponse(int code,Docente docente, Date createdAt);

    DocenteCreadoDTOResponse mappingDocenteDTOResponse(Docente docente);
    
    public List<DocenteCreadoDTOResponse> mappingListDocenteModelToDocenteCreadoDTOResponse(List<Docente> docentes);
}
