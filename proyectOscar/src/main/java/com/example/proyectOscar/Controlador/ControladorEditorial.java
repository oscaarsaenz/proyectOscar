package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.DTO.Editorial.EditorialInputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialOutputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialSimpleOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.EditorialRepositorio;
import com.example.proyectOscar.services.Editorial.EditorialService;
import com.example.proyectOscar.services.Espanol.EspanolImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("editorial")
public class ControladorEditorial {
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Autowired
    private EditorialService es;

    @PostMapping("/añadir")
    public EditorialSimpleOutputDTO añadir(@RequestBody EditorialInputDTO editorialInputDTO) {
        return es.añadir(editorialInputDTO);
    }

    @GetMapping("/consultar/{palabra}")
    public EditorialOutputDTO consultar(@PathVariable String palabra){
        return es.consultar(palabra);
    }
    @GetMapping("/consultarTodos")
    public List<EditorialSimpleOutputDTO> consultarTodos(){
        return es.consultarTodo();
    }
    @DeleteMapping("/borrar/{palabra}")
    public void borrar(@PathVariable String palabra){
        es.borrar(palabra);
    }

}
