package com.example.autorefacciones.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer empleado;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
