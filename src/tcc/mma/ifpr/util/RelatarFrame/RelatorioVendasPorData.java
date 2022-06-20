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
import tcc.mma.ifpr.util.TableModel.TableModelRelatorioVendas;

/**
 *
 * @author nnath
 */
public class RelatorioVendasPorData extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioMaisVendidoMes
     */
    public RelatorioVendasPorData() {
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

        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMercadorias = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorDesconto = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();
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
        jLabel13 = new javax.swing.JLabel();
        jbLimparDataInicial = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jbLimparDataFinal = new javax.swing.JButton();
        jbBuscarDatas = new javax.swing.JButton();
        txtDataInicial = new javax.swing.JFormattedTextField();
        txtDataFinal = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        txtValorFinal = new javax.swing.JTextField();
        btnPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório de Vendas Por Data");

        jLabel4.setText("Cliente:");

        txtCliente.setEditable(false);

        jLabel5.setText("Mercadorias:");

        txtMercadorias.setEditable(false);

        jLabel6.setText("Valor:");

        txtValorTotal.setEditable(false);

        jLabel7.setText("Valor de Desconto:");

        txtValorDesconto.setEditable(false);

        txtID.setEditable(false);

        txtStatus.setEditable(false);

        jLabel2.setText("Data da Venda:");

        txtDataVenda.setEditable(false);

        jLabel3.setText("Funcionário:");

        txtFuncionario.setEditable(false);

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/data.png"))); // NOI18N
        jLabel13.setText("Data inicial:");

        jbLimparDataInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparDataInicial.setText("Limpar");
        jbLimparDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparDataInicialActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/data.png"))); // NOI18N
        jLabel14.setText("Data Final:");

        jbLimparDataFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparDataFinal.setText("Limpar");
        jbLimparDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparDataFinalActionPerformed(evt);
            }
        });

        jbBuscarDatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarDatas.setText("Buscar");
        jbBuscarDatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDatasActionPerformed(evt);
            }
        });

        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setText("Valor Final:");

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
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
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMercadorias)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPDF))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimparDataInicial)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimparDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbBuscarDatas)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jbLimparDataFinal)
                        .addComponent(jbBuscarDatas)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jbLimparDataInicial)
                        .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                    .addComponent(jLabel15)
                    .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
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

    private void jbLimparDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparDataInicialActionPerformed

        txtDataInicial.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparDataInicialActionPerformed

    private void jbLimparDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparDataFinalActionPerformed

        txtDataFinal.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparDataFinalActionPerformed

    private void jbBuscarDatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDatasActionPerformed

        try {
            String dataRecebidaInicial = txtDataInicial.getText();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicialFormatada = formato.parse(dataRecebidaInicial);

            String dataRecebidaFinal = txtDataFinal.getText();

            Date dataFinalFormatada = formato.parse(dataRecebidaFinal);

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            VendaDAO daoVenda = new VendaDAO(con);
            List<Venda> venda = daoVenda.retriveAllData(dataInicialFormatada, dataFinalFormatada);
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

            System.out.println(e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarDatasActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        if (txtDataInicial.getText().equals("  /  /    ") && txtDataFinal.getText().equals("  /  /    ")) {
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
        } else {

            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Vendas Por Data" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE VENDAS DO DIA " + txtDataInicial.getText() + " ATÉ O DIA " + txtDataFinal.getText() + "\n \n"
                ));

                int tabela = jtVendas.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioVendas tbVenda = (TableModelRelatorioVendas) jtVendas.getModel();
                    Venda vendas = tbVenda.getVenda(i);
                    try {

                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        VendaDAO daoVenda = new VendaDAO(con);

                        String dataRecebidaInicial = txtDataInicial.getText();

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataInicialFormatada = formato.parse(dataRecebidaInicial);

                        String dataRecebidaFinal = txtDataFinal.getText();

                        Date dataFinalFormatada = formato.parse(dataRecebidaFinal);

                        List<Venda> venda = daoVenda.retriveAllData(dataInicialFormatada, dataFinalFormatada);
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
                Desktop.getDesktop().open(new File("Relatório de Vendas Por Data" + data.getTime() + ".pdf"));
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarDatas;
    private javax.swing.JButton jbLimparDataFinal;
    private javax.swing.JButton jbLimparDataInicial;
    private javax.swing.JTable jtVendas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMercadorias;
    private javax.swing.JTextField txtModoPagamento;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtParcela;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtValorDesconto;
    private javax.swing.JTextField txtValorFinal;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
