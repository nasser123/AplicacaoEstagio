/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Usuario;
import java.security.NoSuchAlgorithmException;
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
        
    }

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of verificaLogin method, of class UsuarioController.
     */
    @Test
    public void testInserir() throws Exception {
        Usuario usu = new Usuario();
        usu.setNome("Fulano3");
        usu.setSenha("abcde");
        usu.setUsername("fulanodetal3");
        usu.setEmail("marcelo@marcelo.com.br");
        System.out.println("inserir");
        boolean validado = new UsuarioController().inserir(usu);
        int idInserido = usu.getIdusuario();
        System.out.println("Inserido " + usu.getNome());
        
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
