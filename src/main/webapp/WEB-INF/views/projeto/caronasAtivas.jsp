<%-- 
    Document   : caronasAtivas
    Created on : Aug 21, 2016, 9:38:29 PM
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
                <div class="well well-sm">
                    <c:if test="${not empty passageiroAtualizado}">
                        <div class="row">
                            <div class="alert alert-info col-md-offset-1">
                                <span><i class="fa-exclamation-circle fa">  ${passageiroAtualizado}</i></span>
                            </div>
                        </div>
                    </c:if>

                    <h4 class="text-muted text-center">Suas caronas como passageiro.</h4>
                    <c:forEach var="passageiro" items="${listaPassageiro}" >
                        <div class="col-md-offset-1">
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Motorista:</label>
                                    <span class="text-info">${passageiro.idCarona.idMotorista.idUsuario.infoUsuario.nome}</span>
                                </div>
                                <div class="col-md-5 col-md-offset-1">
                                    <label>Data:</label>
                                    <span class="text-info"><fmt:formatDate type="both" timeStyle="short" value="${passageiro.idCarona.dataHorario}" /></span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <label>Local de partida:</label>
                                    <span class="text-info">${passageiro.idCarona.localPartida}</span>
                                </div>
                                <div class="col-md-5 col-md-offset-1">
                                    <label>Local de chegada:</label>
                                    <span class="text-info">${passageiro.idCarona.localChegada}</span>
                                </div>
                            </div>
                            <div class="row">
                                <c:if test="${passageiro.ativo}">
                                    <div class="col-md-5">
                                        <form action="passageiroAtualizar" method="POST">
                                            <input type="hidden" value="${passageiro.id}" name="idPass" />
                                            <button class="btn btn-info">Cheguei no destino!</button>
                                        </form>
                                    </div>
                                </c:if>
                                <c:if test="${not passageiro.ativo}">
                                    <div class="col-md-5">
                                        <button class="btn btn-info disabled">Carona realizada!</button>
                                    </div>

                                </c:if>
                            </div>
                        </div>
                        <hr class="dotted" />
                    </c:forEach>

                    <hr class="quebraLinhaCarona" />
                    <h4 class="text-muted text-center">Suas caronas como motorista.</h4>

                    <c:forEach var="motorista" items="${listaMostorista}">

                    </c:forEach>

                </div>
            </div>            
        </section>

    </body>
</html>
