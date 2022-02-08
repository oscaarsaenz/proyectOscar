package com.example.proyectOscar;

import com.example.proyectOscar.ingles.Ingles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("trabajador")
public class ControladorTrabajador {

    @Autowired
    TrabajadorRepositorio trabajadorRepositorio;

    @PostMapping("/añadir")
    public Trabajador añadir(@RequestBody Trabajador trabajador){

        trabajadorRepositorio.save(trabajador);
        return trabajador;
    }

    @GetMapping("/verTodos")
    public List<Trabajador> verTodos(){
        return trabajadorRepositorio.findAll();
    }


    @GetMapping("verIngles/{palabra}")
    public ResponseEntity<Ingles> ver(@PathVariable String palabra){
        ResponseEntity<Ingles> responseEntity = new RestTemplate().getForEntity("http://localhost:8090/ingles/consultar/"+palabra, Ingles.class);
        return responseEntity.ok(responseEntity.getBody());
    }
}
