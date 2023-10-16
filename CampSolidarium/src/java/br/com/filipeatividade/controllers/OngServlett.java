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
@WebServlet(name = "OngServlett", urlPatterns = {"/OngServlett"})
public class OngServlett extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OngServlett</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OngServlett at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    String id = request.getParameter("id");
    
    if (id != null) {
        Ong ong = OngRepository.find(Long.parseLong(id));

        String op = request.getParameter("operacao");

        if (op != null) {
            if (op.equals("edit")) {
                showEditForm(ong, response);
                return;
            } else if (op.equals("delete")) {
                deleteOng(ong, response);
                return;
            }
        } else {
            showDetails(ong, response);
            return;
        }
    }

    // BUSCANDO TODAS AS ONGS
    List<Ong> ongs = OngRepository.findAll();

    response.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ongs</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Todas as Ongs</h1>");
        out.println("<a href='index.html'>Página Inicial</a>");
        out.println("<table border='1'>");
        out.println("<tr><th>Id</th><th>CNPJ</th><th>Nome</th>"
                + "<th>Email</th><th>Telefone</th><th>Instagram</th><th>Ações</th></tr>");
        for (Ong oAux : ongs) {
            out.println("<tr>");
            out.println("<td>" + oAux.getId() + "</td>");
            out.println("<td>" + oAux.getCnpj() + "</td>");
            out.println("<td>" + oAux.getName() + "</td>");
            out.println("<td>" + oAux.getEmail() + "</td>");
            out.println("<td>" + oAux.getPhone() + "</td>");
            out.println("<td>" + oAux.getInstagram() + "</td>");
            out.println("<td><a href='OngServlet?id="
                    + oAux.getId() + "&operacao=edit'>editar</a> "
                    + "<a href='OngServlet?id="
                    + oAux.getId() + "&operacao=delete'>deletar</a>"
                    + "<a href='OngServlet?id="
                    + oAux.getId() + "'>detalhar</a> ");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

public void showEditForm(Ong ong, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Editar Ong</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Editar Ong: " + ong.getName() + "</h1>");
        out.println("<form method='post' action='OngServlet?operacao=edit'>");
        out.println("<input type='hidden' name='id' value='" + ong.getId() + "'/>");
        out.println("Nome: <input type='text' name='name' value='" + ong.getName() + "'/><br/>");
        out.println("CNPJ: <input type='text' name='cnpj' value='" + ong.getCnpj() + "'/><br/>");
        out.println("Email: <input type='text' name='email' value='" + ong.getEmail() + "'/><br/>");
        out.println("Telefone: <input type='text' name='phone' value='" + ong.getPhone() + "'/><br/>");
        out.println("Instagram: <input type='text' name='instagram' value='" + ong.getInstagram() + "'/><br/>");
        out.println("<input type='submit' value='Salvar'/>");
        out.println("</form>");
        out.println("<a href='OngServlet'>Voltar</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

public void deleteOng(Ong ong, HttpServletResponse response) throws IOException {
    OngRepository.delete(ong);
    response.sendRedirect("OngServlet"); // Redireciona para a lista de Ongs após a exclusão
}

public void showDetails(Ong ong, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detalhes da Ong</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Detalhes da Ong: " + ong.getName() + "</h1>");
        out.println("<p>CNPJ: " + ong.getCnpj() + "</p>");
        out.println("<p>Email: " + ong.getEmail() + "</p>");
        out.println("<p>Telefone: " + ong.getPhone() + "</p>");
        out.println("<p>Instagram: " + ong.getInstagram() + "</p>");
        out.println("<a href='OngServlet'>Voltar</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String idParam = request.getParameter("id");
    String name = request.getParameter("name");
    String cnpj = request.getParameter("cnpj");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String instagram = request.getParameter("instagram");

    if (idParam != null) {
        long id = Long.parseLong(idParam);
        Ong ong = new Ong(id, name, cnpj, email, phone, instagram);
        OngRepository.update(ong);
        // Após a atualização
        response.sendRedirect("OngServlet?id=" + ong.getId());
    } else {
        long id = Long.parseLong(idParam);
        Ong ong = new Ong(id, name, cnpj, email, phone, instagram);
        OngRepository.save(ong);
        // Após a exclusão
        response.sendRedirect("OngServlet");
    }
}



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
