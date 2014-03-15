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
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class FabricanteDAO implements IDao {

    private EntityManager entity;
    private List<Fabricante> fabricantes;

    public FabricanteDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof Fabricante) {
            Fabricante g = (Fabricante) objeto;
            if (!existeFabricante(g.getDescricao())) {
                entity.getTransaction().begin();
                entity.persist(g);
                entity.getTransaction().commit();

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof Fabricante) {
            Fabricante f = (Fabricante) objeto;
            if (pesquisarPorId(f.getIdfabricante()) != null) {
                Fabricante antigo = pesquisarPorId(f.getIdfabricante());
                antigo = f;
                entity.getTransaction().begin();
                entity.persist(antigo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object objeto) throws SQLException {
        if (objeto instanceof Fabricante) {
            Fabricante f = (Fabricante) objeto;
            entity.getTransaction().begin();
            entity.remove(f);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Fabricante pesquisarPorId(int id) throws SQLException {
        Fabricante g = null;
        fabricantes = entity.createNamedQuery("Fabricante.findByIdfabricante").setParameter("idfabricante", id).getResultList();
        if (!fabricantes.isEmpty()) {
            g = (Fabricante) fabricantes.get(0);
            return g;
        }
        return g;
    }

    @Override
    public List<Fabricante> pesquisarTodos() throws SQLException {
        fabricantes = entity.createNamedQuery("Fabricante.findAll").getResultList();
        return fabricantes;
    }

    @Override
    public List<Fabricante> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
//        if (criterioOrdenamento == "descricao") {
//            fabricantes = entity.createNamedQuery("Fabricante.OrderByDescricao").getResultList();
//        } else if (criterioOrdenamento == "idgrupo") {
//            fabricantes = entity.createNamedQuery("Fabricante.OrderByIdFabricante").getResultList();
//        } else {
//            fabricantes = entity.createNamedQuery("Fabricante.findAll").getResultList();
//        }

        return fabricantes;
    }

    public boolean existeFabricante(String descricao) {
        Fabricante f = null;
        List fabricantes = entity.createNamedQuery("Fabricante.findByDescricao").setParameter("descricao", descricao).getResultList();
        if (!fabricantes.isEmpty()) {
            return true;
        }
        return false;
    }

}
