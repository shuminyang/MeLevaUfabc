<%-- 
    Document   : listarCarona
    Created on : Aug 8, 2016, 5:03:52 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeLeva</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
            <section>
                <div class="container">

                <c:forEach var="carona" items="${listaCarona}" >
                    <a href="#" class="caronaLink">
                        <div class="col-md-4 well-sm well">                        
                            <div class="row">
                                <i class="col-md-6 fa fa-user fa-fw well-sm well">${carona.idMotorista.idUsuario.infoUsuario.nome}</i>
                            </div>
                            <div class="row">
                                <label for="localPartida" class="col-md-8">Local de partida:</label>
                                <span id="localPartida" class="col-md-4 text-info">${carona.localPartida}</span>
                            </div>
                            <div class="row">
                                <label for="localChegada" class="col-md-8">Local de chegada:</label>
                                <span id="localChegada" class="col-md-4 text-info">${carona.localChegada}</span>
                            </div>
                            <div class="row">
                                <label for="dataHorario" class="col-md-8">Data de partida:</label>
                                <span id="dataHorario" class="col-md-4 text-info">${carona.dataHorario}</span>
                            </div>
                            <div class="row">
                                <label for="horarioChegada" class="col-md-8">Horario de chegada:</label>
                                <span id="horarioChegada" class="col-md-4 text-info">${carona.horarioChegada}</span>
                            </div>
                            <div class="row">
                                <label for="custos" class="col-md-8">Custos:</label>
                                <span id="custos" class="col-md-4 text-info">${carona.custos}</span>                            
                            </div>
                            <div class="row">
                                <label id="lugares" class="col-md-8">Lugares:</label>
                                <span id="lugares" class="col-md-4 text-info">${carona.NLugares}</span>
                            </div>
                        </div>
                    </a>
                </c:forEach>

            </div>
        </section>
        <script src="${pageContext.request.contextPath}/resources/js/listarCaronaJS.js"></script>
    </body>
</html>
