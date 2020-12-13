<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg  bg-info  bg-dark">           
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item" text='white'>
                        <a>
                            <img src="img/logo.gif" alt=""/>
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                    </li>
                    <li  class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                    </li>
                  
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Ventas</a>
                    </li>
                
                </ul>                
            </div>
            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light" type="button" >
                  
                     <a style="margin-left: 10px; border: none" class="btn btn-outline-light"  href="Controlador?menu=Info" target="myFrame">Acerca de:</a>
                    
                    
                </button>
                
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNombres()}
                </button>
                <div class="dropdown-menu text-center">

                    <a class="dropdown-item" href="#">
                        <img src="img/usuario_s.png" alt="50" width="50"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <a class="dropdown-item" href="#">${usuario.getCorreoelectronico()}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Validar?accion=Salir">Cerrar sesion</a>
                </div>
            </div>
        </nav>
        <div class="embed-responsives m-4" style="height: 530px;">
             <iframe class="embed-responsive-item" name="myFrame"  style="height: 100%; width: 100%; border:navy"></iframe>
        </div>   
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
