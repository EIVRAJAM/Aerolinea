package com.example.aerolineamodels.models;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity
@Table(name="Vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id_vuelo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_de_salida;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date hora_de_salida;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Date duracion;

    @Column(nullable = false, unique = true)
    private String capacidad;

    @ManyToMany(mappedBy = "vuelos")
    private ArrayList<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto")
    private Aeropuerto aeropuerto;

}
