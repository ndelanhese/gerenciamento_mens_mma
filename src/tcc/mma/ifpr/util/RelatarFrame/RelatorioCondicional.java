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
import tcc.mma.ifpr.bean.Venda;
import tcc.mma.ifpr.dao.ClienteDAO;
import tcc.mma.ifpr.dao.CondicionalDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.dao.VendaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.Main;
import tcc.mma.ifpr.util.TableModel.TableModelRelatorioCondicional;
import tcc.mma.ifpr.util.TableModel.TableModelRelatorioVendas;

/**
 *
 * @author nnath
 */
public class RelatorioCondicional extends javax.swing.JInternalFrame {

    /**
     * Creates new form RelatorioCondicional
     */
    public RelatorioCondicional() {
        initComponents();

    }

    public void pegarTabela() {
        if (jcLimite.isSelected()) {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CondicionalDAO daoCondicional = new CondicionalDAO(con);
                List<Condicional> condicional = daoCondicional.retriveAllFull();
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
        } else {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtCondicional = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMercadorias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtObervacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataRetirada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDataDevolucao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jbAtualizarStatus = new javax.swing.JButton();
        jcLimite = new javax.swing.JCheckBox();
        btnPDF = new javax.swing.JButton();

        setClosable(true);
        setTitle("Relatório de Condicional");
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

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setText("Mercadorias:");

        txtMercadorias.setEditable(false);

        jLabel3.setText("Cliente:");

        txtCliente.setEditable(false);

        jLabel4.setText("Funcionário:");

        txtFuncionario.setEditable(false);

        jLabel6.setText("Observação:");

        txtObervacao.setEditable(false);

        jLabel7.setText("Data de Retirada:");

        txtDataRetirada.setEditable(false);

        jLabel8.setText("Data de Devolução:");

        txtDataDevolucao.setEditable(false);

        jLabel9.setText("Status:");

        txtStatus.setEditable(false);

        jbAtualizarStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/editar.png"))); // NOI18N
        jbAtualizarStatus.setText("Atualizar Status");
        jbAtualizarStatus.setEnabled(false);
        jbAtualizarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarStatusActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcLimite))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtObervacao, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAtualizarStatus)
                                .addGap(18, 18, 18)
                                .addComponent(btnPDF)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAtualizarStatus)
                    .addComponent(btnPDF))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jbAtualizarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarStatusActionPerformed
        RelatorioCondicionalStatus condicionalAtt = new RelatorioCondicionalStatus();

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

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

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
        pegarTabela();   // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        if (jcLimite.isSelected()) {
            Document document = new Document();

            Date data = new Date();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("Relatório de Condicional" + data.getTime() + ".pdf"));

                document.open();

                document.add(new Paragraph(
                        "RELATÓRIO DE CONDICIONAL \n\n"
                ));

                int tabela = jtCondicional.getRowCount();
                int contador = 0;
                for (int i = 0; i < tabela; i++) {

                    TableModelRelatorioCondicional tbVenda = (TableModelRelatorioCondicional) jtCondicional.getModel();
                    Condicional condicionais = tbVenda.getCondicional(i);
                    try {
                        Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                        CondicionalDAO daoCondicional = new CondicionalDAO(con);

                        List<Condicional> condicional = daoCondicional.retriveAll();

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
    private javax.swing.JButton jbAtualizarStatus;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JTable jtCondicional;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataRetirada;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMercadorias;
    private javax.swing.JTextField txtObervacao;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
