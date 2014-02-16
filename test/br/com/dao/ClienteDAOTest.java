/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dao;

import br.com.model.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Nasser
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of inserir method, of class ClienteDAO.
     */
    @Deprecated
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        boolean result = instance.inserir(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class ClienteDAO.
     */
    @Deprecated
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        boolean result = instance.alterar(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ClienteDAO.
     */
    @Deprecated
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        boolean result = instance.excluir(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        int id = 1;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.pesquisarPorId(id);
        Cliente c = (Cliente) result;
        System.out.println(c.getNome());
    }

    /**
     * Test of pesquisarTodos method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarTodos();
        
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).toString());
        
        }
        
    }

    /**
     * Test of pesquisarTodosOrdenadoPor method, of class ClienteDAO.
     */
    @Test
    public void testPesquisarTodosOrdenadoPorNome() throws Exception {
        System.out.println("pesquisarTodosOrdenadoPorNome");
        String criterioOrdenamento = "nome";
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        for (int i= 0 ; i < result.size(); i ++){
            System.out.println(result.get(i).getNome());
        }
    }
    
    
    @Test
    public void testPesquisarTodosOrdenadoPorDataNascimento() throws Exception {
        System.out.println("pesquisarTodosOrdenadoPor");
        String criterioOrdenamento = "data_nascimento";
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        for (int i= 0 ; i < result.size(); i ++){
            System.out.println(result.get(i).getNome() + " - " + result.get(i).getDataNascimento() );
        }
    }
    
    
    
}
