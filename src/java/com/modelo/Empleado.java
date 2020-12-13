
package com.modelo;

public class Empleado {
    int id;
    String ci;
    String nombres;
    String apellidos;
    String telefono;
    String usuario;
    String correoelectronico;

    public Empleado() {
    }

    public Empleado(int id, String ci, String nombres, String apellidos, String telefono, String usuario,String correoelectronico) {
        this.id = id;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.usuario = usuario;
        this.correoelectronico = correoelectronico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }   

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
    
}
