<%-- 
    Document   : emergencyList
    Created on : Nov 13, 2023, 11:58:04 PM
    Author     : adm
--%>

<%@page import="br.com.filipeatividade.entities.Emergency"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Emergencias</h1>
        <a href='index.html'>Voltar</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>local</th>
                <th>tipo</th>
                <th>descrição</th>
                <th>seriedade</th>
                <th>Ações</th>
            </tr>

            <%
             
                List<Emergency> emergencies = (List<Emergency>) request.getAttribute("emergencies");

                for (Emergency emergencia : emergencies) {
            %>

            <tr>
                <td><%= emergencia.getId() %></td>
                <td><%= emergencia.getLocal() %></td>
                <td><%= emergencia.getType() %></td>
                <td><%= emergencia.getDescription() %></td>
                <td><%= emergencia.getSeverityLevel() %></td>
                <td>
                    <a href='EmergencyServlet?id=<%= emergencia.getId() %>&operacao=detalhar'>Detalhar</a>
                    <a href='EmergencyServlet?id=<%= emergencia.getId() %>&operacao=editar'>Editar</a>
                    <a href='EmergencyServlet?id=<%= emergencia.getId() %>&operacao=excluir'>Excluir</a>
                </td>
            </tr>

            <% } %>

        </table>

    </body>
</html>
