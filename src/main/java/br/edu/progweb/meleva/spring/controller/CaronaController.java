/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

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
public class CaronaController {

    @RequestMapping(value = "projeto/carona", method = RequestMethod.GET)
    public String carona(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        if (u.getCarroList() == null || u.getCarroList().isEmpty()) {
            request.setAttribute("usuarioMsg", "Você não possui carro! Não é possível criar uma carona sem carro!");
        } else {
            request.setAttribute("usuarioMsg", "");
        }

        return "projeto/carona";
    }
}
