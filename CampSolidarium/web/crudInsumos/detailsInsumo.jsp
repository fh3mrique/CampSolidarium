<%-- 
    Document   : detailsInsumo
    Created on : Nov 12, 2023, 8:35:27 PM
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
        <li><strong>ID:</strong> ${insumo.id}</li>
        <li><strong>Nome:</strong> ${insumo.name}</li>
        <li><strong>Marca:</strong> ${insumo.brand}</li>
        <li><strong>Categoria:</strong> ${insumo.category}</li>
        <li><strong>Quantidade:</strong> ${insumo.qtd}</li>
    </ul>
    <a href="InsumoServlet">Voltar para a Lista de Insumos</a>
    </body>
</html>
