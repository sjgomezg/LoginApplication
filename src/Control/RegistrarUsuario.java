/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import java.util.ArrayList;

/**
 *
 * @author SantiagoJGG
 */
public class RegistrarUsuario {
    
    private Sistema sistema = FramePrincipal.sistema;
    
    public RegistrarUsuario(){
        
    }
    
    public String registrar(Usuario usuario,String rPassword){
        
        if(!verificarLongitudNombre(usuario.getNombre()))
            return("Longitud de nombre incorrecta");
        
        ArrayList <Usuario> usuarios = sistema.getUsuarios();
        for(Usuario u: sistema.getUsuarios()){
            if(usuario.getNombre().equals(u.getNombre()))
                return("El usuario ya existe");
        }
                
        if(!verificarPassword(usuario.getPassword()))
            return("Longitud de contraseña incorrecta");
        
        if(!usuario.getPassword().equals(rPassword))
            return("Las contraseñas no coinciden");
        

        usuarios.add(usuario);
        sistema.setUsuarios(usuarios);
        return("Usuario Registrado con exito");
    }
    
    public boolean verificarLongitudNombre(String password) {
        return (password.length() > 1 && password.length() <= 6);
    }

    public boolean verificarPassword(String password) {
        return(password.length()>=3 && password.length() < 6);
    }
    
    
}
