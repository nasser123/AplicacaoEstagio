/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Cidade;
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
public class CidadeDAOTest {

    public CidadeDAOTest() {
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
     * Test of pesquisarTodosPorEstado method, of class CidadeDAO.
     */
    @Test
    public void testPesquisarTodosPorEstado() throws Exception {
        int idEstado = 21;
        CidadeDAO c = new CidadeDAO();
        List<Cidade> cidades = c.pesquisarTodosPorEstado(idEstado);
        for (int i = 0; i < cidades.size(); i++) {
            System.out.println(cidades.get(i).getNome());
        }
    }

    /**
     * Test of pesquisarPorNome method, of class CidadeDAO.
     */
    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        String nome = "uruguaiana";
        CidadeDAO instance = new CidadeDAO();
        Cidade result = instance.pesquisarPorNome(nome);
        System.out.println(result.getNome() + " - " + result.getIdcidade() + " - " + result.getIdestado().getUf());
    }

    /**
     * Test of pesquisarPorId method, of class CidadeDAO.
     */
    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        int idCidade = 4266;
        CidadeDAO instance = new CidadeDAO();
        String expResult = "Uruguaiana";
        Cidade result = instance.pesquisarPorId(idCidade);
        assertEquals(expResult, result.getNome());
    }
}
