package com.example.proyectOscar.espanol;

import com.example.proyectOscar.espanol.EspanolDTO.EspanolInputDTO;
import com.example.proyectOscar.espanol.EspanolDTO.EspanolOutputDTO;
import com.example.proyectOscar.espanol.EspanolDTO.EspanolSimpleOutputDTO;
import com.example.proyectOscar.espanol.ServiceEspanol.EspanolImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("español")
public class ControladorEspanol {

    @Autowired
    private EspanolImplService es;

    @PostMapping("/añadir")
    public Optional<EspanolSimpleOutputDTO> añadir(@RequestBody @Valid EspanolInputDTO espanolInputDTO) {
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
