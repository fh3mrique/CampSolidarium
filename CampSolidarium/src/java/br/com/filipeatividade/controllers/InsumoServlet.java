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

            Insumo i = InsumoRepository.find(Long.parseLong(id));

            String op = request.getParameter("operacao");

            if (op != null && op.equals("edit")) {

                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet UsuariosServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Editar Usuário: " + i.getName() + "</h1>");

                    out.println("<form method='post' action='InsumoServlet'>");

                    out.println("<input type='hidden' name='codigo' value='" + i.getId() + "'/></br>");
                    out.println("Name:<input type='text' name='name' value='" + i.getName() + "'/></br>");
                    out.println("brand:<input type='text' name='brand' value='" + i.getBrand() + "'/></br>");
                    out.println("Category:<input type='text' name='category' value='" + i.getCategory() + "'/></br>");
                    out.println("Amount:<input type='text' name='qtd' value='" + i.getQtd() + "'/></br>");
                    out.println("<input type='submit' value='editar'/></br>");
                    out.println("</form>");

                    out.println("<a href='InsumoServlet'>voltar</a>");
                    out.println("</body>");
                    out.println("</html>");
                    return;

                }
            }
            else if(op.equals("delete")){
                
                InsumoRepository.delete(i);
                
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UsuariosServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Insumo Deleted Successfully!</h1>");
                out.println("<a href='InsumoServlet'>voltar</a>");
                out.println("</body>");
                out.println("</html>");
        }
                
            }

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UsuariosServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Detalhes do usuário: " + i.getName() + "</h1>");
                out.println("<h5>brand:" + i.getBrand() + "</h5>");
                out.println("<h5>Category:" + i.getCategory() + "</h5>");
                out.println("<h5>qunatidade:" + i.getQtd() + "</h5>");
                out.println("<a href='InsumoServlet'>voltar</a>");
                out.println("</body>");
                out.println("</html>");

                return;
            }

        }
    
    

    List<Insumo> insumos = InsumoRepository.findAll();

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet RegisterInsumoServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Insumos Cadastrados</h1>");
        out.println("<a href='index.html'>home</a>");
        out.println("<table border='1'>");
        out.println("<tr><th>id</th><th>name</th><th>brand</th>"
                + "<th>category</th><th>qtd</th><th>ações</th></tr>");

        for (Insumo iAux : insumos) {
            out.println("<tr>");
            out.println("<td>" + iAux.getId() + "</td>");
            out.println("<td>" + iAux.getName() + "</td>");
            out.println("<td>" + iAux.getBrand() + "</td>");
            out.println("<td>" + iAux.getCategory() + "</td>");
            out.println("<td>" + iAux.getQtd() + "</td>");
            out.println("<td><a href='InsumoServlet?id=" + iAux.getId() + "&operacao=detalhar'>detalhar</a> " +
            "<a href='InsumoServlet?id=" + iAux.getId() + "&operacao=edit'>editar</a>" +
            " <a href='InsumoServlet?id=" + iAux.getId() + "&operacao=delete'>deletar</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    Long id = Long.parseLong(request.getParameter("codigo")); // Alteração aqui

    Insumo i = InsumoRepository.find(id);

    i.setName(request.getParameter("name"));
    i.setBrand(request.getParameter("brand"));
    i.setCategory(request.getParameter("category"));
    i.setQtd(Integer.parseInt(request.getParameter("qtd")));

    InsumoRepository.update(i);

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Insumo servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Insumo Updated Successfully!</h1>");
        out.println("<a href='InsumoServlet'>voltar</a>");
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
