package Modelo;

import java.io.Serializable;
import java.sql.Date;

public class usuariosJB implements Serializable {
    int ID_usuario;
    String usuario;
    String nombre;
    String apellido;
    String direccion;
    String email;
    String contraseña;
    Date fechaNac;

    public usuariosJB() {

    }

    //VALIDAR USUARIO Y CONTRASEÑA
    public usuariosJB (String usuario, String email, String contraseña) {
        this.usuario = usuario;
        this.email = email;
        this.contraseña = contraseña;
    }

    //BUSCAR O ELIMINARR
    public usuariosJB(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    //INSERTAR Y MODIFICAR
    public usuariosJB(String usuario, String nombre, String apellido, String direccion, String email, String contraseña, Date fechaNac) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaNac = fechaNac;
    }

    //MOSTRAR
    public usuariosJB(int ID_usuario, String usuario, String nombre, String apellido, String direccion, String email, String contraseña, Date fechaNac) {
        this.ID_usuario = ID_usuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.contraseña = contraseña;
        this.fechaNac = fechaNac;
    }


    //METDOS SET Y GET
    public int getId_usuario() {
        return ID_usuario;
    }

    public void setId_cliente(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getfechaNac() {
        return fechaNac;
    }

    public void setfechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

}
