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
import br.com.model.Cidade;
import br.com.model.Estado;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nasser
 */
public class CidadeDAO {
    private EntityManager entity;

    public CidadeDAO() {
        this.entity = ConnectionFactory.getEntityManager();
    }
    public List<Cidade> pesquisarTodosPorEstado(int idEstado) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Cidade where idestado = " + idEstado, Cidade.class);
        List cidades = query.getResultList();
        if (!cidades.isEmpty()) {
            return cidades;
        }
        return null;
    }
    
    public Cidade pesquisarPorNome(String nome) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Cidade where nome = \"" + nome + "\"", Cidade.class);
        List<Cidade> cidades = query.getResultList();
        if (!cidades.isEmpty()) {
            return cidades.get(0);
        }
        return null;
    }
    
    public Cidade pesquisarPorId(int idCidade) throws SQLException {
        Query query = entity.createNativeQuery("Select * from Cidade where idcidade = "+ idCidade , Cidade.class);
        List<Cidade> cidades = query.getResultList();
        if (!cidades.isEmpty()) {
            return cidades.get(0);
        }
        return null;
    }
}
