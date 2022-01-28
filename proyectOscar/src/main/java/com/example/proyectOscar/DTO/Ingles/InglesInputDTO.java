package com.example.proyectOscar.DTO.Ingles;

import com.example.proyectOscar.Modelo.Espanol;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InglesInputDTO implements Serializable {
    private String palabra;
    private String palabraEspanol;
}
