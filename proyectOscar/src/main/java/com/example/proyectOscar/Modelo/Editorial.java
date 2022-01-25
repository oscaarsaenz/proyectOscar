package com.example.proyectOscar.Modelo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numero_paginas")
    private int numero_paginas;
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;

    //una editorial puede tener muchos diccionarios
    @OneToMany(mappedBy="editorial", cascade = CascadeType.ALL)
    private List<Espanol> diccionariosEspIng = new ArrayList<>();
}
