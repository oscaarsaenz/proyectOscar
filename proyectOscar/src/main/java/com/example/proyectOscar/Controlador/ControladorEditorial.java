package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.Interfaces.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crudEditorial")
public class ControladorEditorial {
    @Autowired
    EditorialRepositorio editorialRepositorio;

}
