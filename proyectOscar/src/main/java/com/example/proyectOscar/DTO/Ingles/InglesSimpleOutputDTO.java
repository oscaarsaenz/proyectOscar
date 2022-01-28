package com.example.proyectOscar.DTO.Ingles;

import com.example.proyectOscar.Modelo.Espanol;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class InglesSimpleOutputDTO implements Serializable {
    private Integer id;
    private String palabra;
    private Date fechaAlta;
    private Date fechaModificacion;
    private String palabraEspanol;
}
