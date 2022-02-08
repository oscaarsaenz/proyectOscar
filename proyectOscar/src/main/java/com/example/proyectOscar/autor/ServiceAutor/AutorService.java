package com.example.proyectOscar.autor.ServiceAutor;

import com.example.proyectOscar.autor.AutorDTO.AutorInputDTO;
import com.example.proyectOscar.autor.AutorDTO.AutorSimpleOutputDTO;

import java.util.List;

public interface AutorService {
    public AutorSimpleOutputDTO añadirAutor(AutorInputDTO autorInputDTO);
    public List<AutorSimpleOutputDTO> getAutores();
    public AutorSimpleOutputDTO buscAutor(String nombre);
    public Boolean borrar(String nombre);
    public AutorSimpleOutputDTO modificar(AutorInputDTO autor);
}
