package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {

        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNombre("Daniel");
        usuario.setApellido("Noguera");
        usuario.setEmail("noguera.daniel@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;

    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {

        Usuario usuario = new Usuario();

        usuario.setId(123l);
        usuario.setNombre("Daniel");
        usuario.setApellido("Noguera");
        usuario.setEmail("noguera.daniel@gmail.com");
        usuario.setTelefono("123456789");

        Usuario usuario2 = new Usuario();

        usuario2.setId(456l);
        usuario2.setNombre("Mercedes");
        usuario2.setApellido("Gutierrez");
        usuario2.setEmail("mercedes@gmail.com");
        usuario2.setTelefono("23456789");

        Usuario usuario3 = new Usuario();

        usuario3.setId(789l);
        usuario3.setNombre("Marcio");
        usuario3.setApellido("Marciano");
        usuario3.setEmail("marciano@gmail.com");
        usuario3.setTelefono("456789456");

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;

    }

    @RequestMapping(value = "prueba1")
    public Usuario editar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Daniel");
        usuario.setApellido("Noguera");
        usuario.setEmail("noguera.daniel@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;

    }

    @RequestMapping(value = "prueba2")
    public Usuario eliminar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Daniel");
        usuario.setApellido("Noguera");
        usuario.setEmail("noguera.daniel@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;

    }

    @RequestMapping(value = "prueba3")
    public Usuario buscar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Daniel");
        usuario.setApellido("Noguera");
        usuario.setEmail("noguera.daniel@gmail.com");
        usuario.setTelefono("123456789");

        return usuario;

    }

}
