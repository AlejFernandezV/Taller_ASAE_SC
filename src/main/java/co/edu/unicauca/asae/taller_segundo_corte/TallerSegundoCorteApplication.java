package co.edu.unicauca.asae.taller_segundo_corte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.unicauca.asae.taller_segundo_corte")
public class TallerSegundoCorteApplication{

	public static void main(String[] args) {
		SpringApplication.run(TallerSegundoCorteApplication.class, args);
	}

}
