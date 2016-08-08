<%-- 
    Document   : cabecalho
    Created on : Aug 3, 2016, 2:34:44 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MeLeva</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/projeto.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" type="text/css">
        <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/cabecalhoJS.js"></script>
    </head>
    <body>
        <header class="navbar navbar-default navbar-static-top" >
            <nav class="container">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/projeto/index" class="navbar-brand"><i class="fa fa-car">  MeLeva</i></a>
                </div>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="${pageContext.request.contextPath}/projeto/profile">Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/projeto/carros">Carros</a></li>                    
                    <li class="dropdown"><a href="#" class="dropdown-toggle" >Carona<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/projeto/carona">Criar</a></li>
                            <li><a href="${pageContext.request.contextPath}/projeto/listarCarona">Pesquisar</a></li>
                        </ul>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/projeto/logout">Logout</a></li>
                </ul>
            </nav>
        </header>        
    </body>
</html>
