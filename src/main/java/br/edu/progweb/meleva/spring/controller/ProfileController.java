/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.controller;

import br.edu.progweb.meleva.entidades.Carona;
import br.edu.progweb.meleva.entidades.InfoUsuario;
import br.edu.progweb.meleva.entidades.Motorista;
import br.edu.progweb.meleva.entidades.Passageiro;
import br.edu.progweb.meleva.entidades.Usuario;
import br.edu.progweb.meleva.facade.MeLevaFacadeInterface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ProfileController {

    @Autowired
    private MeLevaFacadeInterface meLevaFacade;

    @RequestMapping(value = "projeto/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        Motorista m = null;
        Passageiro p = null;
        Carona c = null;
        for (Motorista mot : u.getMotoristaList()) {
            if (mot.getAtivo()) {
                m = mot;
                if (m.getCarona().getAtivo()) {
                    c = m.getCarona();
                }
            }
        }
        if (m == null) {
            for (Passageiro pass : u.getPassageiroList()) {
                if (pass.getAtivo()) {
                    p = pass;
                }
            }
            if (p != null) {
                c = p.getIdCarona();
            }
        }
        request.setAttribute("caronaAtiva", c);
        request.setAttribute("passageiroUsuario", p);
        request.setAttribute("motoristaUsuario", m);
        return "projeto/index";
    }

    @RequestMapping(value = "projeto/alterarProfile", method = RequestMethod.GET)
    public String alterarProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        request.setAttribute("usuarioInfo", u.getInfoUsuario());
        request.setAttribute("usuario", u);
        return "projeto/alterarProfile";
    }

    @RequestMapping(value = "projeto/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:../login";
    }

    @RequestMapping(value = "projeto/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        request.setAttribute("usuario", u);
        request.setAttribute("usuarioInfo", u.getInfoUsuario());        
        request.setAttribute("usuarioCarros", u.getCarroList());
        request.setAttribute("usuarioPassageiro", u.getPassageiroList());
        request.setAttribute("usuarioMotorista", u.getMotoristaList());
        return "projeto/profile";
    }

    @Transactional
    @RequestMapping(value = "projeto/updateProfile", method = RequestMethod.POST)
    public String updateProfile(HttpServletRequest request, InfoUsuario iu, @RequestParam("senha") String senha) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        iu.setId(u.getInfoUsuario().getId());
        iu.setUsuario(u);
        iu = meLevaFacade.atualizarInfoUsuario(iu);
        u.setInfoUsuario(iu);
        return "projeto/profile";
    }

}
