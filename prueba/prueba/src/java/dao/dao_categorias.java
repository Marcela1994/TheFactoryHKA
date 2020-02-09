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
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class dao_categorias {
    
    public ArrayList<md_categoria> listarCategorias(){
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
}
