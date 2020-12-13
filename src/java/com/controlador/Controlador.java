package com.controlador;

import com.modelo.Cliente;
import com.modelo.ClienteDAO;
import com.modelo.Empleado;
import com.modelo.EmpleadoDAO;
import com.modelo.Producto;
import com.modelo.ProductoDAO;
import com.modelo.Venta;
import com.modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double total;
    double totalPagar;
    VentaDAO vdao = new VentaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        if (menu.equals("Info")) {
            request.getRequestDispatcher("Info.jsp").forward(request, response);
        }
        
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String ci = request.getParameter("txtCi");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String telefono = request.getParameter("txtTelefono");    
                    String usuario = request.getParameter("txtUsuario");
                    String correoelectronico=request.getParameter("txtCorreoelectronico");
                    em.setCi(ci);
                    em.setNombres(nombres);
                    em.setApellidos(apellidos);
                    em.setTelefono(telefono);                  
                    em.setUsuario(usuario);
                    em.setCorreoelectronico(correoelectronico);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Edit":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String ci1 = request.getParameter("txtCi");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    String telefono1 = request.getParameter("txtTelefono");
                    String usuario1 = request.getParameter("txtUsuario");
                    String correoelectronico1 = request.getParameter("txtCorreoelectronico");
                    em.setCi(ci1);
                    em.setNombres(nombres1);
                    em.setTelefono(telefono1);
                    em.setApellidos(apellidos1);
                    em.setUsuario(usuario1);
                    em.setCorreoelectronico(correoelectronico1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String ci = request.getParameter("txtCi");
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    c.setCi(ci);
                    c.setNombres(nombres);
                    c.setApellidos(apellidos);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Edit":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = cdao.listarId(idc);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String ci1 = request.getParameter("txtCi");
                    String nombres1 = request.getParameter("txtNombres");
                    String apellidos1 = request.getParameter("txtApellidos");
                    c.setCi(ci1);
                    c.setNombres(nombres1);
                    c.setApellidos(apellidos1);                   
                    c.setId(idc);
                    cdao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombre");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setStock(stock);
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Edit":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pr = pdao.listarId(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtNombre");
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));                
                    p.setNombre(nombre1);
                    p.setPrecio(precio1);
                    p.setStock(stock1);
                    p.setId(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:                    
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {           
            switch (accion) {
                case "BuscarCliente":
                    String ci =request.getParameter("codigocliente");
                    c.setCi(ci);
                    c = cdao.buscar(ci);
                    request.setAttribute("c", c);
                    request.setAttribute("cliente", c);
                                      
                    request.setAttribute("lista", lista); 
                    
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId(id);                    
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);                    
                    request.setAttribute("lista", lista);                    
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    total = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setTotal(total);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getTotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);                    
                    break;
                case "GenerarVenta":
                    //Actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setIdcliente(c.getId());
                    v.setIdempleado(2);
                    v.setFecha(3);
                    v.setMonto(totalPagar);
                    vdao.guardarVenta(v);
                    //Guardar Detalle ventas
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarVentas(v);
                    }
                    lista=new ArrayList<>();
                    break;
                default:                    
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;                    
                    
               
                    request.getRequestDispatcher("RegistraVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistraVenta.jsp").forward(request, response);
        }
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
