package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio_fisico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="espacio_fisico_id")
    private int id;
    @Column(unique = true, length = 25)
    private String nombre;
    private String capacidad;

    // Relaciones
    @OneToMany(
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
        fetch =  FetchType.LAZY, 
        mappedBy = "objEspacioFisico"
    )
    private List<FranjaHorariaEntity> lstFranjasHorarias = new ArrayList<>();
}
