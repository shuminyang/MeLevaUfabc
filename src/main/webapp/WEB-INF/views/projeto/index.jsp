<%-- 
    Document   : index
    Created on : Aug 4, 2016, 1:33:35 AM
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
        <jsp:include page="cabecalho.jsp" />        
        <section>
            <div class="container">
                <h2>Olá ${usuario.login}!</h2>

                <hr class="quebraLinhaIndex"/>

                <c:if test="${not empty motoristaUsuario or not empty passageiroUsuario}">
                    <p class="text-center">Você tem uma carona ativa!</p>
                    <div class="col-md-6">
                        <div class="row">
                            <label>Data:</label>
                            <span>${caronaAtiva.dataHorario}</span>
                        </div>
                        <div class="row">
                            <label>Local de partida</label>
                            <span>${caronaAtiva.localPartida}</span>
                        </div>
                    </div>
                </c:if>
                <%--<c:if test="${empty motoristaUsuario or empty passageiroUsuario}" >--%>
                    <!--<p class="text-center text-muted">Você não possui caronas! Crie ou procure uma!</p>-->
                <%--</c:if>--%>

            </div>
        </section>
    </body>
</html>
