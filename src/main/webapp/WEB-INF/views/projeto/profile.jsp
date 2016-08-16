<%-- 
    Document   : profile
    Created on : Aug 4, 2016, 3:49:43 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeLeva</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>

            <section>
                <div class="container" >
                    <div class="well">

                        <p class="h2">Olá ${usuario.login}! Abaixo suas informações</p>

                    <div class="row">
                        <label class="col-md-4" for="nome" >Nome:</label>
                        <span id="nome" class="col-md-4 col-md-offset-2 text-info" >${usuarioInfo.nome}</span>
                    </div>      

                    <div class="row">
                        <label class="col-md-4" for="endereco" >Endereco:</label>
                        <span id="endereco" class="col-md-4 col-md-offset-2 text-info" >${usuarioInfo.endereco}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-4" for="cpf" >CPF:</label>
                        <span id="cpf" class="col-md-4 col-md-offset-2 text-info" >${usuarioInfo.cpf}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-4" for="email" >Email:</label>
                        <span id="email" class="col-md-4 col-md-offset-2 text-info" >${usuarioInfo.email}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-4" for="dataNascimento" >Data nascimento:</label>
                        <span id="dataNascimento" class="col-md-4 col-md-offset-2 text-info" ><fmt:formatDate pattern="dd/MM/yyyy" value="${usuarioInfo.dataNascimento}" /></span>
                    </div>

                    <div class="row">
                        <label class="col-md-4" for="dataInclusao" >Data inclusão:</label>
                        <span id="dataInclusao" class="col-md-4 col-md-offset-2 text-info" ><fmt:formatDate pattern="dd/MM/yyyy" value="${usuarioInfo.dataInclusao}" /></span>
                    </div>

                </div>
                <a class="btn btn-info btn-group-sm row col-md-offset-10" href="alterarProfile">Atualizar informação</a>
            </div>
        </section>
        <!--<script src="${pageContext.request.contextPath}/resources/js/profileJS.js"></script>-->
    </body>
</html>
