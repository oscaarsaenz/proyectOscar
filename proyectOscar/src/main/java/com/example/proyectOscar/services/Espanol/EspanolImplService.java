package com.example.proyectOscar.services.Espanol;

import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.EspanolRepositorio;
import com.example.proyectOscar.Modelo.Espanol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EspanolImplService implements EspanolService {
    private EspanolRepositorio espanolRepositorio;

    @Autowired
    public EspanolImplService(EspanolRepositorio espanolRepositorio){
        this.espanolRepositorio=espanolRepositorio;
    }

    //este metodo añadira una palabra a la base de datos
    @Override
    public EspanolSimpleOutputDTO añadir(EspanolInputDTO espanolInputDTO) {
        //creo el objeto a devolver
        EspanolSimpleOutputDTO devuelve = new EspanolSimpleOutputDTO();
        //le meto los datos
        devuelve.setPalabra(espanolInputDTO.getPalabra());
        devuelve.setDescripcion(espanolInputDTO.getDescripcion());
        //creo el objeto para meter en la base de datos
        Espanol esp = new Espanol();
        esp.setPalabra(espanolInputDTO.getPalabra());
        esp.setDescripcion(espanolInputDTO.getDescripcion());
        esp.setFecha_alta(new Date());
        //lo guardo en la base de datos
        espanolRepositorio.save(esp);
        //devuelvo el objeto
        return devuelve;
    }

    @Override
    public EspanolSimpleOutputDTO modificar(EspanolInputDTO espanolInputDTO) {
        return null;
    }

    @Override
    public void borrar(String palabra) {
        if(espanolRepositorio.findByName(palabra)!=null){
            Espanol e = espanolRepositorio.findByName(palabra);
            espanolRepositorio.delete(e);
        }
    }

    @Override
    public EspanolOutputDTO consultar(String palabra) {
        if(espanolRepositorio.findByName(palabra)!=null){
            Espanol esp = espanolRepositorio.findByName(palabra);
            EspanolOutputDTO espDTO = new EspanolOutputDTO();
            espDTO.setId(esp.getId());
            espDTO.setPalabra(esp.getPalabra());
            espDTO.setDescripcion(esp.getDescripcion());
            espDTO.setFechaAlta(esp.getFecha_alta());
            espDTO.setFechaModificacion(esp.getFecha_modificacion());
            return espDTO;
        }
        return null;
    }

    @Override
    public List<EspanolSimpleOutputDTO> consultarTodo() {
        List<EspanolSimpleOutputDTO> listaDevuelve = new ArrayList<>();

        List <Espanol> l = espanolRepositorio.findAll();
        for (int a =0;a<l.size();a++){
            Espanol e = l.get(a);
            EspanolSimpleOutputDTO devuelve = new EspanolSimpleOutputDTO();
            devuelve.setId(e.getId());
            devuelve.setPalabra(e.getPalabra());
            devuelve.setDescripcion(e.getDescripcion());
            devuelve.setFechaAlta(e.getFecha_alta());
            listaDevuelve.add(devuelve);
        }
        return listaDevuelve;
    }
}
