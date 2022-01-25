package com.example.proyectOscar.DTO.Editorial;

import com.example.proyectOscar.Modelo.Espanol;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EditorialOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private int num_paginas;
    private Date fecha_publicacion;
    private List<Espanol> diccionarios;
}
