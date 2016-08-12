/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.facade;

import br.edu.progweb.meleva.dao.CaronaDAOInterface;
import br.edu.progweb.meleva.dao.CarroDAOInterface;
import br.edu.progweb.meleva.dao.InfoUsuarioDAOInterface;
import br.edu.progweb.meleva.dao.UsuarioDAOInterface;
import br.edu.progweb.meleva.entidades.Carona;
import br.edu.progweb.meleva.entidades.Carro;
import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Usuario;
import java.util.List;
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

    @Autowired
    private CarroDAOInterface carroDao;

    @Autowired
    private CaronaDAOInterface caronaDao;

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
    public void criarInfoUsuario(InfoUsuario iu) {
        Usuario u = iu.getUsuario();
        usuarioDao.criarLogin(u);        
        iu.setUsuario(u);
        
        iu.setId(u.getId());
        infoUsuarioDao.criarInfoUsuario(iu);
        
    }

    @Override
    public void cadastrarCarro(Carro c) {
        Usuario u = c.getIdUsuario();

        carroDao.criarCarro(c);

        u.getCarroList().add(c);
        u = usuarioDao.atualizarUsuario(u);
    }

    @Override
    public void criarCarona(Carona c, Usuario u) {
        caronaDao.criarCarona(c);
//        u.setIdCarona(c);
        u = usuarioDao.atualizarUsuario(u);
    }

    @Override
    public List<Carona> listarCarona() {
        return caronaDao.listarCarona();
    }

}
