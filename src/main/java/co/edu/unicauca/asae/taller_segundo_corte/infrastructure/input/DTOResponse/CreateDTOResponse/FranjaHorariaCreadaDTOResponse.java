package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.input.DTOResponse.CreateDTOResponse;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaCreadaDTOResponse {
    private int code;
    private boolean isCreated;
    private Date createdAt;
}
