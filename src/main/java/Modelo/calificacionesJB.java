package Modelo;

import java.io.Serializable;
import java.sql.Date;
public class calificacionesJB implements Serializable{
    int ID_calificacion;
    int ID_usuario;
    int ID_producto;
    int calificacion;
    Date fecha_calificacion;

    public calificacionesJB() {

    }

    //BUSCAR O ELIMINAR
    public calificacionesJB(int ID_calificacion) {
        this.ID_calificacion = ID_calificacion;
    }

    //MOSTRAR
    public calificacionesJB(int ID_calificacion, int ID_usuario, int ID_producto, int calificacion, Date fecha_calificacion) {
        this.ID_calificacion = ID_calificacion;
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.calificacion = calificacion;
        this.fecha_calificacion = fecha_calificacion;
    }

    //INSERTAR Y MODIFICAR
    public calificacionesJB(int ID_usuario, int ID_producto, int calificacion,Date fecha_calificacion) {
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.calificacion = calificacion;
        this.fecha_calificacion = fecha_calificacion;
    }

    //METODOS GET Y SET

    public int getID_calificacion() {
        return ID_calificacion;
    }

    public void setID_calificacion(int ID_calificacion) {
        this.ID_calificacion = ID_calificacion;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha_calificacion() {
        return fecha_calificacion;
    }

    public void setFecha_calificacion(Date fecha_calificacion) {
        this.fecha_calificacion = fecha_calificacion;
    }
}
