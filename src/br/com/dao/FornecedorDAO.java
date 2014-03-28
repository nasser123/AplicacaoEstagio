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
import br.com.model.Fornecedor;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nasser
 */
public class FornecedorDAO implements IDao {

    private EntityManager entity;

    public FornecedorDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    private List<Fornecedor> getFornecedorBanco(String fornecedor) {
        return entity.createNamedQuery("Fornecedor.findByNome").setParameter("nome", fornecedor).getResultList();

    }

    @Override
    public boolean inserir(Object fornecedor) throws SQLException {
        if (fornecedor instanceof Fornecedor) {
            Fornecedor c = (Fornecedor) fornecedor;
            entity.getTransaction().begin();
            entity.persist(c);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

//    public boolean inserir(String nome, String endereco, String numero, String complemento, String bairro, String cep, String email, String cpfCnpj, String inscEstadual) throws SQLException {
//        Fornecedor f = new Fornecedor(nome, endereco, numero, complemento, bairro, cep, email, cpfCnpj, inscEstadual);
//        entity.getTransaction().begin();
//        entity.persist(f);
//        entity.getTransaction().commit();
//        return true;
//    }

    @Override
    public boolean alterar(Object fornecedor) throws SQLException {
        if (fornecedor instanceof Fornecedor) {
            Fornecedor c = (Fornecedor) fornecedor;
            entity.getTransaction().begin();
            entity.merge(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean excluir(Object fornecedor) throws SQLException {
        if (fornecedor instanceof Fornecedor) {
            Fornecedor c = (Fornecedor) fornecedor;
            entity.getTransaction().begin();
            entity.remove(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;
    }

    @Override
    public Fornecedor pesquisarPorId(int id) throws SQLException {
        Fornecedor fornecedor = null;
        List fornecedores = entity.createNamedQuery("Fornecedor.findByIdfornecedor").setParameter("idfornecedor", id).getResultList();
        if (!fornecedores.isEmpty()) {
            fornecedor = (Fornecedor) fornecedores.get(0);
            return fornecedor;
        }

        return null;
    }

//    @Override
    public List<Fornecedor> pesquisarTodos() throws SQLException {
        List fornecedores = entity.createNamedQuery("Fornecedor.findAll").getResultList();
        if (!fornecedores.isEmpty()) {
            return fornecedores;
        }
        return null;
    }

//    @Override
    public List<Fornecedor> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Fornecedor order by " + criterioOrdenamento, Fornecedor.class);
        List fornecedors = query.getResultList();
        if (!fornecedors.isEmpty()) {
            return fornecedors;
        }
        return null;
    }

}
