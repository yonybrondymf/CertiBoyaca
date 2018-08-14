package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCiudadanos extends Conexion {

    public boolean registrar(Ciudadanos ciu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO ciudadanos(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,identificacion,departamento_id,municipio_id,direccion,correo,sisben,certificado_electoral,certificado_jac,otros_soportes,usuario_id,tramite_id,observaciones) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // String sql = "INSERT INTO ciudadanos(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,identificacion,departamento_id,municipio_id,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, ciu.getPrimerNombre());
            ps.setString(2, ciu.getSegundoNombre());
            ps.setString(3, ciu.getPrimerApellido());
            ps.setString(4, ciu.getSegundoApellido());
            ps.setString(5, ciu.getIdentificacion());
            ps.setInt(6, ciu.getDepartamento());
            ps.setInt(7, ciu.getMunicipio());
            ps.setString(8, ciu.getDireccion());
            ps.setString(9, ciu.getCorreo());
            ps.setInt(10, ciu.getSisben());
            ps.setInt(11, ciu.getCertificadoElectoral());
            ps.setInt(12, ciu.getCertificadoJAC());
            ps.setInt(13, ciu.getOtrosSoportes());
            ps.setInt(14, ciu.getUsuario());
            ps.setInt(15,ciu.getTramite());
            ps.setString(16,ciu.getObservacion());
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
    
    public boolean buscar(Ciudadanos ciu) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT c.*, d.nombre as depa, m.nombre as muni FROM ciudadanos c INNER JOIN departamentos d ON c.departamento_id = d.id INNER JOIN municipios m ON c.municipio_id=m.id WHERE identificacion = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, ciu.getIdentificacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                ciu.setId(rs.getInt("id"));
                ciu.setPrimerNombre(rs.getString("primer_nombre"));
                ciu.setSegundoNombre(rs.getString("segundo_nombre"));
                ciu.setPrimerApellido(rs.getString("primer_apellido"));
                ciu.setSegundoApellido(rs.getString("segundo_apellido"));
                ciu.setIdentificacion(rs.getString("identificacion"));
                ciu.setCorreo(rs.getString("correo"));
                ciu.setDireccion(rs.getString("direccion"));
                ciu.setCertificadoJAC(rs.getInt("certificado_jac"));
                ciu.setSisben(rs.getInt("sisben"));
                ciu.setCertificadoElectoral(rs.getInt("certificado_electoral"));
                ciu.setOtrosSoportes(rs.getInt("otros_soportes"));
                ciu.setDp(rs.getString("depa"));
                ciu.setMun(rs.getString("muni"));
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
