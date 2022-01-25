package com.example.proyectOscar.DTO.Espanol;

import com.example.proyectOscar.DTO.Ingles.InglesSimpleOutputDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EspanolOutputDTO implements Serializable {
    private Integer id;
    private String palabra;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaModificacion;
    private List<InglesSimpleOutputDTO> palabrasIngles;
}
