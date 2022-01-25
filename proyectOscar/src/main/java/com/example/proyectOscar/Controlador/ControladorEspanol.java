package com.example.proyectOscar.Controlador;

import com.example.proyectOscar.Interfaces.EspanolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crudEspIng")
public class ControladorEspanol {
    @Autowired
    EspanolRepositorio espanolRepositorio;

}
