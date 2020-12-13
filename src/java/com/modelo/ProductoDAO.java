
package com.modelo;

import com.utiles.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
  public Producto buscar(int id){
      Producto p=new Producto();
      String sql="select * from producto where idproducto="+id;
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while (rs.next()) {
              p.setId(rs.getInt(1));
              p.setNombre(rs.getString(2));
              p.setPrecio(rs.getDouble(3));
              p.setStock(rs.getInt(4));
          }
      } catch (Exception e) {
      }
     return p;
  }
  public int actualizarstock(int id, int stock){
      String sql="update producto set Stock=? where idproducto=?";
      try {
          con=cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.setInt(1, stock);
          ps.setInt(2, id);
          ps.executeUpdate();
      } catch (Exception e) {
      }
      return r;
  }
    
  //*******Operaciones CRUD***************//    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNombre(rs.getString(2));               
                em.setPrecio(rs.getDouble(3));
                em.setStock(rs.getInt(4));               
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Producto p){ 
        String sql="insert into producto(Nombre, Precio,Stock)values(?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());       
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public Producto listarId(int id){
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNombre(rs.getString(2));               
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4)); 
            }
        } catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Producto pr){
        String sql="update producto set Nombre=?, Precio=?, Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());            
            ps.setInt(4, pr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
