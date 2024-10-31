package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosDocenteIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosEspacioFisicoIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.FormateadorResultadosFranjaHorariaIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarEspacioFisicoGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.application.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller_segundo_corte.domain.useCases.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.taller_segundo_corte.domain.useCases.GestionarEspacioFisicoCUAdapter;
import co.edu.unicauca.asae.taller_segundo_corte.domain.useCases.GestionarFranjaHorariaCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, FormateadorResultadosDocenteIntPort objFormateadorResultados){
        return new GestionarDocenteCUAdapter(objGestionarDocenteGateway,objFormateadorResultados);
    }

    @Bean
    public GestionarEspacioFisicoCUAdapter crearGestionarEspacioFisicoCUAdapter(GestionarEspacioFisicoGatewayIntPort objGestionarEspacioFisicoGateway, FormateadorResultadosEspacioFisicoIntPort objFormateadorResultados){
        return new GestionarEspacioFisicoCUAdapter(objGestionarEspacioFisicoGateway,objFormateadorResultados);
    }

    @Bean
    public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUAdapter(GestionarFranjaHorariaGatewayIntPort objFranjaHorariaGateway, FormateadorResultadosFranjaHorariaIntPort objFormateadorResultados){
        return new GestionarFranjaHorariaCUAdapter(objFranjaHorariaGateway,objFormateadorResultados);
    }

}
