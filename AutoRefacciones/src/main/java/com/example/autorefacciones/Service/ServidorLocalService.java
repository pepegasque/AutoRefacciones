package com.example.autorefacciones.Service;

import com.example.autorefacciones.DTO.ServidorLocalDTO;
import com.example.autorefacciones.Entity.ServidorLocal;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Exception.NotFoundException;
import com.example.autorefacciones.Repository.ServidorLocalRepository;
import com.example.autorefacciones.Repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorLocalService {

    private final ServidorLocalRepository repository;
    private final SucursalRepository sucursalRepository;

    public ServidorLocalService(ServidorLocalRepository repository, SucursalRepository sucursalRepository){
        this.repository = repository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<ServidorLocal>Listar(){
        return repository.findAll();
    }

    public ServidorLocal buscar(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("ServidorLocal no existe: " + id));
    }

    public ServidorLocal guardar(ServidorLocalDTO dto){
        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(()-> new NotFoundException("No existe: "));

        ServidorLocal servidorLocal = new ServidorLocal();

        servidorLocal.setNombre(dto.getNombre());
        servidorLocal.setIpRed(dto.getIpRed());
        servidorLocal.setSucursal(sucursal);

        return repository.save(servidorLocal);
    }

    public void eliminar(Long id){
        ServidorLocal servidorLocal = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("ServidorLocal no existe: " + id));
        repository.delete(servidorLocal);
    }

    public ServidorLocal actualizar(Long id, ServidorLocalDTO dto){
        ServidorLocal servidorLocal = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("ServidorLocal no existe: " + id));

        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(()-> new NotFoundException("No existe: "));

        servidorLocal.setNombre(dto.getNombre());
        servidorLocal.setIpRed(dto.getIpRed());
        servidorLocal.setSucursal(sucursal);

        return repository.save(servidorLocal);
    }
}
