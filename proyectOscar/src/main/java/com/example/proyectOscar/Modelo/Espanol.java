package com.example.proyectOscar.Modelo;

import com.example.proyectOscar.DTO.Ingles.InglesOutputDTO;
import com.example.proyectOscar.DTO.Ingles.InglesSimpleOutputDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="DiccionarioEspIng")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Espanol {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="palabra")
    private String palabra;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="fecha_alta")
    private Date fecha_alta;
    @Column(name="fecha_modificacion")
    private Date fecha_modificacion;
    @Column(name="activo")
    private boolean activo;

    //un diccionario es de una editorial
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEditorial")
    private Editorial editorial;

    //un diccionario es de un autor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAutor")
    private Autor autor;


}
