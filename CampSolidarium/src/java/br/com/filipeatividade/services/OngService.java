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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class OngService {
    
     public static void showOngList(HttpServletResponse response, List<Ong> ongs) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ong List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registered Ong</h1>");
            out.println("<a href='index.html'>Home</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Cnpj</th><th>Name</th>"
                    + "<th>Login</th><th>Password</th><th>Email</th><th>Phone</th><th>Instagram</th><th>Actions</th></tr>");

            for (Ong oAux : ongs) {
                out.println("<tr>");
                out.println("<td>" + oAux.getId() + "</td>");
                out.println("<td>" + oAux.getCnpj() + "</td>");
                out.println("<td>" + oAux.getName() + "</td>");
                out.println("<td>" + oAux.getLogin() + "</td>");
                out.println("<td>" + oAux.getPassword() + "</td>");
                out.println("<td>" + oAux.getEmail() + "</td>");
                out.println("<td>" + oAux.getPhone() + "</td>");
                out.println("<td>" + oAux.getInstagram() + "</td>");
                out.println("<td><a href='OngServlet?id=" + oAux.getId() + "&operacao=detalhar'>Details</a> " +
                        "<a href='OngServlet?id=" + oAux.getId() + "&operacao=edit'>Edit</a>" +
                        " <a href='OngServlet?id=" + oAux.getId() + "&operacao=delete'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static void showEditForm(HttpServletRequest request, HttpServletResponse response, Ong ong) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Ong</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit Ong: " + ong.getName() + "</h1>");

            out.println("<form method='post' action='OngServlet'>");
            out.println("<input type='hidden' name='id' value='" + ong.getId() + "'/></br>");
            out.println("Cnpj:<input type='text' name='cnpj' value='" + ong.getCnpj() + "'/></br>");
            out.println("Name:<input type='text' name='name' value='" + ong.getName() + "'/></br>");
            out.println("Login:<input type='text' name='login' value='" + ong.getLogin() + "'/></br>");
            out.println("Password:<input type='text' name='password' value='" + ong.getPassword() + "'/></br>");
            out.println("Email:<input type='text' name='email' value='" + ong.getEmail() + "'/></br>");
            out.println("Phone:<input type='text' name='phone' value='" + ong.getPhone() + "'/></br>");
            out.println("Instagram:<input type='text' name='instagram' value='" + ong.getInstagram() + "'/></br>");
            
            out.println("<input type='submit' value='Edit'/></br>");
            out.println("</form>");

            out.println("<a href='OngServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static void deleteOng(HttpServletRequest request, HttpServletResponse response, Ong ong) throws IOException {
        OngRepository.delete(ong);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ong Deleted</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ong Deleted Successfully!</h1>");
            out.println("<a href='OngServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static void showDetails(HttpServletResponse response, Ong ong) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Details: " + ong.getName() + "</h1>");
            out.println("<h5>Cnpj:" + ong.getCnpj() + "</h5>");
            out.println("<h5>Email:" + ong.getEmail() + "</h5>");
            out.println("<h5>Phone:" + ong.getPhone() + "</h5>");
            out.println("<h5>Login:" + ong.getLogin() + "</h5>");
            out.println("<h5>Instagram:" + ong.getInstagram() + "</h5>");
            out.println("<a href='OngServlet'>Back</a>");
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
            out.println("<title>Insumo servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ong Updated Successfully!</h1>");
            out.println("<a href='OngServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
