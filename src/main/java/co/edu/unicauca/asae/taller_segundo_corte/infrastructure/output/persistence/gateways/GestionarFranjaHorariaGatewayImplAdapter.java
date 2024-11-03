package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories.FranjaHorariaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionarFranjaHorariaGatewayImplAdapter implements GestionarFranjaHorariaGatewayIntPort{

    @Autowired
    private FranjaHorariaRepository franjaHorariaRepository;
    
    @Autowired
    private ModelMapper franjaHorariaMapper;

    @Override
    public boolean isDocenteDisponibleParaFH(String dia, LocalTime horaInicio, LocalTime horaFin, int idDocente) {
        return this.franjaHorariaRepository.isDocenteOcupado(dia, horaInicio, horaFin, idDocente);
    }

    @Override
    public boolean isEspacioFisicoDisponibleParaFH(String dia, LocalTime horaInicio, LocalTime horaFin,int idEspacioFisico) {
        return this.franjaHorariaRepository.isEspacioFisicoOcupado(dia, horaInicio, horaFin, idEspacioFisico);
    }

    @Override
    public FranjaHoraria guardar(FranjaHoraria prmFranjaHoraria) {
        FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaMapper.map(prmFranjaHoraria, FranjaHorariaEntity.class);
        FranjaHorariaEntity objFranjaHorariaEntitySaved = this.franjaHorariaRepository.save(objFranjaHorariaEntity);
        return this.franjaHorariaMapper.map(objFranjaHorariaEntitySaved, FranjaHoraria.class);
    }

    @Override
    public List<FranjaHoraria> listar() {
        List<FranjaHorariaEntity> lstTuplas = this.franjaHorariaRepository.findAll();
        return this.franjaHorariaMapper.map(lstTuplas, new TypeToken<List<FranjaHoraria>>(){}.getType());
    }

    @Override
    public List<FranjaHoraria> listarPorDocente(int prmIdDocente) {
        List<FranjaHorariaEntity> lstTuplas = this.franjaHorariaRepository.findAllByDocenteId(prmIdDocente);
        return this.franjaHorariaMapper.map(lstTuplas, new TypeToken<List<FranjaHoraria>>(){}.getType());
    }

}
