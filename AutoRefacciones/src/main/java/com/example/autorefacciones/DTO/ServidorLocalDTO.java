package com.example.autorefacciones.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class ServidorLocalDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String ipRed;

    @NotNull
    private Long sucursalId;
}
