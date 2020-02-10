/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Model.md_proveedor;
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
public class dao_proveedores {

    public ArrayList<md_proveedor> listarProveedores() {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        ArrayList<md_proveedor> listado_proveedores = new ArrayList<>();
        String sql = "select nit, nombre_empresa from proveedor;";

        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                md_proveedor proveedor = new md_proveedor();
                proveedor.setNit(rs.getInt(1));
                proveedor.setNombre_empresa(rs.getString(2));
                listado_proveedores.add(proveedor);
            }
        } catch (Exception e) {
            System.out.println("Error obteniendo proveedores");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return listado_proveedores;
    }

    public int Insertar_datos(md_proveedor pro) throws SQLException {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        int res = 99;

        String sql = "INSERT INTO dbo.proveedor (nit, nombre_empresa)\n"
                + "VALUES (?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getNit());
            ps.setString(2, pro.getNombre_empresa());
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException ex) {
            Logger.getLogger(dao_productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }
    }

    public boolean EliminarProveedor(int nit) {

        int res = 99;
        connection conexion = new connection();
        try {
            Connection con = conexion.Conectar();
            String sql = "delete from dbo.proveedor where nit =?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, nit);
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

    public boolean ModificarProveedor(md_proveedor proveedorModificar) {

        connection conexion = new connection();

        try {
            Connection con = conexion.Conectar();
            String sql = "update proveedor\n"
                    + "set nombre_empresa =?\n"
                    + "where nit=?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, proveedorModificar.getNombre_empresa());
            ps.setInt(2, proveedorModificar.getNit());
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

    public md_proveedor MostrarProveedorPorID(int nit) {
        connection conexion = new connection();
        md_proveedor busqueda = new md_proveedor();
        try {
            Connection con = conexion.Conectar();
            String sql = "select p.nombre_empresa, p.nit\n"
                    + "from dbo.proveedor p\n"
                    + "where nit =?;";

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, nit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                busqueda.setNombre_empresa(rs.getString(1));
                busqueda.setNit(rs.getInt(2));
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
