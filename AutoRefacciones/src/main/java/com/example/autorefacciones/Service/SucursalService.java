package com.example.autorefacciones.Service;

import com.example.autorefacciones.DTO.SucursalDTO;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Exception.NotFoundException;
import com.example.autorefacciones.Repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository repository;

    public SucursalService(SucursalRepository repository){
        this.repository = repository;
    }

    public List<Sucursal>Listar(){
        return repository.findAll();
    }

    public Sucursal buscar(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Sucursal no existe: " + id));
    }

    public Sucursal guardar(SucursalDTO dto){
        Sucursal sucursal = new Sucursal();

        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());

        return repository.save(sucursal);
    }

    public void eliminar(Long id){
        Sucursal sucursal = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Sucursal no existe: " + id));

        repository.delete(sucursal);
    }

    public Sucursal actualizar(Long id, SucursalDTO dto){
        Sucursal sucursal = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Sucursal no existe: " + id));

        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());

        return repository.save(sucursal);
    }
}
