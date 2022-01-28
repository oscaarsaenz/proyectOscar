package com.example.proyectOscar.services.Editorial;

import com.example.proyectOscar.DTO.Editorial.EditorialInputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialOutputDTO;
import com.example.proyectOscar.DTO.Editorial.EditorialSimpleOutputDTO;
import com.example.proyectOscar.Interfaces.EditorialRepositorio;
import com.example.proyectOscar.Modelo.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
