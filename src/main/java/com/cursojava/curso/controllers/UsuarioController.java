package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    /* Autowired busca un objeto manejado (beans) que implemente
    determinada interfaz para hacer referencia a él.
    De esta manera no es necesario crear una instancia nueva del objeto cada vez
    que se necesite */
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET) // RUTA DE ACCESO DESDE EL FRONT
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token) {

        if (!validarToken(token)) return null;

        return usuarioDao.getUsuarios();

    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public boolean registrarUsuario(@RequestBody Usuario usuario) {

        //Verificamos que no este el usuario
        if (usuarioDao.verificarEmail(usuario) != null) {

            return false;
        }

        //Encriptamos la contraseña que envio el cliente para su registro:
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());

        //Llamamos al set para modificar la contraseña con el hash creado
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);

        return true;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {

        if (!validarToken(token)) return;

        usuarioDao.eliminar(id);

    }

    private boolean validarToken(String token) {

        String usuarioId = jwtUtil.getKey(token);

        return usuarioId != null;

    }

}
