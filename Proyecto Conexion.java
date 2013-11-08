package proyecto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vanessa 
 */
public class Conexion {

    public Connection conexion;
    private static Conexion INSTANCE = new Conexion();

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sw_mantenimiento", "root", "karem");
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
    }
    

    public static Conexion obtenerConexion() {
        if (INSTANCE == null) {
            INSTANCE = new Conexion();
        }
        return INSTANCE;
    }

    public Connection getConexion() {
        return conexion;
    }
//    public static Connection getConexion1() {
//        return conexion;
//    }
}
