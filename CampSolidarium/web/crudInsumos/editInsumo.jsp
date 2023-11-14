<%-- 
    Document   : editInsumo
    Created on : Nov 12, 2023, 8:34:59 PM
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
        <h1>Editar Insumo</h1>
    <form action="InsumoServlet" method="post">
        <input type="hidden" name="codigo" value="${insumo.id}" />
        Nome: <input type="text" name="nome" value="${insumo.name}" /><br>
        Marca: <input type="text" name="marca" value="${insumo.brand}" /><br>
        Categoria: <input type="text" name="categoria" value="${insumo.category}" /><br>
        Quantidade: <input type="text" name="quantidade" value="${insumo.qtd}" /><br>
        <input type="submit" value="Salvar">
    </form>
    <a href="InsumoServlet">Cancelar</a>

    </body>
</html>
