
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

public class Pieza {
    
    public int cod_pieza;
    public String nom_pieza;
    public String marca;
    public String pieza_maquina;
  
  
   
    Conexion conexion;
    
//----------------------------- CONSTRUCTOR ------------------------------//

    public Pieza() {
         conexion = Conexion.obtenerConexion();
    }

    public Pieza(int cod_pieza) {
        this.cod_pieza = cod_pieza;
    }
    
    public Pieza(int cod_pieza, String nom_pieza, String marca, String pieza_maquina) {
        this.cod_pieza = cod_pieza ;
        this.nom_pieza = nom_pieza;
        this.marca = marca;
        this.pieza_maquina = pieza_maquina;
      
    }

    public void setCod_pieza(int cod_pieza) {
        this.cod_pieza = cod_pieza;
    }

    public int getCod_pieza() {
        return cod_pieza;
    }

    public String getNom_pieza() {
        return nom_pieza;
    }

    public void setNom_pieza(String nom_pieza) {
        this.nom_pieza = nom_pieza;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setPieza_maquina(String pieza_maquina) {
        this.pieza_maquina = pieza_maquina;
    }

    public String getPieza_maquina() {
        return pieza_maquina;
    }

   

    
 
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer insertar() {
        Integer cod_pieza = 0;
        Statement stmt;
        ResultSet rs;
        try {

            String SQL = "SELECT * FROM piezas;";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.moveToInsertRow();
            rs.updateString("nom_pieza", nom_pieza);
            rs.updateString("marca", marca);
            rs.updateString("pieza_maquina", pieza_maquina);
            rs.insertRow();
            rs.last();
            cod_pieza = rs.getInt("cod_pieza");

        } catch (Exception e) {
            System.out.print("ERROR AL INSERTAR" + " " + e.getMessage());
        }
        return cod_pieza;
    }
    ////--------------------------- MODIFICAR -----------------------------------//
//    
    public void modificar() {

        Statement stmt = null;
        ResultSet rs = null;

        try {

            String SQL = "SELECT * FROM piezas WHERE cod_pieza=" + cod_pieza;
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.updateString("nom_pieza", nom_pieza);
            rs.updateString("marca", marca);
            rs.updateString("pieza_maquina", pieza_maquina);
            rs.updateRow();

        } catch (Exception e) {
            System.out.print("ERROR AL MODIFICAR" + " " + e.getMessage());
        }
    }

//////--------------------------- ELIMINAR -----------------------------------//
    
    public void eliminar() {

        Statement stmt = null;
        ResultSet rs = null;

        try {

            String SQL = "SELECT * FROM piezas WHERE cod_pieza=" + cod_pieza;
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.deleteRow();

        } catch (Exception e) {
            System.out.print("ERROR AL ELIMINAR" + " " + e.getMessage());
        }
    }

// //--------------------------- LISTAR -----------------------------------//
    
    public ArrayList<Pieza> listar() {

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Pieza> listaPieza = new ArrayList<Pieza>();

        try {
            String SQL = "SELECT * FROM piezas;";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Pieza d = new Pieza();
                d.cod_pieza= rs.getInt("cod_pieza");
                d.nom_pieza = rs.getString("nom_pieza");
                d.marca = rs.getString("marca");
                d.pieza_maquina = rs.getString("pieza_maquina");
                listaPieza.add(d);
            }
            return listaPieza;

        } catch (Exception e) {
            System.out.print("ERROR AL LISTAR" + " " + e.getMessage());
        }
        return null;
    }
//    
////--------------------------- BUSCAR -----------------------------------//    

    public boolean obtener(int cod_pieza) {
        
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT * FROM piezas where cod_pieza= " + cod_pieza+ ";";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();

            this.setCod_pieza(rs.getInt("cod_pieza"));
            this.setNom_pieza(rs.getString("nombre"));
            this.setMarca(rs.getString("marca"));
            this.setPieza_maquina(rs.getString("pieza_maquina"));
        } 
        catch (SQLException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
 
}

