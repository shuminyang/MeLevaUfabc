/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Carona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shu
 */
@Repository
public class CaronaDAO implements CaronaDAOInterface {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void criarCarona(Carona c) {
        manager.persist(c);
    }

    @Override
    public List<Carona> listarCarona() {
        return manager.createNamedQuery("Carona.findAll").getResultList();
    }

}
