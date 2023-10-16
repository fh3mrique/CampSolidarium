/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.filipeatividade.controllers;

import br.com.filipeatividade.entities.Insumo;
import br.com.filipeatividade.repository.InsumoRepository;
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
                showEditForm(request, response, insumo);
            } else if ("delete".equals(operacao)) {
                deleteInsumo(request, response, insumo);
            } else {
                showDetails(response, insumo);
            }
        } else {
            List<Insumo> insumos = InsumoRepository.findAll();
            showInsumosList(response, insumos);
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

        showUpdatedMessage(response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response, Insumo insumo) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit User</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit User: " + insumo.getName() + "</h1>");

            out.println("<form method='post' action='InsumoServlet'>");
            out.println("<input type='hidden' name='codigo' value='" + insumo.getId() + "'/></br>");
            out.println("Name:<input type='text' name='name' value='" + insumo.getName() + "'/></br>");
            out.println("Brand:<input type='text' name='brand' value='" + insumo.getBrand() + "'/></br>");
            out.println("Category:<input type='text' name='category' value='" + insumo.getCategory() + "'/></br>");
            out.println("Amount:<input type='text' name='qtd' value='" + insumo.getQtd() + "'/></br>");
            out.println("<input type='submit' value='Edit'/></br>");
            out.println("</form>");

            out.println("<a href='InsumoServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void deleteInsumo(HttpServletRequest request, HttpServletResponse response, Insumo insumo) throws IOException {
        InsumoRepository.delete(insumo);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Deleted</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Insumo Deleted Successfully!</h1>");
            out.println("<a href='InsumoServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void showDetails(HttpServletResponse response, Insumo insumo) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Details: " + insumo.getName() + "</h1>");
            out.println("<h5>Brand:" + insumo.getBrand() + "</h5>");
            out.println("<h5>Category:" + insumo.getCategory() + "</h5>");
            out.println("<h5>Quantity:" + insumo.getQtd() + "</h5>");
            out.println("<a href='InsumoServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void showInsumosList(HttpServletResponse response, List<Insumo> insumos) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Insumos List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registered Insumos</h1>");
            out.println("<a href='index.html'>Home</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Brand</th>"
                    + "<th>Category</th><th>Quantity</th><th>Actions</th></tr>");

            for (Insumo iAux : insumos) {
                out.println("<tr>");
                out.println("<td>" + iAux.getId() + "</td>");
                out.println("<td>" + iAux.getName() + "</td>");
                out.println("<td>" + iAux.getBrand() + "</td>");
                out.println("<td>" + iAux.getCategory() + "</td>");
                out.println("<td>" + iAux.getQtd() + "</td>");
                out.println("<td><a href='InsumoServlet?id=" + iAux.getId() + "&operacao=detalhar'>Details</a> " +
                        "<a href='InsumoServlet?id=" + iAux.getId() + "&operacao=edit'>Edit</a>" +
                        " <a href='InsumoServlet?id=" + iAux.getId() + "&operacao=delete'>Delete</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void showUpdatedMessage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Insumo servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Insumo Updated Successfully!</h1>");
            out.println("<a href='InsumoServlet'>Back</a>");
            out.println("</body>");
            out.println("</html>");
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
