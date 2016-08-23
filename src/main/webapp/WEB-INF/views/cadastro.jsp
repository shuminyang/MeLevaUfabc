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
                    <div class="well well-sm col-md-7 col-md-offset-3">
                        <h3 class="text-center text-muted">Cadastro</h3>
                        <hr class="dotted" />
                        <form class="text-left col-md-offset-1" method="POST" action="cadastraUsuario" >
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-user-plus fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="nome" placeholder="NOME" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon"><i class="fa fa-home fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="endereco" placeholder="ENDEREÇO" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-credit-card-alt"></i></span>
                                    <input type="text" class="form-control" id="login" name="cpf" placeholder="CPF(EX:nnn.nnn.nnn-nn)"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-envelope fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="email" placeholder="EMAIL" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-birthday-cake fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="dataNascimento" placeholder="DATA DE NASCIMENTO" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-user fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="login" placeholder="LOGIN" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10 input-group">
                                    <span class="input-group-addon cadastro-addon"><i class="fa fa-key fa-fw"></i></span>
                                    <input type="text" class="form-control" id="login" name="senha" placeholder="SENHA" />
                                </div>
                            </div>
                            <div class="row">
                                <button type="submit" class="btn btn-info col-md-offset-8"><i class="fa fa-plus-circle fa-2x fa-fw"></i></button>
                            </div>
                        </form>
                    </div>
                </div>
                <script src="${pageContext.request.contextPath}/resources/js/cadastroJS.js"></script>
        </section>
    </body>
</html>
