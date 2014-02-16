/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nasser
 */
public class UsuarioControllerTest {

    
    public UsuarioControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        UsuarioController uc = new UsuarioController();
        List<Usuario> usuariosTeste = null;
        try {
            usuariosTeste = uc.pesquisarTodosPor("nome", "Fulano3");
            for (int i = 0; i < usuariosTeste.size(); i++) {
                    uc.excluir(usuariosTeste.get(i));
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for (int i = 0; i < usuariosTeste.size(); i++) {
//            System.out.println(usuariosTeste.get(i).toString());
//
//        }

    }

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        
    }

    @After
    public void tearDown() throws SQLException {

    }

    /**
     * Test of verificaLogin method, of class UsuarioController.
     */
    @Test
    public void testInserirUsuarioNovo() throws Exception {
        Usuario usu = new Usuario();
        usu.setNome("Fulano3");
        usu.setSenha("abcde");
        Long valorAleatorio = System.currentTimeMillis();
        String username = valorAleatorio.toString();
        usu.setUsername(username);
        usu.setEmail("marcelo@marcelo.com.br");
        System.out.println("inserirUsuarioNovo");
        boolean validado = new UsuarioController().inserir(usu);
        int idInserido = usu.getIdusuario();
        assertEquals(validado, true);
        //testExcluir();
    }

    @Test
    public void testInserirUsuarioExistente() throws Exception {
        Usuario usu = new Usuario();
        usu.setNome("Fulano3");
        usu.setSenha("abcde");
        Long valorAleatorio = System.currentTimeMillis();
        String username = valorAleatorio.toString();
        usu.setUsername("nasser");
        usu.setEmail("marcelo@marcelo.com.br");
        System.out.println("inserirUsuarioNovo");
        boolean validado = new UsuarioController().inserir(usu);
        assertEquals(validado, false);
        //testExcluir();
    }
    
    /**
     * Test of inserir method, of class UsuarioController.
     */

    //@Test
//    public void testExcluir() throws Exception {
//        System.out.println("Excluir");
//        Usuario usu = null;
//        usu = instance.pesquisarPorId(idInserido);
//        if(usu!= null){
//            if(usu.equals(usuario))
//                this.instance.excluir(usu);
//        }
//    }
    
    
    @Test
    public void testVerificaLoginErrado() throws Exception {
        System.out.println("verificaLoginErrado");
        String username = "nasser";
        String senha = "123";
        boolean expResult = false;
        boolean result = new UsuarioController().verificaLogin(username, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testVerificaLoginCerto() throws Exception {
        System.out.println("verificaLoginCerto");
        String username = "nasser";
        String senha = "123456";
        UsuarioController instance = new UsuarioController();
        boolean expResult = true;
        boolean result = instance.verificaLogin(username, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}
