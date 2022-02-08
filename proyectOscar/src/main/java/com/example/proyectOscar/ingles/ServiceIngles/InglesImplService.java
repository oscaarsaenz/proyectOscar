package com.example.proyectOscar.ingles.ServiceIngles;

import com.example.proyectOscar.ingles.InglesDTO.InglesInputDTO;
import com.example.proyectOscar.ingles.InglesDTO.InglesSimpleOutputDTO;
import com.example.proyectOscar.espanol.EspanolRepositorio;
import com.example.proyectOscar.ingles.InglesRepositorio;
import com.example.proyectOscar.espanol.Espanol;
import com.example.proyectOscar.ingles.Ingles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InglesImplService implements InglesService{
    private InglesRepositorio inglesRepositorio;
    private EspanolRepositorio espanolRepositorio;
    @Autowired
    public InglesImplService(InglesRepositorio inglesRepositorio, EspanolRepositorio espanolRepositorio){
        this.inglesRepositorio = inglesRepositorio;
        this.espanolRepositorio = espanolRepositorio;
    }

    //añade una palabra en ingles
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

    //consulta por la palabra
    @Override
    public InglesSimpleOutputDTO consultar(String palabra) {

        List <Ingles> l = inglesRepositorio.findAll();

        Optional<Ingles> optionalIngles = l.stream().filter(ingles -> ingles.getPalabra().equalsIgnoreCase(palabra)).findFirst();
        InglesSimpleOutputDTO iSDTO = new InglesSimpleOutputDTO();

        if(optionalIngles.isEmpty()){
            return iSDTO;
        }else{
            Ingles i = optionalIngles.get();
            iSDTO.setId(i.getId());
            iSDTO.setPalabra(i.getPalabra());
            iSDTO.setFechaAlta(i.getFecha_alta());
            Espanol e = espanolRepositorio.findByName(i.getPalabraEspanol().getPalabra());
            iSDTO.setPalabraEspanol(e.getPalabra());
            iSDTO.setFechaModificacion(i.getFecha_modificacion());
        }
        return iSDTO;
    }
    //devuelve todas las palabras de la base de datos
    @Override
    public List<InglesSimpleOutputDTO> consultarTodos() {
        List<Ingles> lista = inglesRepositorio.findAll();

        List<InglesSimpleOutputDTO> listaDevuelve = new ArrayList();
        for (Ingles  i:lista) {
            InglesSimpleOutputDTO iSDTO = new InglesSimpleOutputDTO();
            iSDTO.setId(i.getId());
            iSDTO.setPalabra(i.getPalabra());
            iSDTO.setFechaAlta(i.getFecha_alta());
            iSDTO.setFechaModificacion(i.getFecha_modificacion());
            listaDevuelve.add(iSDTO);
        }
        return listaDevuelve;
    }
    //borra una palabra
    @Override
    public Boolean borrar(String palabra) {
        if(inglesRepositorio.findByName(palabra)!=null){
            inglesRepositorio.delete(inglesRepositorio.findByName(palabra));
            return true;
        }
        return false;
    }
    //modifica una palabra
    @Override
    public InglesSimpleOutputDTO modificar(InglesInputDTO inglesInputDTO) {
        if(inglesRepositorio.findByName(inglesInputDTO.getPalabra())!=null){
            this.borrar(inglesInputDTO.getPalabra());
            inglesRepositorio.findByName(inglesInputDTO.getPalabra()).getId();
            return this.añadir(inglesInputDTO);
        }
        return null;
    }
}
