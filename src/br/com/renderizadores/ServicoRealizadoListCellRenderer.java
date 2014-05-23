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
import br.com.model.Servico;
import br.com.model.ServicoRealizado;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ServicoRealizadoListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof ServicoRealizado) {
            ServicoRealizado s = (ServicoRealizado) value;
            setText(s.getIdservico().getDescricao());
            
            if(s.getIdsituacaoServico().getIdsituacaoServico() == 1){
                setBackground(Color.yellow);
                setForeground(Color.black);
            }
        }
        
        return this;
    }
}
