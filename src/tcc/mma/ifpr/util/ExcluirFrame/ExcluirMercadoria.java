/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.ExcluirFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMercadoria;
import tcc.mma.ifpr.util.EditarFrame.EditarMercadoria;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelMercadoriaFull;

/**
 *
 * @author nnath
 */
public class ExcluirMercadoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form ExcluirMercadoria
     */
    public ExcluirMercadoria() {
        initComponents();

    }

    int contador1 = 0;
    int contador2 = 0;
    String valor1 = "";

    int contador3 = 0;
    int contador4 = 0;
    String valor2 = "";

    public void pegarTabelaMercadoria() {

        if (jcLimite.isSelected()) {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                List<Mercadoria> mer = daoMercadoria.retrieveAll1Full();

                TableModelMercadoriaFull tableModelMercadoria = new TableModelMercadoriaFull();

                jtTabela.setModel(tableModelMercadoria);

                for (int i = 0; i < mer.size(); i++) {

                    int status = mer.get(i).getStatus();

                    if (status == 3) {

                    } else {

                        Mercadoria mercadorias = new Mercadoria();

                        mercadorias.setId(mer.get(i).getId());
                        mercadorias.setCategoria(mer.get(i).getCategoria());
                        mercadorias.setDescricao(mer.get(i).getDescricao());
                        mercadorias.setCor(mer.get(i).getCor());
                        mercadorias.setTamanho(mer.get(i).getTamanho());

                        String valorVendaBd = mer.get(i).getValor_venda().replace(".", ",");
                        String valorVenda = "R$ " + valorVendaBd;

                        mercadorias.setValor_venda(valorVenda);
                        tableModelMercadoria.addRow(mercadorias);

                    }
                }

            } catch (Exception e) {
            }
        } else {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                List<Mercadoria> mer = daoMercadoria.retrieveAll1();

                TableModelMercadoriaFull tableModelMercadoria = new TableModelMercadoriaFull();

                jtTabela.setModel(tableModelMercadoria);

                for (int i = 0; i < mer.size(); i++) {

                    Mercadoria mercadorias = new Mercadoria();

                    mercadorias.setId(mer.get(i).getId());
                    mercadorias.setCategoria(mer.get(i).getCategoria());
                    mercadorias.setDescricao(mer.get(i).getDescricao());
                    mercadorias.setCor(mer.get(i).getCor());
                    mercadorias.setTamanho(mer.get(i).getTamanho());

                    String valorVendaBd = mer.get(i).getValor_venda().replace(".", ",");
                    String valorVenda = "R$ " + valorVendaBd;

                    mercadorias.setValor_venda(valorVenda);
                    tableModelMercadoria.addRow(mercadorias);

                }

            } catch (Exception e) {
            }
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

        jLabel3 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorVenda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jbCadastrarNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jcLimite = new javax.swing.JCheckBox();
        jbBuscarDescricao = new javax.swing.JButton();

        setClosable(true);
        setTitle("Excluir Mercadoria");
        setToolTipText("");
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

        jLabel3.setText("Fornecedor:");

        txtFornecedor.setEditable(false);

        jLabel4.setText("Descri????o:");

        jLabel5.setText("Marca:");

        txtMarca.setEditable(false);

        jLabel6.setText("Valor de Compra:");

        txtValorCusto.setEditable(false);

        jLabel7.setText("Valor de Venda:");

        txtValorVenda.setEditable(false);

        jLabel8.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Mercadoria", "Valor"
            }
        ));
        jtTabela.getTableHeader().setReorderingAllowed(false);
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setText("Categoria:");

        txtCategoria.setEditable(false);

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

        jLabel9.setText("Cor:");

        txtCor.setEditable(false);

        jLabel10.setText("Tamanho:");

        txtTamanho.setEditable(false);

        jLabel11.setText("Quantidade:");

        txtQuantidade.setEditable(false);

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

        jbBuscarDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarDescricao.setText("Buscar");
        jbBuscarDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcLimite))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(jbCadastrarNovo)
                                .addGap(18, 18, 18)
                                .addComponent(jbEditar)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscarDescricao)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrarNovo, jbEditar, jbExcluir, jbLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarDescricao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbCadastrarNovo)
                    .addComponent(jbEditar)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked

        int linhaSelecionada = jtTabela.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelMercadoriaFull tbMercadoriaFull = (TableModelMercadoriaFull) jtTabela.getModel();
            Mercadoria mercadorias = tbMercadoriaFull.getMercadoria(jtTabela.getSelectedRow());

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                Mercadoria mercadoria = daoMercadoria.retrieve(mercadorias.getId());

                txtID.setText(String.valueOf(mercadoria.getId()));
                txtCategoria.setText(mercadoria.getCategoria().getCategoria());
                txtFornecedor.setText(mercadoria.getFornecedor().getRazaoSocial());
                txtDescricao.setText(mercadoria.getDescricao());
                txtCor.setText(mercadoria.getCor());
                txtTamanho.setText(mercadoria.getTamanho());
                txtQuantidade.setText(String.valueOf(mercadoria.getQuantide()));
                txtMarca.setText(mercadoria.getMarca().getMarca());
                String valorCustoBd = mercadoria.getValor_custo().replace(".", ",");
                String valorCusto = "R$ " + valorCustoBd;
                txtValorCusto.setText(valorCusto);

                String valorVendaBd = mercadoria.getValor_venda().replace(".", ",");
                String valorVenda = "R$ " + valorVendaBd;

                txtValorVenda.setText(valorVenda);
                jcbStatus.setSelectedIndex(mercadoria.getStatus() - 1);
                txtDescricao.setEditable(false);
                jbCadastrarNovo.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
                
                pegarTabelaMercadoria();

            } catch (Exception e) {

            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        txtCategoria.setText(null);
        txtDescricao.setText(null);
        txtCor.setText(null);
        txtTamanho.setText(null);
        txtFornecedor.setText(null);
        txtID.setText(null);
        txtQuantidade.setText(null);
        txtMarca.setText(null);
        txtValorCusto.setText(null);
        txtValorVenda.setText(null);
        jcbStatus.setSelectedIndex(0);

        pegarTabelaMercadoria();
        jbCadastrarNovo.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        if (txtCategoria.getText().isEmpty() || txtDescricao.getText().isEmpty()
                || txtFornecedor.getText().isEmpty() || txtMarca.getText().isEmpty()
                || txtValorCusto.getText().isEmpty() || txtValorVenda.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os dados do formul??rio utilizando a tabela, para excluir a mercadoria", "Atenc??o!", NORMAL);

        } else {

            if (JOptionPane.showConfirmDialog(null, "Voc?? realmente deseja excluir a mercadoria '" + txtDescricao.getText() + "' ?", "Aten????o!",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int id = Integer.parseInt(txtID.getText());

                try {

                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                    MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                    daoMercadoria.delete(id);

                    txtCategoria.setText(null);
                    txtDescricao.setText(null);
                    txtFornecedor.setText(null);
                    txtID.setText(null);
                    txtCor.setText(null);
                    txtTamanho.setText(null);
                    txtQuantidade.setText(null);
                    txtMarca.setText(null);
                    txtValorCusto.setText(null);
                    txtValorVenda.setText(null);
                    jcbStatus.setSelectedIndex(0);

                    pegarTabelaMercadoria();
                    jbCadastrarNovo.setEnabled(true);
                    jbEditar.setEnabled(false);
                    jbExcluir.setEnabled(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel excluir a mercadoria ");
                }

            } else {
                txtCategoria.setText(null);
                txtDescricao.setText(null);
                txtFornecedor.setText(null);
                txtID.setText(null);
                txtMarca.setText(null);
                txtCor.setText(null);
                txtTamanho.setText(null);
                txtQuantidade.setText(null);
                txtValorCusto.setText(null);
                txtValorVenda.setText(null);
                jcbStatus.setSelectedIndex(0);

                pegarTabelaMercadoria();
                jbCadastrarNovo.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbCadastrarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarNovoActionPerformed

        CadastrarMercadoria mercadoria = new CadastrarMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarNovoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        EditarMercadoria mercadoria = new EditarMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLimiteActionPerformed

        if (jcLimite.isSelected()) {
            pegarTabelaMercadoria();
        } else {

            JOptionPane.showMessageDialog(null, "Voc?? realmente deseja tirar o limite de busca no banco?"
                    + "\nO preenchimento da tabela pode demorar!");

            pegarTabelaMercadoria();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        pegarTabelaMercadoria();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained
        txtCategoria.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void jbBuscarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDescricaoActionPerformed
      if (txtDescricao.getText().isEmpty() || txtDescricao.getText().equals(null)) {
            
            pegarTabelaMercadoria();
        } else {
            
            String mercadoria = txtDescricao.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                List<Mercadoria> mer = daoMercadoria.retrieveNome1(mercadoria);

                TableModelMercadoriaFull tableModelMercadoria = new TableModelMercadoriaFull();

                jtTabela.setModel(tableModelMercadoria);

                for (int i = 0; i < mer.size(); i++) {

                    Mercadoria mercadorias = new Mercadoria();

                    mercadorias.setId(mer.get(i).getId());
                    mercadorias.setCategoria(mer.get(i).getCategoria());
                    mercadorias.setDescricao(mer.get(i).getDescricao());
                    String valorVendaBd = mer.get(i).getValor_venda().replace(".", ",");
                    String valorVenda = "R$ " + valorVendaBd;

                    mercadorias.setValor_venda(valorVenda);
                    tableModelMercadoria.addRow(mercadorias);

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "N??o foi poss??vel localizar a mercadoria '" + txtDescricao.getText() + "'",
                        "Aten????o", NORMAL);

                pegarTabelaMercadoria();

            }

        }  // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarDescricaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarDescricao;
    private javax.swing.JButton jbCadastrarNovo;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtValorCusto;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}
