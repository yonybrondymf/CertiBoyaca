package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsuarios extends Conexion {

    public boolean registrar(Usuarios usu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO usuarios(nombres,apellidos,identificacion,direccion,telefono,usuario,password,perfil_id,fecha_registro) VALUES(?,?,?,?,?,?,?,?,?)";
            // String sql = "INSERT INTO ciudadanos(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,identificacion,departamento_id,municipio_id,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getNombres());
            ps.setString(2, usu.getApellidos());
            ps.setString(3, usu.getIdentificacion());
            ps.setString(4, usu.getDireccion());
            ps.setString(5, usu.getTelefono());
            ps.setString(6, usu.getUsuario());
            ps.setString(7, usu.getPassword());
            ps.setInt(8, usu.getPerfil());
            ps.setString(9, usu.getFecha());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    public boolean actualizar(Usuarios usu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;

            String sql = "UPDATE usuarios SET nombres = ?, apellidos = ?, identificacion = ?, direccion = ?, telefono = ?, "
                    + "usuario = ?, password = ?, perfil_id = ? WHERE id = ?";
            // String sql = "INSERT INTO ciudadanos(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,identificacion,departamento_id,municipio_id,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);
            
            ps.setString(1, usu.getNombres());
            ps.setString(2, usu.getApellidos());
            ps.setString(3, usu.getIdentificacion());
            ps.setString(4, usu.getDireccion());
            ps.setString(5, usu.getTelefono());
            ps.setString(6, usu.getUsuario());
            ps.setString(7, usu.getPassword());
            ps.setInt(8, usu.getPerfil());
            ps.setInt(9, usu.getId());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }


    public boolean login(Usuarios usu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM usuarios WHERE usuario = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (usu.getPassword().equals(rs.getString("password"))) {
                    usu.setId(rs.getInt("id"));
                    usu.setPerfil(rs.getInt("perfil_id"));
                    return true;
                } else {
                    return false;
                }

            }

            return false;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    
     public boolean buscar(Usuarios usu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT * FROM usuarios WHERE identificacion = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                usu.setId(rs.getInt("id"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setIdentificacion(rs.getString("identificacion"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setPerfil(rs.getInt("perfil_id"));
                usu.setPassword(rs.getString("password"));
                return true;
            }

            return false;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    

}
