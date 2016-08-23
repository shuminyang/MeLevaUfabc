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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
public class CaronaController {

    @Autowired
    private MeLevaFacadeInterface meLevaFacade;

    @RequestMapping(value = "projeto/caronasAtivas", method = RequestMethod.GET)
    public String caronasAtivas(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        request.setAttribute("listaMotorista", u.getMotoristaList());
        request.setAttribute("listaPassageiro", u.getPassageiroList());
        return "projeto/caronasAtivas";
    }

    @RequestMapping(value = "projeto/carona", method = RequestMethod.GET)
    public String carona(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        boolean temAtivo = false;
        if (u.getCarroList() == null || u.getCarroList().isEmpty()) {
            request.setAttribute("usuarioMsg", "Você não possui carro! Não é possível criar uma carona sem carro!");
            temAtivo = true;
        } else if (u.getMotoristaList() != null || u.getPassageiroList() != null) {
            for (Motorista m : u.getMotoristaList()) {
                if (m.getAtivo()) {
                    request.setAttribute("usuarioMsg", "Você possui carona ativa!");
                    temAtivo = true;
                }

            }

            for (Passageiro p : u.getPassageiroList()) {
                if (p.getAtivo()) {
                    request.setAttribute("usuarioMsg", "Você possui carona ativa!");
                    temAtivo = true;
                }

            }
        }
        if (temAtivo == false) {
            request.setAttribute("usuarioMsg", "");
            request.setAttribute("carroLista", u.getCarroList());
        }

        return "projeto/carona";
    }

    @RequestMapping(value = "projeto/listarCarona", method = RequestMethod.GET)
    public String listarCarona(HttpServletRequest request) {
        List<Carona> listaCarona = meLevaFacade.listarCarona();
        List<Carona> listaAtualizada = new ArrayList<>();
        for (Carona c : listaCarona) {
            if (c.getAtivo()) {
                listaAtualizada.add(c);
            }
        }
        System.out.println(listaAtualizada.size());

        request.setAttribute("listaCarona", listaAtualizada);
        return "projeto/listarCarona";
    }

    @RequestMapping(value = "projeto/criarCarona", method = RequestMethod.POST)
    @Transactional
    public String criarCarona(HttpServletRequest request, Carona c, @RequestParam("chegada") String chegada, @RequestParam("partida") String partida) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        Motorista m = new Motorista();
        m.setIdUsuario(u);
        m.setCarona(c);
        m.setAtivo(Boolean.TRUE);
        meLevaFacade.criarMotorista(m);
        u.getMotoristaList().add(m);
        c.setMotorista(m);
        c.setAtivo(Boolean.TRUE);
        c.setId(m.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.clear(Calendar.HOUR_OF_DAY);
        calendar.clear(Calendar.AM_PM);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.clear(Calendar.HOUR_OF_DAY);
        calendar2.clear(Calendar.AM_PM);
        calendar2.clear(Calendar.MINUTE);
        calendar2.clear(Calendar.SECOND);
        calendar2.clear(Calendar.MILLISECOND);

        String hh = partida.split(":")[0];
        String mm = partida.split(":")[1];

        calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hh) - 3);
        calendar.add(Calendar.MINUTE, Integer.parseInt(mm));

        Date newDate = calendar.getTime();

        c.setDataHorario(newDate);

        hh = chegada.split(":")[0];
        mm = chegada.split(":")[1];

        calendar2.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hh) - 3);
        calendar2.add(Calendar.MINUTE, Integer.parseInt(mm));

        Date novoDate = calendar2.getTime();

        c.setHorarioChegada(novoDate);

        meLevaFacade.criarCarona(c, u);
        carona(request);
        return "redirect:carona";
    }

    @Transactional
    @RequestMapping(value = "projeto/caronaTeste", method = RequestMethod.POST)
    public String testeCarona(HttpServletRequest request, HttpServletResponse response, @RequestParam("teste") Integer idCarona) throws IOException {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        boolean temCarona = false;
        for (Motorista m : u.getMotoristaList()) {
            if (m.getAtivo()) {
                temCarona = true;
            }
        }
        for (Passageiro p : u.getPassageiroList()) {
            if (p.getAtivo()) {
                temCarona = true;
            }
        }
        if (!temCarona) {
            Carona carona = meLevaFacade.caronaPeloId(idCarona);
            Passageiro pass = new Passageiro();
            pass.setIdUsuario(u);
            pass.setIdCarona(carona);
            pass.setAtivo(Boolean.TRUE);
            meLevaFacade.criarPassageiro(pass);
            u.getPassageiroList().add(pass);
            carona.getPassageiroList().add(pass);
            carona.setNLugares(carona.getNLugares() - 1);
        } else {

            request.setAttribute("mensagemCarona", "Você já possui uma carona! Não é possível entrar em outra!");

        }
        listarCarona(request);
        return "projeto/listarCarona";
    }

    @RequestMapping(value = "projeto/passageiroAtualizar", method = RequestMethod.POST)
    @Transactional
    public String passageiroChegar(HttpServletRequest request, @RequestParam("idPass") Integer idPass) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        for (Passageiro p : u.getPassageiroList()) {
            if (Objects.equals(p.getId(), idPass)) {
                p.setAtivo(Boolean.FALSE);
                p = meLevaFacade.atualizarPassageiro(p);
                request.setAttribute("mpAtualizado", "Carona atualizada com sucesso!");
            }
        }
        caronasAtivas(request);
        return "projeto/caronasAtivas";

    }

    @Transactional
    @RequestMapping(value = "projeto/motoristaAtualizar", method = RequestMethod.POST)
    public String motoristaChegar(HttpServletRequest request, @RequestParam("idMot") Integer idMot) {
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        for (Motorista m : u.getMotoristaList()) {
            if (Objects.equals(m.getId(), idMot)) {
                Carona c = m.getCarona();
                boolean passageiro = false;
                for (Passageiro p : c.getPassageiroList()) {
                    if (p.getAtivo()) {
                        passageiro = true;
                    }
                }
                if (!passageiro) {
                    m.setAtivo(Boolean.FALSE);
                    m = meLevaFacade.atualizarMotorista(m);
                    request.setAttribute("mpAtualizado", "Carona atualizada com sucesso!");
                } else {
                    request.setAttribute("mpAtualizado", "Há passageiros na carona ainda, espere eles chegarem no local.");

                }

            }
        }
        caronasAtivas(request);
        return "projeto/caronasAtivas";
    }

}
