/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.services;

import br.com.filipeatividade.entities.Emergency;
import br.com.filipeatividade.repository.EmergencyRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class EmergencyService {
    
    public static void showEmergenciesList(HttpServletResponse response, List<Emergency> emergencies) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Emergencies List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registered Emergencies</h1>");
            out.println("<a href='index.html'>Home</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Local</th><th>Type</th>"
                    + "<th>Description</th><th>Severity Level</th><th>Actions</th></tr>");

            for (Emergency eAux : emergencies) {
                out.println("<tr>");
                out.println("<td>" + eAux.getId() + "</td>");
                out.println("<td>" + eAux.getLocal() + "</td>");
                out.println("<td>" + eAux.getType() + "</td>");
                out.println("<td>" + eAux.getDescription() + "</td>");
                out.println("<td>" + eAux.getSeverityLevel() + "</td>");
                out.println("<td><a href='EmergencyServlet?id=" + eAux.getId() + "&operacao=detalhar'>Details</a> " +
                        "<a href='EmergencyServlet?id=" + eAux.getId() + "&operacao=edit'>Edit</a>" +
                        " <a href='EmergencyServlet?id=" + eAux.getId() + "&operacao=delete'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
       
    public static void showEditForm(HttpServletRequest request, HttpServletResponse response, Emergency emergency) throws IOException {
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit User</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit emergency: " + emergency.getId() + "</h1>");

            out.println("<form method='post' action='EmergencyServlet'>");
            out.println("<input type='hidden' name='codigo' value='" + emergency.getId() + "'/></br>");
            out.println("local:<input type='text' name='local' value='" + emergency.getLocal() + "'/></br>");
            out.println("description:<input type='text' name='description' value='" + emergency.getDescription() + "'/></br>");
            out.println("severityLevel:<input type='text' name='severityLevel' value='" + emergency.getSeverityLevel() + "'/></br>");
            out.println("type:<input type='text' name='type' value='" + emergency.getType() + "'/></br>");
            out.println("<input type='submit' value='Edit'/></br>");
            out.println("</form>");

            out.println("<a href='InsumoServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    
    }
    
    public static void deleteEmergency(HttpServletRequest request, HttpServletResponse response, Emergency emergency) throws IOException {
        
        EmergencyRepository.delete(emergency);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>emergency Deleted</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Emergency Deleted Successfully!</h1>");
            out.println("<a href='EmergencyServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static void showDetails(HttpServletResponse response, Emergency emergency) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Emergency Details</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Emergency Details: " + emergency.getSeverityLevel() + "</h1>");
            out.println("<h5>Local:" + emergency.getType()+ "</h5>");
            out.println("<h5>Category:" + emergency.getLocal() + "</h5>");
            out.println("<h5>Description: " + emergency.getDescription() + "</h5>");
            out.println("<a href='EmergencyServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
     public static void showUpdatedMessage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Emergency servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Emergency Updated Successfully!</h1>");
            out.println("<a href='EmergencyServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
}
