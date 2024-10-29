package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.EspacioFisico;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories.EspacioFisicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionarEspacioFisicoGatewayImplAdapter implements GestionarEspacioFisicoGatewayIntPort{

    @Autowired
    private final EspacioFisicoRepository espacioFisicoRepository;

    @Autowired
    private final ModelMapper espacioFisicoMapper;

    @Override
    public List<EspacioFisico> listar() {
        List<EspacioFisicoEntity> lstTuplas = this.espacioFisicoRepository.findAll();
        return this.espacioFisicoMapper.map(lstTuplas, new TypeToken<List<EspacioFisico>>() {}.getType());
    }
    
}
