package com.example.proyectOscar.Interfaces;

import com.example.proyectOscar.Modelo.Espanol;
import com.example.proyectOscar.Modelo.Ingles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InglesRepositorio extends JpaRepository<Ingles,Integer> {
    @Query(value = "SELECT * FROM diccionario_ing_esp WHERE palabra like ?1",nativeQuery = true)
    Ingles findByName(String palabra);
}
