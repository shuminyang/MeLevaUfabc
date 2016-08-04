/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.facade;

import br.edu.progweb.meleva.dao.InfoUsuarioDAOInterface;
import br.edu.progweb.meleva.dao.UsuarioDAOInterface;
import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class MeLevaFacade implements MeLevaFacadeInterface {

    @Autowired
    private UsuarioDAOInterface usuarioDao;
    
    @Autowired
    private InfoUsuarioDAOInterface infoUsuarioDao;

    @Override
    public Usuario validarLogin(Usuario u) {
        Usuario us = (Usuario) usuarioDao.buscarUsuarioPorNome(u);

        if (us != null) {
            if (us.getSenha().equals(u.getSenha())) {
                return us;
            }
        }
        return null;
    }

    @Override
    public void criarLogin(Usuario u) {
        usuarioDao.criarLogin(u);
    }

    @Override
    public void criarInfoUsuario(InfoUsuario iu) {
        infoUsuarioDao.criarInfoUsuario(iu);
    }
    
    
}
