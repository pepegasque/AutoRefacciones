package com.example.autorefacciones.Entity;

import com.example.autorefacciones.Interfaces.NormativaISO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ServidorLocal implements NormativaISO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ipRed;

    @OneToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @Override
    public void generarReporteEstado(){
        System.out.println("Reporte Servidor");
    }
    @Override
    public  void calibrar(){
        System.out.println("Servidor calibrado");
    }
}
