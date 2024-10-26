package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.FranjaHoraria;

public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaIntPort{

    @Override
    public FranjaHoraria crear(FranjaHoraria prmFranjaHoraria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Iterable<FranjaHoraria> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Iterable<FranjaHoraria> listarPorDocente(int prmIdDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorDocente'");
    }
    
}
