package com.example.proyectOscar.ingles.InglesDTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class InglesOutputDTO implements Serializable {
    private Integer id;
    private String palabra;
    private Date fechaAlta;
    private Date fechaModificacion;
    private String palabraEspanol;
    private String Descripcion;
}
