package com.example.proyectOscar.autor.AutorDTO;

import com.example.proyectOscar.editorial.Editorial;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AutorOutputDTO implements Serializable {
    private Integer id;
    private String nombre;
    private String pais;
    private String poblacion;
    private List<Editorial> editoriales;
}
