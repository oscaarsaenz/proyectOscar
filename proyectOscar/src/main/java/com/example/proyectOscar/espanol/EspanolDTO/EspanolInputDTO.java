package com.example.proyectOscar.espanol.EspanolDTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class EspanolInputDTO implements Serializable {
    private String palabra;
    private String Descripcion;
    String nombreAutor;
    String editorial;
}
