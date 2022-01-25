package com.example.proyectOscar.services.Autor;

import com.example.proyectOscar.Interfaces.AutorRepositorio;
import com.example.proyectOscar.Modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AutorImplService implements AutorService {

    private AutorRepositorio autorRepositorio;

    @Autowired
    public AutorImplService(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    //devuelve el autor con el id que le pases
    public Autor buscarAutor(@PathVariable int id) {
        List <Autor> aux = autorRepositorio.findAll();
        for (int a =0;a<aux.size();a++){
            Autor au =aux.get(a);
            if(au.getId()==id){
                return au;
            }
        }
        return null;
    }

    //añade un autor a la base de datos
    public Autor añadirAutor(@RequestBody Autor a){
        autorRepositorio.save(a);
        return a;
    }

    //muestra todos los autores
    public List<Autor> getAutores(){
        return autorRepositorio.findAll();
    }

    //elimina un autor
    public Boolean borrarAutor(@PathVariable int id){
        autorRepositorio.deleteById(id);
        return true;
    }

    //busca un autor por nombre
    public Autor buscAutor(@PathVariable String nombre){
        return autorRepositorio.findByName(nombre);
    }

    //elimina un autor por nombre
    public Boolean borrarAutorNombre(@PathVariable String nombre){
        if(autorRepositorio.findByName(nombre)==null){
            return false;
        }
        autorRepositorio.deleteById(autorRepositorio.findByName(nombre).getId());
        return true;
    }

    //modifica un autor
    public Boolean actualizarAutor(@RequestBody Autor a){
        if(autorRepositorio.findById(a.getId())==null){
            return false;
        }
        autorRepositorio.deleteById(a.getId());
        autorRepositorio.save(a);
        return true;
    }
}
