package com.modelo;
import com.utiles.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Cliente buscar(String ci){
        Cliente c=new Cliente();
        String sql="Select * from cliente where Ci="+ci;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);         
            rs=ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCi(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setApellidos(rs.getString(4));
                
            }
        } catch (Exception e) {
        }
        return c;
    }   
//*******Operaciones CRUD***************//
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Cliente cl=new Cliente();
                cl.setId(rs.getInt(1));
                cl.setCi(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setApellidos(rs.getString(4));                             
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Cliente c){ 
        String sql="insert into cliente(Ci, Nombres, Apellidos)values(?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getCi());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getApellidos());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;      
    }
    public Cliente listarId(int id){
        Cliente cl=new Cliente();
        String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                cl.setCi(rs.getString(2));
                cl.setNombres(rs.getString(3));
                cl.setApellidos(rs.getString(4));              
            }
        } catch (Exception e) {
        }
        return cl;
    }
    public int actualizar(Cliente cl){
        String sql="update cliente set Ci=?, Nombres=?, Apellidos=? where IdCliente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getCi());
            ps.setString(2, cl.getNombres());
            ps.setString(3, cl.getApellidos());          
            ps.setInt(4, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
