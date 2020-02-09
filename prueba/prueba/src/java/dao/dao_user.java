/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.md_producto;
import Model.md_usuario;
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
public class dao_user {

    public int Insertar_datos(md_usuario per) throws SQLException {
        connection conexion = new connection();
        Connection con = conexion.Conectar();
        int res = 99;

        String sql = "INSERT INTO dbo.usuarios (ID, nombre, apellido, usuario, clave)\n"
                + "VALUES (?,?,?,?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApellido());
            ps.setString(4, per.getUsuario());
            ps.setString(5, per.getClave());
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException ex) {
            Logger.getLogger(dao_productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return res;
        }

    }

    public boolean ValidarUser(String usuario, String clave) {
        
        connection conexion = new connection();
        
        try {
            Connection con = conexion.Conectar();
            String sql = "select u.ID, u.nombre, u.apellido from dbo.usuarios u\n" +
                        "where u.usuario=? and u.clave=?";
            
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               return true;
            }
            ps.close();
        }
        catch (SQLException e) {
            System.out.println("Error al validar usuario");
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return false;
    }
}
