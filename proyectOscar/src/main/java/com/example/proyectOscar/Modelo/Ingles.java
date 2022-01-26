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
@Table(name="DiccionarioIngEsp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Espanol> palabrasEspanol= new ArrayList<>();
}
