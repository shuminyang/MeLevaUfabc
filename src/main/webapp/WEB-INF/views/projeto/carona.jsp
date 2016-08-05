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
        <jsp:include page="cabecalho.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="well">
                    <c:if test="${empty usuarioMsg}">
                        <p>Possui carro!!</p>
                    </c:if>
                    <form class="form-group">
                        <div class="row" style="margin-bottom: 15px;">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-car fa-fw"></i></span>
                                    <input class="form-control" type="text" name="placa" placeholder="CARRO"/>
                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-hashtag fa-fw"></i></span>
                                    <input class="form-control" type="text" name="lugares" placeholder="LUGARES"/>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 15px;">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-arrow-down fa-fw"></i></span>
                                    <input class="form-control" type="text" name="placa" placeholder="LOCAL DE PARTIDA"/>
                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-fa fa-fw"></i></span>
                                    <input class="form-control" type="text" name="placa" placeholder="LOCAL DE CHEGADA"/>
                                </div>
                            </div>
                        </div>                            
                        <div class="row" style="margin-bottom: 15px;">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-calendar-check-o fa-fw"></i></span>
                                    <input class="form-control" type="text" name="placa" placeholder="DATA E HORARIO"/>
                                </div>
                            </div>
                            <div class="col-md-5 col-md-offset-1">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-clock-o fa-fw"></i></span>
                                    <input class="form-control" type="text" name="placa" placeholder="HORARIO DE CHEGADA"/>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 15px;">
                            <div class="col-md-5">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-money fa-fw"></i></span>
                                    <input class="form-control" type="text" name="" placeholder="CUSTOS" />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
