/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Ong;
import br.com.filipeatividade.repository.OngRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
@WebServlet(name = "RegisterOngServlet", urlPatterns = {"/RegisterOngServlet"})
public class RegisterOngServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        String cnpj = request.getParameter("cnpj");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String instagram = request.getParameter("instagram");
        
        
        Ong ong = new Ong(id, cnpj, name, login, password, email, phone, instagram);
        
        OngRepository.save(ong);
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>new Ong</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ong "+name+" saved!</h1>");
            out.println("<a href='registerOng.html'>Register new Ong</a>");
            out.println("</body>");
            out.println("</html>");
            
        }
        
    }

}
