/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_proveedor;
import dao.dao_proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ct_crear_prov", urlPatterns = {"/ct_crear_prov"})
public class ct_crear_prov extends HttpServlet {

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
            out.println("<title>Crear Proveedor</title>"); 
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<form method='post'>");
            out.println("<h1>Crear Producto</h1><BR><br>");
            out.println("<div class='form-group'>");
            out.println("<label>NIT DEL PROVEEDOR</label>");
            out.println("<input type='text' class='form-control' id='nitPro' name='nitPro' placeholder='Ingrese el Nit del proveedor sin digito de verificación' required='true'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label>NOMBRE DEL PROVEEDOR</label>");
            out.println("<input type='text' class='form-control' id='nombrePro' name='nombrePro' placeholder='Nombre del proveedor' required='true'>");
            out.println("</div>");
            out.println("<center><button type='submit' class='btn btn-primary'>CREAR</button></center>");
            out.println("</form>");
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
        
        md_proveedor pro = new md_proveedor();
        
        pro.setNit(Integer.parseInt(request.getParameter("nitPro")));
        pro.setNombre_empresa(request.getParameter("nombrePro"));
        
        dao_proveedores dp = new dao_proveedores();
        int res = 99;
        try {
            res = dp.Insertar_datos(pro);
        } catch (SQLException ex) {
            Logger.getLogger(ct_crear_produc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (res == 1){
            request.getRequestDispatcher("ct_proveedores").forward(request, response);
        } else {
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
