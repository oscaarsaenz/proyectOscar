package com.example.proyectOscar.espanol.EspanolDTO;

import com.example.proyectOscar.ingles.InglesDTO.InglesSimpleOutputDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class EspanolOutputDTO implements Serializable {
    private Integer id;
    private String palabra;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaModificacion;
    private List<InglesSimpleOutputDTO> palabrasIngles;
}

