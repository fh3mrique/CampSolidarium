/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Insumo;
import br.com.filipeatividade.repository.InsumoRepository;
import br.com.filipeatividade.services.InsumoService;
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
@WebServlet(name = "InsumoServlet", urlPatterns = {"/InsumoServlet"})
public class InsumoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null) {
            Insumo insumo = InsumoRepository.find(Long.parseLong(id));

            String operacao = request.getParameter("operacao");

            if ("edit".equals(operacao)) {
                 InsumoService.showEditForm(request, response, insumo);
            } else if ("delete".equals(operacao)) {
               InsumoService.deleteInsumo(request, response, insumo);
            } else {
                InsumoService.showDetails(response, insumo);
            }
        } else {
            List<Insumo> insumos = InsumoRepository.findAll();
             InsumoService.showInsumosList(response, insumos);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("codigo"));

        Insumo insumo = InsumoRepository.find(id);

        insumo.setName(request.getParameter("name"));
        insumo.setBrand(request.getParameter("brand"));
        insumo.setCategory(request.getParameter("category"));
        insumo.setQtd(Integer.parseInt(request.getParameter("qtd")));

        InsumoRepository.update(insumo);

        InsumoService.showUpdatedMessage(response);
    }

}
