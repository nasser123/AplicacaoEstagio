/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.config.ConnectionFactory;
import br.com.dao.ClienteDAO;
import br.com.dao.OrdemServicoDAO;
import br.com.model.Cliente;
import br.com.model.Equipamento;
import br.com.model.OrdemServico;
import br.com.model.SituacaoOs;
import br.com.utilidades.ConfigTelas;
import br.com.utilidades.Datas;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Produção
 */
public class TelaCadastroOrdemServico extends javax.swing.JFrame {

    /**
     * Creates new form OrdemServicoCadastro
     */
    private Cliente cliente;
    private OrdemServico osCad;

    public TelaCadastroOrdemServico() {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        jDateChooserAbertura.setDate(Datas.getCurrentTime());
        jLabelTitulo.setText("Ordem de Serviço");
        jLabelNrOs.setText("");
    }

    public TelaCadastroOrdemServico(Cliente c) {
        this.osCad = new OrdemServico();
        this.cliente = c;
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        jTextFieldCodigo.setText(this.cliente.getIdcliente().toString());
        jTextFieldNome.setText(this.cliente.getNome());
        jTextFieldCelular.setText(this.cliente.getCelular().toString());
        jTextFieldFone.setText(this.cliente.getFone().toString());
        jDateChooserAbertura.setDate(Datas.getCurrentTime());
        jLabelNrOs.setText("");

    }

    public TelaCadastroOrdemServico(OrdemServico os) {
        initComponents();
        ConfigTelas ct = new ConfigTelas(this);
        this.osCad = os;
        this.cliente = this.osCad.getIdcliente();
        
       // jDateChooserAbertura.setDate(Datas.getCurrentTime());
        preencheTodosDados();
        jLabelTitulo.setText("Ordem de Serviço N° ");
        bloqueiaEdicao();

        jButtonNovo.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        
    }

    private void preencheTodosDados() {
        jTextFieldCodigo.setText(this.osCad.getIdcliente().getIdcliente().toString());
        jTextFieldNome.setText(this.osCad.getIdcliente().getNome());
        jTextFieldFone.setText(this.osCad.getIdcliente().getFone().toString());
        jTextFieldCelular.setText(this.osCad.getIdcliente().getCelular().toString());
        jTextFieldProcessador.setText(this.osCad.getProcessador());
        jTextFieldMemoria.setText((this.osCad.getMemoria()));
        jTextFieldDiscoRigido.setText(this.osCad.getDiscoRigido());
        jTextFieldFonte.setText(this.osCad.getFonte());
        jTextFieldPlacaMae.setText(this.osCad.getPlacaMae());
        jTextFieldMarca.setText(this.osCad.getMarca());
        jTextAreaEfeitoCliente.setText(this.osCad.getEfeitoCliente());
        jTextAreaObservacoes.setText(this.osCad.getObservacao());
        jComboBoxEquipamento.setSelectedItem(this.osCad.getIdequipamento());
        jComboBoxSituacaoOS.setSelectedItem(this.osCad.getIdsituacaoOs());
        jLabelNrOs.setText(this.osCad.getIdordemServico().toString());
        jDateChooserAbertura.setDate(this.osCad.getDataAbertura());
        jTextFieldTotalServicos.setText(this.osCad.getTotalServicos().toString());
    }

    private void bloqueiaEdicao() {
        jTextFieldCodigo.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldFone.setEnabled(false);
        jTextFieldCelular.setEnabled(false);
        jTextFieldProcessador.setEnabled(false);
        jTextFieldMemoria.setEnabled(false);
        jTextFieldDiscoRigido.setEnabled(false);;
        jTextFieldFonte.setEnabled(false);
        jTextFieldPlacaMae.setEnabled(false);
        jTextFieldMarca.setEnabled(false);
        jComboBoxEquipamento.setEnabled(false);
        jComboBoxSituacaoOS.setEnabled(false);
        jTextAreaEfeitoCliente.setEnabled(false);
        jTextAreaObservacoes.setEnabled(false);
        jDateChooserAbertura.setEnabled(false);

        jButtonGravar.setEnabled(false);

    }

    private void liberaEdicao() {
        jButtonPesquisar.setEnabled(true);
        jTextFieldCodigo.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jTextFieldFone.setEnabled(true);
        jTextFieldCelular.setEnabled(true);
        jTextFieldProcessador.setEnabled(true);
        jTextFieldMemoria.setEnabled(true);
        jTextFieldDiscoRigido.setEnabled(true);;
        jTextFieldFonte.setEnabled(true);
        jTextFieldPlacaMae.setEnabled(true);
        jTextFieldMarca.setEnabled(true);
        jComboBoxEquipamento.setEnabled(true);
        jComboBoxSituacaoOS.setEnabled(true);
        jTextAreaEfeitoCliente.setEnabled(true);
        jTextAreaObservacoes.setEnabled(true);

        jButtonGravar.setEnabled(true);

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

        SistotalPUEntityManager = ConnectionFactory.getEntityManager();
        equipamentoQuery = java.beans.Beans.isDesignTime() ? null : SistotalPUEntityManager.createQuery("SELECT e FROM Equipamento e");
        equipamentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : equipamentoQuery.getResultList();
        situacaoOsQuery = java.beans.Beans.isDesignTime() ? null : SistotalPUEntityManager.createQuery("SELECT s FROM SituacaoOs s");
        situacaoOsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : situacaoOsQuery.getResultList();
        equipamentoListCellRenderer1 = new br.com.renderizadores.EquipamentoListCellRenderer();
        situacaoOsListCellRenderer1 = new br.com.renderizadores.SituacaoOsListCellRenderer();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEfeitoCliente = new javax.swing.JTextArea();
        jTextFieldProcessador = new javax.swing.JTextField();
        jTextFieldMemoria = new javax.swing.JTextField();
        jTextFieldDiscoRigido = new javax.swing.JTextField();
        jComboBoxEquipamento = new javax.swing.JComboBox();
        jComboBoxSituacaoOS = new javax.swing.JComboBox();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldFonte = new javax.swing.JTextField();
        jTextFieldPlacaMae = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonGravar = new javax.swing.JButton();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldFone = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNrOs = new javax.swing.JLabel();
        jDateChooserAbertura = new com.toedter.calendar.JDateChooser();
        jButtonServicos = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTotalServicos = new javax.swing.JTextField();

        equipamentoListCellRenderer1.setText("equipamentoListCellRenderer1");

        situacaoOsListCellRenderer1.setText("situacaoOsListCellRenderer1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextAreaEfeitoCliente.setColumns(20);
        jTextAreaEfeitoCliente.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEfeitoCliente);

        jTextFieldMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMemoriaActionPerformed(evt);
            }
        });

        jComboBoxEquipamento.setRenderer(equipamentoListCellRenderer1);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, equipamentoList, jComboBoxEquipamento);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxSituacaoOS.setRenderer(situacaoOsListCellRenderer1);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, situacaoOsList, jComboBoxSituacaoOS);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setText("Ordem de Serviço  ");

        jLabel2.setText("Problemas Apresentados:");

        jLabel3.setText("Data de Abertura:");

        jTextFieldCodigo.setEnabled(false);
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jTextFieldNome.setEnabled(false);

        jLabel4.setText("Código");

        jLabel5.setText("Nome");

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/pesquisar16x16.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefone");

        jLabel7.setText("Celular");

        jLabel8.setText("Dados do Equipamento");

        jLabel9.setText("Processador");

        jLabel10.setText("Memória");

        jLabel11.setText("Disco Rígido");

        jLabel12.setText("Fonte");

        jTextFieldPlacaMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlacaMaeActionPerformed(evt);
            }
        });

        jLabel13.setText("Placa Mãe:");

        jLabel14.setText("Tipo de Equipamento:");

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jScrollPane3.setViewportView(jTextAreaObservacoes);

        jLabel15.setText("Observações:");

        jLabel16.setText("Situação");

        jButtonGravar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/save_64.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jLabel17.setText("Marca/Modelo:");

        jTextFieldFone.setEnabled(false);

        jTextFieldCelular.setEnabled(false);

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/add_user16x16.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/pencil_64.png"))); // NOI18N
        jButtonEditar.setText("editar");
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/block_64.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelNrOs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNrOs.setForeground(new java.awt.Color(255, 0, 0));
        jLabelNrOs.setText("jLabel18");

        jButtonServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/add_servico_64.png"))); // NOI18N
        jButtonServicos.setText("Incluir Serviços");
        jButtonServicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicosActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/exit_64.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Total de serviços:");

        jTextFieldTotalServicos.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPlacaMae, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jTextFieldFone))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCelular)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jTextFieldDiscoRigido, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jButtonServicos)
                                    .addGap(51, 51, 51)
                                    .addComponent(jButtonCancelar)
                                    .addGap(53, 53, 53)
                                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(243, 243, 243)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jButtonGravar)
                                        .addGap(44, 44, 44)
                                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNrOs))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSituacaoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNrOs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jTextFieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDiscoRigido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPlacaMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxSituacaoOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(jButtonCancelar))
                            .addComponent(jButtonServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(816, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMemoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMemoriaActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        TelaListaClientes tlc = new TelaListaClientes();
        tlc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldPlacaMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlacaMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlacaMaeActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed

        OrdemServicoDAO osd = new OrdemServicoDAO();
        this.osCad.setProcessador(this.jTextFieldProcessador.getText());
        this.osCad.setMemoria(this.jTextFieldMemoria.getText());
        this.osCad.setDiscoRigido(this.jTextFieldDiscoRigido.getText());
        this.osCad.setFonte(this.jTextFieldFonte.getText());
        this.osCad.setPlacaMae(this.jTextFieldPlacaMae.getText());
        this.osCad.setMarca(this.jTextFieldMarca.getText());
        this.osCad.setIdequipamento((Equipamento) jComboBoxEquipamento.getSelectedItem());
        this.osCad.setEfeitoCliente(jTextAreaEfeitoCliente.getText());
        this.osCad.setObservacao(jTextAreaObservacoes.getText());
        this.osCad.setIdsituacaoOs((SituacaoOs) jComboBoxSituacaoOS.getSelectedItem());
        this.osCad.setDataAbertura(jDateChooserAbertura.getDate());
        if (this.cliente.getIdcliente() != null) {
            this.osCad.setIdcliente(this.cliente);
        } else {
            ClienteDAO cd = new ClienteDAO();

            this.cliente.setNome(jTextFieldNome.getText());
            this.cliente.setCelular(new BigInteger(jTextFieldCelular.getText()));
            this.cliente.setFone(new BigInteger(jTextFieldFone.getText()));
            try {
                cd.inserir(this.cliente);
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.osCad.setIdcliente(this.cliente);
        }

        if (this.osCad.getIdordemServico() != null) {

            try {
                osd.alterar(this.osCad);
                JOptionPane.showMessageDialog(rootPane, "Ordem de serviço alterada com sucesso");
                TelaListaOS tlo = new TelaListaOS();
                tlo.setVisible(true);

                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }

//            SistotalPUEntityManager.getTransaction().begin();
//            SistotalPUEntityManager.merge(this.osCad);
//            SistotalPUEntityManager.getTransaction().commit();
        } else {
            OrdemServico os = new OrdemServico();
            os = this.osCad;
            try {
                osd.inserir(this.osCad);
                JOptionPane.showMessageDialog(rootPane, "Ordem de serviço gravada com sucesso");
                TelaCadastroOrdemServico osc = new TelaCadastroOrdemServico();
                osc.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }

//            SistotalPUEntityManager.getTransaction().begin();
//            SistotalPUEntityManager.persist(os);
//            SistotalPUEntityManager.getTransaction().commit();
        }

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        new TelaCadastroCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        liberaEdicao();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    //    if (this.osCad != null) {
            TelaListaOS tlo = new TelaListaOS();
            tlo.setVisible(true);
            this.dispose();
//        } else {
//            this.dispose();
//
//        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicosActionPerformed
        TelaInserirServicoNaOS tiso = new TelaInserirServicoNaOS(this.osCad);
        tiso.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonServicosActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaCadastroOrdemServico().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SistotalPUEntityManager;
    private java.util.List<br.com.model.Equipamento> equipamentoList;
    private br.com.renderizadores.EquipamentoListCellRenderer equipamentoListCellRenderer1;
    private javax.persistence.Query equipamentoQuery;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonServicos;
    private javax.swing.JComboBox jComboBoxEquipamento;
    private javax.swing.JComboBox jComboBoxSituacaoOS;
    private com.toedter.calendar.JDateChooser jDateChooserAbertura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNrOs;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaEfeitoCliente;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDiscoRigido;
    private javax.swing.JTextField jTextFieldFone;
    private javax.swing.JTextField jTextFieldFonte;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMemoria;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPlacaMae;
    private javax.swing.JTextField jTextFieldProcessador;
    private javax.swing.JTextField jTextFieldTotalServicos;
    private java.util.List<br.com.model.SituacaoOs> situacaoOsList;
    private br.com.renderizadores.SituacaoOsListCellRenderer situacaoOsListCellRenderer1;
    private javax.persistence.Query situacaoOsQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
