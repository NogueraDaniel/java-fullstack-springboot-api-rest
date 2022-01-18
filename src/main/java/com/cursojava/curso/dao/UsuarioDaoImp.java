package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager; // Manejo de la base de datos

    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario";
        List<Usuario> usuarios = entityManager.createQuery(query).getResultList();
        return usuarios;
    }

    @Override
    public void eliminar(Long id) {

        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {

        entityManager.merge(usuario);

    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {

        Usuario usuarioConsultado = verificarEmail(usuario);

        if (usuarioConsultado == null) {

            return null;
        }

        // Creo un argon para validar la contraseña:
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        //Obtengo el password encriptado
        String passwordHashed = usuarioConsultado.getPassword();

        //Uso la funcion de argon que matchea el password enviado desde el front
        //con el password encriptado que esta en la base de datos
        return argon2.verify(passwordHashed, usuario.getPassword()) ? usuarioConsultado : null;

    }

    @Override
    public Usuario verificarEmail(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";

        // Creo una lista con la consulta a la base de datos
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        return (!lista.isEmpty()) ? lista.get(0) : null;
    }

}
