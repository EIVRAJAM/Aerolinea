package model.models;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_Origen_id")
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_Destino_id")
    private Aeropuerto aeropuertoDestino;

    @Column(name = "fecha_salida")
    private LocalDate fecha_salida;

    @Column(name = "exit_time")
    private Time tiempo_salida;

    @Column(name = "duracion")
    private Time duracion;

    @Column(name = "capacidad")
    private int capacidad;

    @ManyToMany(mappedBy = "vuelos")
    private List<Reserva> reservas;
}
