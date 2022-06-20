/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.RelatarFrame;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import static java.awt.Frame.NORMAL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Condicional;
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.dao.ClienteDAO;
import tcc.mma.ifpr.dao.CondicionalDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.Main;
import tcc.mma.ifpr.util.TableModel.TableModelCliente;
import tcc.mma.ifpr.util.TableModel.TableModelRelatorioCondicional;

/**
 *
 * @author nnath
 */
public class RelatorioCondicionalPorCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioCondicionalPorCliente
     */
    public RelatorioCondicionalPorCliente() {
        initComponents();

        pegarTabela();
    }

    public void pegarTabela() {
        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            CondicionalDAO daoCondicional = new CondicionalDAO(con);
            List<Condicional> condicional = daoCondicional.retriveAll();
            TableModelRelatorioCondicional tableModelCondicional = new TableModelRelatorioCondicional();

            jtCondicional.setModel(tableModelCondicional);
            jtCondicional.getColumnModel().getColumn(2).setPreferredWidth(500);
            for (int i = 0; i < condicional.size(); i++) {
                Condicional condicionals = new Condicional();
                condicionals.setId(condicional.get(i).getId());
                condicionals.setCliente(condicional.get(i).getCliente());
                condicionals.setMercadoria(transformarMercadoria(condicional.get(i).getMercadoria(), condicional.get(i).getQuantidade()));
                condicionals.setDataRetirada(condicional.get(i).getDataRetirada());
                condicionals.setStatus(condicional.get(i).getStatus());
                tableModelCondicional.addRow(condicionals);
            }

        } catch (Exception e) {
        }
    }

    public void pegarTabelaCli() {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();

            Condicional condicionalC = new Condicional();

            ClienteDAO daoCliente = new ClienteDAO(con);

            Cliente cliente = daoCliente.retrieve(Integer.parseInt(txtID1.getText()));

            condicionalC.setCliente(cliente);
            CondicionalDAO daoCondicional = new CondicionalDAO(con);
            List<Condicional> condicional = daoCondicional.retriveAllCliente(condicionalC);
            TableModelRelatorioCondicional tableModelCondicional = new TableModelRelatorioCondicional();

            jtCondicional.setModel(tableModelCondicional);
           jtCondicional.getColumnModel().getColumn(2).setPreferredWidth(500);

            for (int i = 0; i < condicional.size(); i++) {
                Condicional condicionals = new Condicional();
                condicionals.setId(condicional.get(i).getId());
                condicionals.setCliente(condicional.get(i).getCliente());
                condicionals.setMercadoria(transformarMercadoria(condicional.get(i).getMercadoria(), condicional.get(i).getQuantidade()));
                condicionals.setDataRetirada(condicional.get(i).getDataRetirada());
                condicionals.setStatus(condicional.get(i).getStatus());
                tableModelCondicional.addRow(condicionals);

            }
        } catch (Exception e) {
        }
    }

    public void transformarMerc(String mercadorias, String quantidade) {

        String[] t = mercadorias.split(Pattern.quote(","));
        String[] u = quantidade.split(Pattern.quote(","));

        String[] y = new String[t.length];
        String[] z = new String[t.length];

        for (int i = 0; i < t.length; i++) {

            y[i] = t[i].replace(" ", "");
            z[i] = y[i].replace(".", "");
        }

        String[] a = new String[u.length];
        String[] b = new String[u.length];

        for (int i = 0; i < u.length; i++) {

            a[i] = u[i].replace(" ", "");
            b[i] = a[i].replace(".", "");

        }

        for (int i = 0; i < y.length; i++) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                Mercadoria mercadoria = daoMercadoria.retrieve(Integer.parseInt(z[i]));
                String existe = txtMercadorias.getText();
                if (existe.isEmpty()) {
                    txtMercadorias.setText(b[i] + " x " + mercadoria.getDescricao());
                } else {
                    txtMercadorias.setText(existe + ", " + b[i] + " x " + mercadoria.getDescricao());
                }

            } catch (Exception e) {
            }

        }

    }

    public String transformarMercadoria(String mercadorias, String quantidade) {
        String retorno = "";
        String[] t = mercadorias.split(Pattern.quote(","));
        String[] u = quantidade.split(Pattern.quote(","));

        String[] y = new String[t.length];
        String[] z = new String[t.length];

        for (int i = 0; i < t.length; i++) {

            y[i] = t[i].replace(" ", "");
            z[i] = y[i].replace(".", "");
        }

        String[] a = new String[u.length];
        String[] b = new String[u.length];

        for (int i = 0; i < u.length; i++) {

            a[i] = u[i].replace(" ", "");
            b[i] = a[i].replace(".", "");

        }

        for (int i = 0; i < y.length; i++) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                Mercadoria mercadoria = daoMercadoria.retrieve(Integer.parseInt(z[i]));
                String existe = retorno;
                if (existe.isEmpty()) {
                    retorno = b[i] + " x " + mercadoria.getDescricao();
                } else {

                    retorno = existe + ", " + b[i] + " x " + mercadoria.getDescricao();
                }

            } catch (Exception e) {
            }

        }

        return retorno;
    }

    public void limpar() {
        txtCliente.setText(null);
        txtDataDevolucao.setText(null);
        txtDataRetirada.setText(null);
        txtFuncionario.setText(null);
        txtID.setText(null);
        txtMercadorias.setText(null);
        txtObervacao.setText(null);

        txtStatus.setText(null);

        jbAtualizarStatus.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbAtualizarStatus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtObervacao = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDataRetirada = new javax.swing.JTextField();
        txtMercadorias = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDataDevolucao = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtFuncionario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCondicional = new javax.swing.JTable();
        jbAlterarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jbBuscarClienteNome1 = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        jbBuscarClienteID1 = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório de Condicional por Cliente");

        jbAtualizarStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/editar.png"))); // NOI18N
        jbAtualizarStatus.setText("Atualizar Status");
        jbAtualizarStatus.setEnabled(false);
        jbAtualizarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarStatusActionPerformed(evt);
            }
        });

        jLabel6.setText("Observação:");

        jLabel1.setText("ID:");

        txtObervacao.setEditable(false);

        txtID.setEditable(false);

        jLabel7.setText("Data de Retirada:");

        jLabel2.setText("Mercadorias:");

        txtDataRetirada.setEditable(false);

        txtMercadorias.setEditable(false);

        jLabel8.setText("Data de Devolução:");

        jLabel3.setText("Cliente:");

        txtDataDevolucao.setEditable(false);

        txtCliente.setEditable(false);

        jLabel9.setText("Status:");

        jLabel4.setText("Funcionário:");

        txtStatus.setEditable(false);

        txtFuncionario.setEditable(false);

        jtCondicional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtCondicional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCondicionalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCondicional);

        jbAlterarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/alterar cliente.png"))); // NOI18N
        jbAlterarCliente.setText("Alterar Cliente");
        jbAlterarCliente.setEnabled(false);
        jbAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarClienteActionPerformed(evt);
            }
        });

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF"
            }
        ));
        jtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCliente);

        lblNome.setText("Cliente:");

        jbBuscarClienteNome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteNome1.setText("Buscar");
        jbBuscarClienteNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteNome1ActionPerformed(evt);
            }
        });

        lblID.setText("ID:");

        txtID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtID1KeyTyped(evt);
            }
        });

        jbBuscarClienteID1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteID1.setText("Buscar");
        jbBuscarClienteID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteID1ActionPerformed(evt);
            }
        });

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/pdf.png"))); // NOI18N
        btnPDF.setText("Gerar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtObervacao, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAtualizarStatus)
                                .addGap(18, 18, 18)
                                .addComponent(btnPDF)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarClienteNome1)
                        .addGap(18, 18, 18)
                        .addComponent(lblID)
                        .addGap(18, 18, 18)
                        .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarClienteID1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAlterarCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarClienteNome1)
                    .addComponent(jbBuscarClienteID1)
                    .addComponent(jbAlterarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtObervacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPDF)
                    .addComponent(jbAtualizarStatus))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jbAtualizarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarStatusActionPerformed
        RelatorioCondicionalPorClienteStatus condicionalAtt = new RelatorioCondicionalPorClienteStatus();

        Main main = new Main();

        getParent().add(condicionalAtt);

        condicionalAtt.setVisible(true);

        int lDesk = getParent().getWidth();
        int aDesk = getParent().getHeight();
        int lIFrame = condicionalAtt.getWidth();
        int aIFrame = condicionalAtt.getHeight();

        condicionalAtt.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        condicionalAtt.povoar(Integer.parseInt(txtID.getText()));        // TODO add your handling code here:
    }//GEN-LAST:event_jbAtualizarStatusActionPerformed

    private void jtCondicionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCondicionalMouseClicked

        int linhaSelecionada = jtCondicional.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelRelatorioCondicional tbCondicional = (TableModelRelatorioCondicional) jtCondicional.getModel();
            Condicional condicional1 = tbCondicional.getCondicional(jtCondicional.getSelectedRow());
            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CondicionalDAO daoCondicional = new CondicionalDAO(con);

                Condicional condicional = daoCondicional.retrieve(condicional1.getId());

                txtID.setText(String.valueOf(condicional.getId()));

                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(condicional.getFuncionario().getId());
                txtFuncionario.setText(funcionario.getNome());

                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(condicional.getCliente().getId());
                txtCliente.setText(cliente.getNome());

                txtMercadorias.setText(null);
                transformarMerc(condicional.getMercadoria(), condicional.getQuantidade());

                txtObervacao.setText(condicional.getObservacao());

                txtDataRetirada.setText(String.valueOf(condicional.getDataRetirada()));
                txtDataDevolucao.setText(String.valueOf(condicional.getDataDevolução()));

                int status = condicional.getStatus();

                if (status == 1) {
                    txtStatus.setText("Ativo");
                    jbAtualizarStatus.setEnabled(true);
                } else {

                    if (status == 2) {
                        txtStatus.setText("Concluido");
                        jbAtualizarStatus.setEnabled(false);
                    } else {
                        txtStatus.setText("Cancelado");
                        jbAtualizarStatus.setEnabled(false);
                    }

                }
                

            } catch (Exception e) {

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtCondicionalMouseClicked

    private void jbAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarClienteActionPerformed

        jbBuscarClienteID1.setEnabled(true);
        jbBuscarClienteNome1.setEnabled(true);
        jbAlterarCliente.setEnabled(false);
        txtID1.setEditable(true);
        txtNome.setEditable(true);
        txtID1.setText(null);
        txtNome.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbAlterarClienteActionPerformed

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked

        int linhaSelecionada = jtCliente.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelCliente tbCliente = (TableModelCliente) jtCliente.getModel();
            Cliente cliente = tbCliente.getCliente(jtCliente.getSelectedRow());

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente clienteR = daoCliente.retrieve(cliente.getId());

                txtID1.setText(String.valueOf(clienteR.getId()));
                txtNome.setText(clienteR.getNome());

            } catch (Exception e) {
            }
            jbBuscarClienteID1.setEnabled(false);
            jbBuscarClienteNome1.setEnabled(false);
            jbAlterarCliente.setEnabled(true);
            txtID1.setEditable(false);
            txtNome.setEditable(false);

            pegarTabelaCli();

            int linhas = jtCliente.getRowCount();
            for (int i = linhas - 1; i >= 0; i--) {

                tbCliente.removeLinha(i);

            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtClienteMouseClicked

    private void jbBuscarClienteNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarClienteNome1ActionPerformed

        if (txtNome.getText().isEmpty() || txtNome.getText().equals(null)) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                List<Cliente> cli = daoCliente.retrieveAll();

                TableModelCliente tableModelCliente = new TableModelCliente();

                jtCliente.setModel(tableModelCliente);

                for (int i = 0; i < cli.size(); i++) {

                    Cliente clientes = new Cliente();

                    clientes.setId(cli.get(i).getId());
                    clientes.setNome(cli.get(i).getNome());
                    clientes.setCpf(cli.get(i).getCpf());
                    tableModelCliente.addRow(clientes);

                }

            } catch (Exception e) {
            }

        } else {

            String cliente = txtNome.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                List<Cliente> cli = daoCliente.retrieveNome(cliente);

                TableModelCliente tableModelCliente = new TableModelCliente();

                jtCliente.setModel(tableModelCliente);

                for (int i = 0; i < cli.size(); i++) {

                    Cliente clientes = new Cliente();

                    clientes.setId(cli.get(i).getId());
                    clientes.setNome(cli.get(i).getNome());
                    clientes.setCpf(cli.get(i).getCpf());
                    tableModelCliente.addRow(clientes);

                }

                txtNome.setText(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível Localizar o cliente com o nome: " + txtNome.getText(), "Atencão", NORMAL);
                txtNome.setText(null);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarClienteNome1ActionPerformed

    private void txtID1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtID1KeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtID1KeyTyped

    private void jbBuscarClienteID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarClienteID1ActionPerformed

        if (txtID1.getText().isEmpty() || txtID1.getText().equals(null)) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                List<Cliente> cli = daoCliente.retrieveAll();

                TableModelCliente tableModelCliente = new TableModelCliente();

                jtCliente.setModel(tableModelCliente);

                for (int i = 0; i < cli.size(); i++) {

                    Cliente clientes = new Cliente();

                    clientes.setId(cli.get(i).getId());
                    clientes.setNome(cli.get(i).getNome());
                    clientes.setCpf(cli.get(i).getCpf());
                    tableModelCliente.addRow(clientes);

                }

            } catch (Exception e) {
            }

        } else {

            String cliente = txtID1.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cli = daoCliente.retrieve(Integer.parseInt(cliente));

                TableModelCliente tableModelCliente = new TableModelCliente();

                jtCliente.setModel(tableModelCliente);

                Cliente clientes = new Cliente();

                clientes.setId(cli.getId());
                clientes.setNome(cli.getNome());
                clientes.setCpf(cli.getCpf());
                tableModelCliente.addRow(clientes);

                txtID1.setText(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível Localizar o cliente com ID: " + txtID1.getText(), "Atencão", NORMAL);
                txtID1.setText(null);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarClienteID1ActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        if (jbAlterarCliente.isEnabled()) {
            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Condicional Por Cliente" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE CONDICIONAL DO CLIENTE: " + txtNome.getText() + "\n\n"
                ));

                int tabela = jtCondicional.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioCondicional tbVenda = (TableModelRelatorioCondicional) jtCondicional.getModel();
                    Condicional condicionais = tbVenda.getCondicional(i);
                    try {
                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        CondicionalDAO daoCondicional = new CondicionalDAO(con);

                        Cliente cliente1 = new Cliente();
                        cliente1.setNome(txtNome.getText());
                        cliente1.setId(Integer.parseInt(txtID1.getText()));

                        Condicional venda1 = new Condicional();
                        venda1.setCliente(cliente1);

                        List<Condicional> condicional = daoCondicional.retriveAllCliente(venda1);

                        int id = condicional.get(i).getId();

                        String dataRetirada = String.valueOf(condicional.get(i).getDataRetirada());
                        String dataDevolucao = String.valueOf(condicional.get(i).getDataDevolução());

                        FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                        Funcionario funcionario = daoFuncionario.retrieve(condicional.get(i).getFuncionario().getId());
                        String NomeFun = funcionario.getNome();

                        ClienteDAO daoCliente = new ClienteDAO(con);
                        Cliente cliente = daoCliente.retrieve(condicional.get(i).getCliente().getId());
                        String nomeCli = cliente.getNome();

                        String mercadoria = transformarMercadoria(condicional.get(i).getMercadoria(), condicional.get(i).getQuantidade());

                        String observacao = condicional.get(i).getObservacao();

                        int status = condicional.get(i).getStatus();
                        String status1;
                        if (status == 1) {
                            status1 = ("Concluida");
                        } else {
                            status1 = ("Cancelada");
                        }

                        if (contador == 0 || contador == 1 || contador == 3) {

                            document.add(new Paragraph("Código da Condicional: " + id + " \n"
                                    + "Data da Retirada: " + dataRetirada + "\n"
                                    + "Data da Devolução: " + dataDevolucao + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Status da Condicional: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));
                            contador = contador + 1;
                        } else {
                            contador = 1;
                            document.add(new Paragraph("\n " + "\n " + "\n " + "\n "
                                    + "\n " + "\n " + "\n " + "\n " + "\n " + "\n " + "\n "));
                            document.add(new Paragraph("Código da Condicional: " + id + " \n"
                                    + "Data da Retirada: " + dataRetirada + "\n"
                                    + "Data da Devolução: " + dataDevolucao + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Status da Condicional: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));

                        }

                    } catch (Exception e) {

                    }

                }

            } catch (DocumentException | FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar o PDF " + ex, "Atenção!", NORMAL);
            } finally {
                document.close();
            }

            try {
                Desktop.getDesktop().open(new File("Relatório de Condicional Por Cliente" + data.getTime() + ".pdf"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Está ação pode demorar alguns minutos");

            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Condicional" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE CONDICIONAL COMPLETO \n\n"
                ));

                int tabela = jtCondicional.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioCondicional tbVenda = (TableModelRelatorioCondicional) jtCondicional.getModel();
                    Condicional condicionais = tbVenda.getCondicional(i);
                    try {
                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        CondicionalDAO daoCondicional = new CondicionalDAO(con);

                        List<Condicional> condicional = daoCondicional.retriveAllFull();

                        int id = condicional.get(i).getId();

                        String dataRetirada = String.valueOf(condicional.get(i).getDataRetirada());
                        String dataDevolucao = String.valueOf(condicional.get(i).getDataDevolução());

                        FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                        Funcionario funcionario = daoFuncionario.retrieve(condicional.get(i).getFuncionario().getId());
                        String NomeFun = funcionario.getNome();

                        ClienteDAO daoCliente = new ClienteDAO(con);
                        Cliente cliente = daoCliente.retrieve(condicional.get(i).getCliente().getId());
                        String nomeCli = cliente.getNome();

                        String mercadoria = transformarMercadoria(condicional.get(i).getMercadoria(), condicional.get(i).getQuantidade());

                        String observacao = condicional.get(i).getObservacao();

                        int status = condicional.get(i).getStatus();
                        String status1;
                        if (status == 1) {
                            status1 = ("Concluida");
                        } else {
                            status1 = ("Cancelada");
                        }

                        if (contador == 0 || contador == 1 || contador == 3) {

                            document.add(new Paragraph("Código da Condicional: " + id + " \n"
                                    + "Data da Retirada: " + dataRetirada + "\n"
                                    + "Data da Devolução: " + dataDevolucao + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Status da Condicional: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));
                            contador = contador + 1;
                        } else {
                            contador = 1;
                            document.add(new Paragraph("\n " + "\n " + "\n " + "\n "
                                    + "\n " + "\n " + "\n " + "\n " + "\n " + "\n " + "\n "));
                            document.add(new Paragraph("Código da Condicional: " + id + " \n"
                                    + "Data da Retirada: " + dataRetirada + "\n"
                                    + "Data da Devolução: " + dataDevolucao + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Status da Condicional: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));

                        }

                    } catch (Exception e) {

                    }

                }

            } catch (DocumentException | FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar o PDF " + ex, "Atenção!", NORMAL);
            } finally {
                document.close();
            }

            try {
                Desktop.getDesktop().open(new File("Relatório de Condicional" + data.getTime() + ".pdf"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }
        }

    }//GEN-LAST:event_btnPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbAtualizarStatus;
    private javax.swing.JButton jbBuscarClienteID1;
    private javax.swing.JButton jbBuscarClienteNome1;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtCondicional;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataRetirada;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtMercadorias;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObervacao;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
