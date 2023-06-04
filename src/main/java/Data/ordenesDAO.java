package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.sql.Date;
import java.util.*;

public class ordenesDAO {

    public static final String select = "Select * from ordenes order by ID_orden";
    public static final String insert="insert into ordenes(ID_usuario,ID_producto,fecha_compra,cantidad,precio,direccion_envio,estado) values (?,?,?,?,?,?,?)";
    public static final String delete="delete from ordenes where ID_orden=?";
    public static final String modificar="Update ordenes set ID_usuario=?,ID_producto=?,fecha_compra=?,cantidad=?,precio=?,direccion_envio=?,estado=? where ID_orden=?";

    //MOSTRAR
    public List<ordenesJB> selecciona()
    {
        Statement st ;
        ResultSet rs ;
        ordenesJB ord;

        List<ordenesJB> ordenes = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_orden = rs.getInt("ID_orden");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_prodcuto");
                Date fecha_compra = rs.getDate("fecha compra");
                Float cantidad = rs.getFloat("cantidad");
                Float precio = rs.getFloat("precio");
                String direccion_envio = rs.getString("direccion envio");
                String estado = rs.getString("estado");
                Float subtotal = rs.getFloat("subtotal");

                ord = new ordenesJB (ID_orden, ID_usuario,ID_producto, fecha_compra,cantidad,precio,direccion_envio,estado,subtotal);
                ordenes.add(ord);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordenes;
    }

    //INSETAR
    public int insertar(ordenesJB orden) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setInt(1, orden.getId_usuario());
            st.setInt(2, orden.getId_producto());
            st.setDate(3, orden.getFechacompra());
            st.setFloat(4, orden.getCantidad());
            st.setFloat(5,orden.getPrecio());
            st.setString(6, orden.getDireccionenvio());
            st.setString(7, orden.getestado());


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

    public void modificar(ordenesJB orden)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setInt(1, orden.getId_usuario());
            st.setInt(2, orden.getId_producto());
            st.setDate(3, orden.getFechacompra());
            st.setFloat(4, orden.getCantidad());
            st.setFloat(5,orden.getPrecio());
            st.setString(6, orden.getDireccionenvio());
            st.setString(7, orden.getestado());
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
    public void borrar(ordenesJB orden)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,orden.getId_orden());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public ordenesJB listarId(int ID)
    {
        ordenesJB orde=null;
        String sql="Select * from ordenes where ID_orden="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_orden = rs.getInt("ID_orden");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_prodcuto");
                Date fecha_compra = rs.getDate("fecha compra");
                Float cantidad = rs.getFloat("cantidad");
                Float precio = rs.getFloat("precio");
                String direccion_envio = rs.getString("direccion envio");
                String estado = rs.getString("estado");
                Float subtotal = rs.getFloat("subtotal");

                orde = new ordenesJB (ID_orden, ID_usuario,ID_producto, fecha_compra,cantidad,precio,direccion_envio,estado,subtotal);

            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orde;
    }

}
