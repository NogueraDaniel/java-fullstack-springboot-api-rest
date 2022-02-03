package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioExistente = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioExistente != null) {

            // Si el usuario existe, envio al front el token para la sesion:
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioExistente.getId()), usuarioExistente.getEmail());

            return tokenJwt;
        }


        return "FAIL";

    }
}
