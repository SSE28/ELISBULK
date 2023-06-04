package Data;


import Modelo.*;

import java.sql.*;
import java.util.*;

public class productosDAO {

    public static final String select = "Select * from productos order by ID_producto";
    public static final String insert="insert into productos(nombre_pro,precio,descripcion,ID_categoria) values (?,?,?,?)";
    public static final String delete="delete from productos where ID_producto=?";
    public static final String modificar="Update prodcutos set nombre_pro=?,precio=?,descripcion=?where ID_producto=?";

    //MOSTRAR
    public List<productoJB> selecciona()
    {
        Statement st ;
        ResultSet rs ;
        productoJB pro;

        List<productoJB> productos = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_producto = rs.getInt("ID_prodcuto");
                String nombre_pro = rs.getString("nombre producto");
                Float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                int ID_categoria = rs.getInt("id categoria");

                pro = new productoJB (ID_producto,nombre_pro, precio,descripcion, ID_categoria);
                productos.add(pro);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    //INSETAR
    public int insertar(productoJB produc) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setString(1, produc.getNombre());
            st.setFloat(2, produc.getprecio());
            st.setString(3, produc.getDescripcion());
            st.setInt(4, produc.getCategoria());

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

    public void modificar(productoJB produc)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setString(1, produc.getNombre());
            st.setFloat(2, produc.getprecio());
            st.setString(3, produc.getDescripcion());
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
    public void borrar(productoJB produc)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,produc.getId_producto());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public productoJB listarId(int ID)
    {
        productoJB product=null;
        String sql="Select * from productos where ID_orden="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_producto = rs.getInt("ID_prodcuto");
                String nombre_pro = rs.getString("nombre producto");
                Float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                int ID_categoria = rs.getInt("ID_categoria");

                product = new productoJB (ID_producto, nombre_pro,precio,descripcion,ID_categoria);

            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
