package com.example.autorefacciones.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Refaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer codigo;
    private BigDecimal precio;
    private String tipoRefaccion;
    private String tipoAleacion;
    private Integer voltaje;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
