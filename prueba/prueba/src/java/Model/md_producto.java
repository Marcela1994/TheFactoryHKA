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
public class md_producto {
    
    int id_producto;
    String nombre;
    String descripcion;
    String categoria;
    String proveedor;
    String precio_unitario;
    String tipo_iva;
    String cant_inventario;
    
    public md_producto() {
    }

    public md_producto(int id_producto, String nombre, String descripcion, String categoria, String proveedor, String precio_unitario, String tipo_iva, String cant_inventario) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.precio_unitario = precio_unitario;
        this.tipo_iva = tipo_iva;
        this.cant_inventario = cant_inventario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getTipo_iva() {
        return tipo_iva;
    }

    public void setTipo_iva(String tipo_iva) {
        this.tipo_iva = tipo_iva;
    }

    public String getCant_inventario() {
        return cant_inventario;
    }

    public void setCant_inventario(String cant_inventario) {
        this.cant_inventario = cant_inventario;
    }
    
}
