<%-- 
    Document   : login
    Created on : Aug 3, 2016, 2:35:57 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form class="text-left col-md-offset-4" action="login" method="POST">
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="login" placeholder="LOGIN" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span for="senha" class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
                            <input type="text" class="form-control" id="senha" name="senha" placeholder="SENHA" />
                        </div>                        
                    </div>
                    <div class="row">                        
                        <div class="col-md-5">
                            <span>Esqueceu a senha?! <a href="#">Clique aqui!</a></span>
                            <span>Novo usuário? <a href="${pageContext.request.contextPath}/cadastro">Crie uma nova conta!</a></span>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-info btn-sm"><i class="fa fa-sign-in fa-2x"></i></button>
                        </div>
                    </div>
                </form>                
            </div>
        </section>

    </body>
</html>
