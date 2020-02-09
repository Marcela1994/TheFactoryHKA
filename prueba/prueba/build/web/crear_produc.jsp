<%-- 
    Document   : crear_produc
    Created on : 8/02/2020, 09:36:00 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Producto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body class="container">
        <form action="ct_crear_produc" method="post">
            <center><h1>CREAR NUEVO PRODUCTO</h1></center>
            <div class="form-group">
                <label>NOMBRE DEL PRODUCTO</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Nombre del Producto" required="true">
            </div>
            <div class="form-group">
                <label>DESCRIPCIÓN</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Descripción del producto" required="true">
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">CATEGORIA</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">USUARIO</label>
                <input type="text" class="form-control" id="user" name="user" placeholder="Usuario" required="true">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">CONTRASEÑA</label>
                <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña" required="true">
            </div>
            <center><button type="submit" class="btn btn-primary">CREAR USUARIO</button></center>
        </form>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
    </body>
</html>
