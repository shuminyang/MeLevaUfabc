<%-- 
    Document   : index
    Created on : Aug 4, 2016, 1:33:35 AM
    Author     : shu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"></jsp:include>
        <section>
            <div class="container">
                <h1>Hello ${usuario}!</h1>
            </div>
        </section>        
    </body>
</html>
