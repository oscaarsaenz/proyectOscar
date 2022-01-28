package com.example.proyectOscar.services.Ingles;

import com.example.proyectOscar.DTO.Ingles.InglesInputDTO;
import com.example.proyectOscar.DTO.Ingles.InglesSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.EspanolRepositorio;
import com.example.proyectOscar.Interfaces.InglesRepositorio;
import com.example.proyectOscar.Modelo.Espanol;
import com.example.proyectOscar.Modelo.Ingles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InglesImplService implements InglesService{
    private InglesRepositorio inglesRepositorio;
    private EspanolRepositorio espanolRepositorio;
    @Autowired
    public InglesImplService(InglesRepositorio inglesRepositorio, EspanolRepositorio espanolRepositorio){
        this.inglesRepositorio = inglesRepositorio;
        this.espanolRepositorio = espanolRepositorio;
    }

    @Override
    public InglesSimpleOutputDTO añadir(InglesInputDTO inglesInputDTO) {
        if(inglesRepositorio.findByName(inglesInputDTO.getPalabra())!=null){
            return null;
        }
        Ingles i = new Ingles();
        i.setPalabra(inglesInputDTO.getPalabra());
        i.setFecha_alta(new Date());
        Espanol e = espanolRepositorio.findByName(inglesInputDTO.getPalabraEspanol());
        i.setPalabraEspanol(e);
        inglesRepositorio.save(i);
        InglesSimpleOutputDTO devuelve = new InglesSimpleOutputDTO();
        devuelve.setPalabra(inglesInputDTO.getPalabra());
        devuelve.setFechaAlta(new Date());
        devuelve.setPalabraEspanol(e.getPalabra());
        return devuelve;
    }

    @Override
    public InglesSimpleOutputDTO consultar(String palabra) {
        Ingles i = inglesRepositorio.findByName(palabra);
        InglesSimpleOutputDTO iSDTO = new InglesSimpleOutputDTO();
        iSDTO.setId(i.getId());
        iSDTO.setPalabra(i.getPalabra());
        iSDTO.setFechaAlta(i.getFecha_alta());
        Espanol e = espanolRepositorio.findByName(i.getPalabraEspanol().getPalabra());
        iSDTO.setPalabraEspanol(e.getPalabra());
        iSDTO.setFechaModificacion(i.getFecha_modificacion());
        return iSDTO;
    }

    @Override
    public List<InglesSimpleOutputDTO> consultarTodos() {
        List<Ingles> lista = inglesRepositorio.findAll();

        List<InglesSimpleOutputDTO> listaDevuelve = null;
        for (int a = 0; a < lista.size(); a++) {
            Ingles i = lista.get(a);
            InglesSimpleOutputDTO iSDTO = new InglesSimpleOutputDTO();
            listaDevuelve = new ArrayList<>();
            iSDTO.setId(i.getId());
            iSDTO.setPalabra(i.getPalabra());
            iSDTO.setFechaAlta(i.getFecha_alta());
            iSDTO.setFechaModificacion(i.getFecha_modificacion());
            listaDevuelve.add(iSDTO);
        }
        return listaDevuelve;
    }

    @Override
    public Boolean borrar(String palabra) {
        if(inglesRepositorio.findByName(palabra)!=null){
            inglesRepositorio.delete(inglesRepositorio.findByName(palabra));
            return true;
        }
        return false;
    }

    @Override
    public InglesSimpleOutputDTO modificar(InglesInputDTO inglesInputDTO) {
        if(inglesRepositorio.findByName(inglesInputDTO.getPalabra())!=null){
            this.borrar(inglesInputDTO.getPalabra());
            return this.añadir(inglesInputDTO);
        }
        return null;
    }
}
