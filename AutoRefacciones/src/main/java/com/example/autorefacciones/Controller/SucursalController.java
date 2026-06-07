package com.example.autorefacciones.Controller;

import com.example.autorefacciones.DTO.SucursalDTO;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Mapper.SucursalMapper;
import com.example.autorefacciones.Service.SucursalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sucursals")
public class SucursalController {

    private final SucursalService service;

    public SucursalController(SucursalService service){
        this.service = service;
    }
    @GetMapping("/listar")
    public List<SucursalDTO>Listar(){
        return service.Listar()
                .stream()
                .map(SucursalMapper :: toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping("/guardar")
    public SucursalDTO guardar(@RequestBody @Valid SucursalDTO dto){

        Sucursal sucursalGuardado = service.guardar(dto);

        return SucursalMapper.toDTO(sucursalGuardado);
    }
    @GetMapping("/buscar/{id}")
    public SucursalDTO buscar(@PathVariable Long Id){
        return SucursalMapper.toDTO(service.buscar(Id));
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long Id){
        service.eliminar(Id);
    }
    @PutMapping("/actualizar/{id}")
    public SucursalDTO actualizar(@PathVariable Long Id, @RequestBody @Valid SucursalDTO dto){

        Sucursal actualizar = service.actualizar(Id, dto);

        return SucursalMapper.toDTO(actualizar);
    }
}
