package com.example.proyectOscar.editorial.EditorialDTO;

import com.example.proyectOscar.espanol.Espanol;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class EditorialOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private int num_paginas;
    private Date fecha_publicacion;
    private List<Espanol> diccionarios;
}
