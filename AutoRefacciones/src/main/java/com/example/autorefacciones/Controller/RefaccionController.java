package com.example.autorefacciones.Controller;

import com.example.autorefacciones.DTO.RefaccionDTO;
import com.example.autorefacciones.Entity.Refaccion;
import com.example.autorefacciones.Mapper.RefaccionMapper;
import com.example.autorefacciones.Service.RefaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/refaccions")
public class RefaccionController {

    private final RefaccionService service;

    public RefaccionController(RefaccionService service){
        this.service = service;
    }

    @GetMapping("/listar")
    public List<RefaccionDTO>Listar(){
        return service.Listar()
                .stream()
                .map(RefaccionMapper :: toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping("/guardar")
    public RefaccionDTO guardar(@RequestBody @Valid RefaccionDTO dto){
        Refaccion refaccionGuardado = service.guardar(dto);
        return RefaccionMapper.toDTO(refaccionGuardado);
    }
    @GetMapping("/buscar/{Id}")
    public RefaccionDTO buscar(@PathVariable Long Id){

        return RefaccionMapper.toDTO(service.buscar(Id));
    }
    @DeleteMapping("/eliminar/{Id}")
    public void eliminar(@PathVariable Long Id){
        service.eliminar(Id);
    }
    @PutMapping("/actualizar/{Id}")
    public RefaccionDTO actualizar(@PathVariable Long Id, @RequestBody @Valid RefaccionDTO dto){

        Refaccion actualizar = service.actualizar(Id, dto);

        return RefaccionMapper.toDTO(actualizar);
    }
}
