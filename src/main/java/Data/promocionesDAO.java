package Data;



import Modelo.*;

import java.sql.*;
import java.util.*;
import java.sql.Date;
public class promocionesDAO {

    public static final String select = "Select * from promociones order by ID_promocion";
    public static final String insert="insert into promociones(ID_producto,promocion, fecha_promocion) values (?,?,?)";
    public static final String delete="delete from promociones where ID_promocion=?";
    public static final String modificar="Update promociones set ID_producto=?,promocion=?, fecha_promocion=? where ID_promocion=?";

    //MOSTRAR
    public List<promocionesJB> selecciona()
    {
        Statement st ;
        ResultSet rs ;
        promocionesJB promo;

        List<promocionesJB> promociones = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_promocion = rs.getInt("ID_promocion");
                int ID_producto = rs.getInt("ID_prodcuto");
                String promocion = rs.getString("promocion");
                Date fecha_promocion = rs.getDate("fecha promocion");

                promo = new promocionesJB (ID_promocion,ID_producto,promocion,fecha_promocion);
                promociones.add(promo);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promociones;
    }

    //INSETAR
    public int insertar(promocionesJB promociones) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setInt(1, promociones.getId_producto());
            st.setString(2, promociones.getPromocion());
            st.setDate(3, promociones.getFecha_promocion());

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

    public void modificar(promocionesJB promoci)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setInt(1, promoci.getId_producto());
            st.setString(2, promoci.getPromocion());
            st.setDate(3, promoci.getFecha_promocion());
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
    public void borrar(promocionesJB promoci)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,promoci.getId_promocion());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public promocionesJB listarId(int ID)
    {
        promocionesJB prom=null;
        String sql="Select * from promociones where ID_promocion="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_promocion = rs.getInt("ID_promocion");
                int ID_producto = rs.getInt("ID_prodcuto");
                String promocion = rs.getString("promocion");
                Date fecha_promocion = rs.getDate("fecha promocion");

                prom = new promocionesJB (ID_promocion,ID_producto,promocion,fecha_promocion );

            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prom;
    }

}
