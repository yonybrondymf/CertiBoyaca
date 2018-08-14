package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Municipios {

    private int id;
    private String municipio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public String toString() {
        return this.municipio;
    }

    public Vector<Municipios> mostrarMunicipios(Integer idDepa) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Municipios> datos = new Vector<Municipios>();
        Municipios dat = null;

        try {
            String sql = "SELECT * FROM municipios WHERE departamento_id="+idDepa;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Municipios();

            dat.setId(0);
            dat.setMunicipio("Seleccione municipio");
            datos.add(dat);

            while (rs.next()) {
                dat = new Municipios();

                dat.setId(rs.getInt("id"));
                dat.setMunicipio(rs.getString("nombre"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return datos;
    }

}
