package com.example.proyectOscar.services.Espanol;

import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolSimpleOutputDTO;

import java.util.List;

public interface EspanolService {
    public EspanolSimpleOutputDTO añadir(EspanolInputDTO espanolInputDTO);
    public  EspanolSimpleOutputDTO modificar(EspanolInputDTO espanolInputDTO);
    public void borrar(String palabra);
    public EspanolOutputDTO consultar(String palabra);
    public List<EspanolSimpleOutputDTO> consultarTodo();
}
