/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Carro;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class CarroDAO implements CarroDAOInterface {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criarCarro(Carro c) {
        manager.persist(c);
    }

    @Override
    public void atualizarCarro(Carro c) {
        Carro ca = manager.find(Carro.class, c.getId());
        ca.setIdUsuario(c.getIdUsuario());
        ca.setLugares(c.getLugares());
        ca.setPlaca(c.getPlaca());
    }

}
