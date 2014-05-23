/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.telas;

import br.com.model.Usuario;
import br.com.dao.Variaveis;
import br.com.utilidades.ConfigTelas;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Usuario usuario;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        //this.usuario = u;
        initComponents();
        jLabel1.setText(Variaveis.getUsuario().getNome());
        ConfigTelas ct = new ConfigTelas(this);
        ct.carregarConfig(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonGrupos = new javax.swing.JButton();
        jButtonVenda = new javax.swing.JButton();
        jButtonProdutos = new javax.swing.JButton();
        jButtonSubgrupos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonServicos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        Produtos = new javax.swing.JMenu();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenuItemGrupos = new javax.swing.JMenuItem();
        jMenuItemSubgrupos = new javax.swing.JMenuItem();
        jMenuItemFabricantes = new javax.swing.JMenuItem();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemVenda = new javax.swing.JMenuItem();
        jMenuItemNotasEntrada = new javax.swing.JMenuItem();
        jMenuItemOrçamento = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemContasPagar = new javax.swing.JMenuItem();
        jMenuItemContasReceber = new javax.swing.JMenuItem();
        jMenuServicos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonGrupos.setText("Grupos");
        jButtonGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGruposActionPerformed(evt);
            }
        });

        jButtonVenda.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/buy_64.png"))); // NOI18N
        jButtonVenda.setText("Venda");
        jButtonVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVenda.setPreferredSize(new java.awt.Dimension(97, 97));
        jButtonVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendaActionPerformed(evt);
            }
        });

        jButtonProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/file-roller.png"))); // NOI18N
        jButtonProdutos.setText("Produtos");
        jButtonProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutosActionPerformed(evt);
            }
        });

        jButtonSubgrupos.setText("Subgrupos");
        jButtonSubgrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubgruposActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/exit_64.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/user_64.png"))); // NOI18N
        jButtonUsuarios.setText("Usuários");
        jButtonUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jButtonServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/servico_32.png"))); // NOI18N
        jButtonServicos.setText("Serviços");
        jButtonServicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSubgrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSubgrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenuCadastros.setText("Cadastros");

        Produtos.setText("Produtos");

        jMenuItemProdutos.setText("Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        Produtos.add(jMenuItemProdutos);

        jMenuItemGrupos.setText("Grupos de Produto");
        jMenuItemGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGruposActionPerformed(evt);
            }
        });
        Produtos.add(jMenuItemGrupos);

        jMenuItemSubgrupos.setText("Subgrupos de Produto");
        jMenuItemSubgrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSubgruposActionPerformed(evt);
            }
        });
        Produtos.add(jMenuItemSubgrupos);

        jMenuItemFabricantes.setText("Fabricantes");
        jMenuItemFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFabricantesActionPerformed(evt);
            }
        });
        Produtos.add(jMenuItemFabricantes);

        jMenuCadastros.add(Produtos);

        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFornecedores);

        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemClientes);

        jMenuBar1.add(jMenuCadastros);

        jMenu2.setText("Movimentos");

        jMenuItemVenda.setText("Venda");
        jMenu2.add(jMenuItemVenda);

        jMenuItemNotasEntrada.setText("Notas Entrada");
        jMenuItemNotasEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNotasEntradaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemNotasEntrada);

        jMenuItemOrçamento.setText("Orçamento");
        jMenuItemOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOrçamentoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemOrçamento);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Caixa");

        jMenuItemContasPagar.setText("Contas a Pagar");
        jMenuItemContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasPagarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemContasPagar);

        jMenuItemContasReceber.setText("Contas a Receber");
        jMenuItemContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasReceberActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemContasReceber);

        jMenuBar1.add(jMenu1);

        jMenuServicos.setText("Serviços");
        jMenuServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuServicosActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuServicos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGruposActionPerformed
        new TelaGrupo().setVisible(true);
        //this.dispose();
                
    }//GEN-LAST:event_jButtonGruposActionPerformed

    private void jButtonProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutosActionPerformed
        new TelaListaProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonProdutosActionPerformed

    private void jButtonSubgruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubgruposActionPerformed
        new TelaSubgrupo().setVisible(true);
    }//GEN-LAST:event_jButtonSubgruposActionPerformed

    private void jButtonVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jButtonVendaActionPerformed

    private void jMenuItemFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedoresActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemFornecedoresActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
       new TelaCadastroCliente().setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFabricantesActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemFabricantesActionPerformed

    private void jMenuItemNotasEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNotasEntradaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemNotasEntradaActionPerformed

    private void jMenuItemOrçamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOrçamentoActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemOrçamentoActionPerformed

    private void jMenuItemContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasPagarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemContasPagarActionPerformed

    private void jMenuItemContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasReceberActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jMenuItemContasReceberActionPerformed

    private void jMenuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutosActionPerformed
        new TelaListaProdutos().setVisible(true);
    }//GEN-LAST:event_jMenuItemProdutosActionPerformed

    private void jMenuItemGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGruposActionPerformed
        new TelaGrupo().setVisible(true);
    }//GEN-LAST:event_jMenuItemGruposActionPerformed

    private void jMenuItemSubgruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSubgruposActionPerformed
        new TelaSubgrupo().setVisible(true);
    }//GEN-LAST:event_jMenuItemSubgruposActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Não implementado", Variaveis.getSiglaSistema(), 1);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicosActionPerformed
        new TelaListaOS().setVisible(true);
    }//GEN-LAST:event_jButtonServicosActionPerformed

    private void jMenuServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuServicosActionPerformed
         new TelaListaOS().setVisible(true);
    }//GEN-LAST:event_jMenuServicosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Produtos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGrupos;
    private javax.swing.JButton jButtonProdutos;
    private javax.swing.JButton jButtonServicos;
    private javax.swing.JButton jButtonSubgrupos;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JButton jButtonVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemContasPagar;
    private javax.swing.JMenuItem jMenuItemContasReceber;
    private javax.swing.JMenuItem jMenuItemFabricantes;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemGrupos;
    private javax.swing.JMenuItem jMenuItemNotasEntrada;
    private javax.swing.JMenuItem jMenuItemOrçamento;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemSubgrupos;
    private javax.swing.JMenuItem jMenuItemVenda;
    private javax.swing.JMenu jMenuServicos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
