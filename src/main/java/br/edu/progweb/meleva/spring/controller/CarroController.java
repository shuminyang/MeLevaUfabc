/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.Carro;
import br.edu.progweb.meleva.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author shu
 */
@Controller
public class CarroController {

    @RequestMapping(value = "projeto/carros", method = RequestMethod.GET)
    public String carro(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        request.setAttribute("usuarioCarros", u.getCarroList());
        return "projeto/carro";
    }

    @RequestMapping(value = "cadastrarCarro", method = RequestMethod.POST)
    public String cadastrarCarro(Carro c, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        c.setIdUsuario(u);

        return "";

    }

}
