package com.example.autorefacciones.Controller;

import com.example.autorefacciones.DTO.VendedorDTO;
import com.example.autorefacciones.Entity.Vendedor;
import com.example.autorefacciones.Mapper.VendedorMapper;
import com.example.autorefacciones.Service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendedors")
public class VendedorController {

    private final VendedorService service;

    public VendedorController(VendedorService service){
        this.service = service;
    }
    @GetMapping("/listar")
    public List<VendedorDTO>Listar(){
        return service.Listar()
                .stream()
                .map(VendedorMapper :: toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping("/guardar")
    public VendedorDTO guardar(@RequestBody @Valid VendedorDTO dto){

        Vendedor vendedorGuardador = service.guardar(dto);

        return VendedorMapper.toDTO(vendedorGuardador);
    }
    @GetMapping("/buscar/{id}")
    public VendedorDTO buscar(@PathVariable Long Id){

        return VendedorMapper.toDTO(service.buscar(Id));
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long Id){
        service.eliminar(Id);
    }
    @PutMapping("/actualizar/{id}")
    public VendedorDTO actualizar(@PathVariable Long Id, @RequestBody @Valid VendedorDTO dto){

        Vendedor actualizar = service.actualizar(Id, dto);

        return VendedorMapper.toDTO(actualizar);
    }

}
