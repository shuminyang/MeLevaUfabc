/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Motorista;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class MotoristaDAO implements MotoristaDAOInterface {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criarMotorista(Motorista m) {
        manager.persist(m);
    }

    @Override
    public Motorista atualizarMotorista(Motorista m) {
        Motorista mo = manager.find(Motorista.class, m.getId());
        mo.setAtivo(m.getAtivo());
        mo.setIdUsuario(m.getIdUsuario());
        return mo;
    }

}
