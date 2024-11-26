package model.models;

import java.time.LocalDate;
import java.util.List;
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
    private Long id;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="numeroPasajeros")
    private int numeroPasajeros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY)
    private List<Pasajero> pasajeros;

    @ManyToMany
    @JoinTable(
            name = "vuelos_reservas",
            joinColumns = @JoinColumn(name = "reserva_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vuelos_id", referencedColumnName = "id")
    ) private List<Vuelo> vuelos;
}

