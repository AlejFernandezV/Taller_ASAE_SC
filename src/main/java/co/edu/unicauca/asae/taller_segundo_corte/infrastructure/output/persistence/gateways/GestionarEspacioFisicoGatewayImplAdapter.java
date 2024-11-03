package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import java.util.List;
import java.util.Optional;

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
    private EspacioFisicoRepository espacioFisicoRepository;

    @Autowired
    private ModelMapper espacioFisicoMapper;

    @Override
    public boolean existeEspacioFisicoPorNombre(String nombre) {
        return espacioFisicoRepository.existsByNombre(nombre);
    }
    
    @Override
    public EspacioFisico guardar(EspacioFisico prmEspacioFisico) {
        EspacioFisicoEntity objEspacioFisicoEntity = this.espacioFisicoMapper.map(prmEspacioFisico, EspacioFisicoEntity.class);
        EspacioFisicoEntity objEspacioFisicoEntitySaved = this.espacioFisicoRepository.save(objEspacioFisicoEntity);
        return this.espacioFisicoMapper.map(objEspacioFisicoEntitySaved, EspacioFisico.class);
    }

    @Override
    public List<EspacioFisico> listar() {
        List<EspacioFisicoEntity> lstTuplas = this.espacioFisicoRepository.findAllByOrderByNombreAsc();
        return this.espacioFisicoMapper.map(lstTuplas, new TypeToken<List<EspacioFisico>>() {}.getType());
    }
    
    @Override
    public EspacioFisico eliminar(EspacioFisico objEspacioFisico) {
        EspacioFisicoEntity objEspacioFisicoEntity = this.espacioFisicoMapper.map(objEspacioFisico, EspacioFisicoEntity.class);
        this.espacioFisicoRepository.delete(objEspacioFisicoEntity);
        return objEspacioFisico;
    }

    @Override
    public EspacioFisico buscarPorId(int id) {
        Optional<EspacioFisicoEntity> objEspacioFisicoEntity = this.espacioFisicoRepository.findById(id);
        if (!objEspacioFisicoEntity.isPresent()) {
            return null;
        }
        return this.espacioFisicoMapper.map(objEspacioFisicoEntity.get(), EspacioFisico.class);
        
    }
    
}
