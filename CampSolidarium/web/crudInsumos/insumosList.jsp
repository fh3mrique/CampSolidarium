<%-- 
    Document   : insumosList
    Created on : Nov 12, 2023, 8:35:53 PM
    Author     : adm
--%>

<%-- 
    Document   : insumosList
    Created on : Nov 12, 2023, 8:35:53 PM
    Author     : adm
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.filipeatividade.entities.Insumo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Insumos</h1>
        <a href='index.html'>Voltar</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Categoria</th>
                <th>Quantidade</th>
                <th>Ações</th>
            </tr>

            <%
                // Obtém os insumos do atributo "insumos"
                List<Insumo> insumos = (List<Insumo>) request.getAttribute("insumos");

                // Itera sobre os insumos
                for (Insumo insumo : insumos) {
            %>

            <tr>
                <td><%= insumo.getId() %></td>
                <td><%= insumo.getName() %></td>
                <td><%= insumo.getBrand() %></td>
                <td><%= insumo.getCategory() %></td>
                <td><%= insumo.getQtd() %></td>
                <td>
                    <a href='InsumoServlet?id=<%= insumo.getId() %>&operacao=detalhar'>Detalhar</a>
                    <a href='InsumoServlet?id=<%= insumo.getId() %>&operacao=editar'>Editar</a>
                    <a href='InsumoServlet?id=<%= insumo.getId() %>&operacao=excluir'>Excluir</a>
                </td>
            </tr>

            <% } %>

        </table>

    </body>
</html>