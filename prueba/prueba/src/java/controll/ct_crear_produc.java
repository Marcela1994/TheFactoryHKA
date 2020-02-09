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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "crear_produc", urlPatterns = {"/crear_produc"})
public class ct_crear_produc extends HttpServlet {

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
            out.println("<title>Crear Producto</title>"); 
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<form method='post'>");
            out.println("<h1>Crear Producto</h1><BR><br>");
            out.println("<div class='form-group'>");
            out.println("<label>NOMBRE DEL PRODUCTO</label>");
            out.println("<input type='text' class='form-control' id='name' name='name' placeholder='Nombre del Producto' required='true'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>DESCRIPCIÓN</label>");
            out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción del producto' required='true'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleFormControlSelect1'>CATEGORIA</label>");
            out.println("<select class='form-control' id='categoria' name='categoria'>");
            //aca van las categorias traidas de la bd
            dao_categorias categorias = new dao_categorias();
            ArrayList<md_categoria> listadoCategorias = categorias.listarCategorias();
            for (md_categoria cat : listadoCategorias) {
                out.println("<option value='"+cat.getId_categoria()+"'>"+ cat.getCategoria() +"</option>");   
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
                out.println("<option value='"+prov.getNit()+"'>"+ prov.getNombre_empresa() +"</option>");   
            }
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleInputEmail1'>PRECIO UNITARIO</label>");
            out.println("<input type='text' class='form-control' id='pre_uni' name='pre_uni' placeholder='Precio Unitario' required='true'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleFormControlSelect1'>TASA DE INTERES</label>");
            out.println("<select class='form-control' id='tasa_iva' name='tasa_iva'>");
            out.println("<option>0%</option>");
            out.println("<option>12%</option>");
            out.println("<option>8%</option>");
            out.println("<option>22%</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='exampleInputEmail1'>CANTIDAD EN INVENTARIO</label>");
            out.println("<input type='text' class='form-control' id='cant_inventario' name='cant_inventario' placeholder='Cantidad en el inventario' required='true'>");
            out.println("</div>");
            out.println("<center><button type='submit' class='btn btn-primary'>CREAR</button></center>");
            out.println("</form>");
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js'></script>");
            out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>");
            out.println("");
            
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
        
        md_producto pro = new md_producto();
        
        pro.setNombre(request.getParameter("name"));
        pro.setDescripcion(request.getParameter("descripcion"));
        pro.setCategoria(request.getParameter("categoria"));
        pro.setProveedor(request.getParameter("proveedor"));
        pro.setPrecio_unitario(request.getParameter("pre_uni"));
        pro.setTipo_iva(request.getParameter("tasa_iva"));
        pro.setCant_inventario(request.getParameter("cant_inventario"));
        
        dao_productos daoP = new dao_productos();
        int respuesta = 99;
        try {
            respuesta = daoP.Insertar_datos(pro);
        } catch (SQLException ex) {
            Logger.getLogger(ct_crear_produc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (respuesta==1){
            request.getRequestDispatcher("ct_productos").forward(request, response);
        }
        else{
            System.out.println("no se puede crear el producto");
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
