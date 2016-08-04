/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Usuario;

/**
 *
 * @author shu
 */
public interface UsuarioDAOInterface {
    
    public Usuario buscarUsuarioPorNome(Usuario u);
    
    public void criarLogin(Usuario u);
    
}
