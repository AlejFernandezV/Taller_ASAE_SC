package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse;

import java.sql.Date;

import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspacioFisicoCreadoDTOResponse {
    private int code;
    private EspacioFisico espacioFisico;
    private Date timestamp;
}
