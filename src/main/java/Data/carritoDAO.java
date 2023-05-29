package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.util.*;

public class carritoDAO {

    public static final String select = "Select * from carrito order by carrito";
    public static final String insert="insert into carrito(ID_producto,cantidad_precion,subtotal) values (?,?,?,?)";
    public static final String delete="delete from carrito where ID_carrito=?";
    public static final String modificar="Update carrito set precio,subtotal";

    //MOSTRAR
    public List<carritoJB> Select()
    {
        Statement st ;
        ResultSet rs ;
        carritoJB carr;

        List<carritoJB> carrito = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_carrito = rs.getInt("ID_carrito");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_producto");
                float cantidad = rs.getFloat("cantidad");
                float precio = rs.getFloat("precio");
                float subtotal = rs.getFloat("subtotal");

                carr = new carritoJB (ID_carrito,ID_usuario, ID_producto,cantidad, precio,subtotal );
                carrito.add(carr);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrito;
    }

    //INSETAR
    public int insertar(carritoJB carrito) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setInt(1, carrito.getId_producto());
            st.setFloat(2, carrito.getCantidad());
            st.setFloat(3, carrito.getPrecio());
            st.setFloat(4, carrito.getSubtotal());

            if (st.executeUpdate() == 1)
                System.out.println("Registro Exitoso");

            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    //MOFIICAR

    public void modificar(carritoJB carrito)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setFloat(1,carrito.getPrecio());
            st.setFloat(2,carrito.getSubtotal());

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
    public void borrar(carritoJB carrito)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,carrito.getID_carrito());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
