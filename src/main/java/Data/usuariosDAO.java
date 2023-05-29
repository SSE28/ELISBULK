package Data;

import Modelo.usuariosJB;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class usuariosDAO {
    public static final String select = "Select * from usuarios order by ID_usuarios";
    public static final String insert="insert into usuarios(usuario,nombre,apellido,direccion,email,contraseña,fechaNac) values (?,?,?,?,?,?,?)";
    public static final String delete="delete from usuarios where ID_usuario=?";
    public static final String modificar="Update usuarios set usuario=?,nombre=?,apellido=?,direccion=?,email=?,contraseña=?,fechaNac=? where ID_usuario=?";
    public static final String valida="select * from usuarios where email=? and contraseña=?";

    //VALIDAR USUARIO Y CONTRASEÑA
    public usuariosJB valida(String email, String contraseña) {
        PreparedStatement st;
        ResultSet rs;
        usuariosJB usuari=null;

        try{
            Connection con=Conexion.getConnection();
            assert con!= null;
            st=con.prepareStatement(valida);
            st.setString(1,email);
            st.setString(2,contraseña);
            rs=st.executeQuery();
            while(rs.next());
            {
                String usuario= rs.getString("usuario");
                String email=rs.getString("email");
                String contraseña=rs.getString("contraseña");
                usuari=new usuariosJB(usuario,email,contraseña);
            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return usuari;
    }

    //MOSTRAR

    public List<usuariosJB> Select()
    {
        Statement st ;
        ResultSet rs ;
        usuariosJB use;

        List<usuariosJB> usuarios = new ArrayList<>();

        try {
            Connection con = Conexion.getConnection();
            assert con != null;
            st = con.createStatement();
            rs = st.executeQuery(select);

            while (rs.next()) {
                int ID_usuario = rs.getInt("ID_categoria");
                String usuario = rs.getString("usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("appellido");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String contraseña = rs.getString("contraseña");
                Date fechaNac = rs.getDate("fechaNac");

                use = new usuariosJB(ID_usuario,usuario,  nombre,  apellido,direccion,email, contraseña,  fechaNac);
                usuarios.add(use);

            }
            Conexion.close(st);
            Conexion.close(rs);
            Conexion.close(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }


    //INSETAR
    public void insertar(usuariosJB usuarios) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setString(1,usuarios.getUsuario());
            st.setString(2,usuarios.getNombre());
            st.setString(3,usuarios.getApellido());
            st.setString(4,usuarios.getDireccion());
            st.setString(5,usuarios.getEmail());
            st.setString(6,usuarios.getContraseña());
            st.setDate(7,usuarios.getfechaNac());

            if (st.executeUpdate()==1)
                System.out.println("Registro Exitoso");

            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //MOFIICAR

    public void modificar(usuariosJB usuarios)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(modificar);

            st.setString(1,usuarios.getUsuario());
            st.setString(2,usuarios.getNombre());
            st.setString(3,usuarios.getApellido());
            st.setString(4,usuarios.getDireccion());
            st.setString(5,usuarios.getEmail());
            st.setString(6,usuarios.getContraseña());
            st.setDate(7,usuarios.getfechaNac());

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
    public void borrar(usuariosJB usuarios)
    {
        Connection con;
        PreparedStatement st;

        try{
            con=Conexion.getConnection();
            assert con != null;
            st=con.prepareStatement(delete);

            st.setInt(1,usuarios.getId_usuario());

            if(st.executeUpdate()==1)
                System.out.println("Registro Eliminado");

            Conexion.close(con);
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
