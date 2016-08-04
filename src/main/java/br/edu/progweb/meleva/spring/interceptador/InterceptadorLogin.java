/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.spring.interceptador;

import br.edu.progweb.meleva.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author shu
 */
public class InterceptadorLogin extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        if (u != null) {
            return true;
        } else {
            response.sendRedirect(request.getServletContext().getContextPath() + "/");
            return false;
        }

    }

}
