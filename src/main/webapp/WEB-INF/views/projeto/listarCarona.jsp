<%-- 
    Document   : listarCarona
    Created on : Aug 8, 2016, 5:03:52 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeLeva</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" />
        <section>
            <div class="container">

                <c:if test="${not empty mensagemCarona}" >
                    <div class="alert alert-danger">
                        <h5 class="text-center text-danger"><i class="fa-exclamation-circle fa">${mensagemCarona}</i></h5>
                    </div>
                    <hr>
                </c:if>


                <c:forEach var="carona" items="${listaCarona}" >
                    <div class="col-md-6 well-sm well">
                        <div class="row">
                            <label class="col-md-8">Motorista: </label>
                            <span class="col-md-4 text-info">${carona.motorista.idUsuario.infoUsuario.nome}</span>
                        </div>
                        <div class="row">
                            <label class="col-md-8">Local de partida:</label>
                            <span class="col-md-4 text-info" name="localPartida">${carona.localPartida}</span>
                        </div>
                        <div class="row">
                            <label class="col-md-8">Local de chegada:</label>
                            <span class="col-md-4 text-info">${carona.localChegada}</span>
                        </div>
                        <div class="row">
                            <label class="col-md-8">Data de partida:</label>
                            <span class="col-md-4 text-info"><fmt:formatDate type="both" timeStyle="short" value="${carona.dataHorario}" /></span>
                        </div>
                        <div class="row">
                            <label class="col-md-8">Horario de chegada:</label>
                            <span class="col-md-4 text-info"><fmt:formatDate type="both" timeStyle="short" value="${carona.horarioChegada}" /></span>
                        </div>
                        <div class="row">
                            <label class="col-md-8">Custos:</label>
                            <span class="col-md-4 text-info">${carona.custos}</span>                            
                        </div>
                        <div class="row">
                            <label class="col-md-8">Lugares:</label>
                            <span class="col-md-4 text-info">${carona.NLugares}</span>
                        </div>

                        <div class="col-md-8 col-md-offset-8">


                            <!--<button type="submit" class="btn btn-info" ></button>-->
                            <c:if test="${carona.NLugares > 0}" >
                                <form action="caronaTeste" method="POST">
                                    <input type="hidden" id="teste" name="teste" value="${carona.id}" >
                                    <button type="submit" class="btn btn-info">Pega carona!</button>
                                </form>
                            </c:if>
                            <c:if test="${carona.NLugares  <= 0}" >
                                <button type="submit" class="btn btn-info disabled">Sem lugar!</button>
                            </c:if>


                        </div>

                    </div>
                </c:forEach>

            </div>
        </section>
        <!--<script src="${pageContext.request.contextPath}/resources/js/listarCaronaJS.js"></script>-->
    </body>
</html>
