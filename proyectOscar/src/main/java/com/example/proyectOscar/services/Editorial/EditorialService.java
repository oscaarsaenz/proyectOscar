package com.example.proyectOscar.services.Editorial;

import com.example.proyectOscar.DTO.Editorial.EditorialInputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialOutputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialSimpleOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;


import java.util.List;

public interface EditorialService {
    public EditorialSimpleOutputDTO añadir(EditorialInputDTO editorialInputDTO);
    public  EditorialSimpleOutputDTO modificar(EditorialInputDTO editorialInputDTO);
    public Boolean borrar(String nombre);
    public EditorialOutputDTO consultar(String nombre);
    public List<EditorialSimpleOutputDTO> consultarTodo();
}
