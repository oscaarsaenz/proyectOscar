package com.example.proyectOscar.services.Autor;

import com.example.proyectOscar.Modelo.Autor;

import java.util.List;

public interface AutorService {
    public Autor buscarAutor(int id);
    public Autor añadirAutor(Autor autor);
    public List<Autor> getAutores();
    public Boolean borrarAutor(int id);
    public Autor buscAutor(String nombre);
    public Boolean borrarAutorNombre(String nombre);
    public Boolean actualizarAutor(Autor autor);
}
