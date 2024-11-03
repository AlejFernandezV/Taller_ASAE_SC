package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.DocenteEntity;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.PersonaEntity;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories.PersonaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{

    @Autowired
    private PersonaRepository docenteRepository;

    @Autowired
    private ModelMapper docenteMapper;

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

    @Override
    public List<Docente> listar() {
        Iterable<PersonaEntity> lstDocentes = this.docenteRepository.findAll();
        return this.docenteMapper.map(lstDocentes, new TypeToken<List<Docente>>() {}.getType());
    }

    @Override
    public Docente eliminar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteMapper.map(objDocente, DocenteEntity.class);
        this.docenteRepository.delete(objDocenteEntity);
        return objDocente;
    }

    @Override
    public Docente buscarPorId(int id) {
        Optional<PersonaEntity> objDocenteEntity = this.docenteRepository.findById(id);
        if (!objDocenteEntity.isPresent()) {
            return null;
        }
        return this.docenteMapper.map(objDocenteEntity.get(), Docente.class);
    }

    
    
}
