package Data;

import Modelo.*;

import java.sql.*;
//import java.sql.Date;
import java.util.*;

public class categoriasDAO {
    public static final String select = "Select * from categorias order by categorias";
    public static final String insert="insert into categorias(nombre_cat) values (?)";
    public static final String delete="delete from categorias where ID_categoria=?";
    public static final String modificar="Update categorias set ID_categoria, nombre_cate";

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

    //MOFIICAR

    public void modificar(categoriasJB categorias)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setString(1,categorias.getNombre_cate());
            st.setInt(2,categorias.getId_categoria());

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

    public categoriasJB listarId(int id)
    {
        categoriasJB cat=new categoriasJB();
        String sql="Select * from categoria where ID_categoria="+id;
        Connection conec;
        PreparedStatement st;
        ResultSet rs;
        try{
            conec=Conexion.getConnection();
            assert conec != null;
            st=conec.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                cat.setNombre_cate(rs.getString(2));
            }
            Conexion.close(conec);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cat;
    }

}
