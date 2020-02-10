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
@WebServlet(name = "ct_cont_categoria", urlPatterns = {"/ct_cont_categoria"})
public class ct_cont_categoria extends HttpServlet {

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
            out.println("<title>Categorias</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            int id = Integer.parseInt(request.getParameter("idcat"));
            String accion = request.getParameter("accion");
            if (accion.equals("modificar")) {
                
                md_categoria mdc = new md_categoria();
                dao_categorias dc = new dao_categorias();
                mdc = dc.mostrarCategoriaPorID(id);

                out.println("<h1>Editar Categoria</h1><BR><br>");
                out.println("<form action='ct_mod_categoria' method='post'>");
                out.println("<div class='form-group'>");
                
                out.println("<input type='hidden' id='idCategoria' name='idCategoria' value='" + id + "'/>");
                out.println("<label>Id Categoria</label>");
                out.println("<fieldset disabled>");
                out.println("<input type='text' class='form-control' id='idCat' name='idCat' placeholder='id de la categoria' required='true' value='" + mdc.getId_categoria() + "'>");
                out.println("</fieldset>");
                out.println("<label>Nombre Categoria</label>");
                out.println("<input type='text' class='form-control' id='nombre' name='nombre' placeholder='Nombre de la categoria' required='true' value='" + mdc.getCategoria() + "'>");
                out.println("</div>");
                out.println("<center><button type='submit' class='btn btn-primary'>GUARDAR CAMBIOS</button></center>");
                out.println("</form>");
            } else {
                dao_categorias dc = new dao_categorias();
                dc.EliminarCategoria(id);
                request.getRequestDispatcher("ct_categoria").forward(request, response);
                
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
