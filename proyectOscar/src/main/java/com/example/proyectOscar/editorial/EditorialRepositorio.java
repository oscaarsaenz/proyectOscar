package com.example.proyectOscar.editorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditorialRepositorio extends JpaRepository<Editorial,Integer> {

    @Query(value = "SELECT * FROM Editorial WHERE nombre = ?1",nativeQuery = true)
    Editorial findByName(String nombre);
}
