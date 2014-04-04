/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.config.ConnectionFactory;
import br.com.model.Grupo;
import br.com.model.ListaAtributoSubgrupo;
import br.com.model.Subgrupo;
import br.com.model.TipoAtributo;
import br.com.renderizadores.TiposAtributosCellRenderer;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public Subgrupo inserirComRetorno(Object objeto) throws SQLException {
        if (objeto instanceof Subgrupo) {
            Subgrupo sg = (Subgrupo) objeto;
            if (!existeSubgrupo(sg.getDescricao())) {
                entity.getTransaction().begin();
                entity.persist(sg);
                entity.getTransaction().commit();

                if (sg.getIdsubgrupo() == null) {
                    sg = this.pesquisarPorDescricao(sg.getDescricao());
                }
                return sg;
            }
        }
        return null;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof Subgrupo) {
            Subgrupo sg = (Subgrupo) objeto;
            if (pesquisarPorId(sg.getIdsubgrupo()) != null) {
//                Subgrupo antigo = pesquisarPorId(sg.getIdsubgrupo());
//                antigo = sg;
                entity.getTransaction().begin();
                entity.merge(sg);
                entity.getTransaction().commit();
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

    public List<Subgrupo> pesquisarPorGrupo(Grupo idGrupo) throws SQLException {

        subGrupos = entity.createNamedQuery("Subgrupo.findByIdGrupo").setParameter("idgrupo", idGrupo).getResultList();

        return subGrupos;
    }

    public List<Subgrupo> pesquisarNaoContemGrupo(Grupo idGrupo, String criterioOrdenamento) {
        if (idGrupo != null) {
            subGrupos = entity.createNativeQuery("Select * from subgrupo where idgrupo <> " + idGrupo.getIdgrupo() + " order by  " + criterioOrdenamento, Subgrupo.class).getResultList();
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

    public List<TipoAtributo> pesquisarNaoContemTiposAtributos(Subgrupo s) {
        List<TipoAtributo> tiposAtributos;
        tiposAtributos = entity.createNativeQuery("Select * from tipo_atributo where idtipo_atributo not in ( "
                + "Select idtipo_atributo from lista_atributo_subgrupo where idsubgrupo = " + s.getIdsubgrupo() + ")", TipoAtributo.class).getResultList();

        return tiposAtributos;
    }

    public Subgrupo pesquisarPorDescricao(String s) {
        Subgrupo sg = (Subgrupo) entity.createNamedQuery("Subgrupo.findByDescricao").setParameter("descricao", s).getSingleResult();

        return sg;
    }

    public List<TipoAtributo> pesquisarTiposAtributos(Subgrupo s) {
        Subgrupo sg = s;
        List<TipoAtributo> listaTiposAtributos = new ArrayList();
        listaTiposAtributos = entity.createNativeQuery("Select idtipo_atributo from lista_atributo_subgrupo where idsubgrupo = " + s.getIdsubgrupo() , TipoAtributo.class).getResultList();
        return listaTiposAtributos;
    }

}
