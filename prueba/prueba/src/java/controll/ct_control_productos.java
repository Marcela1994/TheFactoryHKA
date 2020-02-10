/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_categoria;
import Model.md_producto;
import Model.md_proveedor;
import dao.dao_categorias;
import dao.dao_productos;
import dao.dao_proveedores;
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
@WebServlet(name = "ct_control_productos", urlPatterns = {"/ct_control_productos"})
public class ct_control_productos extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Productos</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            String nombre = request.getParameter("nombreProducto");
            String accion = request.getParameter("accion");
            if (accion.equals("modificar")){
                md_producto mdP = new md_producto();
                dao_productos daoP = new dao_productos();
                mdP = daoP.MostrarProductoPorID(Integer.parseInt(request.getParameter("idProducto")));
                
            out.println("<h1>Editar Producto</h1><BR><br>");
            out.println("<form action='ct_modificar_producto' method='post'>");
            out.println("<div class='form-group'>");
            int id = Integer.parseInt(request.getParameter("idProducto"));
            out.println("<input type='hidden' id='idProducto' name='idProducto' value='"+id+"'/>");
            out.println("<label>NOMBRE DEL PRODUCTO</label>");
            out.println("<input type='text' class='form-control' id='name' name='name' placeholder='Nombre del Producto' required='true' value='"+mdP.getNombre()+"'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>DESCRIPCIÓN</label>");
            out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción del producto' required='true' value='"+mdP.getDescripcion()+"'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleFormControlSelect1'>CATEGORIA</label>");
            out.println("<select class='form-control' id='categoria' name='categoria'>");
            //aca van las categorias traidas de la bd
            dao_categorias categorias = new dao_categorias();
            ArrayList<md_categoria> listadoCategorias = categorias.listarCategorias();
            for (md_categoria cat : listadoCategorias) {
                if (cat.getId_categoria()== Integer.parseInt(mdP.getCategoria())){
                out.println("<option value='"+cat.getId_categoria()+"' selected>"+ cat.getCategoria() +"</option>");   
                } else{
                    out.println("<option value='"+cat.getId_categoria()+"'>"+ cat.getCategoria() +"</option>");   
                }
            }
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleFormControlSelect1'>PROVEEDOR</label>");
            out.println("<select class='form-control' id='proveedor' name='proveedor'>");
            //aca van los proveedores traidos desde la bd
            dao_proveedores proveedores = new dao_proveedores();
            ArrayList<md_proveedor> listadoProveedores = proveedores.listarProveedores();
            for (md_proveedor prov : listadoProveedores) {
                if(prov.getNit() == Integer.parseInt(mdP.getProveedor())){
                    out.println("<option value='"+prov.getNit()+"' selected>"+ prov.getNombre_empresa() +"</option>");   
                }else{
                    out.println("<option value='"+prov.getNit()+"'>"+ prov.getNombre_empresa() +"</option>");   
                }
            }
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleInputEmail1'>PRECIO UNITARIO</label>");
            out.println("<input type='text' class='form-control' id='pre_uni' name='pre_uni' placeholder='Precio Unitario' required='true' value='"+mdP.getPrecio_unitario()+"'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleFormControlSelect1'>TASA DE INTERES</label>");
            out.println("<select class='form-control' id='tasa_iva' name='tasa_iva'>");
            if(mdP.getTipo_iva().equals("0%")){
                out.println("<option selected>0%</option>");
            } else {
                out.println("<option>0%</option>");
            }
                System.out.println(mdP.getTipo_iva());
            if (mdP.getTipo_iva().equals("12%")){
                out.println("<option selected>12%</option>");
            } else {
                out.println("<option>12%</option>");
            }
            if (mdP.getTipo_iva().equals("8%")){
                out.println("<option selected>8%</option>");
            } else {
                out.println("<option>8%</option>");
            }
            if (mdP.getTipo_iva().equals("22%")) {
                out.println("<option selected>22%</option>");
            } else {
                out.println("<option>22%</option>");
            }
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleInputEmail1'>CANTIDAD EN INVENTARIO</label>");
            out.println("<input type='text' class='form-control' id='cant_inventario' name='cant_inventario' placeholder='Cantidad en el inventario' required='true' value='"+mdP.getCant_inventario()+"'>");
            out.println("</div>");
            out.println("<center><button type='submit' class='btn btn-primary'>GUARDAR CAMBIOS</button></center>");
            out.println("</form>");
            } else {
                dao_productos daoP = new dao_productos();
                daoP.EliminarProducto(Integer.parseInt(request.getParameter("idProducto")));
                request.getRequestDispatcher("ct_productos").forward(request, response);
            }
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
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js'></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>");
            out.println("</body>");
            out.println("</html>");
        }
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
