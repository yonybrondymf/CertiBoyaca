package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Perfiles {

    private int id;
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.perfil;
    }

    public Vector<Perfiles> mostrarPerfiles() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Perfiles> datos = new Vector<Perfiles>();
        Perfiles dat = null;

        try {
            String sql = "SELECT * FROM perfiles";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Perfiles();

            dat.setId(0);
            dat.setPerfil("Seleccione Cargo");
            datos.add(dat);

            while (rs.next()) {
                dat = new Perfiles();

                dat.setId(rs.getInt("id"));
                dat.setPerfil(rs.getString("nombre"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return datos;
    }
}
