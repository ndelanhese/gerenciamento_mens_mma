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
import javax.swing.JTable;
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
public class RelatorioVendasDoDia extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioMaisVendidoDia
     */
    public RelatorioVendasDoDia() {
        initComponents();

    }

    public void pegarTabela() {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            VendaDAO daoVenda = new VendaDAO(con);
            Date data = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            txtData.setText(formato.format(data));
            List<Venda> venda = daoVenda.retriveAllDia(data);
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
        txtDataVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtValorFinal = new javax.swing.JTextField();
        btnPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório Vendas do Dia");
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

        txtDataVenda.setEditable(false);

        jLabel3.setText("Funcionário:");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/data.png"))); // NOI18N
        jLabel13.setText("Data:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Valor Final:");

        txtValorFinal.setEditable(false);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPDF))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel14)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        txtData.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            String dataRecebida = txtData.getText();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatada = formato.parse(dataRecebida);
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            VendaDAO daoVenda = new VendaDAO(con);
            List<Venda> venda = daoVenda.retriveAllDia(dataFormatada);
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

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        pegarTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        if (txtData.getText().equals("  /  /    ")) {
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
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Vendas Do Dia" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE VENDAS DO DIA " + txtData.getText() + "\n \n"
                ));

                int tabela = jtVendas.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioVendas tbVenda = (TableModelRelatorioVendas) jtVendas.getModel();
                    Venda vendas = tbVenda.getVenda(i);
                    try {

                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        VendaDAO daoVenda = new VendaDAO(con);

                        String dataRecebida = txtData.getText();

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataFormatada = formato.parse(dataRecebida);

                        List<Venda> venda = daoVenda.retriveAllDia(dataFormatada);
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
                Desktop.getDesktop().open(new File("Relatório de Vendas Do Dia" + data.getTime() + ".pdf"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }
        }
    }//GEN-LAST:event_btnPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtVendas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtData;
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
