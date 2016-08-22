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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
                return "redirect:projeto/index";
            }
        }
        request.setAttribute("loginMsg", "Usuário ou senha inválidos!");
        return "login";
    }

    @Transactional
    @RequestMapping(value = "cadastraUsuario", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CadastroControl criarConta(@ModelAttribute Usuario u, @ModelAttribute InfoUsuario iu, HttpServletRequest request, HttpServletResponse response) {
        CadastroControl rc = new CadastroControl();        
        if (u != null && iu != null) {

            iu.setUsuario(u);
            iu.setDataInclusao(new Date());
            try {
                meLevaFacade.criarInfoUsuario(iu);
                rc.setCadastrado(true);
                rc.setMensagem("Usuário cadastrado!");
                return rc;
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
                rc.setCadastrado(false);
                rc.setMensagem("Erro durante o cadastro! Contate o adm e tente novamente");
            }
        }
        rc.setCadastrado(false);
        rc.setMensagem("Há parâmetros em branco!");
        return rc;

    }

    public class CadastroControl {

        private boolean cadastrado;
        private String mensagem;

        public CadastroControl() {
        }

        public CadastroControl(boolean cadastrado, String mensagem) {
            this.cadastrado = cadastrado;
            this.mensagem = mensagem;
        }

        public boolean isCadastrado() {
            return cadastrado;
        }

        public void setCadastrado(boolean cadastrado) {
            this.cadastrado = cadastrado;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }

    }

}
