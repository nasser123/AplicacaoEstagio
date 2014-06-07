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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class OrdemServicoDAO implements IDao {

    private EntityManager entity;
    private List<OrdemServico> ordemServicos;

    public OrdemServicoDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    @Override
    public boolean inserir(Object objeto) throws SQLException {
        if (objeto instanceof OrdemServico) {
            OrdemServico os = (OrdemServico) objeto;
            entity.getTransaction().begin();
            entity.persist(os);
            entity.getTransaction().commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) throws SQLException {
        if (objeto instanceof OrdemServico) {
            OrdemServico os = (OrdemServico) objeto;
            OrdemServico antigo = pesquisarPorId(os.getIdordemServico());
            if (pesquisarPorId(os.getIdordemServico()) != null) {

                atualizaListaServicosRealizados(os);
                antigo = os;
                entity.getTransaction().begin();
                entity.merge(antigo);
                entity.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluir(Object objeto) throws SQLException {
        if (objeto instanceof OrdemServico) {
            OrdemServico os = (OrdemServico) objeto;
            entity.getTransaction().begin();
            entity.remove(os);
            entity.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public OrdemServico pesquisarPorId(int id) throws SQLException {
        OrdemServico g = null;
        ordemServicos = entity.createNamedQuery("OrdemServico.findByIdordemServico").setParameter("idordemServico", id).getResultList();
        if (!ordemServicos.isEmpty()) {
            g = (OrdemServico) ordemServicos.get(0);
            return g;
        }
        return g;
    }

    @Override
    public List<OrdemServico> pesquisarTodos() throws SQLException {
        ordemServicos = entity.createNamedQuery("OrdemServico.findAll").getResultList();
        return ordemServicos;
    }

    private void atualizaListaServicosRealizados(OrdemServico os) {
        ServicoRealizadoDAO srdao = new ServicoRealizadoDAO();
        List<ServicoRealizado> listaServicos = null;
        try {
            listaServicos = srdao.pesquisarPorIdordemServico(os);
        } catch (SQLException ex) {
            Logger.getLogger(OrdemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!os.getServicoRealizadoList().equals(listaServicos)) {
            for (int i = 0; i < listaServicos.size(); i++) {
                boolean tem = false;
                for (int j = 0; j < os.getServicoRealizadoList().size(); j++) {
                    if (listaServicos.get(i).equals(os.getServicoRealizadoList().get(j))) {
                        tem = true;
                    }
                }
                if (!tem) {

                    try {
                        srdao.excluir(listaServicos.get(i));
                    } catch (SQLException ex) {
                        Logger.getLogger(OrdemServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        }

    }

    @Override
    public List<OrdemServico> pesquisarTodosOrdenadoPor(String criterioOrdenamento) throws SQLException {
//        if (criterioOrdenamento == "idcliente") {
//            ordemServicos = entity.createNamedQuery("OrdemServico.OrderByDescricao").getResultList();
//        } else if (criterioOrdenamento == "idgrupo") {
//            ordemServicos = entity.createNamedQuery("OrdemServico.OrderByIdOrdemServico").getResultList();
//        } else {
//            ordemServicos = entity.createNamedQuery("OrdemServico.findAll").getResultList();
//        }

        return ordemServicos;
    }

    public OrdemServico pesquisarPorIdcliente(int idcliente) throws SQLException {
        OrdemServico os = null;
        ordemServicos = entity.createNamedQuery("OrdemServico.findByIdcliente").setParameter("idcliente", idcliente).getResultList();
        if (!ordemServicos.isEmpty()) {
            os = (OrdemServico) ordemServicos.get(0);
            return os;
        }
        return os;
    }

    public OrdemServico pesquisarPorIdsituacao_os(int idsituacao_os) throws SQLException {
        OrdemServico os = null;
        ordemServicos = entity.createNamedQuery("OrdemServico.findByIdsituacao_os").setParameter("idsituacao_os", idsituacao_os).getResultList();
        if (!ordemServicos.isEmpty()) {
            os = (OrdemServico) ordemServicos.get(0);
            return os;
        }
        return os;
    }

}
