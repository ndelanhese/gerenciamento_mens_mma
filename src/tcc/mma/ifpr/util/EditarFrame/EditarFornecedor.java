/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.EditarFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cidade;
import tcc.mma.ifpr.bean.Estado;
import tcc.mma.ifpr.bean.Fornecedor;
import tcc.mma.ifpr.dao.CidadeDAO;
import tcc.mma.ifpr.dao.EstadoDAO;
import tcc.mma.ifpr.dao.FornecedorDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCidade;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFornecedor;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirFornecedor;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCidade;
import tcc.mma.ifpr.util.TableModel.TableModelFornecedorFull;
import tcc.mma.ifpr.util.Validar.CNPJ;
import tcc.mma.ifpr.util.Validar.CPF;
import tcc.mma.ifpr.util.Validar.Texto;

/**
 *
 * @author nnath
 */
public class EditarFornecedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarFornecedor
     */
    public EditarFornecedor() {
        initComponents();

    }
    int a = 0;

    public void pegarTabela() {
        a = 1;
        if (jcLimite.isSelected()) {
            txtCNPJ.setVisible(false);

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveAll1Full();
                TableModelFornecedorFull tableModelFornecedor = new TableModelFornecedorFull();
                jtFornecedor.setModel(tableModelFornecedor);

                for (int i = 0; i < forne.size(); i++) {

                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor.setId(forne.get(i).getId());
                    fornecedor.setRazaoSocial(forne.get(i).getRazaoSocial());
                    fornecedor.setTelefone(forne.get(i).getTelefone());
                    fornecedor.setCpfCnpj(forne.get(i).getCpfCnpj());
                    tableModelFornecedor.addRow(fornecedor);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar a tabela!");
            }
        } else {
            txtCNPJ.setVisible(false);

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveAll1();
                TableModelFornecedorFull tableModelFornecedor = new TableModelFornecedorFull();
                jtFornecedor.setModel(tableModelFornecedor);

                for (int i = 0; i < forne.size(); i++) {

                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor.setId(forne.get(i).getId());
                    fornecedor.setRazaoSocial(forne.get(i).getRazaoSocial());
                    fornecedor.setTelefone(forne.get(i).getTelefone());
                    fornecedor.setCpfCnpj(forne.get(i).getCpfCnpj());
                    tableModelFornecedor.addRow(fornecedor);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar a tabela!");
            }
        }

    }

    public void pegarTabela1() {
        a = 1;

        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            FornecedorDAO daoFornecedor = new FornecedorDAO(con);
            List<Fornecedor> forne = daoFornecedor.retrieveAll1Full();
            TableModelFornecedorFull tableModelFornecedor = new TableModelFornecedorFull();
            jtFornecedor.setModel(tableModelFornecedor);

            for (int i = 0; i < forne.size(); i++) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(forne.get(i).getId());
                fornecedor.setRazaoSocial(forne.get(i).getRazaoSocial());
                fornecedor.setTelefone(forne.get(i).getTelefone());
                fornecedor.setCpfCnpj(forne.get(i).getCpfCnpj());
                tableModelFornecedor.addRow(fornecedor);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a tabela!");
        }

    }

    public void estado() {
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            EstadoDAO daoEstado = new EstadoDAO(con);

            for (int i = 1; i < 28; i++) {
                Estado estado = daoEstado.retrieve(i);

                jcbEstado.addItem(estado.getNome() + " - " + estado.getUf());
            }

            jcbEstado.setSelectedIndex(17);

        } catch (Exception e) {
        }
    }

    public int validarCPF(String cpf) {
        int resposta = 0;

        CPF pf = new CPF(cpf);
        if (pf.isCPF()) {
            resposta = 1;
        } else {
            resposta = 2;
        }

        return resposta;
    }

    public int validarCNPJ(String cnpj) {
        int resposta = 0;

        CNPJ pj = new CNPJ(cnpj);
        if (pj.isCNPJ()) {
            resposta = 1;
        } else {
            resposta = 2;
        }

        return resposta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtFornecedor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeContato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jbEditar = new javax.swing.JButton();
        jbCadastrarNovo = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        cbPessoa = new javax.swing.JComboBox<>();
        lblCpfCnpj = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JFormattedTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jcLimite = new javax.swing.JCheckBox();
        jbBuscarCidade3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Editar Fornecedor");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Razão Social", "Telefone", "CPF / CPNJ"
            }
        ));
        jtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFornecedor);

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setText("Razão Social:");

        txtRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazaoSocialKeyPressed(evt);
            }
        });

        jLabel3.setText("Telefone:");

        jLabel4.setText("Nome Contato:");

        jLabel6.setText("Cidade:");

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidadeKeyPressed(evt);
            }
        });

        jLabel7.setText("Estado:");

        jLabel8.setText("Endereço:");

        jLabel9.setText("Número:");

        jLabel10.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLabel11.setText("Bairro:");

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbCadastrarNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrarNovo.setText("Cadastrar Novo");
        jbCadastrarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarNovoActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Pessoa:");

        cbPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Jurídica" }));
        cbPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPessoaActionPerformed(evt);
            }
        });

        lblCpfCnpj.setText("CPF:");

        try {
            txtCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfCnpjFocusLost(evt);
            }
        });

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCNPJFocusLost(evt);
            }
        });

        jcLimite.setSelected(true);
        jcLimite.setText("Limite de busca no bando de dados");
        jcLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcLimiteFocusGained(evt);
            }
        });
        jcLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcLimiteActionPerformed(evt);
            }
        });

        jbBuscarCidade3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCidade3.setText("Buscar");
        jbBuscarCidade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCidade3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCadastrarNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNumero)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbBuscarCidade3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEndereco))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCpfCnpj)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCNPJ))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 734, Short.MAX_VALUE)
                                .addComponent(jcLimite)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrarNovo, jbEditar, jbExcluir, jbLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jbBuscar)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpfCnpj)
                    .addComponent(cbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbBuscarCidade3)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbCadastrarNovo)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jtFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFornecedorMouseClicked

        if (a == 0 || a == 1) {

            int linhaSelecionada = jtFornecedor.getSelectedRow();

            if (linhaSelecionada != -1) {
                TableModelFornecedorFull tbFornecedor = (TableModelFornecedorFull) jtFornecedor.getModel();
                Fornecedor fornecedore = tbFornecedor.getFornecedor(jtFornecedor.getSelectedRow());

                try {
                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                    FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                    Fornecedor fornecedor = daoFornecedor.retrieve(fornecedore.getId());

                    txtID.setText(String.valueOf(fornecedor.getId()));
                    txtRazaoSocial.setText(fornecedor.getRazaoSocial());
                    txtTelefone.setText(fornecedor.getTelefone());
                    txtNomeContato.setText(fornecedor.getNomeContato());

                    String cpfcnpj = fornecedor.getCpfCnpj();
                    if (cpfcnpj.length() > 15) {
                        txtCpfCnpj.setVisible(false);
                        txtCNPJ.setVisible(true);
                        cbPessoa.setSelectedIndex(1);
                        txtCNPJ.setText(fornecedor.getCpfCnpj());
                    } else {
                        txtCNPJ.setVisible(false);
                        txtCpfCnpj.setVisible(true);
                        cbPessoa.setSelectedIndex(0);
                        txtCpfCnpj.setText(fornecedor.getCpfCnpj());
                    }

                    txtCidade.setText(fornecedor.getCidade());
                    jcbEstado.setSelectedIndex(fornecedor.getEstado().getId() - 1);
                    txtEndereco.setText(fornecedor.getEndereco());
                    txtNumero.setText(fornecedor.getNumero());
                    txtBairro.setText(fornecedor.getBairro());
                    jcbStatus.setSelectedIndex(fornecedor.getStatus() - 1);

                    jbCadastrarNovo.setEnabled(false);
                    jbEditar.setEnabled(true);
                    jbExcluir.setEnabled(true);

                    pegarTabela();

                    if (cpfcnpj.length() > 15) {
                        txtCpfCnpj.setVisible(false);
                        txtCNPJ.setVisible(true);
                        cbPessoa.setSelectedIndex(1);
                        txtCNPJ.setText(fornecedor.getCpfCnpj());
                    } else {
                        txtCNPJ.setVisible(false);
                        txtCpfCnpj.setVisible(true);
                        cbPessoa.setSelectedIndex(0);
                        txtCpfCnpj.setText(fornecedor.getCpfCnpj());
                    }
                } catch (Exception e) {
                }

            }
        } else {
            if (a == 2) {
                int linhaSelecionada = jtFornecedor.getSelectedRow();

                if (linhaSelecionada != -1) {
                    TableModelCidade tbCidade = (TableModelCidade) jtFornecedor.getModel();
                    Cidade cidade = tbCidade.getCidade(jtFornecedor.getSelectedRow());

                    txtCidade.setText(cidade.getNome());
                    jcbEstado.setSelectedIndex(cidade.getEstado().getId() - 1);

                    jbCadastrarNovo.setEnabled(true);
                    jbEditar.setEnabled(true);
                    jbExcluir.setEnabled(true);

                }

            }
            pegarTabela1();
        }


    }//GEN-LAST:event_jtFornecedorMouseClicked

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Texto texto = new Texto();
        String razaoSocialRetorno = texto.textoConverter(txtRazaoSocial.getText());
        txtRazaoSocial.setText(razaoSocialRetorno);

        String nomeContatoRetorno = texto.textoConverter(txtNomeContato.getText());
        txtNomeContato.setText(nomeContatoRetorno);

        String retornoBairro = texto.textoConverter(txtBairro.getText());
        txtBairro.setText(retornoBairro);

        String retornoEndereco = texto.textoConverter(txtEndereco.getText());
        txtEndereco.setText(retornoEndereco);
        String cpfCnpjT = "";

        if (cbPessoa.getSelectedIndex() == 0) {

            String cpf = txtCpfCnpj.getText();

            int resposta = validarCPF(cpf);

            if (resposta == 2) {
                JOptionPane.showMessageDialog(null, "CPF inválido!", "Atenção", NORMAL);
                txtCpfCnpj.setText(null);
            }

            cpfCnpjT = txtCpfCnpj.getText();
        } else {

            String cnpj = txtCNPJ.getText();

            int resposta = validarCNPJ(cnpj);

            if (resposta == 2) {
                JOptionPane.showMessageDialog(null, "CNPJ inválido!", "Atenção", NORMAL);
                txtCNPJ.setText(null);
            }
            cpfCnpjT = txtCNPJ.getText();
        }

        if (txtBairro.getText().isEmpty() || txtCidade.getText().isEmpty()
                || cpfCnpjT.equals("   .   .   -  ") || txtEndereco.getText().isEmpty()
                || txtNomeContato.getText().isEmpty() || txtNumero.getText().isEmpty()
                || txtRazaoSocial.getText().isEmpty() || txtTelefone.getText().isEmpty()
                || cpfCnpjT.equals("   .   .   /    -  ")) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos do formulário para concluir a edição do Fornecedor!",
                    "Atenção", NORMAL);

        } else {

            int id = Integer.parseInt(txtID.getText());
            String razaoSocial = txtRazaoSocial.getText();
            String telefone = txtTelefone.getText();
            String nomeContato = txtNomeContato.getText();
            String cpfCnpj = "";

            if (cbPessoa.getSelectedIndex() == 0) {
                cpfCnpj = txtCpfCnpj.getText();
            } else {
                cpfCnpj = txtCNPJ.getText();
            }

            String cidade = txtCidade.getText();
            Estado estado = new Estado();
            estado.setId(jcbEstado.getSelectedIndex() + 1);
            String endereco = txtEndereco.getText();
            String numero = txtNumero.getText();
            String bairro = txtBairro.getText();
            int status = jcbStatus.getSelectedIndex() + 1;

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                Fornecedor fornecedor = new Fornecedor(id, razaoSocial, telefone, nomeContato, cpfCnpj, cidade, estado, endereco, numero, bairro, status);
                daoFornecedor.update(fornecedor);

                JOptionPane.showMessageDialog(null, "Fornecedor '" + txtRazaoSocial.getText() + "' atualizado com sucesso!");

                txtID.setText(null);
                txtRazaoSocial.setText(null);
                txtTelefone.setText(null);
                txtNomeContato.setText(null);
                txtCpfCnpj.setText(null);
                txtCidade.setText(null);
                jcbEstado.setSelectedIndex(0);
                txtEndereco.setText(null);
                txtNumero.setText(null);
                txtBairro.setText(null);
                jcbStatus.setSelectedIndex(0);
                pegarTabela();
                estado();
                a = 0;

                jbCadastrarNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

                cbPessoa.setSelectedIndex(0);
                txtCNPJ.setText(null);
                txtCNPJ.setVisible(false);
                txtCpfCnpj.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar o fornecedor! \n", "Atenção", NORMAL);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        txtID.setText(null);
        txtRazaoSocial.setText(null);
        txtTelefone.setText(null);
        txtNomeContato.setText(null);
        txtCpfCnpj.setText(null);
        txtCidade.setText(null);
        jcbEstado.setSelectedIndex(0);
        txtEndereco.setText(null);
        txtNumero.setText(null);
        txtBairro.setText(null);
        jcbStatus.setSelectedIndex(0);
        pegarTabela();
        estado();

        jbCadastrarNovo.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        cbPessoa.setSelectedIndex(0);
        txtCNPJ.setText(null);
        txtCNPJ.setVisible(false);
        txtCpfCnpj.setVisible(true);

        a = 0;
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (txtRazaoSocial.getText().isEmpty() || txtRazaoSocial.getText().equals(null)) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveAll1();
                TableModelFornecedorFull tableModelFornecedor = new TableModelFornecedorFull();

                jtFornecedor.setModel(tableModelFornecedor);

                for (int i = 0; i < forne.size(); i++) {

                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor.setId(forne.get(i).getId());
                    fornecedor.setRazaoSocial(forne.get(i).getRazaoSocial());
                    fornecedor.setTelefone(forne.get(i).getTelefone());
                    fornecedor.setCpfCnpj(forne.get(i).getCpfCnpj());
                    tableModelFornecedor.addRow(fornecedor);

                }

            } catch (Exception e) {
            }

        } else {

            String fornecedore = txtRazaoSocial.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveNome1(fornecedore);
                TableModelFornecedorFull tableModelFornecedor = new TableModelFornecedorFull();

                jtFornecedor.setModel(tableModelFornecedor);

                for (int i = 0; i < forne.size(); i++) {

                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor.setId(forne.get(i).getId());
                    fornecedor.setRazaoSocial(forne.get(i).getRazaoSocial());
                    fornecedor.setTelefone(forne.get(i).getTelefone());
                    fornecedor.setCpfCnpj(forne.get(i).getCpfCnpj());
                    tableModelFornecedor.addRow(fornecedor);
                }

            } catch (Exception e) {
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void cbPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPessoaActionPerformed

        if (cbPessoa.getSelectedIndex() == 0) {
            lblCpfCnpj.setText("CPF:");
            txtCNPJ.setVisible(false);
            txtCpfCnpj.setVisible(true);
        } else {
            lblCpfCnpj.setText("CNPJ:");
            txtCpfCnpj.setVisible(false);
            txtCNPJ.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbPessoaActionPerformed

    private void txtCpfCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfCnpjFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCnpjFocusLost

    private void txtCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCNPJFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCNPJFocusLost

    private void jbCadastrarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarNovoActionPerformed

        CadastrarFornecedor fornecedor = new CadastrarFornecedor();
        getParent().add(fornecedor);
        fornecedor.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarNovoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        ExcluirFornecedor fornecedor = new ExcluirFornecedor();
        getParent().add(fornecedor);
        fornecedor.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jcLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLimiteActionPerformed

        if (jcLimite.isSelected()) {
            pegarTabela();
        } else {

            JOptionPane.showMessageDialog(null, "Você realmente deseja tirar o limite de busca no banco?"
                    + "\nO preenchimento da tabela pode demorar!");

            pegarTabela();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        estado();
        pegarTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained
        txtRazaoSocial.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void jbBuscarCidade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCidade3ActionPerformed

        if (txtCidade.getText().isEmpty()) {

            a = 2;

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CidadeDAO daoCidade = new CidadeDAO(con);
                List<Cidade> cit = daoCidade.retrieveAllFull();

                TableModelCidade tableModelCidade = new TableModelCidade();

                jtFornecedor.setModel(tableModelCidade);

                for (int i = 0; i < cit.size(); i++) {

                    Cidade cidade = new Cidade();

                    cidade.setId(cit.get(i).getId());
                    cidade.setNome(cit.get(i).getNome());
                    cidade.setEstado(cit.get(i).getEstado());
                    tableModelCidade.addRow(cidade);

                }

            } catch (Exception e) {
            }
        } else {
            String cidadeNome = txtCidade.getText();
            a = 2;
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CidadeDAO daoCidade = new CidadeDAO(con);
                List<Cidade> cit = daoCidade.retrieveNome(cidadeNome);

                if (cit.isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null, "A cidade '" + txtCidade.getText() + "' não foi encontrada \n"
                            + " Deseja cadastrar uma nova?", "Atenção!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        CadastrarCidade cidade = new CadastrarCidade();
                        getParent().add(cidade);
                        cidade.setVisible(true);
                        getParent().remove(1);
                    }
                } else {

                    TableModelCidade tableModelCidade = new TableModelCidade();

                    jtFornecedor.setModel(tableModelCidade);

                    for (int i = 0; i < cit.size(); i++) {

                        Cidade cidade = new Cidade();

                        cidade.setId(cit.get(i).getId());
                        cidade.setNome(cit.get(i).getNome());
                        cidade.setEstado(cit.get(i).getEstado());
                        tableModelCidade.addRow(cidade);

                    }
                }

            } catch (SQLException e) {

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarCidade3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtCidade.setText(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoSocialKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscar.doClick();

        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtRazaoSocialKeyPressed

    private void txtCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyPressed
      if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCidade3.doClick();

        }    // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeKeyPressed
                                          
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPessoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscarCidade3;
    private javax.swing.JButton jbCadastrarNovo;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtFornecedor;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpfCnpj;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNomeContato;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
