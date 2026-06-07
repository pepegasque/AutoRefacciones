package com.example.autorefacciones.Mapper;

import com.example.autorefacciones.DTO.SucursalDTO;
import com.example.autorefacciones.Entity.Sucursal;

public class SucursalMapper {
    public static SucursalDTO toDTO(Sucursal sucursal){
        SucursalDTO dto = new SucursalDTO();

        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());

        return dto;
    }
    public static Sucursal toEntity(SucursalDTO dto){
        Sucursal sucursal = new Sucursal();

        sucursal.setId(dto.getId());
        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());

        return sucursal;
    }
}
