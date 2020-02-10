/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.md_producto;
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
public class dao_productos {

    public int Insertar_datos(md_producto pro) throws SQLException {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        int res = 99;

        String sql = "INSERT INTO dbo.producto (nombre, descripcion, categ_pro, prov_pro, precio_unitario, tipo_iva, cant_inventario)\n"
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setString(3, pro.getCategoria());
            ps.setString(4, pro.getProveedor());
            ps.setString(5, pro.getPrecio_unitario());
            ps.setString(6, pro.getTipo_iva());
            ps.setString(7, pro.getCant_inventario());
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException ex) {
            Logger.getLogger(dao_productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }
    }

    public ArrayList<md_producto> MostrarProducto() {
        ArrayList<md_producto> listado_productos = new ArrayList<>();
        connection conexion = new connection();
        try {
            Connection con = conexion.Conectar();
            String sql = "select p.id_producto, p.nombre, p.descripcion, c.categoria, pr.nombre_empresa, p.precio_unitario, p.tipo_iva, p.cant_inventario\n"
                    + "from dbo.producto p\n"
                    + "inner join categoria c\n"
                    + "on p.categ_pro = c.id_categoria\n"
                    + "inner join proveedor pr\n"
                    + "on p.prov_pro = pr.nit;";

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                md_producto busqueda = new md_producto();

                busqueda.setId_producto(rs.getInt(1));
                busqueda.setNombre(rs.getString(2));
                busqueda.setDescripcion(rs.getString(3));
                busqueda.setCategoria(rs.getString(4));
                busqueda.setProveedor(rs.getString(5));
                busqueda.setPrecio_unitario(rs.getString(6));
                busqueda.setTipo_iva(rs.getString(7));
                busqueda.setCant_inventario(rs.getString(8));
                listado_productos.add(busqueda);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return listado_productos;

    }

    public boolean EliminarProducto(int id) {

        int res = 99;
        connection conexion = new connection();
        try {
            Connection con = conexion.Conectar();
            String sql = "delete from dbo.producto where id_producto =?;";

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

    public md_producto MostrarProductoPorID(int id) {
        connection conexion = new connection();
        md_producto busqueda = new md_producto();
        try {
            Connection con = conexion.Conectar();
            String sql = "select p.nombre, p.descripcion, p.categ_pro, p.prov_pro, p.precio_unitario, p.tipo_iva, p.cant_inventario, p.id_producto\n"
                    + "from dbo.producto p\n"
                    + "where id_producto = ?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                busqueda.setNombre(rs.getString(1));
                busqueda.setDescripcion(rs.getString(2));
                busqueda.setCategoria(rs.getString(3));
                busqueda.setProveedor(rs.getString(4));
                busqueda.setPrecio_unitario(rs.getString(5));
                busqueda.setTipo_iva(rs.getString(6));
                busqueda.setCant_inventario(rs.getString(7));
                busqueda.setId_producto(rs.getInt(8));

            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return busqueda;

    }

    public boolean ModificarProducto(md_producto productoEliminar) {

        connection conexion = new connection();
        
        try {
            Connection con = conexion.Conectar();
            String sql = "update producto\n"
                    + "set cant_inventario=?, nombre =?, descripcion =?,\n"
                    + "categ_pro =?, tipo_iva =?, prov_pro =?, precio_unitario =?\n"
                    + "where id_producto=?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, productoEliminar.getCant_inventario());
            ps.setString(2, productoEliminar.getNombre());
            ps.setString(3, productoEliminar.getDescripcion());
            ps.setInt(4, Integer.parseInt(productoEliminar.getCategoria()));
            ps.setString(5, productoEliminar.getTipo_iva());
            ps.setInt(6, Integer.parseInt(productoEliminar.getProveedor()));
            ps.setString(7, productoEliminar.getPrecio_unitario());
            ps.setInt(8, productoEliminar.getId_producto());
            int res = ps.executeUpdate();
            if(res==1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return false;
    }

}
