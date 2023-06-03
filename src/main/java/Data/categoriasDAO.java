package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.sql.Date;
import java.util.*;

public class categoriasDAO {
    public static final String select = "Select * from categorias order by ID_categoria";
    public static final String insert="insert into categorias(nombre_cat) values (?)";
    public static final String delete="delete from categorias where ID_categoria=?";
    public static final String modificar="Update categorias set nombre_cate=? where ID_categoria=?";

    //MOSTRAR

    public List<categoriasJB> Select()
    {
        Statement st ;
        ResultSet rs ;
        categoriasJB cate;

        List<categoriasJB> categoria = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_categoria = rs.getInt("ID_categoria");
                String nombre_cate = rs.getString("nombre_cate");

                cate = new categoriasJB (ID_categoria, nombre_cate);
                categoria.add(cate);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria;
    }

    //INSETAR
    public void insertar(categoriasJB categoria) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setString(1,categoria.getNombre_cate());

            if (st.executeUpdate()==1)
                System.out.println("Registro Exitoso");

            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MODFICAR

    public void modificar(categoriasJB categorias)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setString(1,categorias.getNombre_cate());
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
    public void borrar(categoriasJB categoria)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,categoria.getId_categoria());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //BUSCA
    public categoriasJB listarId(int ID)
    {
        categoriasJB cate=null;
        String sql="Select * from categoria where ID_categoria="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_categoria = rs.getInt("ID_categoria");
                String nombre_cate = rs.getString("nombre categoria");

                cate=new categoriasJB(ID_categoria, nombre_cate);
            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cate;
    }

}
