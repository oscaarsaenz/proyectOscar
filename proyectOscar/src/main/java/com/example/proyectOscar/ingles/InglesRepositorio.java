package com.example.proyectOscar.ingles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InglesRepositorio extends JpaRepository<Ingles,Integer> {
    @Query(value = "SELECT * FROM diccionario_ing_esp WHERE palabra like ?1",nativeQuery = true)
    Ingles findByName(String palabra);
}
