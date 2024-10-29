package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.DocenteEntity;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories.PersonaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{

    @Autowired
    private final PersonaRepository docenteRepository;

    @Autowired
    private final ModelMapper docenteMapper;

    @Override
    public boolean existeDocentePorCorreo(String prmCorreo) {
        return this.docenteRepository.existsByCorreo(prmCorreo);
    }

    @Override
    public Docente guardar(Docente prmDocente) {
        DocenteEntity objDocenteEntity = this.docenteMapper.map(prmDocente, DocenteEntity.class);
        DocenteEntity objDocenteEntitySaved = this.docenteRepository.save(objDocenteEntity);
        return this.docenteMapper.map(objDocenteEntitySaved, Docente.class);
    }
}
