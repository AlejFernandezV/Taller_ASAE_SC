package co.edu.unicauca.asae.taller_segundo_corte.domain.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unicauca.asae.taller_segundo_corte.application.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosDocenteIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.models.Docente;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort{

    @Autowired
    private GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    
    @Autowired
    private FormateadorResultadosDocenteIntPort objFormateadorResultados;

    @Override
    public Docente crear(Docente prmDocente) {
        if(this.objGestionarDocenteGateway.existeDocentePorCorreo(prmDocente.getCorreo())){
            return this.objFormateadorResultados.preparaRespuestaFallidaCrearDocente("El docente con esa información ya esta creado");
        }
        return this.objGestionarDocenteGateway.guardar(prmDocente);
    }    

    @Override
    public Docente eliminar(int id) {
        Docente objDocente = this.objGestionarDocenteGateway.buscarPorId(id);
        if(objDocente == null) {
            return this.objFormateadorResultados.preparaRespuestaFallidaEliminarDocente("El docente no existe");
        }
        return this.objGestionarDocenteGateway.eliminar(objDocente);
    }

    @Override
    public Docente buscarPorId(int id) {
        Docente objDocente = this.objGestionarDocenteGateway.buscarPorId(id);
        if(objDocente == null) {
            return this.objFormateadorResultados.preparaRespuestaFallidaBuscarDocente("El docente no existe");
        }
        return objDocente;
    }

    @Override
    public List<Docente> listar() {
        List<Docente> lstDocentes = this.objGestionarDocenteGateway.listar();
        if(lstDocentes.isEmpty()) {
            return this.objFormateadorResultados.preparaRespuestaFallidaListarDocentes("No hay docentes registrados");
        }
        return lstDocentes;
    }
}
