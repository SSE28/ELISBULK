package Modelo;
import java.io.Serializable;
import java.sql.Date;
public class promocionesJB implements Serializable{
    int ID_promocion;
    int ID_producto;
    String promocion;
    Date fecha_promocion;

    public promocionesJB() {

    }

    //BUSCAR O ELIMINAR
    public promocionesJB(int ID_promocion) {
        this.ID_promocion = ID_promocion;
    }

    //MOSTRAR
    public promocionesJB(int ID_promocion, int ID_producto, String promocion, Date fecha_promocion) {
        this.ID_promocion = ID_promocion;
        this.ID_producto = ID_producto;
        this.promocion = promocion;
        this.fecha_promocion = fecha_promocion;
    }

    //MODIFICAR E INSERTAR
    public promocionesJB(int ID_producto, String promocion, Date fecha_promocion) {
        this.ID_producto = ID_producto;
        this.promocion = promocion;
        this.fecha_promocion = fecha_promocion;
    }

    //METODOS GET Y SET

    public int getID_promocion() {
        return ID_promocion;
    }

    public void setID_promocion(int ID_promocion) {
        this.ID_promocion = ID_promocion;
    }

    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public Date getFecha_promocion() {
        return fecha_promocion;
    }

    public void setFecha_promocion(Date fecha_promocion) {
        this.fecha_promocion = fecha_promocion;
    }
}
