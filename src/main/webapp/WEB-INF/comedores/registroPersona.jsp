<%-- 
    Document   : registroPersona
    Created on : 8/03/2021, 10:50:21 PM
    Author     : CORE I9 RX 5700XT
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Personas</title>
    </head>
    <body>
        <h1>complete los campos  para el registro de personas</h1>
        <form action="PersonaController" method="post">
            <div class="row">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Nombres">
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Apellidos">
                </div>
            </div>
        </form>
    </body>
</html>
