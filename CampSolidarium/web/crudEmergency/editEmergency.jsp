<%-- 
    Document   : editEmergency
    Created on : Nov 13, 2023, 11:57:03 PM
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
        <h1>Editar Emergencia</h1>
    <form action="EmergencyServlet" method="post">
        <input type="hidden" name="id" value="${emergency.id}" />
        local: <input type="text" name="local" value="${emergency.local}" /><br>
        tipo: <input type="text" name="description" value="${emergency.type}" /><br>
        descrição <input type="text" name="categoria" value="${emergency.description}" /><br>
        seriedade: <input type="text" name="severityLevel" value="${emergency.severityLevel}" /><br>
        <input type="submit" value="Salvar">
    </form>
    <a href="EmergencyServlet">Cancelar</a>
    </body>
</html>
