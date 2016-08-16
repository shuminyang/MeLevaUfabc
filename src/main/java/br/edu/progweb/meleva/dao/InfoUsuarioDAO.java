/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.InfoUsuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class InfoUsuarioDAO implements InfoUsuarioDAOInterface {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criarInfoUsuario(InfoUsuario iu) {
        manager.persist(iu);
    }

    @Override
    public InfoUsuario atualizarInfoUsuario(InfoUsuario iu) {
        InfoUsuario info = manager.find(InfoUsuario.class, iu.getId());
        info.setCpf(iu.getCpf());
        info.setDataNascimento(iu.getDataNascimento());
        info.setEmail(iu.getEmail());
        info.setEndereco(iu.getEndereco());
        info.setNome(iu.getNome());
        return info;
        
    }

}
