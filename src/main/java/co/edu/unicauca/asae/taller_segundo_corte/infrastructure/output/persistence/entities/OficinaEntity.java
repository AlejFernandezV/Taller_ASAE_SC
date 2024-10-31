package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="oficina_id")
    private int idOficina;

    @Column(unique = true, length = 20)
    private String nombreOficina;
    
    @Column(length = 20)
    private String ubicacionOficina;
}
