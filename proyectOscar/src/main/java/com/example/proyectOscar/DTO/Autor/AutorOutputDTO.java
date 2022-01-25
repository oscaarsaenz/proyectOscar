package com.example.proyectOscar.DTO.Autor;

import com.example.proyectOscar.Modelo.Editorial;

import java.io.Serializable;
import java.util.List;

public class AutorOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private String pais;
    private String poblacion;
    private List<Editorial> editoriales;
}
