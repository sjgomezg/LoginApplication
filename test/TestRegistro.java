/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.RegistrarUsuario;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moroc
 */
public class TestRegistro {
    
    private static RegistrarUsuario registrarUsuario = new RegistrarUsuario();
    private String LONG_NOMBRE_INCORRECTA = "Longitud de nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud de contraseña incorrecta";
    private String EL_USUARIO_YA_EXISTE = "El usuario ya existe";
    private String LAS_CONTRASENIAS_NO_COINCIDEN = "Las contraseñas no coinciden";
    private String USUARIO_REGISTRADO = "Usuario Registrado con exito";
    
    public TestRegistro() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        sistema.setUsuarios(usuarios);
        
        for(Usuario u: sistema.getUsuarios()){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("--------------");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        String vPassword = "123456";
        assertEquals(LONG_NOMBRE_INCORRECTA, registrarUsuario.registrar(u, vPassword));
                       
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(LONG_NOMBRE_INCORRECTA, registrarUsuario.registrar(u, vPassword));
    }
    
    @Test
    public void testVerificarNombre(){
        Usuario u = new Usuario();
        u.setNombre("juan");
        u.setPassword("123456");
        String vPassword = "123456";
        assertEquals(EL_USUARIO_YA_EXISTE,registrarUsuario.registrar(u, vPassword));
                       
        u.setNombre("maria");
        u.setPassword("123456");
        
        assertEquals(EL_USUARIO_YA_EXISTE,registrarUsuario.registrar(u, vPassword));
        
    }
    
    @Test
    public void testLongitudPassword(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        String vPassword = "123456";
        assertEquals(LONG_PASSWORD_INCORRECTA,registrarUsuario.registrar(u, vPassword));
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(LONG_PASSWORD_INCORRECTA,registrarUsuario.registrar(u, vPassword));
    }
    
    @Test
    public void validarPassword(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12345");
        String vPassword = "12346";
        assertEquals(LAS_CONTRASENIAS_NO_COINCIDEN, registrarUsuario.registrar(u, vPassword));
        
        u.setNombre("Pepe");
        u.setPassword("12345");
        vPassword = "12347";
        assertEquals(LAS_CONTRASENIAS_NO_COINCIDEN, registrarUsuario.registrar(u, vPassword));
        
    }
    @Test
    public void usuarioRegistrado(){
        Usuario u = new Usuario();
        u.setNombre("lucia");
        u.setPassword("54321");
        String vPassword = "54321";
        assertEquals(USUARIO_REGISTRADO, registrarUsuario.registrar(u, vPassword));
        
        Usuario v = new Usuario();
        v.setNombre("john");
        v.setPassword("AB123");
        vPassword = "AB123";
        assertEquals(USUARIO_REGISTRADO, registrarUsuario.registrar(v, vPassword)); 
    }
    // public void hello() {}
}
