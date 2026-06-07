package com.example.autorefacciones.Controller;

import com.example.autorefacciones.DTO.ServidorLocalDTO;
import com.example.autorefacciones.Entity.ServidorLocal;
import com.example.autorefacciones.Mapper.ServidorLocalMapper;
import com.example.autorefacciones.Service.ServidorLocalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servidorLocals")
public class ServidorLocalController {

    private final ServidorLocalService service;

    public ServidorLocalController(ServidorLocalService service){
        this.service = service;
    }
    @GetMapping("/listar")
    public List<ServidorLocalDTO>Listar(){
        return service.Listar()
                .stream()
                .map(ServidorLocalMapper :: toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping("/guardar")
    public ServidorLocalDTO guardar(@RequestBody @Valid ServidorLocalDTO dto){

        ServidorLocal servidorLocalGuardado = service.guardar(dto);

        return ServidorLocalMapper.toDTO(servidorLocalGuardado);
    }
    @GetMapping("/buscar/{id}")
    public ServidorLocalDTO buscar(@PathVariable Long Id){

        return ServidorLocalMapper.toDTO(service.buscar(Id));
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long Id){
        service.eliminar(Id);
    }
    @PutMapping("/actualizar/{id}")
    public ServidorLocalDTO actualizar(@PathVariable Long Id,@RequestBody @Valid ServidorLocalDTO dto){

        ServidorLocal actualizar = service.actualizar(Id, dto);

        return ServidorLocalMapper.toDTO(actualizar);
    }
}
