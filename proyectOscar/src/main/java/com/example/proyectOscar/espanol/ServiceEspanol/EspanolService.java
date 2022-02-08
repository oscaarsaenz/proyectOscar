package com.example.proyectOscar.espanol.ServiceEspanol;

import com.example.proyectOscar.espanol.EspanolDTO.EspanolInputDTO;
import com.example.proyectOscar.espanol.EspanolDTO.EspanolOutputDTO;
import com.example.proyectOscar.espanol.EspanolDTO.EspanolSimpleOutputDTO;

import java.util.List;
import java.util.Optional;

public interface EspanolService {
    public Optional<EspanolSimpleOutputDTO> añadir(EspanolInputDTO espanolInputDTO);
    public  Optional<EspanolSimpleOutputDTO> modificar(EspanolInputDTO espanolInputDTO);
    public void borrar(String palabra);
    public EspanolOutputDTO consultar(String palabra);
    public List<EspanolSimpleOutputDTO> consultarTodo();
}
