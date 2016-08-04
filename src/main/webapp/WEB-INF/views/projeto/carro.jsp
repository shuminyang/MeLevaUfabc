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
        <jsp:include page="cabecalho.jsp"></jsp:include>
            <section>
                <div class="container" id="mostraCarro">
                    <div class="well">

                    <c:if test="${empty usuarioCarros}">
                        <p>Você não possui carros!</p>                        
                    </c:if>

                    <c:forEach var="carro" items="${usuarioCarros}" >
                        <p>Placa: ${carro.placa}</p>
                        <p>Lugares: ${carro.lugares}</p>
                    </c:forEach>

                </div>
                <button href="${pageContext.request.contextPath}/projeto/criarCarro" class="btn btn-primary well-sm" id="adicionarRemover">Adicionar carro</button>

                <div class="well" id="carroForm" style="display: none;">
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

        <script src="${pageContext.request.contextPath}/resources/js/CarroJS.js"></script>
    </body>
</html>
