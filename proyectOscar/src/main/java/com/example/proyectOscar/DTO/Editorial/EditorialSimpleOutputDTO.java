package com.example.proyectOscar.DTO.Editorial;

import java.io.Serializable;
import java.util.Date;

public class EditorialSimpleOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private int num_paginas;
    private Date fecha_publicacion;
}
