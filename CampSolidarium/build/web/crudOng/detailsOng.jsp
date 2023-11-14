<%-- 
    Document   : detailsOng
    Created on : Nov 13, 2023, 10:15:17 PM
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
        <h1>Detalhes do Insumo</h1>
    <ul>
        <li><strong>ID:</strong> ${ong.id}</li>
        <li><strong>cnpj:</strong> ${ong.cnpj}</li>
        <li><strong>nome:</strong> ${ong.name}</li>
        <li><strong>login:</strong> ${ong.login}</li>
        <li><strong>email:</strong> ${ong.email}</li>
        <li><strong>phone:</strong> ${ong.phone}</li>
        <li><strong>instagram:</strong> ${ong.instagram}</li>
    </ul>
    <a href="OngServlet">Voltar para a Lista de Ongs</a>
    </body>
</html>
