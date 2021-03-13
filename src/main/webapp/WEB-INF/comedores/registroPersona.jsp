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
        
        <form action="PersonaController" method="post" class="col-lg-6 offset-lg-3">
            
             Seleccione la zona más cercana:&nbsp;
                <select class="form-control" id="selectedZona" name="Zonavalue">
                    <option>Seleccione la zona</option> 
                    <c:forEach items="${listZonas}" var="zona">
                        <option value="${zona.id}"> ${zona.nombreZona}</option>
                    </c:forEach>
                    <input type="hidden" class="form-control" id="selectedZona" name="selectedZona" value="" />
                </select> 
            
            <input type="hidden" name="id" value="${persona.id}"/>
            <div class="form-row">
                <div class="form-group col-md-6 mb-3 sm-6">
                    <label for="inputnombre">Nombres</label>
                    <input type="text" class="form-control" id="inputnombre" name="inputnombre" placeholder="Nombres" value="${persona.nombre}">
                </div>
                <div class="col mb-3">
                    <label for="inputApellidos">Apellidos</label>
                    <input type="text" class="form-control" id="inputApellidos" name="inputApellidos" placeholder="Apellidos" value="${persona.apellido}">
                </div>
                <div class="col mb-3">
                    <label for="inputCedula">Cedula</label>
                    <input type="number" class="form-control" id="inputCedula" name="inputCedula" value="${persona.cedula}">
                </div>
            </div>
            <div class="form-group mb-3">
                <label for="inputdireccion">Dirección</label>
                <input type="text" class="form-control" id="inputdireccion" name="inputdireccion" placeholder="avenida 123" value="${persona.direccion}">
            </div>
            <div class="form-row mb-3">
                <label for="inputTelefono">Teléfono</label>
                <input type="tel" class="form-control" id="inputTelefono" name="inputTelefono" placeholder="3002005050"  value="${persona.movil}">
            </div>
            <div class="form-row mb-3">
                <label for="inputsisben">Número sisben</label>
                <input type="number" class="form-control" id="inputsisben" name="inputsisben" placeholder="00044" value="${persona.numeroSisben}">
            </div> 
            <div class="form-group row mb-3">
                <div class="col-sm-2 mb-3">Persona en discapacidad</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="CheckDiscapacidad" name="CheckDiscapacidad" value="${persona.personaEnDiscapacidad}">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
                <div class="col-sm-2 mb-3">Victima del conflicto</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="Checkconflicto" name="Checkconflicto" value="${persona.victimaConflicto}">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
                <div class="col-sm-2 mb-3">Persona habitante de calle</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="Checkhabitante"  name="Checkhabitante" value="${persona.habitanteDeCalle}">
                        <label class="form-check-label" for="gridCheck1">
                        </label>
                    </div>
                </div>
            </div>
            <button type="submit"  class="btn btn-primary" value="persistirPersona" name="accion">Crear Persona</button>
        </form>

        <div>${mensaje}</div>







        <div class="progress" width="600px">
            <div class="progress-bar" role="progressbar" style="width: 10%;" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">2%</div>
        </div>

    </body>
</html>
