/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.services;

import br.com.filipeatividade.entities.Ong;
import br.com.filipeatividade.repository.OngRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class OngService {
    
     public static void showOngList(HttpServletRequest request,HttpServletResponse response, List<Ong> ongs) 
              throws ServletException, IOException {
        request.setAttribute("ongs", ongs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudOng/ongList.jsp");
        dispatcher.forward(request, response);
        
    }
    
    public static void showEditForm(HttpServletRequest request, HttpServletResponse response, Ong ong) 
            throws ServletException, IOException {
        request.setAttribute("ong", ong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudOng/editOng.jsp");
        dispatcher.forward(request, response);
    }

    public static void deleteOng(HttpServletRequest request, HttpServletResponse response, Ong ong) throws ServletException, IOException {
        OngRepository.delete(ong);

        showUpdatedMessage(request, response);
    }

    public static void showDetails(HttpServletRequest request, HttpServletResponse response, Ong ong) 
            throws ServletException, IOException {
      
        request.setAttribute("ong", ong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudOng/detailsOng.jsp");
        dispatcher.forward(request, response);
        
    }

    public static void showUpdatedMessage(HttpServletRequest request,  HttpServletResponse response) 
           throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/crudOng/message.jsp");
        dispatcher.forward(request, response);
        
    }
    
    public static void updateOng(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("codigo"));
        Ong ong = OngRepository.find(id);

        ong.setName(request.getParameter("id"));
        ong.setCnpj(request.getParameter("cnpj"));
        ong.setName(request.getParameter("name"));
        ong.setLogin(request.getParameter("login"));
        ong.setPassword(request.getParameter("password"));
        ong.setEmail(request.getParameter("email"));
        ong.setPhone(request.getParameter("phone"));
        ong.setEmail(request.getParameter("email"));
        
        OngRepository.update(ong);

        showUpdatedMessage(request, response);
    }
    
}
