/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.persistencia;

import br.com.config.ConnectionFactory;
import br.com.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
            //transforma a senha texto em md5
//            MessageDigest m = MessageDigest.getInstance("MD5");
//            m.update(senha.getBytes(), 0, senha.length());
//            senha = new BigInteger(1, m.digest()).toString(16);
            System.out.println(senha);

            List<Usuario> usuarios = getUsuariosBanco(username);
            boolean verifica = false;
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
                    if (usuario != null) {
                        if (senha.equals(usuario.getSenha())) {
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
    
    
}

    
    
    
    
