<%-- 
    Document   : vercomedores
    Created on : 10/03/2021, 10:43:32 PM
    Author     : CORE I9 RX 5700XT
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de comedores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
         
        <main role="main">
            <div class ="container">
                <div class="alert alert-success" role="alert">
                    ${mensaje}
                   
                </div>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-header"><strong>listado de Comedores de acuerdo a su Zona</strong></h4>
                    </div>
                    <br>
                   
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <th>Zona</th>
                            <th>Comedor</th>
                            <th>Hora Inicio</th>
                            <th>Hora Fin</th>
                            <th>Capacidad comedor</th>
                            <th>cupo(s) disponible(s)</th>
                            <!--<th>porcentaje ocupación</th>-->
                        </thead>
                        <tbody>
                             <c:forEach items="${comedores}" var="comedor">
                                <tr>
                                    
                                    <td><c:out value="${comedor.zona.nombreZona}"></c:out></td>
                                    <td><c:out value="${comedor.nombre_Comedor}"></c:out></td>
                                    <td><c:out value="${comedor.hora_inicio}"></c:out></td>
                                    <td><c:out value="${comedor.hora_fin}"></c:out></td>
                                    <td><c:out value="${comedor.capacidad_comedor}"></c:out></td>
                                    <td><c:out value="${comedor.cupo_disponible}"></c:out></td>
                                    <!--<td><c:out value="${comedor.porcentajeOcupacion}"></c:out></td>-->
                                    <td>
                                        <form action="ComedorController" method="post">
                                            <input type="hidden" name="idComedor" value="${comedor.id}">
                                            <input type="hidden" name="personaRecord" value="${personaRecord}">
                                            <input type="hidden" name="comedores" value="${comedores}">
                                            <input type="submit" name="accion" value="Seleccionar" class="btn btn-success">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>
