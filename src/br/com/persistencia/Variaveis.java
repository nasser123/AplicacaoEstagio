/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.persistencia;

import br.com.config.ConnectionFactory;
import br.com.model.Usuario;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thiago
 */
public class Variaveis {

    private static Usuario usuario;
    private static Connection conexao;
    private static EntityManager entityManager;

    public static void setUsuario(Usuario usuario) {
        Variaveis.usuario = usuario;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static Usuario getUsuarioPadrao() {
//        EntityManager em = Persistence.createEntityManagerFactory("AplicacaoEstagioPU").createEntityManager();
//        usuario = em.find(Usuario.class, 1);
//        em.close();
        
        return usuario;
    }
    
//    public static void setConnection(){
//        conexao = ConnectionFactory.getConnection();
//    }
//    
//    public static Connection getConnection(){
//        return conexao;
//    }
//    
//    public static void setEntityManager(EntityManager em) throws InstantiationException{
//        entityManager = Persistence.createEntityManagerFactory("AplicacaoEstagioPU").createEntityManager();
//    }
//    
//    public static EntityManager getEntityManager(){
//        EntityManagerFactory emf;
//        entityManager = null;
//        
//        Map prop = new HashMap();  
//        prop.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/sistotal");  
//        prop.put("javax.persistence.jdbc.password", "12345");  
//        prop.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");  
//        prop.put("javax.persistence.jdbc.user", "root");  
//        //SQL-SERVER  
//  
//        emf = Persistence.createEntityManagerFactory("AplicacaoEstagioPU", prop);  
//        entityManager = emf.createEntityManager();
//        return entityManager;
//    }
}
