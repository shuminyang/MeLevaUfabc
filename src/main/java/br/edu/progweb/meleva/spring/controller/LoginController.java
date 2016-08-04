/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Usuario;
import br.edu.progweb.meleva.facade.MeLevaFacadeInterface;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class LoginController {

    @Autowired
    private MeLevaFacadeInterface meLevaFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "login";
    }

    @RequestMapping(value = "cadastro", method = RequestMethod.GET)
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "sobre", method = RequestMethod.GET)
    public String sobre() {
        return "sobre";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Usuario u, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if (u != null) {
            Usuario us = meLevaFacade.validarLogin(u);

            if (us != null) {
                session.setAttribute("usuario", us);
                return "projeto/index";
            }
        }

        return "login";
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String criarConta(Usuario u, InfoUsuario iu, HttpServletRequest request, HttpServletResponse response) {
        
        if (u != null && iu != null) {
            
            meLevaFacade.criarLogin(u);
            iu.setUsuario(u);
            iu.setDataInclusao(new Date());
            iu.setDataNascimento(new Date());
            meLevaFacade.criarInfoUsuario(iu);
            
            return "login";
        }
        return null;
    }

}
