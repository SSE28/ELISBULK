package Data;

import Modelo.usuariosJB;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class usuariosDAO {
    public static final String select = "Select * from usuarios order by ID_usuario";
    public static final String insert="insert into usuarios(usuario,nombre,apellido,direccion,zip,email,contraseña,fechaNac) values (?,?,?,?,?,?,?,?)";
    public static final String delete="delete from usuarios where ID_usuario=?";
    public static final String modificar="Update usuarios set usuario=?,nombre=?,apellido=?,direccion=?,zip=?,email=?,contraseña=?,fechaNac=? where ID_usuario=?";
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
                email = rs.getString("email");
                contraseña=rs.getString("contraseña");
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

    //MOSTRAR/SELECCIONAR

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
                int zip = rs.getInt("codigo postal");
                String email = rs.getString("email");
                String contraseña = rs.getString("contraseña");
                Date fechaNac = rs.getDate("fechaNac");

                use = new usuariosJB(ID_usuario,usuario,  nombre,  apellido,direccion,zip,email, contraseña,  fechaNac);
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
    public int insertar(usuariosJB usuarios) {

        Connection con;
        PreparedStatement st;

        try {
            con = Conexion.getConnection();
            assert con != null;
            st = con.prepareStatement(insert);
            st.setString(1, usuarios.getUsuario());
            st.setString(2, usuarios.getNombre());
            st.setString(3, usuarios.getApellido());
            st.setString(4, usuarios.getDireccion());
            st.setInt(5, usuarios.getZip());
            st.setString(6, usuarios.getEmail());
            st.setString(7, usuarios.getContraseña());
            st.setDate(8, usuarios.getfechaNac());

            if (st.executeUpdate() == 1) {
                System.out.println("Registro Exitoso");
                return 1;
            }
            Conexion.close(con);
            Conexion.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
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
            st.setInt(5, usuarios.getZip());
            st.setString(6,usuarios.getEmail());
            st.setString(7,usuarios.getContraseña());
            st.setDate(8,usuarios.getfechaNac());

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

    //BUSCA
    public usuariosJB listarId(int ID)
    {
        usuariosJB usuari=null;
        String sql="Select * from usuarios where ID_usuario="+ID;
        Connection conecta;
        PreparedStatement st;
        ResultSet rs;

        try{
            conecta=Conexion.getConnection();
            assert conecta != null;
            st=conecta.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){

                int ID_usuario = rs.getInt("ID_usuario");
                String usuario = rs.getString("usuario");
                String nombre=rs.getString("nombre");
                String apellido =rs.getString("apellido");
                String direccion=rs.getString("direccion");
                int zip= rs.getInt("codigo postal");
                String email=rs.getString("email");
                String contraseña=rs.getString("contraseña");
                Date fechaNac=rs.getDate("fechaNaci");
                usuari=new usuariosJB(ID_usuario,usuario, nombre, apellido, direccion,zip,email,contraseña,fechaNac);
            }
            Conexion.close(conecta);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuari;
    }

}
