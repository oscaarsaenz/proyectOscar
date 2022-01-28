package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.DTO.Autor.AutorInputDTO;
import com.example.proyectOscar.DTO.Autor.AutorSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.AutorRepositorio;
import com.example.proyectOscar.Modelo.Autor;
import com.example.proyectOscar.services.Autor.AutorImplService;
import com.example.proyectOscar.services.Autor.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("autor")
public class ControladorAutor {

    @Autowired
    private AutorImplService as;

    //OPERACIONES CRUD AUTOR

    //añade un autor a la base de datos
    @PostMapping("/añadir")
    public AutorSimpleOutputDTO anadirAutor(@RequestBody AutorInputDTO a){
        return as.añadirAutor(a);
    }

    //muestra todos los autores
    @GetMapping("/getAutores")
    public List<AutorSimpleOutputDTO> getAutores(){
        return as.getAutores();
    }

    //elimina un autor
    @DeleteMapping("/borrar/{nombre}")
    public Boolean borrarAutor(@PathVariable String nombre){
        return as.borrar(nombre);
    }

    //busca un autor por nombre
    @GetMapping("/buscAutor/{nombre}")
    public AutorSimpleOutputDTO buscAutor(@PathVariable String nombre){
        return as.buscAutor(nombre);
    }

    //modifica un autor
    @PostMapping("/modificar")
    public AutorSimpleOutputDTO actualiuzarAutor(@RequestBody AutorInputDTO a){
        return as.modificar(a);
    }
}
