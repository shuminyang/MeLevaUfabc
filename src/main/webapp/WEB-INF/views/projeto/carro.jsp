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
                <div class="well">

                    <c:if test="${empty usuarioCarros}">
                        <h5>Você não possui carros!</h5>                        
                    </c:if>

                    <c:forEach var="carro" items="${usuarioCarros}" >
                        <p class="row">Placa: ${carro.placa}</p>
                        <p class="row">Lugares: ${carro.lugares}</p>
                    </c:forEach>

                </div>
                <button class="btn btn-primary well-sm" id="adicionarRemover">Adicionar carro</button>

                <div class="well projeto-well" id="carroForm" style="display: none;">
                    <form method="POST" action="cadastrarCarro" class="form-group-sm form-inline">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon" style="min-width: 90px;">Placa: </span>
                                    <input class="form-control" type="text" name="placa"/>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <span class="input-group-addon" style="min-width: 90px;">Lugares: </span>
                                    <input class="form-control" type="text" name="lugares"/>
                                </div>
                            </div>
                            <div class="col-md-2 col-md-offset-2" >
                                <button type="submit" class="btn btn-success " >Adicionar</button>
                            </div>
                        </div>
                    </form>


                </div>
            </div>


        </section>

        <script src="${pageContext.request.contextPath}/resources/js/carroJS.js"></script>
    </body>
</html>
