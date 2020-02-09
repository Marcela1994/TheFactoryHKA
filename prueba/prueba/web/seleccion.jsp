<%-- 
    Document   : seleccion
    Created on : 8/02/2020, 02:59:14 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selección</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body class="container">
        <br>
        <br>
        <center>
            <h1>¿Que operación desea realizar?</h1>
        </center>
        <br>
        <hr>
        <br>
        <br>
        <br>
        <div class="card-deck">
            <div class="card">
                <form action="prov_categ.jsp">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Administracón de Elementos Básicos</h5>
                            <p class="card-text">Proveedor y Categoria</p>
                            <button type="submit" class="btn btn-primary">INGRESAR</button>
                        </center>
                    </div>
                </form>
            </div>
            <div class="card">
                <form action="">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Administración de Productos</h5>
                            <p class="card-text">Productos</p>
                            <a href="ct_productos" class="btn btn-secondary">INGRESAR</a>
                        </center>
                    </div>
                </form>
            </div>
            <div class="card">
                    <div class="card-body">
                        <center>
                            <h5 class="card-title">Facturación de Orden</h5>
                            <p class="card-text">Facturación</p>
                            <a href="publicacion_adopciones.jsp" class="btn btn-primary">INGRESAR</a>
                        </center>
                    </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> 
    </body>
</html>
