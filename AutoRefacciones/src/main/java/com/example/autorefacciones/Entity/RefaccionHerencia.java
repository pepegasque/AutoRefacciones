package com.example.autorefacciones.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RefaccionHerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer codigo;
    private BigDecimal precio;
}
