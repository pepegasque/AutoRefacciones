package com.example.autorefacciones.Mapper;

import com.example.autorefacciones.DTO.RefaccionDTO;
import com.example.autorefacciones.Entity.Refaccion;

public class RefaccionMapper {
    public static RefaccionDTO toDTO (Refaccion refaccion){
        RefaccionDTO dto = new RefaccionDTO();

        dto.setId(refaccion.getId());
        dto.setNombre(refaccion.getNombre());
        dto.setCodigo(refaccion.getCodigo());
        dto.setPrecio(refaccion.getPrecio());
        dto.setTipoRefaccion(refaccion.getTipoRefaccion());
        dto.setTipoAleacion(refaccion.getTipoAleacion());
        dto.setVoltaje(refaccion.getVoltaje());

        if(refaccion.getSucursal() != null){
            dto.setSucursalId(refaccion.getSucursal().getId());
        }
        return dto;
    }
    public static Refaccion toEntity (RefaccionDTO dto){
        Refaccion refaccion = new Refaccion();

        refaccion.setId(dto.getId());
        refaccion.setNombre(dto.getNombre());
        refaccion.setCodigo(dto.getCodigo());
        refaccion.setPrecio(dto.getPrecio());
        refaccion.setTipoRefaccion(dto.getTipoRefaccion());
        refaccion.setTipoAleacion(dto.getTipoAleacion());
        refaccion.setVoltaje(dto.getVoltaje());

        return refaccion;
    }
}
