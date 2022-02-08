package com.example.proyectOscar.ingles.InglesDTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class InglesInputDTO implements Serializable {
    private String palabra;
    private String palabraEspanol;
}
