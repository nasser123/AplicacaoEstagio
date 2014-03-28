/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.config.ConnectionFactory;
import br.com.dao.SubGrupoDAO;
import br.com.model.Grupo;
import br.com.model.ListaAtributoSubgrupo;
import br.com.model.Subgrupo;
import br.com.model.TipoAtributo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser
 */
public class TelaNovoSubgrupo extends javax.swing.JFrame {

    /**
     * Creates new form TelaNovoSubgrupo
     */
    private SubGrupoDAO subGrupoDAO;
    private ArrayList<TipoAtributo> listaAtributosSelecionados;
    private ArrayList<TipoAtributo> listaAtributosNaoSelecionados;
    private ListaAtributoSubgrupo listaAtributoSubgrupo;
    

    public TelaNovoSubgrupo() {
        initComponents();
        listaAtributosSelecionados = new ArrayList();
    }

    public TelaNovoSubgrupo(Subgrupo subgrupo) {
        initComponents();
        this.subgrupo1 = subgrupo;
        jTextField1.setText("Editar Subgrupo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        AplicacaoEstagioPUEntityManager = ConnectionFactory.getEntityManager();
        grupoQuery = java.beans.Beans.isDesignTime() ? null : AplicacaoEstagioPUEntityManager.createQuery("SELECT g FROM Grupo g");
        grupoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(grupoQuery.getResultList());
        grupoListCellRenderer1 = new br.com.renderizadores.GrupoListCellRenderer();
        tipoAtributoQuery = java.beans.Beans.isDesignTime() ? null : AplicacaoEstagioPUEntityManager.createQuery("SELECT t FROM TipoAtributo t");
        tipoAtributoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(tipoAtributoQuery.getResultList());
        tiposAtributosCellRenderer1 = new br.com.renderizadores.TiposAtributosCellRenderer();
        subgrupo1 = new br.com.model.Subgrupo();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxGrupo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButtonGravar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAtributos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAtributosSelecionados = new javax.swing.JList();
        jButtonAdicionaAtributo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        grupoListCellRenderer1.setText("grupoListCellRenderer1");

        tiposAtributosCellRenderer1.setText("tiposAtributosCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Subgrupo");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, subgrupo1, org.jdesktop.beansbinding.ELProperty.create("${descricao}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Descrição");

        jComboBoxGrupo.setRenderer(grupoListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, grupoList, jComboBoxGrupo);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel3.setText("Grupo");

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jListAtributos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListAtributos.setCellRenderer(tiposAtributosCellRenderer1);

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tipoAtributoList, jListAtributos);
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(jListAtributos);

        jListAtributosSelecionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListAtributosSelecionados.setCellRenderer(tiposAtributosCellRenderer1);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaAtributoSubgrupoList}");
        jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, subgrupo1, eLProperty, jListAtributosSelecionados);
        bindingGroup.addBinding(jListBinding);

        jScrollPane2.setViewportView(jListAtributosSelecionados);

        jButtonAdicionaAtributo.setText(">");
        jButtonAdicionaAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionaAtributoActionPerformed(evt);
            }
        });

        jButton2.setText("<");

        jLabel4.setText("Tipos de Atributos");

        jLabel5.setText("Tipos de Atributos Selecionados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonGravar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAdicionaAtributo)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 60, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1)
                                .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonAdicionaAtributo)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGravar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        if ((jTextField1.getText() != null) && (jTextField1.getText() != "")) {
            Subgrupo sg = new Subgrupo();
            subGrupoDAO = new SubGrupoDAO();
            sg.setDescricao(jTextField1.getText());
            sg.setIdgrupo((Grupo) jComboBoxGrupo.getSelectedItem());
            this.dispose();
            try {
                subGrupoDAO.inserir(sg);
                for (int i = 0; i < jListAtributosSelecionados.getModel().getSize(); i++) {
                    listaAtributoSubgrupo = new ListaAtributoSubgrupo();
                    listaAtributoSubgrupo.setIdsubgrupo(sg);
                    listaAtributoSubgrupo.setIdtipoAtributo((TipoAtributo)jListAtributosSelecionados.getModel().getElementAt(i));
                    
                }
                JOptionPane.showMessageDialog(rootPane, "Subgrupo gravado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(TelaNovoSubgrupo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        List<TipoAtributo> aTipoAtributo = new ArrayList();
            for (int i = 0; i < jListAtributosSelecionados.getModel().getSize(); i++) {
                aTipoAtributo.add((TipoAtributo)jListAtributosSelecionados.getModel().getElementAt(i));
            }
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonAdicionaAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionaAtributoActionPerformed
        if (jListAtributos.getSelectedValue() != null) {
            TipoAtributo ta = (TipoAtributo) jListAtributos.getSelectedValue();
            listaAtributosSelecionados.add(ta);
        }
    }//GEN-LAST:event_jButtonAdicionaAtributoActionPerformed

    private void atualizaJList() {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNovoSubgrupo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoSubgrupo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoSubgrupo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoSubgrupo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoSubgrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AplicacaoEstagioPUEntityManager;
    private java.util.List<br.com.model.Grupo> grupoList;
    private br.com.renderizadores.GrupoListCellRenderer grupoListCellRenderer1;
    private javax.persistence.Query grupoQuery;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdicionaAtributo;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListAtributos;
    private javax.swing.JList jListAtributosSelecionados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private br.com.model.Subgrupo subgrupo1;
    private java.util.List<br.com.model.TipoAtributo> tipoAtributoList;
    private javax.persistence.Query tipoAtributoQuery;
    private br.com.renderizadores.TiposAtributosCellRenderer tiposAtributosCellRenderer1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
