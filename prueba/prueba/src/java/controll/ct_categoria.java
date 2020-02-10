/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_categoria;
import dao.dao_categorias;
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
@WebServlet(name = "ct_categoria", urlPatterns = {"/ct_categoria"})
public class ct_categoria extends HttpServlet {

    ArrayList<md_categoria> cat = new ArrayList<>();
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
            out.println("<title>Categoria</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body class='container'>");
            out.println("<h1>CATEGORIAS</h1>");
            out.println("<table class='table'>");
            out.println("<thead class='thead-dark'>");
            out.println("<tr>");
            out.println("<th scope='col'>ID CATEGORIA</th>");
            out.println("<th scope='col'>NOMBRE DE LA CATEGORIA</th>");
            out.println("<th scope='col'>MODIFICAR</th>");
            out.println("<th scope='col'>ELIMINARR</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            dao_categorias dc = new dao_categorias();
            cat = dc.listarCategorias();
            for (md_categoria categ : cat){
                out.println("<tr>");
                out.println("<form action='ct_cont_categoria' method='post'>");
                out.println("<input type='hidden' id='idcat' name='idcat' value='" + categ.getId_categoria() + "'/>");
                out.println("<input type='hidden' id='categoria' name='categoria' value='" + categ.getCategoria()+ "'/>");
                out.println("<th scope='row'>" + categ.getId_categoria() + "</th>");
                out.println("<td>" + categ.getCategoria() + "</td>");
                out.println("<td><button id='accion' name='accion' type='submit' value='modificar' class='btn btn-primary'>MODIFICAR</button></td>");
                out.println("<td><button id='accion' name='accion' type='submit' value='eliminar' class='btn btn-primary'>ELIMINAR</button></td>");
                out.println("</form>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<center><a href='ct_crear_categoria' class='btn btn-primary'>CREAR NUEVA CATEGORIA</a></center>");
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
