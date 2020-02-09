<%-- 
    Document   : index
    Created on : 8/02/2020, 01:36:03 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body class="container">
        <form action="ct_validacion_login" method="post">
            <center><h1>BIENVENIDOS</h1></center>
                <div class="form-group">
                    <label for="exampleInputEmail1">USUARIO</label>
                    <input type="text" class="form-control" id="user" name="user" placeholder="Usuario" required="true">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">CONTRASEÑA</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña" required="true">
                </div>
                <br>
                <center>
                <button type="submit" class="btn btn-primary">INGRESAR</button>
                <a href="createUser.jsp" class="btn btn-secondary">REGISTRARSE</a>
                </center>
        </form>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
    </body>  
</html>
