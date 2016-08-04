<%-- 
    Document   : profile
    Created on : Aug 4, 2016, 3:49:43 PM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <div class="row">
                            <label class="col-md-6" for="usuarioNome" >Nome:</label>
                            <span id="usuarioNome" class="col-md-6" >${usuarioInfo.nome}</span>
                    </div>      

                    <div class="row">
                        <label class="col-md-6" for="usuarioEnd" >Endereco:</label>
                        <span id="usuarioEnd" class="col-md-6" >${usuarioInfo.endereco}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-6" for="usuarioCpf" >CPF:</label>
                        <span id="usuarioCpf" class="col-md-6" >${usuarioInfo.cpf}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-6" for="usuarioEmail" >Email:</label>
                        <span id="usuarioEmail" class="col-md-6" >${usuarioInfo.email}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-6" for="usuarioNasc" >Data nascimento:</label>
                        <span id="usuarioNasc" class="col-md-6" >${usuarioInfo.dataNascimento}</span>
                    </div>

                    <div class="row">
                        <label class="col-md-6" for="usuarioIncl" >Data inclusão:</label>
                        <span id="usuarioIncl" class="col-md-6" >${usuarioInfo.dataInclusao}</span>
                    </div>

                </div>
            </div>
        </section>

    </body>
</html>
