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
import br.com.model.TipoAtributo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class TipoAtributoDAO implements IDao {

    private EntityManager entity;
    private List<TipoAtributo> tipoAtributos;

    public TipoAtributoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof TipoAtributo) {
            TipoAtributo ta = (TipoAtributo) objeto;
            if (!existeTipoAtributo(ta.getDescricao())) {
                entity.getTransaction().begin();
                entity.persist(ta);
                entity.getTransaction().commit();

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof TipoAtributo) {
            TipoAtributo ta = (TipoAtributo) objeto;
            if (pesquisarPorId(ta.getIdtipoAtributo()) != null) {
                TipoAtributo antigo = pesquisarPorId(ta.getIdtipoAtributo());
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
        if (objeto instanceof TipoAtributo) {
            TipoAtributo f = (TipoAtributo) objeto;
            entity.getTransaction().begin();
            entity.remove(f);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public TipoAtributo pesquisarPorId(int id) throws SQLException {
        TipoAtributo ta = null;
        tipoAtributos = entity.createNamedQuery("TipoAtributo.findByIdtipoAtributo").setParameter("idtipoAtributo", id).getResultList();
        if (!tipoAtributos.isEmpty()) {
            ta = (TipoAtributo) tipoAtributos.get(0);
            return ta;
        }
        return ta;
    }

    @Override
    public List<TipoAtributo> pesquisarTodos() throws SQLException {
        tipoAtributos = entity.createNamedQuery("TipoAtributo.findAll").getResultList();
        return tipoAtributos;
    }

    @Override
    public List<TipoAtributo> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
//        if (criterioOrdenamento == "descricao") {
//            fabricantes = entity.createNamedQuery("TipoAtributo.OrderByDescricao").getResultList();
//        } else if (criterioOrdenamento == "idgrupo") {
//            fabricantes = entity.createNamedQuery("TipoAtributo.OrderByIdTipoAtributo").getResultList();
//        } else {
//            fabricantes = entity.createNamedQuery("TipoAtributo.findAll").getResultList();
//        }

        return tipoAtributos;
    }

    public boolean existeTipoAtributo(String descricao) {
        List<TipoAtributo> tipoAtributo = entity.createNamedQuery("TipoAtributo.findByDescricao").setParameter("descricao", descricao).getResultList();
        if (!tipoAtributo.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<TipoAtributo> pesquisaTiposAtributosNaoPresentes(List<TipoAtributo> tiposAtributosToRemove) throws SQLException {
        tipoAtributos = this.pesquisarTodos();
        for (int i = 0; i < tiposAtributosToRemove.size(); i++) {
            for (int j = 0; j < tipoAtributos.size(); j++) {
                if (tiposAtributosToRemove.get(i).equals(tipoAtributos.get(j))) {
                    tipoAtributos.remove(j);
                    break;
                }
            }
        }
        return tipoAtributos;
    }

}
