/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.config.ConnectionFactory;
import br.com.dao.ProdutoDAO;
import br.com.dao.SubGrupoDAO;
import br.com.model.Fabricante;
import br.com.model.Grupo;
import br.com.model.Produto;
import br.com.model.Subgrupo;
import br.com.utilidades.Validadores;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser
 */
public class TelaCadastroProduto extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroProduto
     */
    private Produto produto;
    private ProdutoDAO pdao;
    private int idproduto = 1;
    private SubGrupoDAO sbdao;
    private boolean editando = false;
    private boolean novo = false;
    private boolean validado = true;

    public TelaCadastroProduto(Produto produto) throws SQLException {
        //this.idproduto = idproduto;
        pdao = new ProdutoDAO();
        this.produto = produto;
        initComponents();

    }

    public TelaCadastroProduto() throws SQLException {
        //this.idproduto = idproduto;
        pdao = new ProdutoDAO();
        novo = true;

        // this.produto = pdao.pesquisarPorId(idproduto);
        initComponents();
        jButtonExcluir.setVisible(false);
        liberaCampos();

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
        gruposListCellRenderer1 = new br.com.renderizadores.GrupoListCellRenderer();
        subgrupoListCellRenderer1 = new br.com.renderizadores.SubgrupoListCellRenderer();
        produto1 = this.produto;
        fabricanteQuery = java.beans.Beans.isDesignTime() ? null : AplicacaoEstagioPUEntityManager.createQuery("SELECT f FROM Fabricante f");
        fabricanteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : fabricanteQuery.getResultList();
        fabricanteListCellRenderer1 = new br.com.renderizadores.FabricanteListCellRenderer();
        grupoQuery = java.beans.Beans.isDesignTime() ? null : AplicacaoEstagioPUEntityManager.createQuery("SELECT g FROM Grupo g");
        grupoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : grupoQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigoBarras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextFieldEntrada = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSaidas = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEstoqueMinimo = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEstoque = new javax.swing.JFormattedTextField();
        jButtonGravar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jTextFieldPreco3 = new javax.swing.JTextField();
        jTextFieldPreco2 = new javax.swing.JTextField();
        jTextFieldPreco1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxFabricante = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxGrupo = new javax.swing.JComboBox();
        jComboBoxSubGrupo = new javax.swing.JComboBox();
        jButtonSair = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        gruposListCellRenderer1.setText("gruposListCellRenderer1");

        subgrupoListCellRenderer1.setText("subgrupoListCellRenderer1");

        fabricanteListCellRenderer1.setText("fabricanteListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldDescricao.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${descricao}"), jTextFieldDescricao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextFieldDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 127, 300, -1));

        jLabel1.setText("Descrição");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 107, 300, -1));

        jTextFieldCodigo.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${codigo}"), jTextFieldCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 65, -1));

        jLabel2.setText("Código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 107, 65, -1));

        jLabel3.setText("Código de Barras");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 107, 100, -1));

        jTextFieldCodigoBarras.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${codigobarras}"), jTextFieldCodigoBarras, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextFieldCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 127, 100, -1));

        jLabel4.setText("Preço 1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, 100, -1));

        jLabel5.setText("Preço 2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 159, 100, -1));

        jLabel6.setText("Preço 3");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 159, 100, -1));

        jLabel7.setText("Entradas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 222, 80, -1));

        jLabel8.setText("Saídas");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 222, 80, -1));

        jLabel9.setText("Estoque Mínimo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 222, 80, -1));

        jLabel10.setText("Estoque");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 222, 80, -1));

        jFormattedTextFieldEntrada.setEditable(false);
        jFormattedTextFieldEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${entrada}"), jFormattedTextFieldEntrada, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jFormattedTextFieldEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 247, 80, -1));

        jFormattedTextFieldSaidas.setEditable(false);
        jFormattedTextFieldSaidas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${saida}"), jFormattedTextFieldSaidas, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jFormattedTextFieldSaidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 247, 80, -1));

        jFormattedTextFieldEstoqueMinimo.setEditable(false);
        jFormattedTextFieldEstoqueMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${estoqueMinimo}"), jFormattedTextFieldEstoqueMinimo, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jFormattedTextFieldEstoqueMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 247, 80, -1));

        jFormattedTextFieldEstoque.setEditable(false);
        jFormattedTextFieldEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${estoque}"), jFormattedTextFieldEstoque, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jFormattedTextFieldEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 247, 80, -1));

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, -1, -1));

        jLabel11.setText("Grupo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel12.setText("Subgrupo");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 290, -1, -1));

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, -1, -1));

        jTextFieldPreco3.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${precoVenda3}"), jTextFieldPreco3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldPreco3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPreco3FocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldPreco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 180, 100, -1));

        jTextFieldPreco2.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${precoVenda2}"), jTextFieldPreco2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldPreco2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPreco2FocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldPreco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 180, 100, -1));

        jTextFieldPreco1.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${precoVenda1}"), jTextFieldPreco1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextFieldPreco1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPreco1FocusLost(evt);
            }
        });
        jPanel1.add(jTextFieldPreco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, -1));

        jTextField1.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${idsubgrupo.descricao}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 220, -1));

        jTextField2.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${idsubgrupo.idgrupo.descricao}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 190, -1));

        jComboBoxFabricante.setEnabled(false);
        jComboBoxFabricante.setRenderer(fabricanteListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, fabricanteList, jComboBoxFabricante);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produto1, org.jdesktop.beansbinding.ELProperty.create("${idfabricante}"), jComboBoxFabricante, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jComboBoxFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 190, -1));

        jLabel13.setText("Fabricante");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jComboBoxGrupo.setRenderer(gruposListCellRenderer1);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, grupoList, jComboBoxGrupo);
        bindingGroup.addBinding(jComboBoxBinding);

        jPanel1.add(jComboBoxGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 190, -1));

        jComboBoxSubGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSubGrupo.setRenderer(subgrupoListCellRenderer1);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.subgrupoList}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jComboBoxGrupo, eLProperty, jComboBoxSubGrupo);
        bindingGroup.addBinding(jComboBoxBinding);

        jPanel1.add(jComboBoxSubGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 220, -1));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, -1, -1));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        if (validado) {
            if (!novo) {
                produto1.setIdsubgrupo((Subgrupo) jComboBoxSubGrupo.getSelectedItem());
                try {
                    boolean alterado = pdao.alterar(produto1);
                    if (alterado) {
                        JOptionPane.showMessageDialog(rootPane, "Produto salvo");
                    }
                    this.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro");
                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                produto1 = new Produto();
                produto1.setCodigo(Integer.parseInt(jTextFieldCodigo.getText()));
                produto1.setCodigobarras(jTextFieldCodigoBarras.getText());
                produto1.setDescricao(jTextFieldDescricao.getText());
                produto1.setPrecoVenda1(new BigDecimal(jTextFieldPreco1.getText()));
                produto1.setPrecoVenda2(new BigDecimal(jTextFieldPreco2.getText()));
                produto1.setPrecoVenda3(new BigDecimal(jTextFieldPreco3.getText()));
                produto1.setEntrada(Integer.parseInt(jFormattedTextFieldEntrada.getText()));
                produto1.setSaida(Integer.parseInt(jFormattedTextFieldSaidas.getText()));
                produto1.setEstoqueMinimo(Integer.parseInt(jFormattedTextFieldEstoqueMinimo.getText()));
                produto1.setIdsubgrupo((Subgrupo) jComboBoxSubGrupo.getSelectedItem());
                produto1.setIdfabricante((Fabricante) jComboBoxFabricante.getSelectedItem());

                try {

                    boolean inserido = pdao.inserir(produto1);
                    if (inserido) {
                        JOptionPane.showMessageDialog(rootPane, "Produto gravado com sucesso");
                    }
                    new TelaListaProdutos().setVisible(true);
                    this.dispose();

                } catch (SQLException ex) {
                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Verifique erro de digitação", "SisGeMPE", 0);
                }

            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "verifique os valores digitados", "SisGeMPE", 0);

        }


    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void liberaCampos() {
        jTextFieldCodigoBarras.setEditable(true);
        jTextFieldDescricao.setEditable(true);
        jFormattedTextFieldEstoqueMinimo.setEditable(true);
        jTextFieldPreco1.setEditable(true);
        jTextFieldPreco2.setEditable(true);
        jTextFieldPreco3.setEditable(true);
        jComboBoxFabricante.setEnabled(true);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);

        if (!novo) {
            Subgrupo sg = produto1.getIdsubgrupo();
            Grupo g = sg.getIdgrupo();
            jComboBoxSubGrupo.setSelectedItem(sg);
            jComboBoxGrupo.setSelectedItem(g);
        } else {
            jTextFieldCodigo.setEditable(true);
            jFormattedTextFieldEntrada.setEditable(true);
            jFormattedTextFieldSaidas.setEditable(true);
        }
        this.editando = true;

    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        liberaCampos();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void preencheComboGrupo() {

    }


    private void jTextFieldPreco3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPreco3FocusLost
        this.validado = Validadores.ehDinheiro(jTextFieldPreco3.getText());
        if (!novo) {
            jTextFieldPreco3.setText(produto1.getPrecoVenda3().toString());
        }
        this.validado = Validadores.ehDinheiro(jTextFieldPreco3.getText());

    }//GEN-LAST:event_jTextFieldPreco3FocusLost

    private void jTextFieldPreco2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPreco2FocusLost
        this.validado = Validadores.ehDinheiro(jTextFieldPreco3.getText());
        if (!novo)
        jTextFieldPreco2.setText(produto1.getPrecoVenda2().toString());    }//GEN-LAST:event_jTextFieldPreco2FocusLost

    private void jTextFieldPreco1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPreco1FocusLost
        this.validado = Validadores.ehDinheiro(jTextFieldPreco3.getText());
        if (!novo)
        jTextFieldPreco1.setText(produto1.getPrecoVenda1().toString());    }//GEN-LAST:event_jTextFieldPreco1FocusLost

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new TelaListaProdutos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        new TelaListaProdutos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            boolean excluido = pdao.excluir(produto1);
            if (excluido) {
                JOptionPane.showMessageDialog(rootPane, "Produto excluido com êxito", "SisGeMPE", 1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new TelaCadastroProduto(1).setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(TelaCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AplicacaoEstagioPUEntityManager;
    private java.util.List<br.com.model.Fabricante> fabricanteList;
    private br.com.renderizadores.FabricanteListCellRenderer fabricanteListCellRenderer1;
    private javax.persistence.Query fabricanteQuery;
    private java.util.List<br.com.model.Grupo> grupoList;
    private javax.persistence.Query grupoQuery;
    private br.com.renderizadores.GrupoListCellRenderer gruposListCellRenderer1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxFabricante;
    private javax.swing.JComboBox jComboBoxGrupo;
    private javax.swing.JComboBox jComboBoxSubGrupo;
    private javax.swing.JFormattedTextField jFormattedTextFieldEntrada;
    private javax.swing.JFormattedTextField jFormattedTextFieldEstoque;
    private javax.swing.JFormattedTextField jFormattedTextFieldEstoqueMinimo;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCodigoBarras;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldPreco1;
    private javax.swing.JTextField jTextFieldPreco2;
    private javax.swing.JTextField jTextFieldPreco3;
    private br.com.model.Produto produto1;
    private br.com.renderizadores.SubgrupoListCellRenderer subgrupoListCellRenderer1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
