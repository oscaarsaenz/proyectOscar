package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolSimpleOutputDTO;
import com.example.proyectOscar.services.Espanol.EspanolImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("español")
public class ControladorEspanol {

    @Autowired
    private EspanolImplService es;

    @PostMapping("/añadir")
    public EspanolSimpleOutputDTO añadir(@RequestBody EspanolInputDTO espanolInputDTO) {
        return es.añadir(espanolInputDTO);
    }

    @GetMapping("/consultar/{palabra}")
    public EspanolOutputDTO consultar(@PathVariable String palabra){
        return es.consultar(palabra);
    }
    @GetMapping("/consultarTodos")
    public List<EspanolSimpleOutputDTO> consultarTodos(){
        return es.consultarTodo();
    }
    @DeleteMapping("/borrar/{palabra}")
    public void borrar(@PathVariable String palabra){
        es.borrar(palabra);
    }

}
