<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de comedores Comunitarios</title>
    </head>
    <body>
    <body>
        <div class="card text-center">
            <div class="card-header">
                Sistema de comedores Comunitarios
            </div>
            <div class="card-body">
                <h5 class="card-title">Por favor seleccione la acción a realizar</h5>
                <form action="PersonaController" method="GET">
                    <input class="btn btn-primary" type="submit" name="accion" value="ver personas por comedor">
                    <input class="btn btn-primary" type="submit" name="accion" value="Registrar">
                 </form>
            </div>
            <div class="card-footer text-muted">
                ucentral app
            </div>
        </div>
    </body>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</html>
