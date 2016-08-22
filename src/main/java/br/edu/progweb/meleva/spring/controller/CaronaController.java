/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.Carona;
import br.edu.progweb.meleva.entidades.Motorista;
import br.edu.progweb.meleva.entidades.Passageiro;
import br.edu.progweb.meleva.entidades.Usuario;
import br.edu.progweb.meleva.facade.MeLevaFacadeInterface;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author shu
 */
@Controller
public class CaronaController {

    @Autowired
    private MeLevaFacadeInterface meLevaFacade;

    @RequestMapping(value = "projeto/carona", method = RequestMethod.GET)
    public String carona(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        if (u.getCarroList() == null || u.getCarroList().isEmpty()) {
            request.setAttribute("usuarioMsg", "Você não possui carro! Não é possível criar uma carona sem carro!");
        } else if (u.getMotoristaList() != null || u.getPassageiroList() != null) {
            for (Motorista m : u.getMotoristaList()) {
                if (m.getAtivo()) {
                    request.setAttribute("usuarioMsg", "Você possui carona ativa!");
                }
            }
            for (Passageiro p : u.getPassageiroList()) {
                if (p.getAtivo()) {
                    request.setAttribute("usuarioMsg", "Você possui carona ativa!");
                }
            }
        } else {
            request.setAttribute("usuarioMsg", "");
            request.setAttribute("carroLista", u.getCarroList());
        }

        return "projeto/carona";
    }

    @RequestMapping(value = "projeto/listarCarona", method = RequestMethod.GET)
    public String listarCarona(HttpServletRequest request) {
        List<Carona> listaCarona = meLevaFacade.listarCarona();
        request.setAttribute("listaCarona", listaCarona);
        return "projeto/listarCarona";
    }

    @RequestMapping(value = "projeto/criarCarona", method = RequestMethod.POST)
    @Transactional
    public String criarCarona(HttpServletRequest request, Carona c) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        Motorista m = new Motorista();
        m.setIdUsuario(u);
        m.setAtivo(Boolean.TRUE);
        meLevaFacade.criarMotorista(m);
        u.getMotoristaList().add(m);
        c.setIdMotorista(m);
        c.setAtivo(Boolean.TRUE);
        meLevaFacade.criarCarona(c, u);
        return "projeto/carona";
    }

    @Transactional
    @RequestMapping(value = "projeto/caronaTeste", method = RequestMethod.POST)
    public String testeCarona(HttpServletRequest request, @RequestParam("teste") Integer idCarona) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        Carona carona = meLevaFacade.caronaPeloId(idCarona);
        Passageiro pass = new Passageiro();
        pass.setIdUsuario(u);
        pass.setIdCarona(carona);
        pass.setAtivo(Boolean.TRUE);
        meLevaFacade.criarPassageiro(pass);
        u.getPassageiroList().add(pass);
        carona.getPassageiroList().add(pass);

        return "redirect:listarCarona";
    }
    
    
}
