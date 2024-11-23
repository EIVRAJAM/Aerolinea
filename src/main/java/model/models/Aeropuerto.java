package model.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "aeropuertos")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String ciudad;
    private String pais;

    @OneToMany(mappedBy = "aeropuertoOrigen", fetch = FetchType.LAZY)
    private List<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "aeropuertoDestino", fetch = FetchType.LAZY)
    private List<Vuelo> vuelosDestino;

}
