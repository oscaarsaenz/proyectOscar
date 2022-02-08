package com.example.proyectOscar.editorial.ServiceEditorial;

import com.example.proyectOscar.editorial.EditorialDTO.EditorialInputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialOutputDTO;
import com.example.proyectOscar.editorial.EditorialDTO.EditorialSimpleOutputDTO;
import com.example.proyectOscar.editorial.EditorialRepositorio;
import com.example.proyectOscar.editorial.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditorialImplService implements EditorialService {
    private EditorialRepositorio editorialRepositorio;

    @Autowired
    public EditorialImplService(EditorialRepositorio editorialRepositorio){
        this.editorialRepositorio = editorialRepositorio;
    }

    @Override
    public EditorialSimpleOutputDTO añadir(EditorialInputDTO editorialInputDTO) {
        Editorial edi = new Editorial();
        edi.setNombre(editorialInputDTO.getNombre());
        edi.setNumero_paginas(editorialInputDTO.getNum_paginas());
        editorialRepositorio.save(edi);
        EditorialSimpleOutputDTO eSDTO = new EditorialSimpleOutputDTO();
        eSDTO.setNombre(editorialInputDTO.getNombre());
        eSDTO.setNum_paginas(editorialInputDTO.getNum_paginas());
        return eSDTO;
    }

    @Override
    public EditorialSimpleOutputDTO modificar(EditorialInputDTO editorialInputDTO) {
        if(editorialRepositorio.findByName(editorialInputDTO.getNombre())!=null){
            this.borrar(editorialInputDTO.getNombre());
            return this.añadir(editorialInputDTO);
        }
        return null;
    }

    @Override
    public Boolean borrar(String nombre) {
        if(editorialRepositorio.findByName(nombre)!=null){
            editorialRepositorio.delete(editorialRepositorio.findByName(nombre));
            return true;
        }
        return false;
    }

    @Override
    public EditorialOutputDTO consultar(String nombre) {
        Editorial edi = editorialRepositorio.findByName(nombre);
        EditorialOutputDTO ediDTO = new EditorialOutputDTO();
        ediDTO.setNombre(edi.getNombre());
        ediDTO.setId(edi.getId());
        ediDTO.setFecha_publicacion(edi.getFecha_publicacion());
        ediDTO.setNum_paginas(edi.getNumero_paginas());
        return ediDTO;
    }

    @Override
    public List<EditorialSimpleOutputDTO> consultarTodo() {
        List <Editorial> lista = editorialRepositorio.findAll();
        List <EditorialSimpleOutputDTO> listaDevuelve = new ArrayList();

        for(Editorial e:lista){
            EditorialSimpleOutputDTO editorialDTO = new EditorialSimpleOutputDTO();
            editorialDTO.setNombre(e.getNombre());
            editorialDTO.setId(e.getId());
            editorialDTO.setNum_paginas(e.getNumero_paginas());
            editorialDTO.setFecha_publicacion(e.getFecha_publicacion());
            listaDevuelve.add(editorialDTO);
        }
        return listaDevuelve;
    }
}
