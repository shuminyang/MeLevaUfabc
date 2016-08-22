<%-- 
    Document   : cabecalho
    Created on : Aug 3, 2016, 2:34:44 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MeLeva UFABC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/projeto.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" type="text/css">
        <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.js"></script>
    </head>
    <body>
        <header class="navbar navbar-default navbar-static-top" >
            <nav class="container">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/login" class="navbar-brand"><i class="fa fa-car">  MeLeva</i></a>
                </div>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/cadastro">Cadastro</a></li>
                    <li><a href="#">Sobre</a></li>
                </ul>
            </nav>
        </header>        
    </body>
</html>
