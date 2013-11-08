/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import datos.Persona;
import java.util.List;

/**
 *
 * @author Vanessa/Sergio
 */

public class CPersona {
    
    Persona persona;

//----------------------------- CONSTRUCTOR ------------------------------//

    public CPersona() {
        persona = new Persona();
    }

    public void setPersona(Persona persona) {
        this.persona= persona;
    }

    public Persona getPersona() {
        return persona;
    }
    
//--------------------------- INSERTAR -----------------------------------//
    
    public Integer registrar(String nom_persona, String apellido, String direccion, String telefono, String ci ) {
        persona.setNom_persona(nom_persona);
        persona.setApellido(apellido);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setCI(ci);
     
        Integer cod_persona = persona.insertar();
        return cod_persona;
    }
    
 //--------------------------- MODIFICAR -----------------------------------//
    
    public void modificar(int cod_persona,String nom_persona, String apellido, String direccion, String telefono, String ci) {
        persona.setCod_persona(cod_persona);
        persona.setNom_persona(nom_persona);
        persona.setApellido(apellido);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setCI(ci);
        
        persona.modificar();
    }
   
// //--------------------------- ELIMINAR -----------------------------------//
    
    public void eliminar(int cod_persona){
        persona.setCod_persona(cod_persona);
        persona.eliminar();
    }
  
 // //--------------------------- LISTAR -----------------------------------//
    
    public List ObtenerLista(){
        List lista = persona.listar();
        return lista;
    }    

//--------------------------- BUSCAR POR CODIGO -----------------------------//
    
    public Persona buscar(int cod_persona){
        persona.setCod_persona(cod_persona);
        boolean encontro = persona.obtener(cod_persona);
        if(encontro){
            return persona;
        }else{
            return null;
        }
    }    
}
