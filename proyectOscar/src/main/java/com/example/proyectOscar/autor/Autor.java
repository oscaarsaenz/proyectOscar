package com.example.proyectOscar.autor;

import com.example.proyectOscar.espanol.Espanol;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Autor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pais")
    private String pais;
    @Column(name = "poblacion")
    private String poblacion;

    //un autor puede tener muchos diccionarios
    @OneToMany(mappedBy="autor", cascade = CascadeType.ALL)
    private List<Espanol> diccionariosEspIngs = new ArrayList<>();
}
