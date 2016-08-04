<%-- 
    Document   : cadastro
    Created on : Aug 3, 2016, 3:05:58 PM
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
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <section>
            <div class="container">
                <form class="text-left col-md-offset-4" >
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-user-plus fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="nome" placeholder="Nome" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon"><i class="fa fa-home fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="endereco" placeholder="Endereço" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-credit-card-alt"></i></span>
                            <input type="text" class="form-control" id="login" name="cpf" placeholder="CPF" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-envelope fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="email" placeholder="Email" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-birthday-cake fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="dataNascimento" placeholder="Data Nascimento" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-user fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="login" placeholder="Login" />
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-md-6 input-group">
                            <span class="input-group-addon cadastro-addon"><i class="fa fa-key fa-fw"></i></span>
                            <input type="text" class="form-control" id="login" name="senha" placeholder="Senha" />
                        </div>
                    </div>
                    <div class="row">
                        <button type="submit" class="btn btn-info btn-sm"><i class="fa fa-sign-in fa-2x"></i></button>
                    </div>
                </form>
            </div>
        </section>        
    </body>
</html>
