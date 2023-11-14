<%-- 
    Document   : detailsEmergency
    Created on : Nov 13, 2023, 11:56:43 PM
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
         <h1>Detalhes da Emergencia</h1>
    <ul>
        <li><strong>ID:</strong> ${emergency.id}</li>
        <li><strong>local:</strong> ${emergency.local}</li>
        <li><strong>tipo:</strong> ${emergency.type}</li>
        <li><strong>descrição:</strong> ${emergency.description}</li>
        <li><strong>seriedade</strong> ${emergency.severityLevel}</li>
    </ul>
    <a href="EmergencyServlet">Voltar para a Lista de Emergencias</a>
    </body>
</html>
