package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.sql.Date;
import java.util.*;

public class comentariosDAO {

    public static final String select = "Select * from comentarios order by ID_comentario";
    public static final String insert="insert into comentarios(ID_producto,cantidad_precion,subtotal) values (?,?,?,?)";
    public static final String delete="delete from comentarios where ID_comentario=?";
    public static final String modificar="Update comentarios set ID_usuario=?, ID_producto=?, comentario=? where ID_comentario=?";

    //MOSTRAR
    public List<comentariosJB> selecciona()
    {
        Statement st ;
        ResultSet rs ;
        comentariosJB com;

        List<comentariosJB> comentarios = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_comentario = rs.getInt("ID_comentario");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_producto");
                String comentario = rs.getString("comentrario");
                Date fecha_comentario = rs.getDate("fecha comentario");

                com = new comentariosJB (ID_comentario,ID_usuario, ID_producto,comentario,fecha_comentario );
                comentarios.add(com);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comentarios;
    }

    //INSETAR
    public int insertar(comentariosJB comenta) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setInt(1, comenta.getId_usuario());
            st.setInt(2, comenta.getId_producto());
            st.setString(3, comenta.getComentario());
            st.setDate(4,comenta.getFecha_comentario());


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

    public void modificar(comentariosJB comenta)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);
            st.setInt(1, comenta.getId_usuario());
            st.setInt(2, comenta.getId_producto());
            st.setString(3, comenta.getComentario());
            st.setDate(4,comenta.getFecha_comentario());

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
    public void borrar(comentariosJB comenta)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,comenta.getId_comentario());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public comentariosJB listarId(int ID)
    {
        comentariosJB coment=null;
        String sql="Select * from comentarios where ID_comentario="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_comentario = rs.getInt("ID_comentario");
                int ID_usuario = rs.getInt("ID_usuario");
                int ID_producto = rs.getInt("ID_producto");
                String comentario = rs.getString("comentario");
                Date fecha_comentario=rs.getDate("fecha comnetario");
                coment=new comentariosJB(ID_comentario,ID_usuario,ID_producto,comentario,fecha_comentario);
            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coment;
    }

}