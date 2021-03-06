/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ct_productos", urlPatterns = {"/ct_productos"})
public class ct_productos extends HttpServlet {

    ArrayList<md_producto> productos = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<titleProductos</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<h1>PRODUCTOS</h1><BR><br>");
            out.println("<table class='table'>");
            out.println("<thead class='thead-dark'>");
            out.println("<tr>");
            out.println("<th scope='col'>Nombre</th>");
            out.println("<th scope='col'>Descripción</th>");
            out.println("<th scope='col'>Categoria</th>");
            out.println("<th scope='col'>Proveedor</th>");
            out.println("<th scope='col'>Precio Unitario</th>");
            out.println("<th scope='col'>Tipo de IVA</th>");
            out.println("<th scope='col'>Cantidad en Inventario</th>");
            out.println("<th scope='col'>Modificar</th>");
            out.println("<th scope='col'>Eliminar</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            dao.dao_productos dp = new dao.dao_productos();
            productos = dp.MostrarProducto();
            for (md_producto producto : productos) {
                out.println("<tr>");
                out.println("<form action='ct_control_productos' method='post'>");
                out.println("<input type='hidden' id='idProducto' name='idProducto' value='" + producto.getId_producto() + "'/>");
                out.println("<input type='hidden' id='nombreProducto' name='nombreProducto' value='" + producto.getNombre() + "'/>");
                out.println("<th scope='row'>" + producto.getNombre() + "</th>");
                out.println("<td>" + producto.getDescripcion() + "</td>");
                out.println("<td id='categoria' name='categoria' value='" + producto.getCategoria() + "'>" + producto.getCategoria() + "</td>");
                out.println("<td id='proveedor' name='proveedor' value='" + producto.getProveedor() + "'>" + producto.getProveedor() + "</td>");
                out.println("<td id='precio' name='precio' value='" + producto.getPrecio_unitario() + "'>" + producto.getPrecio_unitario() + "</td>");
                out.println("<td id='iva' name='iva' value='" + producto.getTipo_iva() + "'>" + producto.getTipo_iva() + "</td>");
                out.println("<td id='cantidad' name='cantidad' value='" + producto.getCant_inventario() + "'>" + producto.getCant_inventario() + "</td>");
                out.println("<td><button id='accion' name='accion' type='submit' value='modificar' class='btn btn-primary'>MODIFICAR</button></td>");
                //out.println("<td><a href='seleccion.jsp?prod="+producto.getId_producto()+"' class='btn btn-primary'>MODIFICAR</a></td>");
                out.println("<td><button id='accion' name='accion' type='submit' value='eliminar' class='btn btn-primary'>ELIMINAR</button></td>");
                out.println("</form>");
                out.println("</tr>");

            }

            out.println("</table>");
            out.println("<center><a href='crear_produc' class='btn btn-primary'>CREAR NUEVO PRODUCTO</a></center>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<hr>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<a href='seleccion.jsp' class='btn btn-secondary btn-lg btn-block'>VOLVER</a>");
            out.println("<br>");
            out.println("<br>");
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' ></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' ></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' ></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
