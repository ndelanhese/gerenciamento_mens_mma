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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.bean.Venda;
import tcc.mma.ifpr.dao.ClienteDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.dao.VendaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCliente;
import tcc.mma.ifpr.util.TableModel.TableModelRelatorioVendas;

/**
 *
 * @author nnath
 */
public class RelatorioVendasPorCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioVendasPorCliente
     */
    public RelatorioVendasPorCliente() {
        initComponents();

        pegarTabela();
    }

    public void pegarTabela() {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            VendaDAO daoVenda = new VendaDAO(con);
            List<Venda> venda = daoVenda.retriveAll();
            TableModelRelatorioVendas tableModelVenda = new TableModelRelatorioVendas();

            jtVendas.setModel(tableModelVenda);

            jtVendas.getColumnModel().getColumn(2).setPreferredWidth(500);

            for (int i = 0; i < venda.size(); i++) {
                Venda vendas = new Venda();
                vendas.setId(venda.get(i).getId());
                vendas.setCliente(venda.get(i).getCliente());
                vendas.setMercadoria(transformarMercadoria(venda.get(i).getMercadoria(), venda.get(i).getQuantidade()));
                vendas.setValorFinal(venda.get(i).getValorFinal());
                vendas.setDataVenda(venda.get(i).getDataVenda());
                tableModelVenda.addRow(vendas);

            }

        } catch (Exception e) {
        }
    }

    public void pegarTabelaCli() {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();

            Venda vendaC = new Venda();

            ClienteDAO daoCliente = new ClienteDAO(con);

            Cliente cliente = daoCliente.retrieve(Integer.parseInt(txtID1.getText()));

            vendaC.setCliente(cliente);
            VendaDAO daoVenda = new VendaDAO(con);
            List<Venda> venda = daoVenda.retriveAllCliente(vendaC);
            TableModelRelatorioVendas tableModelVenda = new TableModelRelatorioVendas();

            jtVendas.setModel(tableModelVenda);
            jtVendas.getColumnModel().getColumn(2).setPreferredWidth(500);

            for (int i = 0; i < venda.size(); i++) {
                Venda vendas = new Venda();
                vendas.setId(venda.get(i).getId());
                vendas.setCliente(venda.get(i).getCliente());
                vendas.setMercadoria(transformarMercadoria(venda.get(i).getMercadoria(), venda.get(i).getQuantidade()));
                vendas.setValorFinal(venda.get(i).getValorFinal());
                vendas.setDataVenda(venda.get(i).getDataVenda());
                tableModelVenda.addRow(vendas);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValorFinal = new javax.swing.JTextField();
        txtFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMercadorias = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtModoPagamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVendas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtParcela = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbBuscarClienteID1 = new javax.swing.JButton();
        jbAlterarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jbBuscarClienteNome1 = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        btnPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório de Vendas por Cliente");

        txtValorFinal.setEditable(false);

        txtFuncionario.setEditable(false);

        jLabel4.setText("Cliente:");

        txtCliente.setEditable(false);

        jLabel5.setText("Mercadorias:");

        txtMercadorias.setEditable(false);

        jLabel6.setText("Valor:");

        txtValorTotal.setEditable(false);

        jLabel7.setText("Valor de Desconto:");

        txtValorDesconto.setEditable(false);

        jLabel9.setText("Observação:");

        txtObservacao.setEditable(false);

        jLabel10.setText("Modo de Pagamento:");

        txtModoPagamento.setEditable(false);

        jtVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Mercadoria", "Quantidade", "Valor"
            }
        ));
        jtVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVendas);

        jLabel11.setText("Quantidade de parcelas:");

        txtParcela.setEditable(false);

        jLabel1.setText("ID:");

        jLabel12.setText("Status:");

        txtID.setEditable(false);

        txtStatus.setEditable(false);

        jLabel2.setText("Data da Venda:");

        jLabel13.setText("Valor Final:");

        txtDataVenda.setEditable(false);

        jLabel3.setText("Funcionário:");

        jbBuscarClienteID1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteID1.setText("Buscar");
        jbBuscarClienteID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteID1ActionPerformed(evt);
            }
        });

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
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarClienteNome1)
                        .addGap(18, 18, 18)
                        .addComponent(lblID)
                        .addGap(18, 18, 18)
                        .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarClienteID1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAlterarCliente))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPDF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnPDF)
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jtVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVendasMouseClicked

        int linhaSelecionada = jtVendas.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelRelatorioVendas tbVenda = (TableModelRelatorioVendas) jtVendas.getModel();
            Venda vendas = tbVenda.getVenda(jtVendas.getSelectedRow());
            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                VendaDAO daoVenda = new VendaDAO(con);

                Venda venda = daoVenda.retrieve(vendas.getId());

                txtID.setText(String.valueOf(venda.getId()));

                txtDataVenda.setText(String.valueOf(venda.getDataVenda()));

                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                Funcionario funcionario = daoFuncionario.retrieve(venda.getFuncionario().getId());
                txtFuncionario.setText(funcionario.getNome());

                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente cliente = daoCliente.retrieve(venda.getCliente().getId());
                txtCliente.setText(cliente.getNome());

                txtMercadorias.setText(null);
                transformarMerc(venda.getMercadoria(), venda.getQuantidade());
                txtValorTotal.setText(venda.getValorTotal());
                txtValorDesconto.setText(venda.getDesconto());
                txtValorFinal.setText(venda.getValorFinal());

                txtObservacao.setText(venda.getObservacao());
                txtModoPagamento.setText(venda.getModoPagamento());
                txtParcela.setText(String.valueOf(venda.getParcelas()));

                int status = venda.getStatus();

                if (status == 1) {
                    txtStatus.setText("Ativo");
                } else {
                    txtStatus.setText("Inativo");
                }

            } catch (Exception e) {

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtVendasMouseClicked

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

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        if (jbAlterarCliente.isEnabled()) {

            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Vendas Por Cliente" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE VENDAS DO CLIENTE: " + txtNome.getText() + "\n \n"
                ));

                int tabela = jtVendas.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioVendas tbVenda = (TableModelRelatorioVendas) jtVendas.getModel();
                    Venda vendas = tbVenda.getVenda(i);
                    try {

                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        VendaDAO daoVenda = new VendaDAO(con);

                        Cliente cliente1 = new Cliente();
                        cliente1.setNome(txtNome.getText());
                        cliente1.setId(Integer.parseInt(txtID1.getText()));

                        Venda venda1 = new Venda();
                        venda1.setCliente(cliente1);

                        List<Venda> venda = daoVenda.retriveAllCliente(venda1);
                        TableModelRelatorioVendas tableModelVenda = new TableModelRelatorioVendas();

                        int id = venda.get(i).getId();

                        String dataVenda = String.valueOf(venda.get(i).getDataVenda());

                        FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                        Funcionario funcionario = daoFuncionario.retrieve(venda.get(i).getFuncionario().getId());
                        String NomeFun = funcionario.getNome();

                        ClienteDAO daoCliente = new ClienteDAO(con);
                        Cliente cliente = daoCliente.retrieve(venda.get(i).getCliente().getId());
                        String nomeCli = cliente.getNome();

                        String mercadoria = transformarMercadoria(venda.get(i).getMercadoria(), venda.get(i).getQuantidade());
                        String valorTotal = venda.get(i).getValorTotal();
                        String valorDesconto = venda.get(i).getDesconto();
                        String valorFinal = venda.get(i).getValorFinal();
                        String observacao = venda.get(i).getObservacao();
                        String modoPagamento = venda.get(i).getModoPagamento();
                        int parcelas = venda.get(i).getParcelas();

                        int status = venda.get(i).getStatus();
                        String status1;
                        if (status == 1) {
                            status1 = ("Concluida");
                        } else {
                            status1 = ("Cancelada");
                        }

                        if (contador == 0 || contador == 1) {

                            document.add(new Paragraph("Código da venda: " + id + " \n"
                                    + "Data da Venda: " + dataVenda + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Valor: " + valorTotal + "\n"
                                    + "Desconto: " + valorDesconto + "\n"
                                    + "Valor Total: " + valorFinal + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Modo de pagamento: " + modoPagamento + " \n"
                                    + "Qtd. de Parcelas: " + parcelas + "\n"
                                    + "Status da venda: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));
                            contador = contador + 1;
                        } else {
                            contador = 1;
                            document.add(new Paragraph("\n " + "\n " + "\n " + "\n "
                                    + "\n " + "\n " + "\n " + "\n " + "\n " + "\n " + "\n "));
                            document.add(new Paragraph("Código da venda: " + id + " \n"
                                    + "Data da Venda: " + dataVenda + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Valor: " + valorTotal + "\n"
                                    + "Desconto: " + valorDesconto + "\n"
                                    + "Valor Total: " + valorFinal + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Modo de pagamento: " + modoPagamento + " \n"
                                    + "Qtd. de Parcelas: " + parcelas + "\n"
                                    + "Status da venda: " + status1 + "\n \n"
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
                Desktop.getDesktop().open(new File("Relatório de Vendas Por Cliente" + data.getTime() + ".pdf"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Está ação pode demorar alguns minutos!");

            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Vendas" + data.getTime() + ".pdf"));

                document.open();
                document.add(new Paragraph(
                        "RELATÓRIO DE VENDAS COMPLETO \n \n"
                ));
                int tabela = jtVendas.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioVendas tbVenda = (TableModelRelatorioVendas) jtVendas.getModel();
                    Venda vendas = tbVenda.getVenda(i);
                    try {
                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        VendaDAO daoVenda = new VendaDAO(con);

                        List<Venda> venda = daoVenda.retriveAllFull();

                        int id = venda.get(i).getId();

                        String dataVenda = String.valueOf(venda.get(i).getDataVenda());

                        FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                        Funcionario funcionario = daoFuncionario.retrieve(venda.get(i).getFuncionario().getId());
                        String NomeFun = funcionario.getNome();

                        ClienteDAO daoCliente = new ClienteDAO(con);
                        Cliente cliente = daoCliente.retrieve(venda.get(i).getCliente().getId());
                        String nomeCli = cliente.getNome();

                        String mercadoria = transformarMercadoria(venda.get(i).getMercadoria(), venda.get(i).getQuantidade());
                        String valorTotal = venda.get(i).getValorTotal();
                        String valorDesconto = venda.get(i).getDesconto();
                        String valorFinal = venda.get(i).getValorFinal();
                        String observacao = venda.get(i).getObservacao();
                        String modoPagamento = venda.get(i).getModoPagamento();
                        int parcelas = venda.get(i).getParcelas();

                        int status = venda.get(i).getStatus();
                        String status1;
                        if (status == 1) {
                            status1 = ("Concluida");
                        } else {
                            status1 = ("Cancelada");
                        }

                        if (contador == 0 || contador == 1) {

                            document.add(new Paragraph("Código da venda: " + id + " \n"
                                    + "Data da Venda: " + dataVenda + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Valor: " + valorTotal + "\n"
                                    + "Desconto: " + valorDesconto + "\n"
                                    + "Valor Total: " + valorFinal + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Modo de pagamento: " + modoPagamento + " \n"
                                    + "Qtd. de Parcelas: " + parcelas + "\n"
                                    + "Status da venda: " + status1 + "\n \n"
                                    + "------------------------------------------------------------------------------------------------------------------------------"
                                    + "\n \n"));
                            contador = contador + 1;
                        } else {
                            contador = 1;
                            document.add(new Paragraph("\n " + "\n " + "\n " + "\n "
                                    + "\n " + "\n " + "\n " + "\n " + "\n " + "\n " + "\n "));
                            document.add(new Paragraph("Código da venda: " + id + " \n"
                                    + "Data da Venda: " + dataVenda + "\n"
                                    + "Funcionário: " + NomeFun + "\n"
                                    + "Cliente: " + nomeCli + "\n"
                                    + "Mercadorias: " + mercadoria + "\n"
                                    + "Valor: " + valorTotal + "\n"
                                    + "Desconto: " + valorDesconto + "\n"
                                    + "Valor Total: " + valorFinal + "\n"
                                    + "Observação: " + observacao + "\n"
                                    + "Modo de pagamento: " + modoPagamento + " \n"
                                    + "Qtd. de Parcelas: " + parcelas + "\n"
                                    + "Status da venda: " + status1 + "\n \n"
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
                Desktop.getDesktop().open(new File("Relatório de Vendas" + data.getTime() + ".pdf"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }
        }
    }//GEN-LAST:event_btnPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbBuscarClienteID1;
    private javax.swing.JButton jbBuscarClienteNome1;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtVendas;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtMercadorias;
    private javax.swing.JTextField txtModoPagamento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtParcela;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtValorDesconto;
    private javax.swing.JTextField txtValorFinal;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
