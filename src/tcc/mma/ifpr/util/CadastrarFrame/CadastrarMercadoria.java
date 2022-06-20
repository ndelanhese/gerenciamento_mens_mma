/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.CadastrarFrame;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import static java.awt.Frame.NORMAL;
import java.awt.HeadlessException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Categoria;
import tcc.mma.ifpr.bean.Fornecedor;
import tcc.mma.ifpr.bean.Marca;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.dao.CategoriaDAO;
import tcc.mma.ifpr.dao.FornecedorDAO;
import tcc.mma.ifpr.dao.MarcaDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.util.EditarFrame.EditarMercadoria;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirMercadoria;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCategoria;
import tcc.mma.ifpr.util.TableModel.TableModelFornecedor;
import tcc.mma.ifpr.util.TableModel.TableModelMarca;
import tcc.mma.ifpr.util.TableModel.TableModelMercadoriaFull;
import tcc.mma.ifpr.util.Validar.Texto;

/**
 *
 * @author nnath
 */
public class CadastrarMercadoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarMercadoriao
     */
    public CadastrarMercadoria() {
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
                c = 3;
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
                c = 3;
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

    public void removerCat() {
        TableModelCategoria tbCategoria = (TableModelCategoria) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbCategoria.removeLinha(0);

        }

        pegarTabelaMercadoria();

    }

    public void removerForne() {
        TableModelFornecedor tbFornecedor = (TableModelFornecedor) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbFornecedor.removeLinha(0);

        }
        pegarTabelaMercadoria();

    }

    public void removerMarc() {
        TableModelMarca tbMarca = (TableModelMarca) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbMarca.removeLinha(0);

        }
        pegarTabelaMercadoria();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jbBuscarMarca = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbLimparMarca = new javax.swing.JButton();
        jbBuscarFornecedor = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        jbBuscarCategoria = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jbLimparFornecedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbLimparCategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        txtValorVenda = new javax.swing.JTextField();
        txtValorCusto = new javax.swing.JTextField();
        jcLimite = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Cadastrar Mercadoria");
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

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
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

        jLabel7.setText("Valor de Venda:");

        jLabel6.setText("Valor de Compra:");

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMarcaKeyPressed(evt);
            }
        });

        jLabel5.setText("Marca:");

        jbBuscarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarMarca.setText("Buscar");
        jbBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarMarcaActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição:");

        jbLimparMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparMarca.setText("Limpar");
        jbLimparMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparMarcaActionPerformed(evt);
            }
        });

        jbBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarFornecedor.setText("Buscar");
        jbBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFornecedorActionPerformed(evt);
            }
        });

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        txtFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFornecedorKeyPressed(evt);
            }
        });

        jLabel11.setText("Quantidade:");

        jLabel3.setText("Fornecedor:");

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
            }
        });

        jLabel10.setText("Tamanho:");

        jLabel9.setText("Cor:");

        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
            }
        });

        jLabel2.setText("Categoria:");

        txtID.setEditable(false);

        jbLimparFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparFornecedor.setText("Limpar");
        jbLimparFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparFornecedorActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jbLimparCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparCategoria.setText("Limpar");
        jbLimparCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparCategoriaActionPerformed(evt);
            }
        });

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Mercadoria", "Cor", "Tamanho", "Valor"
            }
        ));
        jtTabela.getTableHeader().setReorderingAllowed(false);
        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabela);
        if (jtTabela.getColumnModel().getColumnCount() > 0) {
            jtTabela.getColumnModel().getColumn(0).setMinWidth(80);
            jtTabela.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtTabela.getColumnModel().getColumn(0).setMaxWidth(80);
            jtTabela.getColumnModel().getColumn(2).setMinWidth(250);
            jtTabela.getColumnModel().getColumn(2).setPreferredWidth(250);
            jtTabela.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        txtValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorVendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorVendaFocusLost(evt);
            }
        });
        txtValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVendaActionPerformed(evt);
            }
        });
        txtValorVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorVendaKeyTyped(evt);
            }
        });

        txtValorCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorCustoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorCustoFocusLost(evt);
            }
        });
        txtValorCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorCustoActionPerformed(evt);
            }
        });
        txtValorCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorCustoKeyTyped(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcLimite))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbEditar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtQuantidade))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtCategoria))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbLimparFornecedor)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbBuscarFornecedor)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jbLimparCategoria)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbBuscarCategoria)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbLimparMarca)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbBuscarMarca)))))
                        .addGap(0, 156, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbEditar, jbExcluir, jbLimpar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtValorCusto, txtValorVenda});

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
                    .addComponent(jbBuscarCategoria)
                    .addComponent(jbLimparCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarFornecedor)
                    .addComponent(jbLimparFornecedor)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimparMarca)
                    .addComponent(jbBuscarMarca))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    public void proximoId() {
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
            Mercadoria mercadoria = daoMercadoria.takeLastId();

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

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        Texto texto = new Texto();
        String retorno = texto.textoConverter(txtDescricao.getText());
        txtDescricao.setText(retorno);
        String corRetorno = texto.textoConverter(txtCor.getText());
        txtCor.setText(corRetorno);

        txtTamanho.setText(texto.grande(txtTamanho.getText()));

        if (txtDescricao.getText().isEmpty() || txtMarca.getText().isEmpty()
                || txtCor.getText().isEmpty() || txtTamanho.getText().isEmpty()
                || txtValorCusto.getText().isEmpty() || txtValorVenda.getText().isEmpty()
                || txtQuantidade.getText().isEmpty()) {

            if (a != 1 || b != 1 || d != 1) {
                JOptionPane.showMessageDialog(null, "Utilize a tabela ao lado para preencher os campos 'CATEGORIA', 'FORNECEDOR' e 'MARCA'!", "Atenção", NORMAL);
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
                int quantidade = Integer.parseInt(txtQuantidade.getText());

                MarcaDAO daoMarca = new MarcaDAO(con);
                String marca = txtMarca.getText();
                List<Marca> marc = daoMarca.retrieveNome(marca);
                Marca marcas = new Marca();
                marcas.setId(marc.get(0).getId());

                String valor_custo = txtValorCusto.getText();

                valor_custo = valor_custo.replace(".", "").replace("R$ ", "").replace(",", ".").replace(" ", "");

                String valor_venda = txtValorVenda.getText();

                valor_venda = valor_venda.replace(".", "").replace("R$ ", "").replace(",", ".").replace(" ", "");

                Mercadoria mercadoria = new Mercadoria(id, categorias, fornecedore, descricao, cor, tamanho, quantidade, marcas, valor_custo, valor_venda, 1);

                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                daoMercadoria.create(mercadoria);

                JOptionPane.showMessageDialog(null, "Mercadoria '" + txtDescricao.getText() + "' Cadastrada com sucesso!");

                barcodeEAN(String.valueOf(id));

                proximoId();
                txtCategoria.setText(null);
                txtFornecedor.setText(null);
                txtDescricao.setText(null);
                txtCor.setText(null);
                txtTamanho.setText(null);
                txtQuantidade.setText(null);
                txtMarca.setText(null);
                txtValorCusto.setText(null);
                txtValorVenda.setText(null);
                pegarTabelaMercadoria();
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                idMarca = 0;
                idCategoria = 0;
                idFornecedor = 0;

                jbCadastrar.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

                jbBuscarCategoria.setEnabled(true);
                jbBuscarFornecedor.setEnabled(true);
                jbBuscarMarca.setEnabled(true);
                jbLimparCategoria.setEnabled(true);
                jbLimparFornecedor.setEnabled(true);
                jbLimparMarca.setEnabled(true);

                contador1 = 0;
                contador2 = 0;
                valor1 = "";

                contador3 = 0;
                contador4 = 0;
                valor2 = null;

                pegarTabelaMercadoria();
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a mercadoria" + e);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarActionPerformed

    void barcodeEAN(String id) {

        Document document = new Document();
        String s = "";
        if (id.length() < 11) {

            int cont = 11 - id.length();

            for (int i = 0; i < cont; i++) {
                s = s + "0";
            }

        }
        id = s + id;

        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("barCode/ean13" + id + ".pdf"));
            document.open();

            PdfContentByte CB = writer.getDirectContent();

            Barcode128 code = new Barcode128();
            code.setCode(id);

            Font f = new Font(FontFamily.TIMES_ROMAN, 6.0f, Font.NORMAL, BaseColor.BLACK);
            Paragraph para = new Paragraph(txtDescricao.getText(), f);
            document.add(para);

            code.setCodeType(Barcode.UPCA);
            code.setCode(id);
            document.add(code.createImageWithBarcode(CB, BaseColor.BLACK, BaseColor.BLACK));

            document.close();

            try {
                Desktop.getDesktop().open(new File("barCode/ean13" + id + ".pdf"));

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o PDF " + ex, "Atenção!", NORMAL);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }


    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        proximoId();
        txtCategoria.setText(null);
        txtFornecedor.setText(null);
        txtDescricao.setText(null);
        txtCor.setText(null);
        txtTamanho.setText(null);
        txtQuantidade.setText(null);
        txtMarca.setText(null);
        txtValorCusto.setText(null);
        txtValorVenda.setText(null);
        pegarTabelaMercadoria();
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        idMarca = 0;
        idCategoria = 0;
        idFornecedor = 0;

        jbCadastrar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        jbBuscarCategoria.setEnabled(true);
        jbBuscarFornecedor.setEnabled(true);
        jbBuscarMarca.setEnabled(true);
        jbLimparCategoria.setEnabled(true);
        jbLimparFornecedor.setEnabled(true);
        jbLimparMarca.setEnabled(true);

        contador1 = 0;
        contador2 = 0;
        valor1 = null;

        contador3 = 0;
        contador4 = 0;
        valor2 = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jtTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMouseClicked

        int linhaSelecionada = jtTabela.getSelectedRow();

        if (c == 1) {
            if (linhaSelecionada != -1) {
                TableModelCategoria tbCategoria = (TableModelCategoria) jtTabela.getModel();
                Categoria categoria = tbCategoria.getCategoria(jtTabela.getSelectedRow());

                txtCategoria.setText(categoria.getCategoria());
                idCategoria = categoria.getId();
                removerCat();
                linhaSelecionada = -1;

            }
            pegarTabelaMercadoria();
        }
        if (c == 2) {
            if (linhaSelecionada != -1) {
                TableModelFornecedor tbFornecedor = (TableModelFornecedor) jtTabela.getModel();
                Fornecedor fornecedor = tbFornecedor.getFornecedor(jtTabela.getSelectedRow());

                idFornecedor = fornecedor.getId();
                txtFornecedor.setText(fornecedor.getRazaoSocial());

                removerForne();
                linhaSelecionada = -1;

            }
            pegarTabelaMercadoria();
        }

        if (c == 3) {
            if (linhaSelecionada != -1) {
                TableModelMercadoriaFull tbMercadoriaFull = (TableModelMercadoriaFull) jtTabela.getModel();
                Mercadoria mercadorias = tbMercadoriaFull.getMercadoria(jtTabela.getSelectedRow());

                try {

                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                    MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                    Mercadoria mercadoria = daoMercadoria.retrieve(mercadorias.getId());

                    txtID.setText(String.valueOf(mercadoria.getId()));
                    txtCategoria.setText(mercadoria.getCategoria().getCategoria());
                    idCategoria = mercadoria.getCategoria().getId();
                    txtFornecedor.setText(mercadoria.getFornecedor().getRazaoSocial());
                    idFornecedor = mercadoria.getFornecedor().getId();
                    txtDescricao.setText(mercadoria.getDescricao());
                    txtCor.setText(mercadoria.getCor());
                    txtTamanho.setText(mercadoria.getTamanho());
                    txtQuantidade.setText(String.valueOf(mercadoria.getQuantide()));
                    idMarca = mercadoria.getMarca().getId();
                    txtMarca.setText(mercadoria.getMarca().getMarca());
                    String valorCustoBd = mercadoria.getValor_custo().replace(".", ",");
                    String valorCusto = "R$ " + valorCustoBd;
                    txtValorCusto.setText(valorCusto);

                    String valorVendaBd = mercadoria.getValor_venda().replace(".", ",");
                    String valorVenda = "R$ " + valorVendaBd;

                    txtValorVenda.setText(valorVenda);

                    jbCadastrar.setEnabled(false);
                    jbEditar.setEnabled(true);
                    jbExcluir.setEnabled(true);

                    jbBuscarCategoria.setEnabled(false);
                    jbBuscarFornecedor.setEnabled(false);
                    jbBuscarMarca.setEnabled(false);
                    jbLimparCategoria.setEnabled(false);
                    jbLimparFornecedor.setEnabled(false);
                    jbLimparMarca.setEnabled(false);

                    pegarTabelaMercadoria();
                } catch (Exception e) {

                }

            }
        }

        if (c == 4) {
            if (linhaSelecionada != -1) {
                TableModelMarca tbMarca = (TableModelMarca) jtTabela.getModel();
                Marca marca = tbMarca.getMarca(jtTabela.getSelectedRow());

                idMarca = marca.getId();
                txtMarca.setText(marca.getMarca());

                removerMarc();
            }
            pegarTabelaMercadoria();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void jbBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarMarcaActionPerformed

        if (txtMarca.getText().isEmpty() || txtMarca.getText().equals(null)) {

            c = 4;

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> marc = daoMarca.retrieveAllFull();
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
            c = 4;
            String marca = txtMarca.getText();

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

    private void jbLimparMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparMarcaActionPerformed

        txtMarca.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparMarcaActionPerformed

    private void jbBuscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarFornecedorActionPerformed

        if (txtFornecedor.getText().isEmpty() || txtFornecedor.getText().equals(null)) {

            c = 2;
            String fornecedor = txtFornecedor.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                FornecedorDAO daoFornecedor = new FornecedorDAO(con);
                List<Fornecedor> forne = daoFornecedor.retrieveAll1Full();
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
                    List<Fornecedor> fornec = daoFornecedor.retrieveNomeAtendente(fornecedor);
                    if (fornec.isEmpty()) {
                        if (JOptionPane.showConfirmDialog(null, "Não foi possível localizar o fornecedor '" + txtFornecedor.getText() + "' \n"
                                + "Deseja ir para a pagina de cadastro de Fornecedor?", "Atenção!",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                            CadastrarFornecedor fornecedor1 = new CadastrarFornecedor();
                            getParent().add(fornecedor1);
                            fornecedor1.setVisible(true);
                            getParent().remove(1);

                        }
                    } else {
                        TableModelFornecedor tableModelFornecedor = new TableModelFornecedor();

                        jtTabela.setModel(tableModelFornecedor);

                        for (int i = 0; i < fornec.size(); i++) {

                            Fornecedor fornecedore = new Fornecedor();

                            fornecedore.setId(fornec.get(i).getId());
                            fornecedore.setNomeContato(fornecedore.getNomeContato());
                            fornecedore.setRazaoSocial(fornec.get(i).getRazaoSocial());
                            tableModelFornecedor.addRow(fornecedore);

                        }
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

    private void jbLimparFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparFornecedorActionPerformed

        txtFornecedor.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparFornecedorActionPerformed

    private void jbBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCategoriaActionPerformed

        if (txtCategoria.getText().isEmpty() || txtCategoria.getText().equals(null)) {

            c = 1;
            String categoria = txtCategoria.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                List<Categoria> cat = daoCategoria.retrieveAllFull();

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

    private void jbLimparCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCategoriaActionPerformed

        txtCategoria.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparCategoriaActionPerformed

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeKeyTyped


    private void txtValorCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorCustoActionPerformed

        if (contador1 == 0) {
            txtValorCusto.setText(null);
            contador1 = 1;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoActionPerformed

    private void txtValorCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorCustoFocusLost
        String valor = txtValorCusto.getText();
        if (valor1.equals(valor) || txtValorCusto.getText().isEmpty()) {

            txtValorCusto.setText(txtValorCusto.getText());

        } else {
            if (valor.indexOf(",") >= 0 || valor.indexOf(".") >= 0) {

                String valorC = valor.replace(".", ",").replace(" ", "").replace("R$", "");

                txtValorCusto.setText("R$ " + valorC);
            } else {

                String valorC = valor.replace(".", ",").replace(" ", "").replace("R$", "") + ",00";
                txtValorCusto.setText("R$ " + valorC);
            }

            valor1 = txtValorCusto.getText();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoFocusLost

    private void txtValorCustoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCustoKeyTyped

        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoKeyTyped

    private void txtValorCustoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorCustoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoFocusGained

    private void txtValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVendaActionPerformed
        if (contador3 == 0) {
            txtValorVenda.setText(null);
            contador3 = 1;
        }
    }//GEN-LAST:event_txtValorVendaActionPerformed

    private void txtValorVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorVendaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaFocusGained

    private void txtValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorVendaFocusLost
        String valor = txtValorVenda.getText();
        if (valor2.equals(valor) || txtValorVenda.getText().isEmpty()) {

            txtValorVenda.setText(txtValorVenda.getText());

        } else {
            if (valor.indexOf(",") >= 0 || valor.indexOf(".") >= 0) {

                String valorC = valor.replace(".", ",").replace(" ", "").replace("R$", "");

                txtValorVenda.setText("R$ " + valorC);
            } else {

                String valorC = valor.replace(".", ",").replace(" ", "").replace("R$", "") + ",00";
                txtValorVenda.setText("R$ " + valorC);
            }

            valor2 = txtValorVenda.getText();
        }
    }//GEN-LAST:event_txtValorVendaFocusLost

    private void txtValorVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorVendaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtValorVendaKeyTyped

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        EditarMercadoria mercadoria = new EditarMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        ExcluirMercadoria mercadoria = new ExcluirMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jcLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcLimiteActionPerformed

        if (jcLimite.isSelected()) {
            pegarTabelaMercadoria();
        } else {

            JOptionPane.showMessageDialog(null, "Você realmente deseja tirar o limite de busca no banco?"
                    + "\nO preenchimento da tabela pode demorar!");

            pegarTabelaMercadoria();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        proximoId();
        pegarTabelaMercadoria();

        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained
        txtCategoria.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCategoria.doClick();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaKeyPressed

    private void txtFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFornecedorKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarFornecedor.doClick();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtFornecedorKeyPressed

    private void txtMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarMarca.doClick();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaKeyPressed


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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbBuscarFornecedor;
    private javax.swing.JButton jbBuscarMarca;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbLimparCategoria;
    private javax.swing.JButton jbLimparFornecedor;
    private javax.swing.JButton jbLimparMarca;
    private javax.swing.JCheckBox jcLimite;
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
