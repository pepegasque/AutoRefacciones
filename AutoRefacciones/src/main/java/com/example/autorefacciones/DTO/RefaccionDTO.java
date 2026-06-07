package com.example.autorefacciones.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class RefaccionDTO {

    private Long id;

    private String nombre;

    @Positive
    @NotNull
    private Integer codigo;

    @Positive
    @NotNull
    private BigDecimal precio;

    @NotBlank
    private String tipoRefaccion;

    @NotBlank
    private String tipoAleacion;

    @Positive
    @NotNull
    private Integer voltaje;

    @NotNull
    private Long sucursalId;
}
