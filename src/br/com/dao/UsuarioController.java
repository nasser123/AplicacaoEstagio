/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.config.ConnectionFactory;
import br.com.model.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nasser
 */
public class UsuarioController {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private EntityManager entity;

    public UsuarioController() {
        this.entity = ConnectionFactory.getEntityManager();
    }

    /*
     * Retorna do banco de dados o objeto usuario
     * 
     */
    private List<Usuario> getUsuariosBanco(String usuario) {
        //EntityManager em = Persistence.createEntityManagerFactory("AplicacaoEstagioPU").createEntityManager();
        //return em.createNamedQuery("Usuario.findByUsername", Usuario.class).setParameter("username", usuario).getResultList();
        return entity.createNamedQuery("Usuario.findByUsername").setParameter("username", usuario).getResultList();

    }

    /*
     * Realiza o teste de login
     */
    public boolean verificaLogin(String username, String senha) throws NoSuchAlgorithmException {
        if (senha != null) {
//            transforma a senha texto em md5
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(), 0, senha.length());
            String s = new BigInteger(1, m.digest()).toString(16);
            System.out.println(s);

            List<Usuario> usuarios = getUsuariosBanco(username);
            boolean verifica = false;
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
                    if (usuario != null) {
                        if (s.equals(usuario.getSenha())) {
                            verifica = true;
                            Variaveis.setUsuario(usuario);
                            break;
                        }
                    }
                }
            }
            return verifica;
        }
        return false;
    }

    public Usuario inserir(Usuario usuario) throws SQLException {
        if (usuario instanceof Usuario) {
            Usuario u = usuario;
            if (!existeUsername(u.getUsername())) {
                entity.getTransaction().begin();
                entity.persist(u);
                entity.getTransaction().commit();

                return u;
            }
        }
        return null;
    }
    
    public Usuario excluir(Usuario usuario) throws SQLException {
        if (usuario instanceof Usuario) {
            Usuario s =  usuario;
            entity.getTransaction().begin();
            entity.remove(s);
            entity.getTransaction().commit();

            return s;
        }
        return null;
    }

    private boolean existeUsername(String username) {
        Usuario u = null;
        List usuarios = entity.createNamedQuery("Usuario.findByUsername").setParameter("username", username).getResultList();
        if (!usuarios.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public Usuario pesquisarPorId(int id) throws SQLException {
        Usuario u = null;
        List usuarios = entity.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", id).getResultList();
        if (!usuarios.isEmpty()) {
            u = (Usuario) usuarios.get(0);
            return u;
        }

        return null;
    }
}
