package com.example.proyectOscar.DTO.Editorial;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class EditorialSimpleOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private int num_paginas;
    private Date fecha_publicacion;
}
