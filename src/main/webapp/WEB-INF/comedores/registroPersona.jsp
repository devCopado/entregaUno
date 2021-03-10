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
        <form action="registroController" method="POST" class="col-lg-6 offset-lg-3">
            <div class="form-row">
                <div class="form-group col-md-6 mb-3 sm-6">
                    <label for="inputnombre">Nombres</label>
                    <input type="text" class="form-control" id="inputnombre" placeholder="Nombres" required>
                </div>
                <div class="col mb-3">
                    <label for="inputApellidos">Apellidos</label>
                    <input type="text" class="form-control" id="inputApellidos" placeholder="Apellidos">
                </div>
            </div>
            <div class="form-group mb-3">
                <label for="inputdireccion">Dirección</label>
                <input type="text" class="form-control" id="inputdireccion" placeholder="avenida 123">
            </div>
            <div class="form-row mb-3">
                <label for="inputTelefono">Teléfono</label>
                <input type="tel" class="form-control" id="inputTelefono" placeholder="3002005050" required>
            </div>
            <div class="form-row mb-3">
                <label for="inputsisben">Número sisben</label>
                <input type="number" class="form-control" id="inputsisben" placeholder="00044" required>
            </div> 
            <div class="form-group row mb-3">
                <div class="col-sm-2 mb-3">Persona en discapacidad</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="CheckDiscapacidad">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
                 <div class="col-sm-2 mb-3">Victima del conflicto</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="Checkconflicto">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
                  <div class="col-sm-2 mb-3">Persona habitante de calle</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="Checkhabitante">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
            </div>
        </form>
        <form action="listarZonas" method = "get" class="col-lg-6 offset-lg-3">
            Seleccione la zona más cercana:&nbsp;
            <select name="Zonas">
                <c:forEach items="${listZonas}" var="zona">
                    <option value="${zona.id}">${zona.nombreZona}</option>
                </c:forEach>
            </select>
        <input type="submit" name="accion" value="vercomedores">
        </form>
        <div class="progress" width="600px">
            <div class="progress-bar" role="progressbar" style="width: 10%;" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">2%</div>
        </div>

    </body>
</html>
