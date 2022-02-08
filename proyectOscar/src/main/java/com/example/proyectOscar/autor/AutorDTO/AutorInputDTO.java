package com.example.proyectOscar.autor.AutorDTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutorInputDTO implements Serializable {
    private String nombre;
    private String pais;
}
