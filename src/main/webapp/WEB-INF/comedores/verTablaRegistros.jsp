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
        <title>Ver Registros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
         
        <main role="main">
            <div class ="container">
                <div class="alert alert-success" role="alert">
                   
                </div>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-header"><strong>listado de comedores por persona</strong></h4>
                    </div>
                    <br>
                   
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <th>Zona</th>
                            <th>Comedor</th>
                            <th>Hora Inicio</th>
                            <th>Hora Fin</th>
                            <th>Capacidad comedor</th>
                            <th>nombre persona</th>
                            <th>apellido persona</th>
                            <th>cedula</th>
                            <th>numero sisben</th>
                            <th>habitante de calle</th>
                            <th>persona en discapacidad</th>
                            <th>victima de conflicto</th>
                            
                        </thead>
                        <tbody>
                             <c:forEach items="${registros}" var="registro">
                                <tr>
                                    
                                    <td><c:out value="${registro.comedor.zona.nombreZona}"></c:out></td>
                                    <td><c:out value="${registro.comedor.nombre_Comedor}"></c:out></td>
                                    <td><c:out value="${registro.comedor.hora_inicio}"></c:out></td>
                                    <td><c:out value="${registro.comedor.hora_fin}"></c:out></td>
                                    <td><c:out value="${registro.comedor.capacidad_comedor}"></c:out></td>
                                    <td><c:out value="${registro.persona.nombre}"></c:out></td>
                                    <td><c:out value="${registro.persona.apellido}"></c:out></td>
                                    <td><c:out value="${registro.persona.cedula}"></c:out></td>
                                    <td><c:out value="${registro.persona.numeroSisben}"></c:out></td>
                                    <td><c:out value="${registro.persona.habitanteDeCalle}"></c:out></td>
                                    <td><c:out value="${registro.persona.personaEnDiscapacidad}"></c:out></td>
                                    <td><c:out value="${registro.persona.victimaConflicto}"></c:out></td>
                                    <td>  
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
