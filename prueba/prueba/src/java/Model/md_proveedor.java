/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class md_proveedor {
    
    int nit;
    String nombre_empresa;

    public md_proveedor() {
    }

    public md_proveedor(int nit, String nombre_empresa) {
        this.nit = nit;
        this.nombre_empresa = nombre_empresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
    
    
    
}
