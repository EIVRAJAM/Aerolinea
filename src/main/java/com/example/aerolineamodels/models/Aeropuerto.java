package com.example.aerolineamodels.models;

import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private Long id_aeropuerto;

    private String nombre;
    private String ciudad;
    private String pais;

    @OneToMany(mappedBy = "aeropuerto", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Vuelo> vuelos;

}
