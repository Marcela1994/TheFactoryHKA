/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import Model.md_producto;
import dao.dao_productos;
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
@WebServlet(name = "ct_modificar_producto", urlPatterns = {"/ct_modificar_producto"})
public class ct_modificar_producto extends HttpServlet {

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

        md_producto mdP = new md_producto();
        int id = Integer.parseInt(request.getParameter("idProducto"));
        mdP.setId_producto(id);
        mdP.setNombre(request.getParameter("name"));
        mdP.setCant_inventario(request.getParameter("cant_inventario"));
        mdP.setCategoria(request.getParameter("categoria"));
        mdP.setDescripcion(request.getParameter("descripcion"));
        mdP.setPrecio_unitario(request.getParameter("pre_uni"));
        mdP.setProveedor(request.getParameter("proveedor"));
        mdP.setTipo_iva(request.getParameter("tasa_iva"));

        dao.dao_productos daoP = new dao_productos();
        boolean respuesta;
        respuesta = daoP.ModificarProducto(mdP);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modificar producto</title>");
            out.println("</head>");
            out.println("<body>");
            if (respuesta == true) {
                request.getRequestDispatcher("ct_productos").forward(request, response);
            } else {
                out.println("<h1>No fue posible actualizar el producto nro " + id + "</h1>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
