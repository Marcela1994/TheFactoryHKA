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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "ct_cont_proveedor", urlPatterns = {"/ct_cont_proveedor"})
public class ct_cont_proveedor extends HttpServlet {

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
            out.println("<title>Proveedores</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            String nombre = request.getParameter("nombreProveedor");
            String accion = request.getParameter("accion");
            if (accion.equals("modificar")) {
                md_proveedor mdp = new md_proveedor();
                dao_proveedores dp = new dao_proveedores();
                mdp = dp.MostrarProveedorPorID(Integer.parseInt(request.getParameter("nit")));

                out.println("<h1>Editar Proveedor</h1><BR><br>");
                out.println("<form action='ct_mod_proveedor' method='post'>");
                out.println("<div class='form-group'>");
                int nit = Integer.parseInt(request.getParameter("nit"));
                out.println("<input type='hidden' id='nit' name='nit' value='" + nit + "'/>");
                out.println("<label>NIT</label>");
                out.println("<fieldset disabled>");
                out.println("<input type='text' class='form-control' id='nit' name='nit' placeholder='Nit del Proveedor' required='true' value='" + mdp.getNit() + "'>");
                out.println("</fieldset>");
                out.println("<label>PROVEEDOR</label>");
                out.println("<input type='text' class='form-control' id='nombre' name='nombre' placeholder='Nombre del Proveedor' required='true' value='" + mdp.getNombre_empresa() + "'>");
                out.println("</div>");
                out.println("<center><button type='submit' class='btn btn-primary'>GUARDAR CAMBIOS</button></center>");
                out.println("</form>");
            } else {
                dao_proveedores dp = new dao_proveedores();
                dp.EliminarProveedor(Integer.parseInt(request.getParameter("nit")));
                request.getRequestDispatcher("ct_proveedores").forward(request, response);
                
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
