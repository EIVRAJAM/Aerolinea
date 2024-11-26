package model.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aerolineas")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name="codigo_aerolinea", nullable = false, unique = true)
    private String codigo_aerolinea;

    //pais_origen
    private String pais_origen;

    @OneToMany(mappedBy = "aerolinea")
    private List<Vuelo> vuelos;
}
