/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Emergency;
import br.com.filipeatividade.repository.EmergencyRepository;
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
@WebServlet(name = "RegisterEmergencyServlet", urlPatterns = {"/RegisterEmergencyServlet"})
public class RegisterEmergencyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id =  Long.parseLong(request.getParameter("id"));
        String local = request.getParameter("local");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String severityLevel = request.getParameter("severityLevel");
        
        Emergency emergency = new Emergency(id, local, type, description, severityLevel);
        
        EmergencyRepository.save(emergency);
        
       response.setContentType("text/html;charset=UTF-8");
       
       try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet new Emergency</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Emergency saved!</h1>");
            out.println("<a href='registerEmergency.html'>Register new emergency</a>");
            out.println("</body>");
            out.println("</html>");
            
        }
                
    }

}
