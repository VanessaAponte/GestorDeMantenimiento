/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author Vanessa 
 */
public class CConexion {

    public static Conexion conexion;

    public static Conexion obtenerConexion(){
        if (conexion==null) {
            conexion=new Conexion();
        }
        return conexion;
    }

}
