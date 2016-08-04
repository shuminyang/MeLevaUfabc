/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.facade;

import br.edu.progweb.meleva.entidades.Carro;
import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Usuario;

/**
 *
 * @author shu
 */
public interface MeLevaFacadeInterface {

    public Usuario validarLogin(Usuario u);

    public void criarInfoUsuario(InfoUsuario iu);
    
    public void cadastrarCarro(Carro c);
}
