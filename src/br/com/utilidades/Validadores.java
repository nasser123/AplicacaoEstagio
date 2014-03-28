/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utilidades;

import java.math.BigDecimal;

/**
 *
 * @author Produção
 */
public class Validadores {

    public static boolean ehNr(String valor) {
        if (valor != null) {
            try {
                Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                return false;
            }

        }

        return true;
    }
    
    public static boolean ehDinheiro(String valor){
        if (valor != null) {
            try {
                new BigDecimal(valor);
            } catch (NumberFormatException nfe) {
                return false;
            }

        }

        return true;
    
    
    }
    
    
}
