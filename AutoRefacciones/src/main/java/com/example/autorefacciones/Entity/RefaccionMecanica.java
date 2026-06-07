package com.example.autorefacciones.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RefaccionMecanica extends RefaccionHerencia{

    private String tipoAleacion;
}
