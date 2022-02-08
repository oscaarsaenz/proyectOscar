package com.example.proyectOscar.ingles;

import com.example.proyectOscar.espanol.Espanol;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    @OneToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "palabraEspanol")
    private Espanol palabraEspanol;

}
