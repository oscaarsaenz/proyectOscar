package com.example.proyectOscar.espanol;

import com.example.proyectOscar.autor.Autor;
import com.example.proyectOscar.editorial.Editorial;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

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


    @NotEmpty(message = "La descripcion no puede estar vacía")
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
