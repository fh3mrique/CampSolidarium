<%-- 
    Document   : ongList
    Created on : Nov 13, 2023, 10:16:26 PM
    Author     : adm
--%>

<%@page import="br.com.filipeatividade.entities.Ong"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Ongs</h1>
        <a href='index.html'>Voltar</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>cnpj</th>
                <th>nome</th>
                <th>login</th>
                <th>senha</th>
                <th>email</th>
                <th>telefone</th>
                <th>instagram</th>
            </tr>

            <%
                List<Ong> ongs = (List<Ong>) request.getAttribute("ongs");

                for (Ong ong : ongs) {
            %>

            <tr>
                <td><%= ong.getId() %></td>
                <td><%= ong.getCnpj() %></td>
                <td><%= ong.getName() %></td>
                <td><%= ong.getLogin() %></td>
                <td><%= ong.getPassword() %></td>
                <td><%= ong.getEmail() %></td>
                <td><%= ong.getPhone() %></td>
                <td><%= ong.getInstagram() %></td>
                <td>
                    <a href='OngServlet?id=<%= ong.getId() %>&operacao=detalhar'>Detalhar</a>
                    <a href='OngServlet?id=<%= ong.getId() %>&operacao=editar'>Editar</a>
                    <a href='OngServlet?id=<%= ong.getId() %>&operacao=excluir'>Excluir</a>
                </td>
            </tr>

            <% } %>

        </table>

    </body>
</html>
