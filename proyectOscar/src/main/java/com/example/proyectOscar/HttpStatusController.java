package com.example.proyectOscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpStatusController {
    @GetMapping("/response")
    ResponseEntity<String> ok() {
        return ResponseEntity.badRequest().body("400 Message");
    }

    @GetMapping("/prueba")
    ResponseEntity<String> metodo1() {
        return ResponseEntity.badRequest().body("Hola");
    }
}
