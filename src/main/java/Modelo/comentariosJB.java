package Modelo;
import java.io.Serializable;
import java.sql.Date;
public class comentariosJB implements Serializable{
    int ID_comentario;
    int ID_usuario;
    int ID_producto;
    String comentario;
    Date fecha_comentario;

    public comentariosJB() {

    }

    //BUSCAR O ELIMINAR
    public comentariosJB(int ID_comentario) {
        this.ID_comentario = ID_comentario;
    }

    //MOSTRAR
    public comentariosJB(int ID_comentario, int ID_usuario, int ID_producto, String comentario, Date fecha_comentario) {
        this.ID_comentario = ID_comentario;
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
    }

    //MODIFICAR E INSERTAR
    public comentariosJB(int ID_usuario, int ID_producto, String comentario) {
        this.ID_usuario = ID_usuario;
        this.ID_producto = ID_producto;
        this.comentario = comentario;
    }

    //METODOS SET Y GET


    public int getID_comentario() {
        return ID_comentario;
    }

    public void setID_comentario(int ID_comentario) {
        this.ID_comentario = ID_comentario;
    }

    public int getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(Date fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }
}
