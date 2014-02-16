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
import br.com.model.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nasser
 */
public class ClienteDAO implements IDao {

    private EntityManager entity;

    public ClienteDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    private List<Cliente> getClienteBanco(String cliente) {
        return entity.createNamedQuery("Cliente.findByNome").setParameter("nome", cliente).getResultList();

    }

    @Override
    public boolean inserir(Object cliente) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;
            entity.getTransaction().begin();
            entity.persist(c);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean inserir(String nome, String endereco, String numero, String complemento, String bairro, String cep, String email, String cpfCnpj, String inscEstadual) throws SQLException {
        Cliente c = new Cliente(nome, endereco, numero, complemento, bairro, cep, email, cpfCnpj, inscEstadual);
        entity.getTransaction().begin();
        entity.persist(c);
        entity.getTransaction().commit();
        return true;
    }

    @Override
    public boolean alterar(Object cliente) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;
            entity.getTransaction().begin();
            entity.merge(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean excluir(Object cliente) throws SQLException {
        if (cliente instanceof Cliente) {
            Cliente c = (Cliente) cliente;
            entity.getTransaction().begin();
            entity.remove(c);
            entity.getTransaction().commit();

            return true;
        }
        return false;
    }

    @Override
    public Cliente pesquisarPorId(int id) throws SQLException {
        Cliente cliente = null;
        List clientes = entity.createNamedQuery("Cliente.findByIdcliente").setParameter("idcliente", id).getResultList();
        if (!clientes.isEmpty()) {
            cliente = (Cliente) clientes.get(0);
            return cliente;
        }

        return null;
    }

//    @Override
    public List<Cliente> pesquisarTodos() throws SQLException {
        List clientes = entity.createNamedQuery("Cliente.findAll").getResultList();
        if (!clientes.isEmpty()) {
            return clientes;
        }
        return null;
    }

//    @Override
    public List<Cliente> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Cliente order by " + criterioOrdenamento, Cliente.class);
        List clientes = query.getResultList();
        if (!clientes.isEmpty()) {
            return clientes;
        }
        return null;
    }

}
