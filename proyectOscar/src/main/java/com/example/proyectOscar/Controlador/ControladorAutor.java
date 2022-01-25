package com.example.proyectOscar.Controlador;

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
@RequestMapping("crudAutor")
public class ControladorAutor {

    @Autowired
    private AutorService as;

    //OPERACIONES CRUD AUTOR

    //devuelve el autor con el id que le pases
    @GetMapping("buscarAutor/{id}")
    public Autor buscarAutor(@PathVariable int id) {
        return as.buscarAutor(id);
    }

    //añade un autor a la base de datos
    @PostMapping("/añadirAutor")
    public Autor anadirAutor(@RequestBody Autor a){
        return as.añadirAutor(a);
    }

    //muestra todos los autores
    @GetMapping("/getAutores")
    public List<Autor> getAutores(){
        return as.getAutores();
    }

    //elimina un autor
    @DeleteMapping("/borrarAutor/{id}")
    public Boolean borrarAutor(@PathVariable int id){
        return as.borrarAutor(id);
    }

    //busca un autor por nombre
    @GetMapping("/buscAutor/{nombre}")
    public Autor buscAutor(@PathVariable String nombre){
        return as.buscAutor(nombre);
    }

    //elimina un autor por nombre
    @DeleteMapping("/borrarAutorNombre/{nombre}")
    public Boolean borrarAutorNombre(@PathVariable String nombre){
        return as.borrarAutorNombre(nombre);
    }

    //modifica un autor
    @PostMapping("actualizarAutor")
    public Boolean actualiuzarAutor(@RequestBody Autor a){
        return as.actualizarAutor(a);
    }
}
