/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.ExcluirFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Estado;
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.dao.EstadoDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFuncionario;
import tcc.mma.ifpr.util.EditarFrame.EditarFuncionario;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelFuncionarioAll;

/**
 *
 * @author nnath
 */
public class ExcluirFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form ExcluirFuncionario
     */
    public ExcluirFuncionario() {
        initComponents();

        
    }

   
    public void pegarTabela() {

        if (jcLimite1.isSelected()) {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                List<Funcionario> funci = daoFuncionario.retrieveAll1Full();
                TableModelFuncionarioAll tableModelFuncionario = new TableModelFuncionarioAll();

                jtFuncionario.setModel(tableModelFuncionario);

                for (int i = 0; i < funci.size(); i++) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(funci.get(i).getId());
                    funcionario.setNome(funci.get(i).getNome());
                    funcionario.setCpf(funci.get(i).getCpf());
                    funcionario.setTelefone(funci.get(i).getTelefone());
                    tableModelFuncionario.addRow(funcionario);
                }

            } catch (Exception e) {
            }
        } else {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                List<Funcionario> funci = daoFuncionario.retrieveAll1();
                TableModelFuncionarioAll tableModelFuncionario = new TableModelFuncionarioAll();

                jtFuncionario.setModel(tableModelFuncionario);

                for (int i = 0; i < funci.size(); i++) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(funci.get(i).getId());
                    funcionario.setNome(funci.get(i).getNome());
                    funcionario.setCpf(funci.get(i).getCpf());
                    funcionario.setTelefone(funci.get(i).getTelefone());
                    tableModelFuncionario.addRow(funcionario);
                }

            } catch (Exception e) {
            }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        txtPisPasep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDataDemissao = new javax.swing.JTextField();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionario = new javax.swing.JTable();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        txtNome = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtDataAdmissao = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbCadastrarNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcLimite1 = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Excluir Funcionário");
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

        jLabel14.setText("PIS PASEP:");

        txtPisPasep.setEditable(false);

        jLabel4.setText("Data de Demissão:");

        jLabel15.setText("Status:");

        txtDataDemissao.setEditable(false);

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLabel5.setText("RG:");

        txtRg.setEditable(false);

        jLabel6.setText("CPF:");

        txtCpf.setEditable(false);

        jLabel7.setText("Telefone:");

        txtTelefone.setEditable(false);

        jLabel8.setText("Data de Nascimento:");

        txtDataNascimento.setEditable(false);

        jLabel9.setText("Endereço:");

        txtEndereco.setEditable(false);

        jLabel10.setText("Número:");

        jtFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone"
            }
        ));
        jtFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFuncionario);

        txtNumero.setEditable(false);

        jLabel11.setText("Bairro:");

        txtBairro.setEditable(false);

        txtID.setEditable(false);

        jLabel12.setText("Estado:");

        jLabel2.setText("Nome:");

        txtNome.setEditable(false);

        jLabel13.setText("Cidade:");

        jLabel3.setText("Data de Admissão:");

        txtCidade.setEditable(false);

        txtDataAdmissao.setEditable(false);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
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

        jbCadastrarNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrarNovo.setText("Cadastrar Novo");
        jbCadastrarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarNovoActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jcLimite1.setSelected(true);
        jcLimite1.setText("Limite de busca no bando de dados");
        jcLimite1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcLimite1FocusGained(evt);
            }
        });
        jcLimite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcLimite1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcLimite1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPisPasep, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(43, 43, 43))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jbBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbCadastrarNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar)))
                .addGap(0, 80, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrarNovo, jbEditar, jbExcluir, jbLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtPisPasep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbCadastrarNovo)
                    .addComponent(jbEditar)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jtFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFuncionarioMouseClicked
        int linhaSelecionada = jtFuncionario.getSelectedRow();
        if (linhaSelecionada != -1) {
            TableModelFuncionarioAll tbFuncionario = (TableModelFuncionarioAll) jtFuncionario.getModel();
            Funcionario funcionario = tbFuncionario.getFuncionario(jtFuncionario.getSelectedRow());

            int id = funcionario.getId();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario1 = daoFuncionario.retrieve(id);

                txtBairro.setText(funcionario1.getBairro());
                txtCidade.setText(funcionario1.getCidade());
                txtCpf.setText(funcionario1.getCpf());

                Date dataAdmissao = new Date(funcionario1.getDateAdmissao().getTime());
                SimpleDateFormat formatoAdmissao = new SimpleDateFormat("dd/MM/yyyy");
                txtDataAdmissao.setText(formatoAdmissao.format(dataAdmissao));

                Date dataDemissao = new Date(funcionario1.getDataDemissao().getTime());
                SimpleDateFormat formatoDemissao = new SimpleDateFormat("dd/MM/yyyy");
                String dataBd = formatoDemissao.format(dataDemissao);

                if (dataBd.equals("10/10/2010")) {
                    txtDataDemissao.setText("Ativo");
                } else {
                    txtDataDemissao.setText(formatoDemissao.format(dataDemissao));
                }

                Date dataNascimento = new Date(funcionario1.getDataNascimento().getTime());
                SimpleDateFormat formatoNascimento = new SimpleDateFormat("dd/MM/yyyy");
                txtDataNascimento.setText(formatoNascimento.format(dataNascimento));

                txtEndereco.setText(funcionario1.getEndereco());
                txtID.setText(String.valueOf(funcionario1.getId()));
                txtNome.setText(funcionario1.getNome());
                txtNumero.setText(funcionario1.getNumero());
                txtPisPasep.setText(funcionario1.getPispasep());
                txtRg.setText(funcionario1.getRg());
                txtTelefone.setText(funcionario1.getTelefone());
                jcbEstado.setSelectedIndex(funcionario1.getEstado().getId() - 1);
                jcbStatus.setSelectedIndex(funcionario1.getStatus() - 1);

                pegarTabela();
                jbCadastrarNovo.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
            } catch (Exception e) {
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFuncionarioMouseClicked

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (txtNome.getText().isEmpty() || txtNome.getText().equals(null)) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                List<Funcionario> fun = daoFuncionario.retrieveAll1();

                TableModelFuncionarioAll tableModelFuncionarios = new TableModelFuncionarioAll();

                jtFuncionario.setModel(tableModelFuncionarios);

                for (int i = 0; i < fun.size(); i++) {

                    Funcionario funcionarios = new Funcionario();

                    funcionarios.setId(fun.get(i).getId());
                    funcionarios.setNome(fun.get(i).getNome());
                    funcionarios.setCpf(fun.get(i).getCpf());
                    funcionarios.setTelefone(fun.get(i).getTelefone());

                    tableModelFuncionarios.addRow(funcionarios);

                }

            } catch (Exception e) {
            }

        } else {

            String funcionario = txtNome.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                List<Funcionario> fun = daoFuncionario.retrieveNome1(funcionario);

                TableModelFuncionarioAll tableModelFuncionarios = new TableModelFuncionarioAll();

                jtFuncionario.setModel(tableModelFuncionarios);

                for (int i = 0; i < fun.size(); i++) {

                    Funcionario funcionarios = new Funcionario();

                    funcionarios.setId(fun.get(i).getId());
                    funcionarios.setNome(fun.get(i).getNome());
                    funcionarios.setCpf(fun.get(i).getCpf());
                    funcionarios.setTelefone(fun.get(i).getTelefone());

                    tableModelFuncionarios.addRow(funcionarios);

                }

            } catch (Exception e) {
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        txtBairro.setText(null);
        txtCidade.setText(null);
        txtCpf.setText(null);
        txtDataAdmissao.setText(null);
        txtDataDemissao.setText(null);
        txtDataNascimento.setText(null);
        txtEndereco.setText(null);
        txtID.setText(null);
        txtNome.setText(null);
        txtNumero.setText(null);
        txtPisPasep.setText(null);
        txtRg.setText(null);
        txtTelefone.setText(null);
        pegarTabela();
        estado();
        jbCadastrarNovo.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        if (txtBairro.getText().isEmpty() || txtCidade.getText().isEmpty()
                || txtCpf.getText().isEmpty() || txtDataAdmissao.getText().isEmpty()
                || txtDataDemissao.getText().isEmpty() || txtDataNascimento.getText().isEmpty()
                || txtEndereco.getText().isEmpty() || txtNome.getText().isEmpty()
                || txtNumero.getText().isEmpty() || txtPisPasep.getText().isEmpty()
                || txtRg.getText().isEmpty() || txtTelefone.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os dados do formulário para pode editar o Funcionário!", "Atenção", NORMAL);

        } else {
            if (JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o funcionário '" + txtNome.getText() + "' ?", "Atenção!",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                try {
                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();

                    int id = Integer.parseInt(txtID.getText());

                    FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                    daoFuncionario.delete(id);

                    txtBairro.setText(null);
                    txtCidade.setText(null);
                    txtCpf.setText(null);
                    txtDataAdmissao.setText(null);
                    txtDataDemissao.setText(null);
                    txtDataNascimento.setText(null);
                    txtEndereco.setText(null);
                    txtID.setText(null);
                    txtNome.setText(null);
                    txtNumero.setText(null);
                    txtPisPasep.setText(null);
                    txtRg.setText(null);
                    txtTelefone.setText(null);
                    pegarTabela();
                    estado();
                    jbCadastrarNovo.setEnabled(true);
                    jbEditar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o funcionário");
                }

            } else {
                txtBairro.setText(null);
                txtCidade.setText(null);
                txtCpf.setText(null);
                txtDataAdmissao.setText(null);
                txtDataDemissao.setText(null);
                txtDataNascimento.setText(null);
                txtEndereco.setText(null);
                txtID.setText(null);
                txtNome.setText(null);
                txtNumero.setText(null);
                txtPisPasep.setText(null);
                txtRg.setText(null);
                txtTelefone.setText(null);
                pegarTabela();
                estado();
                jbCadastrarNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbCadastrarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarNovoActionPerformed
        CadastrarFuncionario funcionario = new CadastrarFuncionario();
        getParent().add(funcionario);
        funcionario.setVisible(true);
        getParent().remove(1);

// TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarNovoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        EditarFuncionario funcionario = new EditarFuncionario();
        getParent().add(funcionario);
        funcionario.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcLimite1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimite1FocusGained

        txtNome.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimite1FocusGained

    private void jcLimite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLimite1ActionPerformed

        if (jcLimite1.isSelected()) {
            pegarTabela();
        } else {

            JOptionPane.showMessageDialog(null, "Você realmente deseja tirar o limite de busca no banco?"
                + "\nO preenchimento da tabela pode demorar!");

            pegarTabela();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimite1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
 estado();
        pegarTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastrarNovo;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtFuncionario;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataAdmissao;
    private javax.swing.JTextField txtDataDemissao;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPisPasep;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}