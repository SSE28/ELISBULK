package Modelo;

import java.io.Serializable;

public class carritoJB implements Serializable {
    int ID_carrito;
    int ID_usuario;
    int ID_producto;
    float cantidad;
    float precio;
    float subtotal;


    public carritoJB() {

    }

    //BUSCAR O BORRAR
    public carritoJB(int ID_carrito) {
        this.ID_carrito = ID_carrito;
    }

    //INSERTAR
    public carritoJB(int ID_producto, float cantidad, float precio, float subtotal) {
        this.ID_producto = ID_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    //MOSTRAR
    public carritoJB(int ID_carrito, int ID_usuario, int ID_producto, float cantidad, float precio, float subtotal) {
        this.ID_carrito = ID_carrito;
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    //MODIFICAR
    public carritoJB(float cantidad,float precio,float subtotal) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    //METODOS SET Y GET
    public int getID_carrito() {
        return ID_carrito;
    }

    public void setID_carrito(int ID_carrito) {
        this.ID_carrito = ID_carrito;
    }

    public int getId_producto() {
        return ID_producto;
    }

    public void setId_producto(int ID_producto) {
        this.ID_producto = ID_producto;
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

}