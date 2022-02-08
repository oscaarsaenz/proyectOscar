package com.example.proyectOscar.editorial;

import com.example.proyectOscar.editorial.EditorialDTO.EditorialInputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialOutputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialSimpleOutputDTO;
import com.example.proyectOscar.editorial.ServiceEditorial.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("editorial")
public class ControladorEditorial {
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Autowired
    private EditorialService es;

    @PostMapping("/añadir")
    public EditorialSimpleOutputDTO añadir(@RequestBody @Valid EditorialInputDTO editorialInputDTO) {
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
