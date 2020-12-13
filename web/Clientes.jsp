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
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Cliente" method="POST">
                            <div class="form-group">
                                <label>Ci</label>
                                <input type="text" value="${cliente.getCi()}" name="txtCi1" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" value="${cliente.getNombres()}" name="txtNombres1" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Apellidos</label>
                                <input type="text" value="${cliente.getApellidos()}" name="txtApellidos1" class="form-control">
                            </div>
                                                
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>                         
                </div>
            </div>                     
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover table-responsive">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>CI</th>
                                    <th>NOMBRES</th>
                                    <th>APELLIDOS</th>
                                   
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="cl" items="${clientes}">
                                    <tr>
                                        <td>${cl.getId()}</td>
                                        <td>${cl.getCi()}</td>
                                        <td>${cl.getNombres()}</td>
                                        <td>${cl.getApellidos()}</td>                                       
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Edit&id=${cl.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cl.getId()}">Eliminar</a>
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
