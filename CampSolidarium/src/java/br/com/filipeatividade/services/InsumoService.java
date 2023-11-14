/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.services;

import br.com.filipeatividade.entities.Insumo;
import br.com.filipeatividade.repository.InsumoRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class InsumoService {
    
    public static void showDetails(HttpServletRequest request, HttpServletResponse response, Insumo insumo)
            throws ServletException, IOException {
        request.setAttribute("insumo", insumo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudInsumos/detailsInsumo.jsp");
        dispatcher.forward(request, response);
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response, Insumo insumo)
            throws ServletException, IOException {
        request.setAttribute("insumo", insumo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudInsumos/editInsumo.jsp");
        dispatcher.forward(request, response);
    }

    public static void deleteInsumo(HttpServletRequest request, HttpServletResponse response, Insumo insumo)
            throws ServletException, IOException {
        InsumoRepository.delete(insumo);
        showUpdatedMessage(request, response);
    }

    public static void showInsumosList(HttpServletRequest request, HttpServletResponse response, List<Insumo> insumos)
            throws ServletException, IOException {
        request.setAttribute("insumos", insumos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudInsumos/insumosList.jsp");
        dispatcher.forward(request, response);
    }

    public static void showUpdatedMessage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudInsumos/updatedMessage.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateInsumo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("codigo"));
        Insumo insumo = InsumoRepository.find(id);

        insumo.setName(request.getParameter("nome"));
        insumo.setBrand(request.getParameter("marca"));
        insumo.setCategory(request.getParameter("categoria"));
        insumo.setQtd(Integer.parseInt(request.getParameter("quantidade")));

        InsumoRepository.update(insumo);

        showUpdatedMessage(request, response);
    }
    
}
