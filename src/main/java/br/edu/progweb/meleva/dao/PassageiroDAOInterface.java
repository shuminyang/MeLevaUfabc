/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Passageiro;

/**
 *
 * @author shu
 */
public interface PassageiroDAOInterface {
    
    public void criarPassageiro(Passageiro p);
    
    public Passageiro atualizarPassageiro(Passageiro p);
    
}
