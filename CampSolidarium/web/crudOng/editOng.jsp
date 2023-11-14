<%-- 
    Document   : editOng
    Created on : Nov 13, 2023, 10:15:59 PM
    Author     : adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Ong</h1>
    <form action="OngServlet" method="post">
        <input type="hidden" name="id" value="${ong.id}" />
        cnpj: <input type="text" name="cnpj" value="${ong.cnpj}" /><br>
        nome: <input type="text" name="name" value="${ong.name}" /><br>
        login: <input type="text" name="login" value="${ong.login}" /><br>
        senha: <input type="text" name="password" value="${ong.password}" /><br>
        email: <input type="text" name="email" value="${ong.email}" /><br>
        telefone: <input type="text" name="phone" value="${ong.phone}" /><br>
        instagram: <input type="text" name="instagram" value="${ong.instagram}" /><br>
        <input type="submit" value="Salvar">
    </form>
    <a href="OngServlet">Cancelar</a>
    </body>
</html>
