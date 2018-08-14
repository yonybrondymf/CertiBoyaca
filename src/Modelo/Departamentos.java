
package Modelo;

import ConectorBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Departamentos {
    private int id;
    private String departamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String toString() {
        return this.departamento;
    }
    
    public Vector<Departamentos> mostrarDepartamentos() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Departamentos> datos = new Vector<Departamentos>();
        Departamentos dat = null;

        try {
            String sql = "SELECT * FROM departamentos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Departamentos();

            dat.setId(0);
            dat.setDepartamento("Seleccione departamento");
            datos.add(dat);

            while (rs.next()) {
                dat = new Departamentos();

                dat.setId(rs.getInt("id"));
                dat.setDepartamento(rs.getString("nombre"));
                datos.add(dat);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        return datos;
    }
}
