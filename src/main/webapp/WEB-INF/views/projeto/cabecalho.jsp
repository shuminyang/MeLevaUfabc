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
    </head>
    <body>
        <header class="navbar navbar-default navbar-static-top" >
            <nav class="container">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand"><i class="fa fa-car">  MeLeva</i></a>
                </div>
                <ul class="nav navbar-nav navbar-right" >
                    <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/carros">Carros</a></li>
                    <li><a href="${pageContext.request.contextPath}/carona">Carona</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </nav>
        </header>        
    </body>
</html>