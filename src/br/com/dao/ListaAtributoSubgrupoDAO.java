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
import br.com.model.ListaAtributoSubgrupo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class ListaAtributoSubgrupoDAO implements IDao {

    private EntityManager entity;
    private List<ListaAtributoSubgrupo> listaTipoAtributos;

    public ListaAtributoSubgrupoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
//        if (objeto instanceof ListaAtributoSubgrupo) {
            ListaAtributoSubgrupo las = (ListaAtributoSubgrupo) objeto;
            if (!existeListaAtributoSubgrupo(las)) {
                entity.getTransaction().begin();
                entity.persist(las);
                entity.getTransaction().commit();
                return true;
            }
//        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof ListaAtributoSubgrupo) {
            ListaAtributoSubgrupo ta = (ListaAtributoSubgrupo) objeto;
            if (pesquisarPorId(ta.getIdtipoAtributo().getIdtipoAtributo()) != null) {
                ListaAtributoSubgrupo antigo = pesquisarPorId(ta.getIdtipoAtributo().getIdtipoAtributo());
                antigo = ta;
                entity.getTransaction().begin();
                entity.persist(antigo);
                entity.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object objeto) throws SQLException {
        if (objeto instanceof ListaAtributoSubgrupo) {
            ListaAtributoSubgrupo f = (ListaAtributoSubgrupo) objeto;
            entity.getTransaction().begin();
            entity.remove(f);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public ListaAtributoSubgrupo pesquisarPorId(int id) throws SQLException {
        ListaAtributoSubgrupo ta = null;
        listaTipoAtributos = entity.createNamedQuery("ListaAtributoSubgrupo.findByIdlistaAtributoSubgrupo").setParameter("idlistaAtributoSubgrupo", id).getResultList();
        if (!listaTipoAtributos.isEmpty()) {
            ta = (ListaAtributoSubgrupo) listaTipoAtributos.get(0);
            return ta;
        }
        return ta;
    }

    @Override
    public List<ListaAtributoSubgrupo> pesquisarTodos() throws SQLException {
        listaTipoAtributos = entity.createNamedQuery("ListaAtributoSubgrupo.findAll").getResultList();
        return listaTipoAtributos;
    }

    @Override
    public List<ListaAtributoSubgrupo> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
//        if (criterioOrdenamento == "descricao") {
//            fabricantes = entity.createNamedQuery("ListaAtributoSubgrupo.OrderByDescricao").getResultList();
//        } else if (criterioOrdenamento == "idgrupo") {
//            fabricantes = entity.createNamedQuery("ListaAtributoSubgrupo.OrderByIdListaAtributoSubgrupo").getResultList();
//        } else {
//            fabricantes = entity.createNamedQuery("ListaAtributoSubgrupo.findAll").getResultList();
//        }

        return listaTipoAtributos;
    }
    

    public boolean existeListaAtributoSubgrupo(ListaAtributoSubgrupo las) {
        List listAtributosSubgrupos = entity.createNativeQuery("SELECT * FROM lista_atributo_subgrupo " +
                                                                "where idsubgrupo = "+ las.getIdsubgrupo().getIdsubgrupo() + 
                                                                " and idtipo_atributo = " + las.getIdtipoAtributo().getIdtipoAtributo(), 
                                                                ListaAtributoSubgrupo.class).getResultList();
        if (!listAtributosSubgrupos.isEmpty()) {
            return true;
        } 
        return false;
    }
    

}
