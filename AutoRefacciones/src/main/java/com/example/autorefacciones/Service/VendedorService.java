package com.example.autorefacciones.Service;

import com.example.autorefacciones.DTO.VendedorDTO;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Entity.Vendedor;
import com.example.autorefacciones.Exception.NotFoundException;
import com.example.autorefacciones.Repository.SucursalRepository;
import com.example.autorefacciones.Repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    private final VendedorRepository repository;
    private final SucursalRepository sucursalRepository;

    public VendedorService(VendedorRepository repository,SucursalRepository sucursalRepository){
        this.repository = repository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<Vendedor>Listar(){
        return repository.findAll();
    }

    public Vendedor buscar(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Vendedor no existe: " + id));
    }

    public Vendedor guardar(VendedorDTO dto){
        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(()-> new NotFoundException("Sucursal no existe: "));

        Vendedor vendedor = new Vendedor();

        vendedor.setNombre(dto.getNombre());
        vendedor.setEmpleado(dto.getEmpleado());
        vendedor.setSucursal(sucursal);

        return repository.save(vendedor);
    }

    public void eliminar(Long id){
        Vendedor vendedor = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("No existe: " + id));
        repository.delete(vendedor);
    }

    public Vendedor actualizar(Long id, VendedorDTO dto){
        Vendedor vendedor = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Vendedor no existe: " + id));

        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(()-> new NotFoundException("No existe:"));

        vendedor.setNombre(dto.getNombre());
        vendedor.setEmpleado(dto.getEmpleado());
        vendedor.setSucursal(sucursal);

        return repository.save(vendedor);
    }
}
