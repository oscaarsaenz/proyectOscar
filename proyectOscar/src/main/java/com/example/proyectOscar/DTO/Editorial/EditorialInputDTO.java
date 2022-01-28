package com.example.proyectOscar.DTO.Editorial;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditorialInputDTO implements Serializable {
    private String nombre;
    private int num_paginas;
}
