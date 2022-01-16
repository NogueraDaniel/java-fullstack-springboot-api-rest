package com.cursojava.curso.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios") //Indicamos con que tabla esta relacionada
public class Usuario {

    @Getter @Setter // Generamos getters y setters automaticamente con Lombok
    @Column(name = "ID") //Anotaciones JPA para mapear los valores
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Generamos automaticamente el valor del ID
    private Long id;

    @Getter @Setter
    @Column(name = "NOMBRE")
    private String nombre;

    @Getter @Setter
    @Column(name = "APELLIDO")
    private String apellido;

    @Getter @Setter
    @Column(name = "EMAIL")
    private String email;

    @Getter @Setter
    @Column(name = "TELEFONO")
    private String telefono;

    @Getter @Setter
    @Column(name = "PASSWORD")
    private String password;

}
