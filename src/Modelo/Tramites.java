package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Tramites {

    private int id;
    private String tramite;

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.tramite;
    }

    public Vector<Tramites> mostrarTramites() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Tramites> datos = new Vector<Tramites>();
        Tramites dat = null;

        try {
            String sql = "SELECT * FROM tramites";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Tramites();
            dat.setId(0);
            dat.setTramite("Seleccione Tramite");
            datos.add(dat);

            while (rs.next()) {
                dat = new Tramites();

                dat.setId(rs.getInt("id"));
                dat.setTramite(rs.getString("nombre"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return datos;
    }
}
