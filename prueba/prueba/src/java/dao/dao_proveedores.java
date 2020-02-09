/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.md_categoria;
import Model.md_proveedor;
import conexion.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class dao_proveedores {
    
    public ArrayList<md_proveedor> listarProveedores(){
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
}
