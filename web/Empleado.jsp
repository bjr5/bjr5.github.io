<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>        
        <div class="d-flex">
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Empleado" method="POST">
                            <div class="form-group">
                                <label>Ci</label>
                                <input type="text" value="${empleado.getCi()}" name="txtCi" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" value="${empleado.getNombres()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Apellidos</label>
                                <input type="text" value="${empleado.getApellidos()}" name="txtApellidos" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Telefono</label>
                                <input type="text" value="${empleado.getTelefono()}" name="txtTelefono" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Usuario</label>
                                <input type="text" value="${empleado.getUsuario()}" name="txtUsuario" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Correo electronico</label>
                                <input type="text" value="${empleado.getCorreoelectronico()}" name="txtCorreoElectronico" class="form-control">
                            </div>
                            
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-9">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>CI</th>
                                    <th>NOMBRES</th>
                                    <th>APELLIDOS</th>                                                                    
                                    <th>TELEFONO</th>
                                    <th>USUARIO</th>  
                                    <th>CORREO ELECTRONICO</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="em" items="${empleados}">
                                    <tr>
                                        <td>${em.getId()}</td>
                                        <td>${em.getCi()}</td>
                                        <td>${em.getNombres()}</td>
                                        <td>${em.getApellidos()}</td>
                                        <td>${em.getTelefono()}</td>
                                        <td>${em.getUsuario()}</td>
                                        <td>${em.getCorreoelectronico()}</td>                                       
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Edit&id=${em.getId()}">Editar</a><br>
                                            <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>          
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
