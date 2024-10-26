package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativoEntity extends PersonaEntity {
    @Column(length = 255)
    private String rol;
}
