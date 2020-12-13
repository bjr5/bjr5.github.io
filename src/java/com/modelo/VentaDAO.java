package com.modelo;

import com.utiles.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
   
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    public int guardarVenta(Venta ve){
        String sql="insert into ventas(IdCliente, IdEmpleado,FechaVenta,Monto)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setDate(3, (java.sql.Date) ve.getFecha());
            ps.setDouble(4, ve.getMonto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int guardarVentas(Venta venta){
        String sql="insert into detalle(IdVentas, IdProducto,Cantidad, PrecioVenta)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public static String fechaActual(){
Date fecha=new Date();
SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
return formatoFecha.format(fecha);
}
    
}
