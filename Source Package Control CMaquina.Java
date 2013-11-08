/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Maquina;
import java.util.List;

/**
 *
 * @author Vanessa/Sergio
 */

public class CMaquina {
    
    Maquina maquina;

//----------------------------- CONSTRUCTOR ------------------------------//

    public CMaquina() {
        maquina = new Maquina();
    }

    public void setMaquina(Maquina maquina) {
        this.maquina= maquina;
    }

    public Maquina getMaquina() {
        return maquina;
    }
    
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer registrar(String num_serie, String nom_maquina, String modelo, String marca, String industria) {
        maquina.setNum_serie(num_serie);
        maquina.setNom_maquina(nom_maquina);
        maquina.setModelo(modelo);
        maquina.setMarca(marca);
        maquina.setIndustria(industria);
      
        Integer cod_maquina = maquina.insertar();
        return cod_maquina;
    }
    
 //--------------------------- MODIFICAR -----------------------------------//
    
    public void modificar(int cod_maquina,String num_serie, String nom_maquina, String modelo, String marca, String industria) {
        maquina.setCod_maquina(cod_maquina);
        maquina.setNum_serie(num_serie);
        maquina.setNom_maquina(nom_maquina);
        maquina.setModelo(modelo);
        maquina.setMarca(marca);
        maquina.setIndustria(industria);
        maquina.modificar();
    }
   
// //--------------------------- ELIMINAR -----------------------------------//
    
    public void eliminar(int cod_maquina){
        maquina.setCod_maquina(cod_maquina);
        maquina.eliminar();
    }
  
 // //--------------------------- LISTAR -----------------------------------//
    
    public List ObtenerLista(){
        List lista = maquina.listar();
        return lista;
    }    

//--------------------------- BUSCAR POR CODIGO -----------------------------//
    
    public Maquina buscar(int cod_maquina){
        maquina.setCod_maquina(cod_maquina);
        boolean encontro = maquina.obtener(cod_maquina);
        if(encontro){
            return maquina;
        }else{
            return null;
        }
    }    
}
