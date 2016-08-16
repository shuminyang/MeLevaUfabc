/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.InfoUsuario;

/**
 *
 * @author shu
 */
public interface InfoUsuarioDAOInterface {
    
    public void criarInfoUsuario(InfoUsuario iu);
    
    public InfoUsuario atualizarInfoUsuario(InfoUsuario iu);
    
}
