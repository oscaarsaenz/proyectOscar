package com.example.proyectOscar.services.Ingles;

import com.example.proyectOscar.DTO.Autor.AutorInputDTO;
import com.example.proyectOscar.DTO.Autor.AutorOutputDTO;
import com.example.proyectOscar.DTO.Autor.AutorSimpleOutputDTO;
import com.example.proyectOscar.DTO.Ingles.InglesInputDTO;
import com.example.proyectOscar.DTO.Ingles.InglesSimpleOutputDTO;

import java.util.List;

public interface InglesService {
    public InglesSimpleOutputDTO añadir(InglesInputDTO inglesInputDTO);
    public InglesSimpleOutputDTO consultar(String palabra);
    public List<InglesSimpleOutputDTO> consultarTodos();
    public Boolean borrar(String palabra);
    public InglesSimpleOutputDTO modificar(InglesInputDTO inglesInputDTO);
}
