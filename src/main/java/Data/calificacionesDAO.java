package Data;

import Modelo.calificacionesJB;

import java.sql.Date;

import java.sql.*;
import java.util.*;

public class calificacionesDAO {
    public static final String select = "Select * from calificaciones order by calificaciones";
    public static final String insert="insert into calificaciones(calificacion, ID_usuario, ID_producto) values (?,?,?)";
    public static final String delete="delete from calificaciones where ID_calificacion=?";
    public static final String modificar="Update calificaciones set calificacion, ID_usuario,ID_producto";

    //MOSTRAR

    public List<calificacionesJB> Select()
    {
        Statement st ;
        ResultSet rs ;
        calificacionesJB calif;

        List<calificacionesJB> calificaciones = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_calificacion = rs.getInt("ID_calificacion");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_producto");
                int calificacion = rs.getInt("calificacion");
                Date fecha_calificacion = rs.getDate("fecha_compra");

                calif = new calificacionesJB(ID_calificacion,ID_usuario,  ID_producto, calificacion, fecha_calificacion);
                calificaciones.add(calif);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calificaciones;
    }
    //INSETAR
    public void insertar(calificacionesJB calificaciones) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setInt(1,calificaciones.getID_usuario());
            st.setInt(2,calificaciones.getID_producto());
            st.setInt(3,calificaciones.getCalificacion());

            if (st.executeUpdate()==1)
                System.out.println("Registro Exitoso");

            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //MOFIICAR

    public void modificar(calificacionesJB calificaciones)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setInt(1,calificaciones.getID_usuario());
            st.setInt(2,calificaciones.getID_producto());
            st.setInt(3,calificaciones.getCalificacion());

            if(st.executeUpdate()==1)
                System.out.println("Registro Actualizado");

            Conexion.close(con);
            Conexion.close(st);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

    }

    //BORRAR
    public void borrar(calificacionesJB calificaciones)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,calificaciones.getID_calificacion());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
