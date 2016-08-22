/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Motorista;

/**
 *
 * @author shu
 */
public interface MotoristaDAOInterface {
    
    public void criarMotorista(Motorista m);
    
    public Motorista atualizarMotorista(Motorista m);
    
}
