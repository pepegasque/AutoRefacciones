package com.example.autorefacciones.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendedorDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @Positive
    @NotNull
    private Integer empleado;

    @NotNull
    private Long sucursalId;
}
