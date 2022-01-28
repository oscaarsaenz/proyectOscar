package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.DTO.Ingles.InglesInputDTO;
import com.example.proyectOscar.DTO.Ingles.InglesSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.EspanolRepositorio;
import com.example.proyectOscar.services.Ingles.InglesImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("ingles")
public class ControladorIngles {
    @Autowired
    InglesImplService inglesImplService;

    @PostMapping("/añadir")
    public InglesSimpleOutputDTO añadir(@RequestBody InglesInputDTO inglesInputDTO){
        return inglesImplService.añadir(inglesInputDTO);
    }
    @GetMapping("/consultar/{palabra}")
    public InglesSimpleOutputDTO consultar(@PathVariable String palabra){
        return inglesImplService.consultar(palabra);
    }
    @GetMapping("/consultarTodos")
    public List<InglesSimpleOutputDTO> consultarTodos(){
        return inglesImplService.consultarTodos();
    }
    @DeleteMapping("/borrar/{palabra}")
    public Boolean borrar(@PathVariable String palabra){
        return inglesImplService.borrar(palabra);
    }
    @PostMapping("/modificar")
    public InglesSimpleOutputDTO modificar(@RequestBody InglesInputDTO inglesInputDTO){
        return inglesImplService.modificar(inglesInputDTO);
    }
}
