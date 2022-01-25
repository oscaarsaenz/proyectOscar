package com.example.proyectOscar.Interfaces;

import com.example.proyectOscar.Modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepositorio extends JpaRepository<Autor,Integer> {

    @Query(value = "SELECT * FROM Autor WHERE nombre = ?1",nativeQuery = true)
    Autor findByName(String nombre);

}
