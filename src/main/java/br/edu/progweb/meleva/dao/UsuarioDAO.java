/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class UsuarioDAO implements UsuarioDAOInterface{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Usuario buscarUsuarioPorNome(Usuario u) {
        Usuario us = null;
        try {
            us = (Usuario) manager.createNamedQuery("Usuario.findByLogin").setParameter("login", u.getLogin()).getSingleResult();
        } catch (NoResultException nre) {
           System.out.println("Excessão buscarUsuarioPorNome: " + nre.getMessage());
        }
        return us;
    }

    @Override
    public void criarLogin(Usuario u) {
        manager.persist(u);
    }

}
