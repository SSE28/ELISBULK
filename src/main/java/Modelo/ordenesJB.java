package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class ordenesJB implements Serializable {

    int ID_orden;
    int ID_usuario;
    int ID_producto;
    Date fecha_compra;
    float cantidad;
    float precio;
    String direccion_envio;
    String estado;
    float subtotal;

    public ordenesJB() {

    }


    //BUSCAR O ELIMINAR
    public ordenesJB(int ID_orden) {
        this.ID_orden = ID_orden;
    }

    //MOSTRAR
    public ordenesJB(int ID_orden,int ID_usuario, int ID_producto, Date fecha_compra, float cantidad, float precio,
                     String direccion_envio, String estado, float subtotal) {
        this.ID_orden = ID_orden;
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.direccion_envio = direccion_envio;
        this.estado = estado;
        this.subtotal = subtotal;
    }

    //INSERTAR
    public ordenesJB(int ID_usuario, int ID_producto, Date fecha_compra, float cantidad, float precio,
                     String direccion_envio, String estado, float subtotal) {

        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.direccion_envio = direccion_envio;
        this.estado = estado;
    }

    //MODIFICAR


    //METODOS GET Y SET
    public int getId_orden() {
        return ID_orden;
    }

    public void setId_orden(int ID_orden) {
        this.ID_orden = ID_orden;
    }

    public int getId_usuario() {
        return ID_usuario;
    }

    public void setId_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public int getId_producto() {
        return ID_producto;
    }

    public void setId_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public Date getFechacompra() {
        return fecha_compra;
    }

    public void setFechacompra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDireccionenvio() {
        return direccion_envio;
    }

    public void setDireccionenvio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getestado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

}
