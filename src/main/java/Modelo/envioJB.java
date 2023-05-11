package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class envioJB implements Serializable {

    int ID_envio;
    Date fecha_envio; 
    Date fecha_entrega; 
    String recibio;

    public envioJB()
    {

    }

    //BUSCAR O ELIMINAR
    public envioJB(int ID_envio){
        this.ID_envio=ID_envio;
    }


    //MODIFICAR
    public envioJB(Date fecha_entrega, String recibio) {
        this.fecha_entrega=fecha_entrega;
        this.recibio=recibio;
    }

    //INSERTAR
    public envioJB(Date fecha_envio, Date fecha_entrega, String recibio) {
        this.fecha_envio=fecha_envio;
        this.fecha_entrega=fecha_entrega;
        this.recibio=recibio;
    }

    //MOSTRAR
    public envioJB(int ID_envio,Date fecha_envio, Date fecha_entrega, String recibio) {
        this.ID_envio=ID_envio;
        this.fecha_envio=fecha_envio;
        this.fecha_entrega=fecha_entrega;
        this.recibio=recibio;
    }

    public int getID_envio() {
        return ID_envio;
    }

    public void setID_envio(int ID_envio) {
        this.ID_envio = ID_envio;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getRecibio() {
        return recibio;
    }

    public void setRecibio(String recibio) {
        this.recibio = recibio;
    }
}
