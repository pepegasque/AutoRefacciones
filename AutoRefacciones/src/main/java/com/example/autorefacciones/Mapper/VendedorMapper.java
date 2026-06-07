package com.example.autorefacciones.Mapper;

import com.example.autorefacciones.DTO.VendedorDTO;
import com.example.autorefacciones.Entity.Vendedor;

public class VendedorMapper {
    public static VendedorDTO toDTO(Vendedor vendedor){
        VendedorDTO dto = new VendedorDTO();

        dto.setId(vendedor.getId());
        dto.setNombre(vendedor.getNombre());
        dto.setEmpleado(vendedor.getEmpleado());

        if(vendedor.getSucursal() != null){
            dto.setSucursalId(vendedor.getSucursal().getId());
        }

        return dto;
    }
    public static Vendedor toEntity(VendedorDTO dto){
        Vendedor vendedor = new Vendedor();

        vendedor.setId(dto.getId());
        vendedor.setNombre(dto.getNombre());
        vendedor.setEmpleado(dto.getEmpleado());

        return vendedor;
    }
}
