package com.example.autorefacciones.Entity;

import com.example.autorefacciones.Interfaces.NormativaISO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RefaccionElectrica extends RefaccionHerencia implements NormativaISO {

    private Integer voltaje;

    @Override
    public void generarReporteEstado(){
        System.out.println("Reporte Electrivo");
    }
    @Override
    public void calibrar(){
        System.out.println("Motor calibrado");
    }
}
