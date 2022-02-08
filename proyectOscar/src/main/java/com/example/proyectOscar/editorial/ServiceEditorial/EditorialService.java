package com.example.proyectOscar.editorial.ServiceEditorial;

import com.example.proyectOscar.editorial.EditorialDTO.EditorialInputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialOutputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialSimpleOutputDTO;


import java.util.List;

public interface EditorialService {
    public EditorialSimpleOutputDTO añadir(EditorialInputDTO editorialInputDTO);
    public  EditorialSimpleOutputDTO modificar(EditorialInputDTO editorialInputDTO);
    public Boolean borrar(String nombre);
    public EditorialOutputDTO consultar(String nombre);
    public List<EditorialSimpleOutputDTO> consultarTodo();
}
