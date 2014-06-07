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
import br.com.model.OrdemServico;
import br.com.model.ServicoRealizado;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class ServicoRealizadoDAO implements IDao {

    private EntityManager entity;
    private List<ServicoRealizado> servicoRealizados;

    public ServicoRealizadoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof ServicoRealizado) {
            ServicoRealizado os = (ServicoRealizado) objeto;
                entity.getTransaction().begin();
                entity.persist(os);
                entity.getTransaction().commit();

                return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof ServicoRealizado) {
            ServicoRealizado sr = (ServicoRealizado) objeto;
            if (pesquisarPorId(sr.getIdservicoRealizado()) != null) {
                ServicoRealizado antigo = pesquisarPorId(sr.getIdservicoRealizado());
                antigo = sr;
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
        if (objeto instanceof ServicoRealizado) {
            ServicoRealizado sr = (ServicoRealizado) objeto;
            entity.getTransaction().begin();
            entity.remove(sr);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public ServicoRealizado pesquisarPorId(int id) throws SQLException {
        ServicoRealizado sr = null;
        servicoRealizados = entity.createNamedQuery("ServicoRealizado.findByIdservicoRealizado").setParameter("idservicoRealizado", id).getResultList();
        if (!servicoRealizados.isEmpty()) {
            sr = (ServicoRealizado) servicoRealizados.get(0);
            return sr;
        }
        return sr;
    }

    @Override
    public List<ServicoRealizado> pesquisarTodos() throws SQLException {
        servicoRealizados = entity.createNamedQuery("ServicoRealizado.findAll").getResultList();
        return servicoRealizados;
    }

    @Override
    public List<ServicoRealizado> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
//        if (criterioOrdenamento == "idcliente") {
//            ordemServicos = entity.createNamedQuery("ServicoRealizado.OrderByDescricao").getResultList();
//        } else if (criterioOrdenamento == "idgrupo") {
//            ordemServicos = entity.createNamedQuery("ServicoRealizado.OrderByIdServicoRealizado").getResultList();
//        } else {
//            ordemServicos = entity.createNamedQuery("ServicoRealizado.findAll").getResultList();
//        }

        return servicoRealizados;
    }

    public List<ServicoRealizado> pesquisarPorIdordemServico(OrdemServico idordemServico) throws SQLException {
        servicoRealizados = entity.createNamedQuery("ServicoRealizado.findByIdordemServico").setParameter("idordemServico", idordemServico).getResultList();
        if (!servicoRealizados.isEmpty()) {
            return servicoRealizados;
        }
        return servicoRealizados;
    }
    
//    public OrdemServico pesquisarPorIdsituacao_os(int idsituacao_os) throws SQLException {
//        OrdemServico os = null;
//        servicoRealizados = entity.createNamedQuery("OrdemServico.findByIdsituacao_os").setParameter("idsituacao_os", idsituacao_os).getResultList();
//        if (!servicoRealizados.isEmpty()) {
//            os = (OrdemServico) servicoRealizados.get(0);
//            return os;
//        }
//        return os;
//    }

}
