/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.AcaoFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Categoria;
import tcc.mma.ifpr.bean.Fornecedor;
import tcc.mma.ifpr.bean.Marca;
import tcc.mma.ifpr.bean.MercadoriaEncomenda;
import tcc.mma.ifpr.dao.CategoriaDAO;
import tcc.mma.ifpr.dao.FornecedorDAO;
import tcc.mma.ifpr.dao.MarcaDAO;
import tcc.mma.ifpr.dao.MercadoriaEncomendaDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCategoria;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFornecedor;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMarca;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCategoria;
import tcc.mma.ifpr.util.TableModel.TableModelFornecedor;
import tcc.mma.ifpr.util.TableModel.TableModelMarca;

/**
 *
 * @author nnath
 */
public class AcaoAdicionarMercadoriaEncomenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form AcaoAdicionarMercadoriaEncomenda
     */
    public AcaoAdicionarMercadoriaEncomenda() {
        initComponents();
        proximoId();
    }

    public void proximoId() {
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaEncomendaDAO daoMercadoria = new MercadoriaEncomendaDAO(con);
            MercadoriaEncomenda mercadoria = daoMercadoria.takeLastId();

            txtID.setText(String.valueOf(mercadoria.getId() + 1));

        } catch (Exception e) {
            txtID.setText("1");

        }

    }

    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int idCategoria = 0;
    int idFornecedor = 0;
    int idMarca = 0;

    public void removerCat() {
        TableModelCategoria tbCategoria = (TableModelCategoria) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbCategoria.removeLinha(0);

        }

        a = 1;

    }

    public void removerForne() {
        TableModelFornecedor tbFornecedor = (TableModelFornecedor) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbFornecedor.removeLinha(0);

        }

        b = 1;
    }

    public void removerMarc() {
        TableModelMarca tbMarca = (TableModelMarca) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbMarca.removeLinha(0);

        }

        d = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        jbBuscarCategoria = new javax.swing.JButton();
        jbBuscarFornecedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar6 = new javax.swing.JButton();
        jbBuscarMarca = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de mercadoria");

        lblId.setText("ID:");

        lblCategoria.setText("Categoria:");

        lblFornecedor.setText("Fornecedor:");

        lblDescricao.setText("Descrição:");

        lblMarca.setText("Marca:");

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
            }
        });

        jbBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarFornecedor.setText("Buscar");
        jbBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFornecedorActionPerformed(evt);
            }
        });

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);
        if (jtTabela.getColumnModel().getColumnCount() > 0) {
            jtTabela.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jtTabela.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jtTabela.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jtTabela.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jLabel1.setText("Cor:");

        jLabel2.setText("Tamanho:");

        txtID.setEnabled(false);

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/editar.png"))); // NOI18N
        jbEditar.setText("Editar");

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");

        jbLimpar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/excluir.png"))); // NOI18N
        jbLimpar6.setText("Limpar");
        jbLimpar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpar6ActionPerformed(evt);
            }
        });

        jbBuscarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarMarca.setText("Buscar");
        jbBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar6)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblMarca)
                            .addGap(51, 51, 51)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jbBuscarMarca))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDescricao)
                                .addComponent(lblFornecedor)
                                .addComponent(lblCategoria)
                                .addComponent(lblId)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtCategoria)
                                                        .addComponent(txtFornecedor))
                                                    .addGap(18, 18, 18)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jbBuscarCategoria)
                                                .addComponent(jbBuscarFornecedor))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCor))
                                            .addGap(91, 91, 91)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtTamanho)
                                    .addGap(547, 547, 547)))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbEditar, jbExcluir, jbLimpar6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarCategoria))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFornecedor)
                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarFornecedor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCategoriaActionPerformed

        if (txtCategoria.getText().isEmpty() || txtCategoria.getText().equals(null)) {

            c = 1;
            String categoria = txtCategoria.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                List<Categoria> cat = daoCategoria.retrieveAll();

                TableModelCategoria tableModelCategoria = new TableModelCategoria();

                jtTabela.setModel(tableModelCategoria);

                for (int i = 0; i < cat.size(); i++) {

                    Categoria categorias = new Categoria();

                    categorias.setId(cat.get(i).getId());
                    categorias.setCategoria(cat.get(i).getCategoria());
                    tableModelCategoria.addRow(categorias);

                }

            } catch (Exception e) {
            }

        } else {

            c = 1;
            String categoria = txtCategoria.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                List<Categoria> cat = daoCategoria.retrieveNome(categoria);
                if (cat.isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null, "Não foi possível localizar a categoria '" + txtCategoria.getText() + "' \n"
                            + "Deseja ir para a pagina de cadastro de Categoria?", "Atenção!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        CadastrarCategoria categoria1 = new CadastrarCategoria();
                        getParent().add(categoria1);
                        categoria1.setVisible(true);
                        getParent().remove(2);
                        getParent().remove(1);

                    }
                } else {
                    TableModelCategoria tableModelCategoria = new TableModelCategoria();

                    jtTabela.setModel(tableModelCategoria);

                    for (int i = 0; i < cat.size(); i++) {

                        Categoria categorias = new Categoria();

                        categorias.setId(cat.get(i).getId());
                        categorias.setCategoria(cat.get(i).getCategoria());
                        tableModelCategoria.addRow(categorias);

                    }
                }

            } catch (Exception e) {
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarCategoriaActionPerformed

    private void jbBuscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarFornecedorActionPerformed

        if (txtFornecedor.getText().isEmpty() || txtFornecedor.getText().equals(null)) {

            c = 2;
            String fornecedor = txtFornecedor.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveAll();
                TableModelFornecedor tableModelFornecedor = new TableModelFornecedor();

                jtTabela.setModel(tableModelFornecedor);

                for (int i = 0; i < forne.size(); i++) {

                    Fornecedor fornecedore = new Fornecedor();

                    fornecedore.setId(forne.get(i).getId());
                    fornecedore.setRazaoSocial(forne.get(i).getRazaoSocial());
                    tableModelFornecedor.addRow(fornecedore);

                }

            } catch (Exception e) {
            }

        } else {
            c = 2;
            String fornecedor = txtFornecedor.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveNome(fornecedor);

                if (forne.isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null, "Não foi possível localizar o fornecedor '" + txtFornecedor.getText() + "' \n"
                            + "Deseja ir para a pagina de cadastro de Fornecedor?", "Atenção!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        CadastrarFornecedor fornecedor1 = new CadastrarFornecedor();
                        getParent().add(fornecedor1);
                        fornecedor1.setVisible(true);
                        getParent().remove(2);
                        getParent().remove(1);

                    }
                } else {

                    TableModelFornecedor tableModelFornecedor = new TableModelFornecedor();

                    jtTabela.setModel(tableModelFornecedor);

                    for (int i = 0; i < forne.size(); i++) {

                        Fornecedor fornecedore = new Fornecedor();

                        fornecedore.setId(forne.get(i).getId());
                        fornecedore.setRazaoSocial(forne.get(i).getRazaoSocial());
                        tableModelFornecedor.addRow(fornecedore);

                    }
                }

            } catch (Exception e) {
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarFornecedorActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked

        int linhaSelecionada = jtTabela.getSelectedRow();

        if (c == 1) {
            if (linhaSelecionada != -1) {
                TableModelCategoria tbCategoria = (TableModelCategoria) jtTabela.getModel();
                Categoria categoria = tbCategoria.getCategoria(jtTabela.getSelectedRow());

                txtCategoria.setText(categoria.getCategoria());
                idCategoria = categoria.getId();
                removerCat();

            }
        }
        if (c == 2) {
            if (linhaSelecionada != -1) {
                TableModelFornecedor tbFornecedor = (TableModelFornecedor) jtTabela.getModel();
                Fornecedor fornecedor = tbFornecedor.getFornecedor(jtTabela.getSelectedRow());

                idFornecedor = fornecedor.getId();
                txtFornecedor.setText(fornecedor.getRazaoSocial());

                removerForne();
            }

        }
        if (c == 3) {
            if (linhaSelecionada != -1) {
                TableModelMarca tbMarca = (TableModelMarca) jtTabela.getModel();
                Marca marca = tbMarca.getMarca(jtTabela.getSelectedRow());

                idMarca = marca.getId();
                txtMarca.setText(marca.getMarca());

                removerMarc();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        if (txtDescricao.getText().isEmpty() || txtMarca.getText().isEmpty()
                || txtCor.getText().isEmpty() || txtTamanho.getText().isEmpty()) {

            if (a != 1 || b != 1 || d != 0) {
                JOptionPane.showMessageDialog(null, "Utilize a tabela ao lado para preencher os campos 'CATEGORIA' e 'FORNECEDOR'!", "Atenção", NORMAL);
            } else {

                JOptionPane.showMessageDialog(null, "Preencha todos os dados do formulário!", "Atenção", NORMAL);
            }
        } else {

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();

                int id = Integer.valueOf(txtID.getText());

                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                String categoria = txtCategoria.getText();
                List<Categoria> cat = daoCategoria.retrieveNome(categoria);
                Categoria categorias = new Categoria();
                categorias.setId(cat.get(0).getId());

                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                String fornecedor = txtFornecedor.getText();
                List<Fornecedor> forne = daoFornecedor.retrieveNome(fornecedor);
                Fornecedor fornecedore = new Fornecedor();
                fornecedore.setId(forne.get(0).getId());

                String descricao = txtDescricao.getText();
                String cor = txtCor.getText();
                String tamanho = txtTamanho.getText();

                MarcaDAO daoMarca = new MarcaDAO(con);
                String marca = txtMarca.getText();
                List<Marca> marc = daoMarca.retrieveNome(marca);
                Marca marcas = new Marca();
                marcas.setId(marc.get(0).getId());

                MercadoriaEncomenda mercadoria = new MercadoriaEncomenda(id, categorias, fornecedore, descricao, cor, tamanho, 0, marcas, 1);

                MercadoriaEncomendaDAO daoMercadoria = new MercadoriaEncomendaDAO(con);
                daoMercadoria.create(mercadoria);

                JOptionPane.showMessageDialog(null, "A encomenda da mercadoria '" + txtDescricao.getText() + "' foi cadastrada com sucesso!");

                AcaoEncomenda encomenda = (AcaoEncomenda) getParent().getComponent(1);

                encomenda.prepararMerc(Integer.parseInt(txtID.getText()));

                proximoId();
                txtCategoria.setText(null);
                txtFornecedor.setText(null);
                txtDescricao.setText(null);
                txtCor.setText(null);
                txtTamanho.setText(null);

                txtMarca.setText(null);

                a = 0;
                b = 0;
                c = 0;
                d = 0;
                idCategoria = 0;
                idFornecedor = 0;
                idMarca = 0;

                this.setVisible(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a mercadoria" + e);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbLimpar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpar6ActionPerformed

        proximoId();
        txtCategoria.setText(null);
        txtFornecedor.setText(null);
        txtDescricao.setText(null);
        txtCor.setText(null);
        txtTamanho.setText(null);

        txtMarca.setText(null);

        a = 0;
        b = 0;
        c = 0;
        d = 0;
        idCategoria = 0;
        idFornecedor = 0;
        idMarca = 0;
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimpar6ActionPerformed

    private void jbBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarMarcaActionPerformed

        if (txtMarca.getText().isEmpty() || txtMarca.getText().equals(null)) {

            c = 3;

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> marc = daoMarca.retrieveAll();
                TableModelMarca tableModelMarca = new TableModelMarca();

                jtTabela.setModel(tableModelMarca);

                for (int i = 0; i < marc.size(); i++) {

                    Marca marcas = new Marca();

                    marcas.setId(marc.get(i).getId());
                    marcas.setMarca(marc.get(i).getMarca());
                    tableModelMarca.addRow(marcas);

                }

            } catch (Exception e) {
            }

        } else {
            c = 3;
            String marca = txtFornecedor.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> marc = daoMarca.retrieveNome(marca);

                if (marc.isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null, "Não foi possível localizar a marca '" + txtMarca.getText() + "' \n"
                            + "Deseja ir para a pagina de cadastro de Marca?", "Atenção!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        CadastrarMarca marca1 = new CadastrarMarca();
                        getParent().add(marca1);
                        marca1.setVisible(true);
                        getParent().remove(2);
                        getParent().remove(1);

                    }
                } else {
                    TableModelMarca tableModelMarca = new TableModelMarca();

                    jtTabela.setModel(tableModelMarca);

                    for (int i = 0; i < marc.size(); i++) {

                        Marca marcas = new Marca();

                        marcas.setId(marc.get(i).getId());
                        marcas.setMarca(marc.get(i).getMarca());
                        tableModelMarca.addRow(marcas);

                    }
                }

            } catch (Exception e) {
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarMarcaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbBuscarFornecedor;
    private javax.swing.JButton jbBuscarMarca;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar6;
    private javax.swing.JTable jtTabela;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}