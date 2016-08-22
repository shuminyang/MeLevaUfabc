<%-- 
    Document   : carro
    Created on : Aug 4, 2016, 4:29:19 PM
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
            <div class="container" id="mostraCarro">
                <div class="well well-sm col-md-7 col-md-offset-3 row" >

                    <c:if test="${empty usuarioCarros}">
                        <h5>Você não possui carros!</h5>                        
                    </c:if>

                    <c:if test="${not empty usuarioCarros}">
                        <h4 class="text-center text-muted">Todos os seus carros estão listados abaixo!</h4>
                        <hr/>
                    </c:if>

                    <c:forEach var="carro" items="${usuarioCarros}" >
                        <div class="col-md-offset-1">
                            <div class="row">
                                <label class="col-md-6" for="placa">Placa:</label>
                                <span class="col-md-5" id="placa">${carro.placa}</span>
                            </div>
                            <div class="row">
                                <label class="col-md-6" for="lugares">Lugares: </label>
                                <span class="col-md-5" id="lugares">${carro.lugares}</span>
                            </div>
                        </div>
                        <hr class="dotted"/>
                    </c:forEach>

                    <button class="btn btn-info" id="adicionarRemover">Adicionar carro</button>
                </div>


                <div class="well well-sm col-md-6 col-md-offset-4 row projeto-well " id="carroForm" style="display: none;">
                    <form method="POST" action="cadastrarCarro" class="form-group-sm form-inline">
                        <div class="row">
                            <div class="col-md-11">
                                <div class="input-group">
                                    <span class="input-group-addon" style="min-width: 90px;">Placa: </span>
                                    <input class="form-control" type="text" name="placa"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-9">
                                <div class="input-group">
                                    <span class="input-group-addon" style="min-width: 90px;">Lugares: </span>
                                    <input class="form-control" type="text" name="lugares"/>
                                </div>
                            </div>
                            <div class="col-md-2 " >
                                <button type="submit" class="btn btn-info" >Adicionar</button>
                            </div>
                        </div>


                    </form>


                </div>
            </div>


        </section>

        <script src="${pageContext.request.contextPath}/resources/js/carroJS.js"></script>
    </body>
</html>
