/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Pieza;
import java.util.List;

/**
 *
 * @author Vanessa/Sergio
 */

public class CPieza {
    
    Pieza pieza;

//----------------------------- CONSTRUCTOR ------------------------------//

    public CPieza() {
        pieza = new Pieza();
    }

    public void setPieza(Pieza pieza) {
        this.pieza= pieza;
    }

    public Pieza getPieza() {
        return pieza;
    }
    
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer registrar(String nom_pieza, String marca, String pieza_maquina) {
        pieza.setNom_pieza(nom_pieza);
        pieza.setMarca(marca);
        pieza.setPieza_maquina(pieza_maquina);
     
        Integer cod_pieza = pieza.insertar();
        return cod_pieza;
    }
    
 //--------------------------- MODIFICAR -----------------------------------//
    
    public void modificar(int cod_pieza,String nom_pieza, String marca, String pieza_maquina) {
        pieza.setCod_pieza(cod_pieza);
        pieza.setNom_pieza(nom_pieza);
        pieza.setMarca(marca);
        pieza.setPieza_maquina(pieza_maquina);
        
        pieza.modificar();
    }
   
// //--------------------------- ELIMINAR -----------------------------------//
    
    public void eliminar(int cod_pieza){
        pieza.setCod_pieza(cod_pieza);
        pieza.eliminar();
    }
  
 // //--------------------------- LISTAR -----------------------------------//
    
    public List ObtenerLista(){
        List lista = pieza.listar();
        return lista;
    }    

//--------------------------- BUSCAR POR CODIGO -----------------------------//
    
    public Pieza buscar(int cod_pieza){
        pieza.setCod_pieza(cod_pieza);
        boolean encontro = pieza.obtener(cod_pieza);
        if(encontro){
            return pieza;
        }else{
            return null;
        }
    }    
}
