/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.facade;

import br.edu.progweb.meleva.entidades.Carona;
import br.edu.progweb.meleva.entidades.Carro;
import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Motorista;
import br.edu.progweb.meleva.entidades.Passageiro;
import br.edu.progweb.meleva.entidades.Usuario;
import java.util.List;

/**
 *
 * @author shu
 */
public interface MeLevaFacadeInterface {

    public Usuario validarLogin(Usuario u);

    public void criarInfoUsuario(InfoUsuario iu);
    
    public void cadastrarCarro(Carro c);
    
    public void criarCarona(Carona c, Usuario u);
    
    public List<Carona> listarCarona();
    
    public InfoUsuario atualizarInfoUsuario(InfoUsuario iu);
    
    public void criarMotorista(Motorista m);
    
    public Carona caronaPeloId(Integer id);
    
    public void criarPassageiro(Passageiro p);
}
