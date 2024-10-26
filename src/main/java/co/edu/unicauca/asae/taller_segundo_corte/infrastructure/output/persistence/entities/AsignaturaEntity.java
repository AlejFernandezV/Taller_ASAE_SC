package co.edu.unicauca.asae.taller_segundo_corte.infrastructure.output.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignatura")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AsignaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asignatura_id")
    private int id;

    @Column(length = 255)
    private String nombre;
    
    @Column(length = 50)
    private String codigo;

    //Relaciones
    @OneToMany(
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE,},
        mappedBy= "objAsignatura"
    )
    private List<CursoEntity> lstCursos = new ArrayList<>();
}
