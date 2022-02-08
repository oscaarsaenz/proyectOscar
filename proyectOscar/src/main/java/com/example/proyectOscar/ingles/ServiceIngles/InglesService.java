package com.example.proyectOscar.ingles.ServiceIngles;

import com.example.proyectOscar.ingles.InglesDTO.InglesInputDTO;
import com.example.proyectOscar.ingles.InglesDTO.InglesSimpleOutputDTO;

import java.util.List;

public interface InglesService {
    public InglesSimpleOutputDTO añadir(InglesInputDTO inglesInputDTO);
    public InglesSimpleOutputDTO consultar(String palabra);
    public List<InglesSimpleOutputDTO> consultarTodos();
    public Boolean borrar(String palabra);
    public InglesSimpleOutputDTO modificar(InglesInputDTO inglesInputDTO);
}
