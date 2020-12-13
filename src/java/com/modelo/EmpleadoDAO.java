package com.modelo;

import com.utiles.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String usuario, String ci) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where Usuario=? and Ci=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, ci);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUsuario(rs.getString("Usuario"));
                em.setCi(rs.getString("Ci"));
                em.setNombres(rs.getString("Nombres"));
                em.setApellidos(rs.getString("Apellidos"));
                em.setCorreoelectronico(rs.getString("CorreoElectronico"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setCi(rs.getString(2));
                em.setNombres(rs.getString(3));
                em.setApellidos(rs.getString(4));
                em.setTelefono(rs.getString(5));
                em.setUsuario(rs.getString(6));
                em.setCorreoelectronico(rs.getString(7));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Empleado em){ 
        String sql="insert into empleado(Ci, Nombres,Apellidos, Telefono, Usuario,CorreoElectronico)values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getCi());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getUsuario());
            ps.setString(6, em.getCorreoelectronico());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                emp.setCi(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setApellidos(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setUsuario(rs.getString(6));
                emp.setCorreoelectronico(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return emp;
    }
    public int actualizar(Empleado em){
        String sql="update empleado set Ci=?, Nombres=?, Apellidos=?, Telefono=?,Usuario=?, CorreoElectronico=? where IdEmpleado=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getCi());
            ps.setString(2, em.getNombres());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getUsuario());
            ps.setString(6, em.getCorreoelectronico());
            ps.setInt(7, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
