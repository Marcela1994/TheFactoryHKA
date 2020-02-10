/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.md_categoria;
import conexion.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class dao_categorias {

    public ArrayList<md_categoria> listarCategorias() {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        ArrayList<md_categoria> listado_categorias = new ArrayList<>();
        String sql = "select id_categoria, categoria from categoria;";

        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                md_categoria categoria = new md_categoria();
                categoria.setId_categoria(rs.getInt(1));
                categoria.setCategoria(rs.getString(2));
                listado_categorias.add(categoria);
            }
        } catch (Exception e) {
            System.out.println("Error obteniendo categorias");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return listado_categorias;
    }

    public int Insertar_datos(md_categoria cat) throws SQLException {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        int res = 99;

        String sql = "INSERT INTO dbo.categoria (categoria)\n"
                + "VALUES (?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCategoria());
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException ex) {
            Logger.getLogger(dao_productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }
    }

    public boolean EliminarCategoria(int id) {

        int res = 99;
        connection conexion = new connection();
        try {
            Connection con = conexion.Conectar();
            String sql = "delete from categoria where id_categoria=?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();
            System.out.println(res);
            if (res == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(dao_productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean modificarCategoria(md_categoria categoriaModificar) {

        connection conexion = new connection();

        try {
            Connection con = conexion.Conectar();
            String sql = "update dbo.categoria\n"
                    + "set categoria =?\n"
                    + "where id_categoria =?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, categoriaModificar.getCategoria());
            ps.setInt(2, categoriaModificar.getId_categoria());
            int res = ps.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return false;
    }

    public md_categoria mostrarCategoriaPorID(int id) {
        connection conexion = new connection();
        md_categoria busqueda = new md_categoria();
        try {
            Connection con = conexion.Conectar();
            String sql = "select c.categoria, c.id_categoria\n"
                    + "from dbo.categoria c\n"
                    + "where id_categoria =?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                busqueda.setCategoria(rs.getString(1));
                busqueda.setId_categoria(rs.getInt(2));
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return busqueda;

    }

}
