package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.Conexion;

/**
 *
 * @author Vanessa 
 */

public class Persona {
    
    public int cod_persona;
    public String nom_persona;
    public String apellido;
    public String direccion;
    public String telefono;
    public String ci;
  
  
   
    Conexion conexion;
    
//----------------------------- CONSTRUCTOR ------------------------------//

    public Persona() {
         conexion = Conexion.obtenerConexion();
    }

    public Persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }
    
    public Persona(int cod_persona, String nom_persona, String apellido, String direccion, String telefono, String ci) {
        this.cod_persona = cod_persona ;
        this.nom_persona = nom_persona;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ci = ci;
      
    }

    public void setCod_persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }

    public int getCod_persona() {
        return cod_persona;
    }

    public String getNom_persona() {
        return nom_persona;
    }

    public void setNom_persona(String nom_persona) {
        this.nom_persona= nom_persona;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    
     public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
     public void setCI(String ci) {
        this.ci= ci;
    }

    public String getCI() {
        return ci;
    }

   
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer insertar() {
        Integer cod_persona = 0;
        Statement stmt;
        ResultSet rs;
        try {

            String SQL = "SELECT * FROM persona;";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.moveToInsertRow();
            rs.updateString("nom_persona", nom_persona);
            rs.updateString("apellido", apellido);
            rs.updateString("direccion", direccion);
            rs.updateString("telefono", telefono);
            rs.updateString("ci", ci);
            rs.insertRow();
            rs.last();
            cod_persona = rs.getInt("cod_persona");

        } catch (Exception e) {
            System.out.print("ERROR AL INSERTAR" + " " + e.getMessage());
        }
        return cod_persona;
    }
