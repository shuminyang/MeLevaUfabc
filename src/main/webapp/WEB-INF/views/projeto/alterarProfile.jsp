<%-- 
    Document   : alterarProfile
    Created on : Aug 16, 2016, 4:04:47 PM
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
        <jsp:include page="cabecalho.jsp" />
        <section>
            <div class="container">
                <form action="updateProfile" method="POST" class="col-md-offset-4">
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-user fa-fw"></i></span>
                            <input type="text" class="form-control" id="nome" name="nome" value="${usuarioInfo.nome}"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-home fa-fw"></i></span>
                            <input type="text" class="form-control" id="endereco" name="endereco" value="${usuarioInfo.endereco}"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-credit-card-alt fa-fw"></i></span>
                            <input type="text" class="form-control" id="cpf" name="cpf" value="${usuarioInfo.cpf}"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-envelope fa-fw"></i></span>
                            <input type="text" class="form-control" id="email" name="email" value="${usuarioInfo.email}"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-birthday-cake fa-fw"></i></span>
                            <input type="text" class="form-control" id="dataNascimento" name="dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usuarioInfo.dataInclusao}" />"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-key fa-fw"></i></span>
                            <input type="text" class="form-control" id="senha" name="senha" value="${usuario.senha}"/>
                        </div>
                    </div>
                    <button class="btn btn-info btn-sm col-md-2 col-md-offset-4" type="submit">Alterar!</button>
                </form>
            </div>
        </section>
    </body>
</html>
