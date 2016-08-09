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
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Local de Partida</th>
                                <th>Local de Chegada</th>
                                <th>Data e horário</th>
                                <th>Horário de chegada</th>
                                <th>Custos</th>
                                <th>Lugares</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="carona" items="${listaCarona}">
                            <tr class="clickable">
                                <td>${carona.localPartida}</td>
                                <td>${carona.localChegada}</td>
                                <td>${carona.dataHorario}</td>
                                <td>${carona.horarioChegada}</td>
                                <td>${carona.custos}</td>
                                <td>${carona.NLugares}</td>

                            </tr>
                            <tr>
                                <td id="qweteste" style="display: none;"><strong>usuarios:</strong></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <script src="${pageContext.request.contextPath}/resources/js/listarCaronaJS.js"></script>
    </body>
</html>
