/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Ong;
import br.com.filipeatividade.repository.OngRepository;
import br.com.filipeatividade.services.OngService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
@WebServlet(name = "OngServlet", urlPatterns = {"/OngServlet"})
public class OngServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null) {
            Ong insumo = OngRepository.find(Long.parseLong(id));

            String operacao = request.getParameter("operacao");

            if ("edit".equals(operacao)) {
                 OngService.showEditForm(request, response, insumo);
            } else if ("delete".equals(operacao)) {
               OngService.deleteOng(request, response, insumo);
            } else {
                OngService.showDetails(response, insumo);
            }
        } else {
            List<Ong> insumos = OngRepository.findAll();
             OngService.showOngList(response, insumos);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Ong ong = OngRepository.find(id);

        ong.setCnpj(request.getParameter("cnpj"));
        ong.setName(request.getParameter("name"));
        ong.setLogin(request.getParameter("login"));
        ong.setPassword(request.getParameter("password"));
        ong.setEmail(request.getParameter("email"));
        ong.setPhone(request.getParameter("phone"));
        ong.setInstagram(request.getParameter("instagram"));

        OngRepository.update(ong);

        OngService.showUpdatedMessage(response);
    }

}
