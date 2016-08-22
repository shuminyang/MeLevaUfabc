<%-- 
    Document   : login
    Created on : Aug 3, 2016, 2:35:57 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MeLeva UFABC</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" ></jsp:include>
            <section>
                <div class="container">
                    <div class="well well-sm col-md-7 col-md-offset-3">

                        <h3 class="text-center text-muted">Login</h3>
                        <hr class="dotted" />

                    <c:if test="${not empty loginMsg}" >
                        <div class="row">
                            <div class="alert alert-danger col-md-10 col-md-offset-1">
                                <span><i class="fa-exclamation-circle fa">  ${loginMsg}</i></span>
                            </div>
                        </div>
                    </c:if>
                    <form action="login" method="POST">
                        <div class="row form-group">
                            <div class="col-md-10 input-group col-md-offset-1">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                                <input type="text" class="form-control" id="login" name="login" placeholder="LOGIN" />
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-10 input-group col-md-offset-1">
                                <span for="senha" class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                                <input type="password" class="form-control" id="senha" name="senha" placeholder="SENHA" />
                            </div>                        
                        </div>
                        <div class="row form-group">
                            <div class="col-md-7 col-md-offset-1" >
                                <span style="display: block;">Esqueceu a senha?! <a href="#">Clique aqui!</a></span>
                                <span style="display: block;">Novo usuário? <a href="${pageContext.request.contextPath}/cadastro">Nova conta!</a></span>
                            </div>
                            <div class="col-md-2 col-md-offset-1">
                                <button type="submit" class="btn btn-info btn-sm"><i class="fa fa-sign-in fa-2x"></i></button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </section>        
    </body>
</html>
