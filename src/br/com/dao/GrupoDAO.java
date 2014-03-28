/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.config.ConnectionFactory;
import br.com.model.Grupo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser
 */
public class GrupoDAO implements IDao {

    private EntityManager entity;
    private List<Grupo> grupos;

    public GrupoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof Grupo) {
            Grupo g = (Grupo) objeto;
            if (!existeGrupo(g.getDescricao())) {
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
        if (objeto instanceof Grupo) {
            Grupo g = (Grupo) objeto;
            if (pesquisarPorId(g.getIdgrupo()) != null) {
                Grupo antigo = pesquisarPorId(g.getIdgrupo());
                antigo = g;
                entity.getTransaction().begin();
                entity.persist(antigo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object objeto) throws SQLException {
        if (objeto instanceof Grupo) {
            //SubGrupoDAO subGrupoDAO = new SubGrupoDAO();

            Grupo g = (Grupo) objeto;
            if (g.getSubgrupoList().isEmpty()) {
                entity.getTransaction().begin();
                entity.remove(g);
                entity.getTransaction().commit();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Existem Subgrupos relacionados a esse grupo \n", Variaveis.getSiglaSistema(), 0);
            
            }
        }
        return false;
    }

    @Override
    public Grupo pesquisarPorId(int id) throws SQLException {
        Grupo g = null;
        grupos = entity.createNamedQuery("Grupo.findByIdgrupo").setParameter("idgrupo", id).getResultList();
        if (!grupos.isEmpty()) {
            g = (Grupo) grupos.get(0);
            return g;
        }
        return g;
    }

    @Override
    public List<Grupo> pesquisarTodos() throws SQLException {
        grupos = entity.createNamedQuery("Grupo.findAll").getResultList();
        return grupos;
    }

    @Override
    public List<Grupo> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
        if (criterioOrdenamento == "descricao") {
            grupos = entity.createNamedQuery("Grupo.OrderByDescricao").getResultList();
        } else if (criterioOrdenamento == "idgrupo") {
            grupos = entity.createNamedQuery("Grupo.OrderByIdGrupo").getResultList();
        } else {
            grupos = entity.createNamedQuery("Grupo.findAll").getResultList();
        }

        return grupos;
    }

    public boolean existeGrupo(String descricao) {
        Grupo g = null;
        List grupos = entity.createNamedQuery("Grupo.findByDescricao").setParameter("descricao", descricao).getResultList();
        if (!grupos.isEmpty()) {
            return true;
        }
        return false;
    }

}
