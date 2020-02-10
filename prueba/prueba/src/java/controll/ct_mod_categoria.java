/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_categoria;
import Model.md_proveedor;
import dao.dao_categorias;
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
@WebServlet(name = "ct_mod_categoria", urlPatterns = {"/ct_mod_categoria"})
public class ct_mod_categoria extends HttpServlet {

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
        
        md_categoria mc = new md_categoria();
        int id = Integer.parseInt(request.getParameter("idCategoria"));
        mc.setId_categoria(id);
        mc.setCategoria(request.getParameter("nombre"));

        dao_categorias dc = new dao_categorias();
        boolean respuesta;
        respuesta = dc.modificarCategoria(mc);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modificar Categoria</title>");
            out.println("</head>");
            out.println("<body>");
            if (respuesta == true) {
                request.getRequestDispatcher("ct_categoria").forward(request, response);
            } else {
                out.println("<h1>No fue posible actualizar la categoria nro " + id + "</h1>");
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
            }

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
