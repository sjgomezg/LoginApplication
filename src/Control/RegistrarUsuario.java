/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import java.util.ArrayList;

/**
 *
 * @author SantiagoJGG
 */
public class RegistrarUsuario {
    
    private UsuarioDAO dao = new UsuarioDAO();
    
    public RegistrarUsuario(){
        
    }
    
    public String registrar(Usuario usuario,String rPassword){
        
        if(!verificarLongitudNombre(usuario.getNombre()))
            return("Longitud de nombre incorrecta");
        
        if(dao.buscarNombre(usuario).getNombre()!= null){
            return("El usuario ya existe");
        }
        
        if(!verificarPassword(usuario.getPassword()))
            return("Longitud de contraseña incorrecta");
        
        if(!usuario.getPassword().equals(rPassword))
            return("Las contraseñas no coinciden");
        

        dao.crear(usuario);
        return("Usuario Registrado con exito");
    }
    
    public boolean verificarLongitudNombre(String password) {
        return (password.length() > 1 && password.length() <= 6);
    }

    public boolean verificarPassword(String password) {
        return(password.length()>=3 && password.length() < 6);
    }
    
    
}
