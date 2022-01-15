package com.cursojava.curso.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios") //Indicamos con que tabla esta relacionada
public class Usuario {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String telefono;

    @Getter @Setter
    private String password;

}
