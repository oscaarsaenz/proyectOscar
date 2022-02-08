package com.example.proyectOscar.espanol.EspanolDTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EspanolSimpleOutputDTO implements Serializable {
    private Integer id;
    private String palabra;
    private String Descripcion;
    private Date fechaAlta;
}
