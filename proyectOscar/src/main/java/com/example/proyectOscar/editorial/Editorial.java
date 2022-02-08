package com.example.proyectOscar.editorial;

import com.example.proyectOscar.espanol.Espanol;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Editorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editorial {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero_paginas")

    @Range(max = 1000, min = 1, message = "El numero de paginas debe estar entre 1-1000.")
    private int numero_paginas;
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;

    //una editorial puede tener muchos diccionarios
    @OneToMany(mappedBy="editorial", cascade = CascadeType.ALL)
    private List<Espanol> diccionariosEspIng = new ArrayList<>();
}
