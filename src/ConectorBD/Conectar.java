
package ConectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ALC_PTO_BOY
 */
public class Conectar {
    
    private static Connection conn;
    private static final String driver = "conn.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/bdcertiboyaca";

    public Conectar() {
        conn = null;
        try {
           Class.forName (driver);
           conn = DriverManager.getConnection(url, user, password);
           if (conn != null){
               System.out.println ("conexión establecida");
           }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println ("error al conectar" + e);
        }
        
    }
    
   //con este metodo me retorna la conexión// 
public Connection getConnection () {
   return conn;

}

//con este metodo me conecto a la base de datos//
public void descocetar () {
    conn = null;
    if (conn == null) {
        System.out.println ("Conexión terminada");
    } else {
    }
}



}




