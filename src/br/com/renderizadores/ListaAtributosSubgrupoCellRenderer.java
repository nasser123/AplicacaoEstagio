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
import br.com.model.ListaAtributoSubgrupo;
import br.com.model.TipoAtributo;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ListaAtributosSubgrupoCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof ListaAtributoSubgrupo) {
            ListaAtributoSubgrupo las = (ListaAtributoSubgrupo) value;
            setText(las.getIdtipoAtributo().getDescricao());
        }
        return this;
    }
}
