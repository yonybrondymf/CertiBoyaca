package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasCertificados extends Conexion {

    public boolean registrar(Certificados cer) {
        Connection con = getConexion();
        try {
            PreparedStatement ps = null;

            String sql = "INSERT INTO certificados(ciudadano_id,fecha_registro,estado,numero,user_registro) VALUES(?,?,?,?,?)";
            // String sql = "INSERT INTO ciudadanos(primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,identificacion,departamento_id,municipio_id,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, cer.getCiudadano());
            ps.setString(2, cer.getFecha());
            ps.setInt(3, cer.getEstado());
            ps.setString(4, cer.getNum());
            ps.setInt(5, cer.getUserRegistro());
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

}
