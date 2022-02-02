package com.example.proyectOscar.services.Espanol;

import com.example.proyectOscar.DTO.Espanol.EspanolInputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolOutputDTO;
import com.example.proyectOscar.DTO.Espanol.EspanolSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.AutorRepositorio;
import com.example.proyectOscar.Interfaces.EditorialRepositorio;
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
    private AutorRepositorio autorRepositorio;
    private EditorialRepositorio editorialRepositorio;
    @Autowired
    public EspanolImplService(EspanolRepositorio espanolRepositorio, AutorRepositorio autorRepositorio, EditorialRepositorio editorialRepositorio){
        this.espanolRepositorio = espanolRepositorio;
        this.autorRepositorio = autorRepositorio;
        this.editorialRepositorio = editorialRepositorio;
    }

    //este metodo añadira una palabra a la base de datos
    @Override
    public EspanolSimpleOutputDTO añadir(EspanolInputDTO espanolInputDTO) {
        if (espanolRepositorio.findByName(espanolInputDTO.getPalabra())==null){
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
            esp.setAutor(autorRepositorio.findByName(espanolInputDTO.getNombreAutor()));
            esp.setEditorial(editorialRepositorio.findByName(espanolInputDTO.getEditorial()));
            //lo guardo en la base de datos
            espanolRepositorio.save(esp);
            //devuelvo el objeto
            return devuelve;
        }
        return null;
    }

    //metodo que mofica la palabra
    @Override
    public EspanolSimpleOutputDTO modificar(EspanolInputDTO espanolInputDTO) {
        if(espanolRepositorio.findByName(espanolInputDTO.getPalabra())!=null){
            this.borrar(espanolInputDTO.getPalabra());
            return this.añadir(espanolInputDTO);
        }
        return null;
    }

    //metodo para borrar la palabra que le pasas
    @Override
    public void borrar(String palabra) {
        if(espanolRepositorio.findByName(palabra)!=null){
            Espanol e = espanolRepositorio.findByName(palabra);
            espanolRepositorio.delete(e);
        }
    }

    //devuelve la palabra que le pasas
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

    //devuelve todas las palabras de la base de datos
    @Override
    public List<EspanolSimpleOutputDTO> consultarTodo() {
        List<EspanolSimpleOutputDTO> listaDevuelve = new ArrayList<>();

        List <Espanol> l = espanolRepositorio.findAll();

        for (Espanol e:l){
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