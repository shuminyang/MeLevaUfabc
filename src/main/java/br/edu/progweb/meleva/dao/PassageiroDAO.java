/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Passageiro;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class PassageiroDAO implements PassageiroDAOInterface {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criarPassageiro(Passageiro p) {
        manager.persist(p);
    }

    @Override
    public Passageiro atualizarPassageiro(Passageiro p) {
        Passageiro pa = manager.find(Passageiro.class, p.getId());
        pa.setIdCarona(p.getIdCarona());
        pa.setIdUsuario(p.getIdUsuario());
        pa.setAtivo(p.getAtivo());
        return pa;
    }

}
