/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author shu
 */
@Controller
public class ProfileController {
    
    @RequestMapping(value = "projeto/index", method = RequestMethod.GET)
    public String index() {
        return "projeto/index";
    }
    
    @RequestMapping(value = "projeto/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {        
        HttpSession session = request.getSession();
        session.invalidate();
        
        System.out.println("VAI SE FUDER");        
        return "redirect:../login";
    }

    @RequestMapping(value = "projeto/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, HttpServletResponse response) {        
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        request.setAttribute("usuarioInfo", u.getInfoUsuario());
        request.setAttribute("usuarioCarros", u.getCarroList());
        return "projeto/profile";
    }

}
