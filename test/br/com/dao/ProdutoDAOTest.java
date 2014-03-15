/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dao;

import br.com.model.Produto;
import java.math.BigDecimal;
import java.util.List;
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
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
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
     * Test of inserir method, of class ProdutoDAO.
     */
//    @Test
    public void testInserir_Object() throws Exception {
        System.out.println("inserir");
        Object produto = null;
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = false;
        boolean result = instance.inserir(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class ProdutoDAO.
     */
    @Test
    public void testInserir_10args() throws Exception {
        System.out.println("inserir");
        int codigo = 123;
        String codigoBarras = "12345678";
        String descricao = "Produto de teste";
        BigDecimal preco_venda1 = new BigDecimal(100.00);
        BigDecimal preco_venda2 = new BigDecimal(90.00);
        BigDecimal preco_venda3 = new BigDecimal(80.00);
        String observacoes = "Observaçoes Teste";
        int ncm = 123;
        int idfabricante = 15;
        int idsubgrupo = 1;
        int entrada = 1;
        int saida = 1;
        int estoqueMinimo = 1;
        BigDecimal custo_atual = new BigDecimal(60.00);
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = true;
        boolean result = instance.inserir(codigo, codigoBarras, descricao, preco_venda1, preco_venda2, preco_venda3, observacoes, ncm, idfabricante, idsubgrupo, entrada, saida, estoqueMinimo, custo_atual);
        assertEquals(expResult, result);
        
        Produto p = instance.pesquisarPorCodigoDeBarras(codigoBarras);
        instance.excluir(p);
    }

    /**
     * Test of alterar method, of class ProdutoDAO.
     */
 //   @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Object produto = null;
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = false;
        boolean result = instance.alterar(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class ProdutoDAO.
     */
 //   @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Object produto = null;
        ProdutoDAO instance = new ProdutoDAO();
        boolean expResult = false;
        boolean result = instance.excluir(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class ProdutoDAO.
     */
//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        int id = 0;
        ProdutoDAO instance = new ProdutoDAO();
        Produto expResult = null;
        Produto result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodos method, of class ProdutoDAO.
     */
//    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        ProdutoDAO instance = new ProdutoDAO();
        List<Produto> expResult = null;
        List<Produto> result = instance.pesquisarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarTodosOrdenadoPor method, of class ProdutoDAO.
     */
//    @Test
    public void testPesquisarTodosOrdenadoPor() throws Exception {
        System.out.println("pesquisarTodosOrdenadoPor");
        String criterioOrdenamento = "";
        ProdutoDAO instance = new ProdutoDAO();
        List<Produto> expResult = null;
        List<Produto> result = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
