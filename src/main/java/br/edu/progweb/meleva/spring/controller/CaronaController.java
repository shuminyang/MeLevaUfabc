/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.Carona;
import br.edu.progweb.meleva.entidades.Motorista;
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
        meLevaFacade.criarMotorista(m);
        u.getMotoristaList().add(m);
        c.setIdMotorista(m);
        meLevaFacade.criarCarona(c, u);
        return "projeto/carona";
    }
}
