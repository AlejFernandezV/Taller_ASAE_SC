package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarCursoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.repositories.CursoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GestionarCursoGatewayImplAdapter implements GestionarCursoGatewayIntPort{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public boolean cursoTieneDocente(int idCurso) {
        return this.cursoRepository.existsByIdAndHasDocentes(idCurso);
    }

    @Override
    public boolean cursoExiste(int idCurso) {
        return this.cursoRepository.existsById(idCurso);
    }
}
