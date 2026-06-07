package com.example.autorefacciones.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SucursalDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;
}
