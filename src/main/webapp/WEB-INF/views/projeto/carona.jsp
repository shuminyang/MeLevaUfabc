<%-- 
    Document   : carona
    Created on : Aug 5, 2016, 3:28:08 PM
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
                <div class="well">
                    <c:set var="teste" value="${usuarioMsg}" />
                    <p id="usuMsg" class="text-center text-danger">${usuarioMsg}</p>
                    <form class="form-group" method="POST" action="criarCarona">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-car fa-fw"></i></span>

                                    <select class="form-control" type="text" name="placa" placeholder="CARRO" id="carroLugaresOption">
                                        <c:forEach var="carro" items="${carroLista}">                                        
                                            <option id="${carro.id}" value="${carro.lugares}" >${carro.placa}</option>                                            
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-hashtag fa-fw"></i></span>
                                    <input class="form-control" name="nLugares" id="carroLugaresLabel" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-arrow-down fa-fw"></i></span>
                                    <input class="form-control" type="text" name="localPartida" placeholder="LOCAL DE PARTIDA"/>
                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-fa fa-fw"></i></span>
                                    <input class="form-control" type="text" name="localChegada" placeholder="LOCAL DE CHEGADA"/>
                                </div>
                            </div>
                        </div>                            
                        <div class="row">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                    <input class="form-control" type="text" name="dataHorario" placeholder="DATA E HORARIO"/>
                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                                    <input class="form-control" type="text" name="horarioChegada" placeholder="HORARIO DE CHEGADA"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-money fa-fw"></i></span>
                                    <input class="form-control" type="text" name="custos" placeholder="CUSTOS" />
                                </div>
                            </div>
                            <div class="col-md-3 col-md-offset-1" >
                                <button class="btn btn-success form-control">Criar carona</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <script src="${pageContext.request.contextPath}/resources/js/caronaJS.js"></script>
    </body>
</html>
