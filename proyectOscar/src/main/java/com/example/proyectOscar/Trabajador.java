package com.example.proyectOscar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Max;


@Entity
@Table(name="trabajador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trabajador_seq")
    @GenericGenerator(
            name = "trabajador_seq",
            strategy = "com.example.proyectOscar.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })

    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;

    @Max(value = 130, message = "La edad no puede ser tan alta")
    @Column(name = "edad")
    private String edad;

    @Column(name = "email")
    private String email;
}
