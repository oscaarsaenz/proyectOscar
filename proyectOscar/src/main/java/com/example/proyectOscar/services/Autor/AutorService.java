package com.example.proyectOscar.services.Autor;

import com.example.proyectOscar.DTO.Autor.AutorInputDTO;
import com.example.proyectOscar.DTO.Autor.AutorOutputDTO;
import com.example.proyectOscar.DTO.Autor.AutorSimpleOutputDTO;
import com.example.proyectOscar.Modelo.Autor;

import java.util.List;

public interface AutorService {
    public AutorSimpleOutputDTO añadirAutor(AutorInputDTO autorInputDTO);
    public List<AutorSimpleOutputDTO> getAutores();
    public AutorSimpleOutputDTO buscAutor(String nombre);
    public Boolean borrar(String nombre);
    public AutorSimpleOutputDTO modificar(AutorInputDTO autor);
}
