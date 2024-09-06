package com.example.aerolineamodels.models;

import java.time.LocalDateTime;
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
@Table(name = "reservas")

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Pasajero> pasajeros;

    private LocalDateTime fechaReserva;
    private int numeroPasajeros;

    @ManyToMany
    @JoinTable(
            name = "reserva_vuelo",
            joinColumns = @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    )
    private ArrayList<Vuelo> vuelos;
}

