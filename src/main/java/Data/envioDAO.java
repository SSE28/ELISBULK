package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.sql.Date;
import java.util.*;

public class envioDAO {

    public static final String select = "Select * from envio order by ID_envio";
    public static final String insert="insert into envio(fecha_envio,fecha_entrega, recibio) values (?,?,?)";
    public static final String delete="delete from envio where ID_envio=?";
    public static final String modificar="Update envio set fecha_entrega=?, recibio=? where ID_envio=?";

    //MOSTRAR
    public List<envioJB> selecciona()
    {
        Statement st ;
        ResultSet rs ;
        envioJB env;

        List<envioJB> envio = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_envio = rs.getInt("ID_envio");
                Date fecha_envio = rs.getDate("fecha envio");
                Date fecha_entrega = rs.getDate("fecha entrega");
                String recibio = rs.getString("recibio");

                env = new envioJB (ID_envio,fecha_envio,fecha_entrega,recibio );
                envio.add(env);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return envio;
    }

    //INSETAR
    public int insertar(envioJB envi) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setDate(1, envi.getFecha_envio());
            st.setDate(2, envi.getFecha_entrega());
            st.setString(3,envi.getRecibio());


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

    public void modificar(envioJB envi)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setDate(1,envi.getFecha_entrega());
            st.setString(2, envi.getRecibio());

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
    public void borrar(envioJB envi)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,envi.getId_envio());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public envioJB listarId(int ID)
    {
        envioJB envios=null;
        String sql="Select * from envio where ID_envio="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_envio = rs.getInt("ID_comentario");
                Date fecha_envio=rs.getDate("fecha comnetario");
                Date fecha_entrega=rs.getDate("fecha comnetario");
                String recibio = rs.getString("comentario");
                envios=new envioJB(ID_envio,fecha_envio,fecha_entrega,recibio);
            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return envios;
    }

}