/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.config.ConnectionFactory;
import br.com.model.Subgrupo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class SubGrupoDAO implements IDao {

    private EntityManager entity;
    private List<Subgrupo> subGrupos;

    public SubGrupoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof Subgrupo) {
            Subgrupo sg = (Subgrupo) objeto;
            if (!existeSubgrupo(sg.getDescricao())) {
                entity.getTransaction().begin();
                entity.persist(sg);
                entity.getTransaction().commit();

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof Subgrupo) {
            Subgrupo sg = (Subgrupo) objeto;
            if (pesquisarPorId(sg.getIdsubgrupo()) != null) {
                Subgrupo antigo = pesquisarPorId(sg.getIdsubgrupo());
                antigo = sg;
                entity.getTransaction().begin();
                entity.persist(antigo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object objeto) throws SQLException {
        if (objeto instanceof Subgrupo) {
            Subgrupo g = (Subgrupo) objeto;
            entity.getTransaction().begin();
            entity.remove(g);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Subgrupo pesquisarPorId(int id) throws SQLException {
        Subgrupo g = null;
        subGrupos = entity.createNamedQuery("Subgrupo.findByIdsubgrupo").setParameter("idsubgrupo", id).getResultList();
        if (!subGrupos.isEmpty()) {
            g = (Subgrupo) subGrupos.get(0);
            return g;
        }
        return g;
    }

    @Override
    public List<Subgrupo> pesquisarTodos() throws SQLException {
        subGrupos = entity.createNamedQuery("Subgrupo.findAll").getResultList();
        return subGrupos;
    }

    @Override
    public List<Subgrupo> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        if (criterioOrdenamento == "descricao") {
            subGrupos = entity.createNamedQuery("Subgrupo.OrderByDescricao").getResultList();
        } else if (criterioOrdenamento == "idgrupo") {
            subGrupos = entity.createNamedQuery("Subgrupo.OrderByIdSubgrupo").getResultList();
        } else {
            subGrupos = entity.createNamedQuery("Subgrupo.findAll").getResultList();
        }

        return subGrupos;
    }

    public boolean existeSubgrupo(String descricao) {
        Subgrupo g = null;
        List subGrupos = entity.createNamedQuery("Subgrupo.findByDescricao").setParameter("descricao", descricao).getResultList();
        if (!subGrupos.isEmpty()) {
            return true;
        }
        return false;
    }

}
