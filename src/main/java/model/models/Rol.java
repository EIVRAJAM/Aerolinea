package model.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rol {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Enumerated(EnumType.STRING)
        private ERol role;

}
