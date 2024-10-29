package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper crearMapper(){
        return new ModelMapper();
    }
}
