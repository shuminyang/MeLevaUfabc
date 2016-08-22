/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.dao;

import br.edu.progweb.meleva.entidades.Carona;
import java.util.List;

/**
 *
 * @author shu
 */
public interface CaronaDAOInterface {
    
    public List<Carona> listarCarona();
    
    public void criarCarona(Carona c);
    
    public Carona caronaPeloId(Integer id);
    
    public Carona desativarCarona(Carona c);
    
}
