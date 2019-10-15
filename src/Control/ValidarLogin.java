/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author SantiagoJGG
 */
public class ValidarLogin {

    private Sistema sistema = FramePrincipal.sistema;

    public ValidarLogin() {

    }

    public String verificarLogin(Usuario usuario) {
        
        if(!verificarLongitudNombre(usuario.getNombre())) {
                return ("Longitud de nombre incorrecta");
        }
        
        if (!verificarPassword(usuario.getPassword())) {
            return ("Longitud de contraseña incorrecta");
        } 
        
        for (Usuario u : sistema.getUsuarios()) {
            if (u.getNombre().equals(usuario.getNombre())
                    && u.getPassword().equals(usuario.getPassword())) {
                return ("Bienvenido");
            }
        }
        return ("Datos Incorrectos");
    }
    
    public boolean verificarLongitudNombre(String password) {
        return (password.length() > 1 && password.length() <= 6);
    }

    public boolean verificarPassword(String password) {
        return(password.length()>=3 && password.length() < 6);
    }
    
}
