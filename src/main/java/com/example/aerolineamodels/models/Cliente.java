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
@Table(name = "clientes")
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private Long id_cliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column
    private String direccion;

    @Column(nullable = false)
    private int telefono;

    @Column (nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Reserva> reservas;

}