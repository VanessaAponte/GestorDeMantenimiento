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

public class Maquina {
    
    public int cod_maquina;
    public String num_serie;
    public String nom_maquina;
    public String modelo;
    public String marca;
    public String industria;
  
   
    Conexion conexion;
    
//----------------------------- CONSTRUCTOR ------------------------------//

    public Maquina() {
         conexion = Conexion.obtenerConexion();
    }

    public Maquina(int cod_maquina) {
        this.cod_maquina = cod_maquina;
    }
    
    public Maquina(int cod_maquina, String num_serie, String nom_maquina, String modelo, String marca, String industria) {
        this.cod_maquina = cod_maquina ;
        this.num_serie = num_serie;
        this.nom_maquina = nom_maquina;
        this.modelo = modelo;
        this.marca = marca;
        this.industria = industria;
      
    }

    public void setCod_maquina(int cod_maquina) {
        this.cod_maquina = cod_maquina;
    }

    public int getCod_maquina() {
        return cod_maquina;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public String getNom_maquina() {
        return nom_maquina;
    }

    public void setNom_maquina(String nom_maquina) {
        this.nom_maquina = nom_maquina;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public String getIndustria() {
        return industria;
    }

   

    
 
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer insertar() {
        Integer cod_maquina = 0;
        Statement stmt;
        ResultSet rs;
        try {

            String SQL = "SELECT * FROM maquina;";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.moveToInsertRow();
            rs.updateString("num_serie", num_serie);
            rs.updateString("nom_maquina", nom_maquina);
            rs.updateString("modelo", modelo);
            rs.updateString("marca", marca);
            rs.updateString("industria", industria);
            rs.insertRow();
            rs.last();
            cod_maquina = rs.getInt("cod_maquina");

        } catch (Exception e) {
            System.out.print("ERROR AL INSERTAR" + " " + e.getMessage());
        }
        return cod_maquina;
    }
    ////--------------------------- MODIFICAR -----------------------------------//
//    
    public void modificar() {

        Statement stmt = null;
        ResultSet rs = null;

        try {

            String SQL = "SELECT * FROM maquina WHERE cod_maquina=" + cod_maquina;
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.updateString("num_serie", num_serie);
            rs.updateString("nom_maquina", nom_maquina);
            rs.updateString("modelo", modelo);
            rs.updateString("marca", marca);
            rs.updateString("industria", industria);
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

            String SQL = "SELECT * FROM maquina WHERE cod_maquina=" + cod_maquina;
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();
            rs.deleteRow();

        } catch (Exception e) {
            System.out.print("ERROR AL ELIMINAR" + " " + e.getMessage());
        }
    }

// //--------------------------- LISTAR -----------------------------------//
    
    public ArrayList<Maquina> listar() {

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Maquina> listaMaquina = new ArrayList<Maquina>();

        try {
            String SQL = "SELECT * FROM maquina;";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Maquina d = new Maquina();
                d.cod_maquina= rs.getInt("cod_maquina");
                d.num_serie = rs.getString("num_serie");
                d.nom_maquina = rs.getString("nom_maquina");
                d.modelo = rs.getString("modelo");
                d.marca = rs.getString("marca");
                d.industria = rs.getString("industria");
                listaMaquina.add(d);
            }
            return listaMaquina;

        } catch (Exception e) {
            System.out.print("ERROR AL LISTAR" + " " + e.getMessage());
        }
        return null;
    }
//    
////--------------------------- BUSCAR -----------------------------------//    

    public boolean obtener(int cod_maquina) {
        
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT * FROM maquina where cod_maquina= " + cod_maquina+ ";";
            stmt = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(SQL);
            rs.first();

            this.setCod_maquina(rs.getInt("cod_maquina"));
            this.setNum_serie(rs.getString("num_serie"));
            this.setNom_maquina(rs.getString("nombre"));
            this.setModelo(rs.getString("modelo"));
            this.setMarca(rs.getString("marca"));
            this.setIndustria(rs.getString("industria"));
        } 
        catch (SQLException ex) {
            Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
 
}

