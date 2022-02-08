package com.example.proyectOscar.espanol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EspanolRepositorio extends JpaRepository<Espanol,Integer> {

    @Query(value = "SELECT * FROM diccionario_esp_ing WHERE palabra like ?1",nativeQuery = true)
    Espanol findByName(String palabra);
}

