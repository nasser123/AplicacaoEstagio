/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renderizadores;

/**
 *
 * @author nasser
 */
import br.com.model.SituacaoOs;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class SituacaoOsListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof SituacaoOs) {
            SituacaoOs so = (SituacaoOs) value;
            setText(so.getDescricao());
            
            if(so.getIdsituacaoOs() == 1){
                setBackground(Color.red);
                setForeground(Color.black);
            }
            if(so.getIdsituacaoOs() == 2){
                setBackground(Color.yellow);
                setForeground(Color.black);
            }
            if(so.getIdsituacaoOs() == 3){
                setBackground(Color.green);
                setForeground(Color.black);
            }
        }
        return this;
    }
}
