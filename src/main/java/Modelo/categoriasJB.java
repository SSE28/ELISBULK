package Modelo;

import java.io.Serializable;

public class categoriasJB implements Serializable {
    private int ID_categoria;
    private String nombre_cate;

    public categoriasJB() {

    }

    //BUSCAR O ELIMINAR
    public categoriasJB(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    //MODIFICAR E INSERTAR
    public categoriasJB(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }

    //MOSTRAR
    public categoriasJB(int ID_categoria, String nombre_cate) {
        this.ID_categoria = ID_categoria;
        this.nombre_cate = nombre_cate;
    }

    //METODO SET Y GET
    public int getId_categoria() {
        return ID_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre_cate() {
        return nombre_cate;
    }

    public void setNombre_cate(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }
}

