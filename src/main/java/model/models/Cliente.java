package model.models;

import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column
    private String direccion;

    @Column(nullable = false)
    private String telefono;//NO SIRVE EN LA BASE DE DATOS

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email", nullable = false, unique = true)///OJOCONESO
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;
}