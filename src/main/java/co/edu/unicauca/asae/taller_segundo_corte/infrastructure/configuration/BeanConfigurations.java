package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_segundo_corte.domain.useCases.GestionarDocenteCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUAdapter(){
        //TO DO: 
        // Implementar correctamente el metodo
        return new GestionarDocenteCUAdapter();
    }
}
