package com.example.proyectOscar.autor.ServiceAutor;

import com.example.proyectOscar.autor.AutorDTO.AutorInputDTO;
import com.example.proyectOscar.autor.AutorDTO.AutorSimpleOutputDTO;
import com.example.proyectOscar.autor.AutorRepositorio;
import com.example.proyectOscar.autor.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorImplService implements AutorService {

    private AutorRepositorio autorRepositorio;

    @Autowired
    public AutorImplService(AutorRepositorio autorRepositorio){
        this.autorRepositorio=autorRepositorio;
    }

    //metodo que añade el autor que le pasas a la base de datos
    @Override
    public AutorSimpleOutputDTO añadirAutor(AutorInputDTO autorInputDTO) {
        Autor au = new Autor();
        au.setNombre(autorInputDTO.getNombre());
        au.setPais(autorInputDTO.getPais());
        autorRepositorio.save(au);
        AutorSimpleOutputDTO devuelve = new AutorSimpleOutputDTO();
        devuelve.setNombre(autorInputDTO.getNombre());
        devuelve.setPais(autorInputDTO.getPais());
        return devuelve;
    }

    //devuelve todos los autores que tenga en la base de datos
    @Override
    public List<AutorSimpleOutputDTO> getAutores() {
        List<Autor>autorLista = autorRepositorio.findAll();
        List<AutorSimpleOutputDTO> devuelve = new ArrayList<>();

          for (Autor aut:autorLista){
            AutorSimpleOutputDTO auSimDTO = new AutorSimpleOutputDTO();
            auSimDTO.setId(aut.getId());
            auSimDTO.setNombre(aut.getNombre());
            auSimDTO.setPais(aut.getPais());
            devuelve.add(auSimDTO);
        }
        return devuelve;
    }

    /**
     *     busca un autor por nombre en la base de datos y lo devuelve
     *
     */
    @Override
    public AutorSimpleOutputDTO buscAutor(String nombre) {
        Autor au = autorRepositorio.findByName(nombre);
        AutorSimpleOutputDTO auSimDTO = new AutorSimpleOutputDTO();
        auSimDTO.setId(au.getId());
        auSimDTO.setNombre(au.getNombre());
        auSimDTO.setPais(au.getPais());
        return auSimDTO;
    }

    //borra el autor con el nombre que le pases
    @Override
    public Boolean borrar(String nombre) {
        Autor a = autorRepositorio.findByName(nombre);
        if(autorRepositorio.findByName(nombre)!=null){
            autorRepositorio.deleteById(a.getId());
            return true;

        }
        return false;
    }

    //metodo para modificar un autor (borra uno y añade el otro)
    @Override
    public AutorSimpleOutputDTO modificar(AutorInputDTO autorInputDTO) {
        if(autorRepositorio.findByName(autorInputDTO.getNombre())!=null){
            this.borrar(autorInputDTO.getNombre());
            return this.añadirAutor(autorInputDTO);
        }
        return null;
    }
}
