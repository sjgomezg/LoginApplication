package Entidad;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList <Usuario> usuarios;
    
    public Sistema(){
        
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> val) {
        this.usuarios = val;
    }
    
}
