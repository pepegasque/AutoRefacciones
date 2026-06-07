package com.example.autorefacciones.Mapper;

import com.example.autorefacciones.DTO.ServidorLocalDTO;
import com.example.autorefacciones.Entity.ServidorLocal;

public class ServidorLocalMapper {
    public static ServidorLocalDTO toDTO(ServidorLocal servidorLocal){
        ServidorLocalDTO dto = new ServidorLocalDTO();

        dto.setId(servidorLocal.getId());
        dto.setNombre(servidorLocal.getNombre());
        dto.setIpRed(servidorLocal.getIpRed());

        if(servidorLocal.getSucursal() != null){
            dto.setSucursalId(servidorLocal.getSucursal().getId());
        }

        return dto;
    }
    public static ServidorLocal toEntity(ServidorLocalDTO dto){
        ServidorLocal servidorLocal = new ServidorLocal();

        servidorLocal.setId(dto.getId());
        servidorLocal.setNombre(dto.getNombre());
        servidorLocal.setIpRed(dto.getIpRed());

        return servidorLocal;
    }
}
