/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Grupo;
import java.sql.SQLException;
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
public class GrupoDAOTest {

    Grupo grupo;

    public GrupoDAOTest() {
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
    public void tearDown() throws SQLException {
        GrupoDAO gd = new GrupoDAO();
        gd.excluir(this.grupo);
    }

    /**
     * Test of inserir method, of class GrupoDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Grupo g = new Grupo();
        g.setDescricao("teste grupo");
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = false;
        boolean result = instance.inserir(g);
        assertEquals(expResult, result);
    }

    @Test
    public void testInserirNovo() throws Exception {
        System.out.println("inserir novo");
        this.grupo = new Grupo();
        this.grupo.setDescricao("teste grupo" + String.valueOf(System.currentTimeMillis()));
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = true;
        boolean result = instance.inserir(this.grupo);
        assertEquals(expResult, result);
    }

    /**
     * Test of alterar method, of class GrupoDAO.
     */
    @Test
    public void testAlterar() throws Exception {
        if (this.grupo != null) {
            this.grupo.setDescricao("testando alteracao");
            GrupoDAO instance = new GrupoDAO();
            boolean expResult = true;
            boolean result = instance.alterar(grupo);
            assertEquals(expResult, result);

        }
    }

    /**
     * Test of excluir method, of class GrupoDAO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Grupo grupo = this.grupo;
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = false;
        boolean result = instance.excluir(grupo);
        assertEquals(expResult, result);
    }

    /**
     * Test of pesquisarPorId method, of class GrupoDAO.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        int id = 2;
        GrupoDAO instance = new GrupoDAO();

        String expResult = "Audio";
        String result = instance.pesquisarPorId(id).getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of pesquisarTodos method, of class GrupoDAO.
     */
    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = true;
        List<Grupo> lista = instance.pesquisarTodos();
        boolean result = !lista.isEmpty();
        assertEquals(expResult, result);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getDescricao());
            
        }
    }

    /**
     * Test of pesquisarTodosOrdenadoPor method, of class GrupoDAO.
     */
    @Test
    public void testPesquisarTodosOrdenadoPor() throws Exception {
        System.out.println("pesquisarTodosOrdenadoPor");
        String criterioOrdenamento = "descricao";
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = true;
        List<Grupo> lista = instance.pesquisarTodosOrdenadoPor(criterioOrdenamento);
        boolean result = !lista.isEmpty();
        assertEquals(expResult, result);

       for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getDescricao());
            
        }
    }

    /**
     * Test of existeGrupo method, of class GrupoDAO.
     */
    @Test
    public void testExisteGrupo() {
        System.out.println("existeGrupo");
        String descricao = "teste grupo";
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = true;
        boolean result = instance.existeGrupo(descricao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testNaoExisteGrupo() {
        System.out.println("naoExisteGrupo");
        String descricao = "nasser";
        GrupoDAO instance = new GrupoDAO();
        boolean expResult = false;
        boolean result = instance.existeGrupo(descricao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
