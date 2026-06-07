package com.example.autorefacciones.Service;

import com.example.autorefacciones.DTO.RefaccionDTO;
import com.example.autorefacciones.Entity.Refaccion;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Exception.NotFoundException;
import com.example.autorefacciones.Repository.RefaccionRepository;
import com.example.autorefacciones.Repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefaccionService {

    private final RefaccionRepository repository;
    private final SucursalRepository sucursalRepository;

    public RefaccionService(RefaccionRepository repository, SucursalRepository sucursalRepository){
        this.repository = repository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<Refaccion>Listar(){
        return repository.findAll();
    }

    public Refaccion buscar(Long id){
        return  repository.findById(id)
                .orElseThrow(()-> new NotFoundException("No existe: " + id));
    }

    public Refaccion guardar(RefaccionDTO dto){
        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(()-> new NotFoundException("Sucursal no existe"));

        Refaccion refaccion = new Refaccion();

        refaccion.setNombre(dto.getNombre());
        refaccion.setPrecio(dto.getPrecio());
        refaccion.setTipoRefaccion(dto.getTipoRefaccion());
        refaccion.setTipoAleacion(dto.getTipoAleacion());
        refaccion.setVoltaje(dto.getVoltaje());
        refaccion.setSucursal(sucursal);

        return repository.save(refaccion);
    }

    public void eliminar(Long id){
        Refaccion refaccion = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("No existe" + id));
        repository.delete(refaccion);
    }

    public Refaccion actualizar(Long id, RefaccionDTO dto) {
        Refaccion refaccion = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Refaccion no existe: " + id));

        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(() -> new NotFoundException("No existe: "));

        refaccion.setNombre(dto.getNombre());
        refaccion.setPrecio(dto.getPrecio());
        refaccion.setTipoRefaccion(dto.getTipoRefaccion());
        refaccion.setTipoAleacion(dto.getTipoAleacion());
        refaccion.setVoltaje(dto.getVoltaje());
        refaccion.setSucursal(sucursal);

        return repository.save(refaccion);

    }

}
