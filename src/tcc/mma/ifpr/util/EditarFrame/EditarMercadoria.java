/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.EditarFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;

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
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCategoria;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFornecedor;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMarca;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMercadoria;
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
public class EditarMercadoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarMercadoriao
     */
    public EditarMercadoria() {
        initComponents();

    }

    int c = 0;
    int idCategoria = 0;
    int idFornecedor = 0;
    int idMarca = 0;

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

    public void removerDesc() {
        TableModelMercadoriaFull tbMerc = (TableModelMercadoriaFull) jtTabela.getModel();

        int linhas = jtTabela.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbMerc.removeLinha(0);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jbBuscarCategoria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jbBuscarFornecedor = new javax.swing.JButton();
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
        jbEditar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        btLimparCategoria = new javax.swing.JButton();
        jbLimparFornecedor = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jbLimparMarca = new javax.swing.JButton();
        jbBuscarMarca = new javax.swing.JButton();
        jbBuscarMercadoria = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jcLimite = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Editar Mercadoria");
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

        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
            }
        });

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor:");

        txtFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFornecedorKeyPressed(evt);
            }
        });

        jbBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarFornecedor.setText("Buscar");
        jbBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFornecedorActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição:");

        jLabel5.setText("Marca:");

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMarcaKeyPressed(evt);
            }
        });

        jLabel6.setText("Valor de Compra:");

        txtValorCusto.addFocusListener(new java.awt.event.FocusAdapter() {
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

        jLabel7.setText("Valor de Venda:");

        txtValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
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

        jLabel8.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar Novo");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
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

        btLimparCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        btLimparCategoria.setText("Limpar");
        btLimparCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparCategoriaActionPerformed(evt);
            }
        });

        jbLimparFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparFornecedor.setText("Limpar");
        jbLimparFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparFornecedorActionPerformed(evt);
            }
        });

        jLabel9.setText("Cor:");

        jLabel10.setText("Tamanho:");

        jLabel11.setText("Quantidade:");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        jbLimparMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparMarca.setText("Limpar");
        jbLimparMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparMarcaActionPerformed(evt);
            }
        });

        jbBuscarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarMarca.setText("Buscar");
        jbBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarMarcaActionPerformed(evt);
            }
        });

        jbBuscarMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarMercadoria.setText("Buscar");
        jbBuscarMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarMercadoriaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbLimparMarca)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbBuscarMarca))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel2)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jbLimparFornecedor)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jbBuscarFornecedor))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btLimparCategoria)
                                                .addGap(18, 18, 18)
                                                .addComponent(jbBuscarCategoria))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbBuscarMercadoria)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 734, Short.MAX_VALUE)
                                .addComponent(jcLimite)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbEditar, jbExcluir, jbLimpar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtValorCusto, txtValorVenda});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btLimparCategoria, jbBuscarCategoria, jbBuscarFornecedor, jbBuscarMarca});

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
                    .addComponent(btLimparCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarFornecedor)
                    .addComponent(jbLimparFornecedor)
                    .addComponent(jLabel4)
                    .addComponent(jButton1)
                    .addComponent(jbBuscarMercadoria))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbCadastrar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

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
                linhaSelecionada = -1;

            }
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
                    jcbStatus.setSelectedIndex(mercadoria.getStatus() - 1);

                    jbCadastrar.setEnabled(false);
                    jbEditar.setEnabled(true);
                    jbExcluir.setEnabled(true);

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

        }

        if (c == 5) {
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

                    txtValorVenda.setText(mercadoria.getValor_venda());

                } catch (Exception e) {

                }

                removerDesc();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtTabelaMouseClicked

    private void btLimparCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparCategoriaActionPerformed

        txtCategoria.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btLimparCategoriaActionPerformed

    private void jbLimparFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparFornecedorActionPerformed

        txtFornecedor.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparFornecedorActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Texto texto = new Texto();
        String retorno = texto.textoConverter(txtDescricao.getText());
        txtDescricao.setText(retorno);
        String corRetorno = texto.textoConverter(txtCor.getText());
        txtCor.setText(corRetorno);

        txtTamanho.setText(texto.grande(txtTamanho.getText()));
        if (txtCategoria.getText().isEmpty() || txtDescricao.getText().isEmpty()
                || txtCor.getText().isEmpty() || txtTamanho.getText().isEmpty()
                || txtFornecedor.getText().isEmpty() || txtMarca.getText().isEmpty() || txtQuantidade.getText().isEmpty()
                || txtValorCusto.getText().isEmpty() || txtValorVenda.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os dados do formulário para editar a mercadoria", "Atencão!", NORMAL);

        } else {

            int id = Integer.parseInt(txtID.getText());
            Categoria categoria = new Categoria();
            categoria.setId(idCategoria);
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(idFornecedor);
            String descricao = txtDescricao.getText();
            String cor = txtCor.getText();
            String tamanho = txtTamanho.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            Marca marca = new Marca();
            marca.setId(idMarca);
            String valor_custo = txtValorCusto.getText();

            valor_custo = valor_custo.replace(".", "").replace("R$ ", "").replace(",", ".").replace(" ", "");

            String valor_venda = txtValorVenda.getText();

            valor_venda = valor_venda.replace(".", "").replace("R$ ", "").replace(",", ".").replace(" ", "");
            int status = jcbStatus.getSelectedIndex() + 1;

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                Mercadoria mercadoria = new Mercadoria(id, categoria, fornecedor, descricao, cor, tamanho, quantidade, marca, valor_custo, valor_venda, status);
                daoMercadoria.update(mercadoria);

                JOptionPane.showMessageDialog(null, "A mercadoria '" + txtDescricao.getText() + "' foi atualizada com sucesso!");

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

                c = 0;
                idCategoria = 0;
                idFornecedor = 0;
                idMarca = 0;

                pegarTabelaMercadoria();

                jbCadastrar.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

                contador1 = 0;
                contador2 = 0;
                valor1 = "";

                contador3 = 0;
                contador4 = 0;
                valor2 = null;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nao foi possivel atualizar a mercadoria ");
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

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

        c = 0;
        idCategoria = 0;
        idFornecedor = 0;
        idMarca = 0;

        pegarTabelaMercadoria();
        jbCadastrar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        contador1 = 0;
        contador2 = 0;
        valor1 = null;

        contador3 = 0;
        contador4 = 0;
        valor2 = null;
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbLimparMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparMarcaActionPerformed

        txtMarca.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparMarcaActionPerformed

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

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarMarcaActionPerformed

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
        }  // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoFocusLost

    private void txtValorCustoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCustoKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtValorCustoKeyTyped

    private void txtValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVendaActionPerformed
        if (contador3 == 0) {
            txtValorVenda.setText(null);
            contador3 = 1;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaActionPerformed

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
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaFocusLost

    private void txtValorVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorVendaKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        } // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaKeyTyped

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        CadastrarMercadoria mercadoria = new CadastrarMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        ExcluirMercadoria mercadoria = new ExcluirMercadoria();
        getParent().add(mercadoria);
        mercadoria.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbBuscarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarMercadoriaActionPerformed
        if (txtDescricao.getText().isEmpty() || txtDescricao.getText().equals(null)) {
            c = 5;
            pegarTabelaMercadoria();
        } else {
            c = 5;
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

                JOptionPane.showMessageDialog(null, "Não foi possível localizar a mercadoria '" + txtDescricao.getText() + "'",
                        "Atenção", NORMAL);

                pegarTabelaMercadoria();

            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarMercadoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        txtDescricao.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
        pegarTabelaMercadoria();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained
        txtCategoria.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCategoria.doClick();

        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaKeyPressed

    private void txtFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFornecedorKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarFornecedor.doClick();

        }  // TODO add your handling code here:
    }//GEN-LAST:event_txtFornecedorKeyPressed

    private void txtMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarMarca.doClick();

        }    // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimparCategoria;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbBuscarFornecedor;
    private javax.swing.JButton jbBuscarMarca;
    private javax.swing.JButton jbBuscarMercadoria;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbLimparFornecedor;
    private javax.swing.JButton jbLimparMarca;
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
