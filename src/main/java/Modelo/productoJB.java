package Modelo;

import java.io.Serializable;

public class productoJB implements Serializable {

    int ID_producto;
    String nombre_pro;
    float precio;
    String descripcion;
    int ID_categoria;

    public productoJB()
    {

    }

    //BUSCAR O ELIMINAR
    public productoJB(int ID_producto){
        this.ID_producto=ID_producto;
    }

    //MODIFICAR
    public productoJB(String nombre_pro, float precio, String descripcion, int ID_categoria) {
        
        this.nombre_pro=nombre_pro;
        this.precio=precio;
        this.descripcion=descripcion;
        this.ID_categoria=ID_categoria;
    }

    //MOSTRAR
    public productoJB(int id_producto, String nombre_pro,float precio, String descripcion, int ID_categoria) {
        this.ID_producto = ID_producto;
        this.nombre_pro=nombre_pro;
        this.precio=precio;
        this.descripcion=descripcion;
        this.ID_categoria=ID_categoria;
    }


    //INSERTAR
    public productoJB(String nombre_pro, int ID_categoria, String descripcion) {
        this.nombre_pro = nombre_pro;
        this.precio=precio;
        this.descripcion = descripcion;
        this.ID_categoria = ID_categoria;
    }


    //METODOS GET Y SET
    public int getId_producto() {
        return ID_producto;
    }

    public void setId_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getNombre() {
        return nombre_pro;
    }

    public void setNombre(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public float getprecio() {
        return precio;
    }

    public void setprecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return ID_categoria;
    }
    public void setCategoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }




}
