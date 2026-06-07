package com.example.autorefacciones.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "sucursal")
    private List<Vendedor>vendedor;

    @OneToMany(mappedBy = "sucursal")
    private List<Refaccion>refaccion;

    @OneToOne(mappedBy = "sucursal")
    private ServidorLocal servidorLocal;
}
