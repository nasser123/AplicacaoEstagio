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
import br.com.model.Fabricante;
import br.com.model.Produto;
import br.com.model.Subgrupo;
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
    private Fabricante idfabricante;
    private FabricanteDAO fabricanteDAO;
    private Subgrupo idsubSubgrupo;
    private SubGrupoDAO subGrupoDAO;

    public ProdutoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    private List<Produto> getProdutoBanco(String produto) {
        return entity.createNamedQuery("Produto.findByNome").setParameter("nome", produto).getResultList();

    }

    @Override
    public boolean inserir(Object produto) throws SQLException {
        if (produto instanceof Produto) {
            Produto p = (Produto) produto;
            entity.getTransaction().begin();
            entity.persist(p);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean inserir(int codigo, String codigoBarras, String descricao, 
                            BigDecimal preco_venda1, BigDecimal preco_venda2, BigDecimal preco_venda3, 
                            String observacoes, int ncm, int idfabricante, int idsubgrupo, int entrada, 
                            int saida, int estoqueMinimo, BigDecimal custo_atual ) throws SQLException {
                             
        Produto p = new Produto();
        fabricanteDAO = new FabricanteDAO();
        this.idfabricante = fabricanteDAO.pesquisarPorId(idfabricante);
        subGrupoDAO = new SubGrupoDAO();
        this.idsubSubgrupo = subGrupoDAO.pesquisarPorId(idsubgrupo);
        p.setCodigo(codigo);
        p.setCodigobarras(codigoBarras);
        p.setDescricao(descricao);
        p.setPrecoVenda1(preco_venda1);
        p.setPrecoVenda2(preco_venda2);
        p.setPrecoVenda3(preco_venda3);
        p.setObservacoes(observacoes);
        p.setNcm(ncm);
        p.setIdfabricante(this.idfabricante);
        p.setIdsubgrupo(this.idsubSubgrupo);
        p.setEntrada(entrada);
        p.setSaida(saida);
        p.setEstoqueMinimo(estoqueMinimo);
        p.setCustoAtual(custo_atual);
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

    public Produto pesquisarPorCodigoDeBarras(String codigoBarras){
    Produto produto = null;
        List produtos = entity.createNamedQuery("Produto.findByCodigobarras").setParameter("codigobarras", codigoBarras).getResultList();
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
