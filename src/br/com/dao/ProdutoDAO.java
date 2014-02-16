/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.config.ConnectionFactory;
import br.com.model.Produto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nasser
 */
public class ProdutoDAO implements IDao {

    private EntityManager entity;

    public ProdutoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    private List<Produto> getProdutoBanco(String produto) {
        return entity.createNamedQuery("Produto.findByNome").setParameter("nome", produto).getResultList();

    }

    @Override
    public boolean inserir(Object produto) throws SQLException {
        if (produto instanceof Produto) {
            Produto c = (Produto) produto;
            entity.getTransaction().begin();
            entity.persist(c);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean inserir(int codigo, String codigoBarras, String descricao, 
                            BigDecimal preco_venda1, BigDecimal preco_venda2, BigDecimal preco_venda3, 
                            String observacoes, int ncm, int idfabricante, int idgrupo ) throws SQLException {
        Produto p = new Produto();
        
        entity.getTransaction().begin();
        entity.persist(p);
        entity.getTransaction().commit();
        return true;
    }

    @Override
    public boolean alterar(Object produto) throws SQLException {
        if (produto instanceof Produto) {
            Produto c = (Produto) produto;
            entity.getTransaction().begin();
            entity.merge(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean excluir(Object produto) throws SQLException {
        if (produto instanceof Produto) {
            Produto c = (Produto) produto;
            entity.getTransaction().begin();
            entity.remove(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;
    }

    @Override
    public Produto pesquisarPorId(int id) throws SQLException {
        Produto produto = null;
        List produtos = entity.createNamedQuery("Produto.findByIdproduto").setParameter("idproduto", id).getResultList();
        if (!produtos.isEmpty()) {
            produto = (Produto) produtos.get(0);
            return produto;
        }

        return null;
    }

//    @Override
    public List<Produto> pesquisarTodos() throws SQLException {
        List produtos = entity.createNamedQuery("Produto.findAll").getResultList();
        if (!produtos.isEmpty()) {
            return produtos;
        }
        return null;
    }

//    @Override
    public List<Produto> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Produto order by " + criterioOrdenamento, Produto.class);
        List produtos = query.getResultList();
        if (!produtos.isEmpty()) {
            return produtos;
        }
        return null;
    }

}
