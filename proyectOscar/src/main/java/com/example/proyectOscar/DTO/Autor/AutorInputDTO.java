package com.example.proyectOscar.DTO.Autor;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutorInputDTO implements Serializable {
    private String nombre;
    private String pais;
}
