/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.AcaoFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.bean.MercadoriaVenda;
import tcc.mma.ifpr.bean.Venda;
import tcc.mma.ifpr.dao.ClienteDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.dao.VendaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.Main;
import tcc.mma.ifpr.util.TableModel.TableModelCliente;
import tcc.mma.ifpr.util.TableModel.TableModelMercadoria;
import tcc.mma.ifpr.util.TableModel.TableModelMercadoriaVenda;

/**
 *
 * @author nnath
 */
public class AcaoVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form AcaoFrameVenda
     */
    public AcaoVenda() {
        initComponents();

        pegarFun();
    }

    public void prepararMerc(int id) {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);

            Mercadoria mercadoria = daoMercadoria.retrieve(id);

            txtMercadoria.setText(mercadoria.getDescricao());
            txtMercadoria.setEditable(false);
            txtQuantidade.setText("1");
            jbMaisMercadoria.setEnabled(true);
            jbMenosMercadoria.setEnabled(true);
            jbAdicionarMercadoriTabela.setEnabled(true);
            idMercadoria = mercadoria.getId();
        } catch (Exception e) {
        }

    }

    public String fazerVetorMercadoria() {

        int tamanhoTabela = jtMercadoria.getRowCount();

        String mercadoria[] = new String[tamanhoTabela];

        TableModelMercadoriaVenda tbMercadoria = (TableModelMercadoriaVenda) jtMercadoria.getModel();

        for (int i = tamanhoTabela - 1; i >= 0; i--) {
            MercadoriaVenda mercadoriaVenda = tbMercadoria.getMercadoria(i);

            if (i != 0) {
                mercadoria[i] = mercadoriaVenda.getId() + ", ";
            } else {
                mercadoria[i] = mercadoriaVenda.getId() + ".";
            }

        }
        String mercadoriaString = "";
        for (int i = mercadoria.length - 1; i >= 0; i--) {
            mercadoriaString = mercadoriaString + mercadoria[i];
        }

        return mercadoriaString;
    }

    public String fazerVetorQuantidade() {
        int tamanhoTabela = jtMercadoria.getRowCount();

        String mercadoriaQuantidade[] = new String[tamanhoTabela];

        TableModelMercadoriaVenda tbMercadoria = (TableModelMercadoriaVenda) jtMercadoria.getModel();

        for (int i = tamanhoTabela - 1; i >= 0; i--) {
            MercadoriaVenda mercadoriaVenda = tbMercadoria.getMercadoria(i);

            if (i != 0) {
                mercadoriaQuantidade[i] = mercadoriaVenda.getQuantidade() + ", ";
            } else {
                mercadoriaQuantidade[i] = mercadoriaVenda.getQuantidade() + ".";
            }

        }
        String QuantidadeString = "";
        for (int i = mercadoriaQuantidade.length - 1; i >= 0; i--) {
            QuantidadeString = QuantidadeString + mercadoriaQuantidade[i];
        }

        return QuantidadeString;
    }

    public void controlarEstoque(String mercadorias, String quantidades) {

        String[] t = mercadorias.split(Pattern.quote(","));
        String[] u = quantidades.split(Pattern.quote(","));

        String[] y = new String[t.length];
        String[] z = new String[t.length];

        String[] m = new String[u.length];
        String[] n = new String[u.length];

        for (int i = 0; i < t.length; i++) {

            y[i] = t[i].replace(" ", "");
            z[i] = y[i].replace(".", "");

            m[i] = u[i].replace(" ", "");
            n[i] = m[i].replace(".", "");
        }

        for (int i = 0; i < y.length; i++) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
                Mercadoria mercadoria = daoMercadoria.retrieve(Integer.parseInt(z[i]));

                Mercadoria mercadoria1 = new Mercadoria();
                mercadoria1.setId(Integer.parseInt(z[i]));
                mercadoria1.setQuantide(mercadoria.getQuantide() - Integer.parseInt(n[i]));

                daoMercadoria.updateQuantidade(mercadoria1);

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

        lblMercadoria = new javax.swing.JLabel();
        txtMercadoria = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblValor = new javax.swing.JLabel();
        lblDesconto = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jbAdicionarDesconto = new javax.swing.JButton();
        jbAdicionarMercadoriTabela = new javax.swing.JButton();
        lblValorFinal = new javax.swing.JLabel();
        txtValorFinal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblFormaPagamento = new javax.swing.JLabel();
        jcbFormaPagamento = new javax.swing.JComboBox<>();
        lblQuantidadeParcelas = new javax.swing.JLabel();
        jcbQuantidadeParcelas = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jbFinalizarVenda = new javax.swing.JButton();
        jbLimparVenda = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblFuncionario = new javax.swing.JLabel();
        jcbFuncionario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        jbPesquisarMercadoria = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMercadoria = new javax.swing.JTable();
        jbMaisMercadoria = new javax.swing.JButton();
        jbMenosMercadoria = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jbBuscarClienteNome = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jbBuscarClienteID = new javax.swing.JButton();
        jbAlterarCliente = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        jcbTipoDesconto = new javax.swing.JComboBox<>();
        jbRemoverMercadoriaTabela = new javax.swing.JButton();

        setClosable(true);
        setTitle("Venda");

        lblMercadoria.setText("Mercadoria:");

        txtMercadoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMercadoriaMouseClicked(evt);
            }
        });
        txtMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMercadoriaActionPerformed(evt);
            }
        });
        txtMercadoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMercadoriaKeyPressed(evt);
            }
        });

        lblValor.setText("Valor:");

        lblDesconto.setText("Desconto:");

        txtDesconto.setText("0");
        txtDesconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescontoMouseClicked(evt);
            }
        });
        txtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescontoKeyTyped(evt);
            }
        });

        jbAdicionarDesconto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/calculadora 1.png"))); // NOI18N
        jbAdicionarDesconto.setText("Calcular");
        jbAdicionarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarDescontoActionPerformed(evt);
            }
        });

        jbAdicionarMercadoriTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/mais.png"))); // NOI18N
        jbAdicionarMercadoriTabela.setText("Adicionar");
        jbAdicionarMercadoriTabela.setEnabled(false);
        jbAdicionarMercadoriTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarMercadoriTabelaActionPerformed(evt);
            }
        });

        lblValorFinal.setText("Valor Final:");

        txtValorFinal.setEnabled(false);

        lblFormaPagamento.setText("Forma de Pagamento");

        jcbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AV - À vista", "CC - Cartão de Crédito", "CD - Cartão de Débito", "PIX - À vista" }));
        jcbFormaPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbFormaPagamentoMouseClicked(evt);
            }
        });
        jcbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFormaPagamentoActionPerformed(evt);
            }
        });

        lblQuantidadeParcelas.setText("Quantidade Parcelas:");

        jcbQuantidadeParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1x -", "2x -", "3x -", "4x -", "5x - ", "6x -", "7x -", "8x - ", "9x - ", "10x -", "11x -", "12x -" }));
        jcbQuantidadeParcelas.setEnabled(false);
        jcbQuantidadeParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbQuantidadeParcelasActionPerformed(evt);
            }
        });

        jbFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/bdConect.png"))); // NOI18N
        jbFinalizarVenda.setText("Finalizar Venda");
        jbFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarVendaActionPerformed(evt);
            }
        });

        jbLimparVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparVenda.setText("Limpar Venda");
        jbLimparVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparVendaActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade:");

        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        lblFuncionario.setText("Funcionário:");

        jLabel2.setText("Observação:");

        txtObservacao.setText("Sem Observações");
        txtObservacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtObservacaoMouseClicked(evt);
            }
        });
        txtObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacaoActionPerformed(evt);
            }
        });

        jbPesquisarMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbPesquisarMercadoria.setText("Buscar");
        jbPesquisarMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarMercadoriaActionPerformed(evt);
            }
        });

        jtMercadoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mercadoria", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMercadoria.getTableHeader().setReorderingAllowed(false);
        jtMercadoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMercadoriaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtMercadoria);
        if (jtMercadoria.getColumnModel().getColumnCount() > 0) {
            jtMercadoria.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtMercadoria.getColumnModel().getColumn(0).setMaxWidth(100);
            jtMercadoria.getColumnModel().getColumn(1).setPreferredWidth(350);
            jtMercadoria.getColumnModel().getColumn(1).setMaxWidth(350);
        }

        jbMaisMercadoria.setText("+");
        jbMaisMercadoria.setEnabled(false);
        jbMaisMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMaisMercadoriaActionPerformed(evt);
            }
        });

        jbMenosMercadoria.setText("-");
        jbMenosMercadoria.setEnabled(false);
        jbMenosMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenosMercadoriaActionPerformed(evt);
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
        jScrollPane1.setViewportView(jtCliente);

        lblNome.setText("Cliente:");

        jbBuscarClienteNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteNome.setText("Buscar");
        jbBuscarClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteNomeActionPerformed(evt);
            }
        });

        lblID.setText("ID:");

        txtID.setEditable(false);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        jbBuscarClienteID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteID.setText("Buscar");
        jbBuscarClienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteIDActionPerformed(evt);
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

        txtValor.setEditable(false);
        txtValor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtValorPropertyChange(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorKeyPressed(evt);
            }
        });

        jcbTipoDesconto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porcento", "Reais" }));

        jbRemoverMercadoriaTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/menos 1.png"))); // NOI18N
        jbRemoverMercadoriaTabela.setText("Remover");
        jbRemoverMercadoriaTabela.setEnabled(false);
        jbRemoverMercadoriaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverMercadoriaTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscarClienteNome)
                                .addGap(18, 18, 18)
                                .addComponent(lblID)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscarClienteID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbAlterarCliente))
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator3)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMercadoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMercadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbPesquisarMercadoria)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbMaisMercadoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbMenosMercadoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jbAdicionarMercadoriTabela)
                                .addGap(18, 18, 18)
                                .addComponent(jbRemoverMercadoriaTabela))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblValor)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDesconto)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbTipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAdicionarDesconto)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblValorFinal)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFuncionario)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFormaPagamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(lblQuantidadeParcelas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbFinalizarVenda)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbLimparVenda)))
                                .addGap(0, 25, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAdicionarDesconto, jbAdicionarMercadoriTabela});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbFinalizarVenda, jbLimparVenda});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarClienteNome)
                    .addComponent(jbBuscarClienteID)
                    .addComponent(jbAlterarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMercadoria)
                    .addComponent(txtMercadoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisarMercadoria)
                    .addComponent(jLabel1)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdicionarMercadoriTabela)
                    .addComponent(jbMaisMercadoria)
                    .addComponent(jbMenosMercadoria)
                    .addComponent(jbRemoverMercadoriaTabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionario)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(lblDesconto)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdicionarDesconto)
                    .addComponent(lblValorFinal)
                    .addComponent(txtValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidadeParcelas)
                    .addComponent(jcbQuantidadeParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizarVenda)
                    .addComponent(jbLimparVenda))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    int a = 0;
    int b = 0;
    int d = 0;

    int idMercadoria = 0;

    private void jcbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFormaPagamentoActionPerformed

        int selecionado = jcbFormaPagamento.getSelectedIndex();
        if (selecionado == 1) {

            if (txtValorFinal.getText().isEmpty() || txtDesconto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos 'VALOR' e 'DESCONTO' \nEm seguida, utilize o botão 'CALCULAR'", "Atencão", NORMAL);

            } else {

                jcbQuantidadeParcelas.setEnabled(true);
                parcelasOff();
            }
        } else {
            jcbQuantidadeParcelas.setEnabled(false);
            jcbQuantidadeParcelas.setSelectedIndex(0);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jcbFormaPagamentoActionPerformed

    public void parcelasOff() {

        double valorParcela = Double.valueOf(txtValorFinal.getText().replace("R$ ", "").replace(",", ".").replace(" ", ""));

        jcbQuantidadeParcelas.setModel(new DefaultComboBoxModel<>(new String[]{
            "1x - " + String.format("%.2f", valorParcela), "2x - " + String.format("%.2f", valorParcela / 2),
            "3x - " + String.format("%.2f", valorParcela / 3), "4x - " + String.format("%.2f", valorParcela / 4),
            "5x - " + String.format("%.2f", valorParcela / 5), "6x - " + String.format("%.2f", valorParcela / 6),
            "7x - " + String.format("%.2f", valorParcela / 7), "8x - " + String.format("%.2f", valorParcela / 8),
            "9x - " + String.format("%.2f", valorParcela / 9), "10x - " + String.format("%.2f", valorParcela / 10),
            "11x - " + String.format("%.2f", valorParcela / 11), "12x - " + String.format("%.2f", valorParcela / 12)
        }));

    }

    public void pegarFun() {
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
            List<Funcionario> funcionario = daoFuncionario.retrieveAll();

            for (int i = 0; i < funcionario.size(); i++) {

                jcbFuncionario.addItem(funcionario.get(i).getNome());

            }

        } catch (Exception e) {
        }
    }

    private void jbLimparVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparVendaActionPerformed

        AcaoVenda venda = new AcaoVenda();

        getParent().add(venda);
        venda.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparVendaActionPerformed

    private void jbAdicionarMercadoriTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarMercadoriTabelaActionPerformed
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
            Mercadoria mer = daoMercadoria.retrieve(idMercadoria);

            int quantidadeEstoque = mer.getQuantide();

            if (Integer.parseInt(txtQuantidade.getText()) > quantidadeEstoque) {
                if (JOptionPane.showConfirmDialog(null, "A quantidade disponível em estoque de "
                        + "'" + mer.getDescricao() + "' é de: " + mer.getQuantide() + "\n"
                        + "Você Deseja vender somente as " + mer.getQuantide() + " restantes?", "Atenção!",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    txtQuantidade.setText(String.valueOf(mer.getQuantide()));

                    if (jtMercadoria.getRowCount() == 0) {

                        TableModelMercadoriaVenda tableModelMercadoriaVenda = new TableModelMercadoriaVenda();
                        jtMercadoria.setModel(tableModelMercadoriaVenda);

                        MercadoriaVenda mercadorias = new MercadoriaVenda();
                        mercadorias.setId(mer.getId());
                        mercadorias.setDescricao(mer.getDescricao());
                        mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

                        double valor_Venda = Double.valueOf(mer.getValor_venda()) * Integer.parseInt(txtQuantidade.getText());

                        mercadorias.setValor_venda("R$ " + String.valueOf(valor_Venda));
                        tableModelMercadoriaVenda.addRow(mercadorias);
                        txtValorFinal.setText("R$ " + (valor_Venda - Double.parseDouble(txtDesconto.getText())));
                        txtValor.setText(String.valueOf(valor_Venda));
                        idMercadoria = 0;
                        txtMercadoria.setText(null);
                        txtMercadoria.setEditable(true);
                        txtQuantidade.setText("");
                        jbMaisMercadoria.setEnabled(false);
                        jbMenosMercadoria.setEnabled(false);
                        jbAdicionarMercadoriTabela.setEnabled(false);

                    } else {
                        TableModelMercadoriaVenda tableModelMercadoriaVenda = (TableModelMercadoriaVenda) jtMercadoria.getModel();
                        jtMercadoria.setModel(tableModelMercadoriaVenda);

                        MercadoriaVenda mercadorias = new MercadoriaVenda();
                        mercadorias.setId(mer.getId());
                        mercadorias.setDescricao(mer.getDescricao());
                        mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                        double valor_Venda = Double.valueOf(mer.getValor_venda()) * Integer.parseInt(txtQuantidade.getText());
                        mercadorias.setValor_venda("R$ " + String.valueOf(valor_Venda));
                        tableModelMercadoriaVenda.addRow(mercadorias);
                        String valor_e = txtValor.getText().replace("R$ ", "").replace(",", ".").replace(" ", "");

                        double conta = Double.valueOf(valor_e) + valor_Venda;
                        txtValorFinal.setText("R$ " + (conta - Double.parseDouble(txtDesconto.getText())));
                        txtValor.setText(String.valueOf("R$ " + conta));
                        idMercadoria = 0;
                        txtMercadoria.setText(null);
                        txtMercadoria.setEditable(true);
                        txtQuantidade.setText("");
                        jbMaisMercadoria.setEnabled(false);
                        jbMenosMercadoria.setEnabled(false);
                        jbAdicionarMercadoriTabela.setEnabled(false);

                    }

                } else {
                    txtQuantidade.setText("1");
                }
            } else {

                if (jtMercadoria.getRowCount() == 0) {
                    TableModelMercadoriaVenda tableModelMercadoriaVenda = new TableModelMercadoriaVenda();
                    jtMercadoria.setModel(tableModelMercadoriaVenda);

                    MercadoriaVenda mercadorias = new MercadoriaVenda();
                    mercadorias.setId(mer.getId());
                    mercadorias.setDescricao(mer.getDescricao());
                    mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                    double valor_Venda = Double.valueOf(mer.getValor_venda()) * Integer.parseInt(txtQuantidade.getText());
                    mercadorias.setValor_venda("R$ " + String.valueOf(valor_Venda));
                    tableModelMercadoriaVenda.addRow(mercadorias);
                    txtValor.setText("R$ " + valor_Venda);

                    txtValorFinal.setText("R$ " + (valor_Venda - Double.parseDouble(txtDesconto.getText())));

                    idMercadoria = 0;
                    txtMercadoria.setText(null);
                    txtMercadoria.setEditable(true);
                    txtQuantidade.setText("");
                    jbMaisMercadoria.setEnabled(false);
                    jbMenosMercadoria.setEnabled(false);
                    jbAdicionarMercadoriTabela.setEnabled(false);

                } else {
                    TableModelMercadoriaVenda tableModelMercadoriaVenda = (TableModelMercadoriaVenda) jtMercadoria.getModel();
                    jtMercadoria.setModel(tableModelMercadoriaVenda);

                    MercadoriaVenda mercadorias = new MercadoriaVenda();
                    mercadorias.setId(mer.getId());
                    mercadorias.setDescricao(mer.getDescricao());
                    mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                    double valor_Venda = Double.valueOf(mer.getValor_venda()) * Integer.parseInt(txtQuantidade.getText());
                    mercadorias.setValor_venda("R$ " + String.valueOf(valor_Venda));
                    tableModelMercadoriaVenda.addRow(mercadorias);

                    String valor_e = txtValor.getText().replace("R$ ", "").replace(",", ".").replace(" ", "");

                    double conta = Double.valueOf(valor_e) + valor_Venda;

                    txtValorFinal.setText("R$ " + (conta - Double.parseDouble(txtDesconto.getText())));

                    txtValor.setText(String.valueOf("R$ " + conta));

                    idMercadoria = 0;
                    txtMercadoria.setText(null);
                    txtMercadoria.setEditable(true);
                    txtQuantidade.setText("");
                    jbMaisMercadoria.setEnabled(false);
                    jbMenosMercadoria.setEnabled(false);
                    jbAdicionarMercadoriTabela.setEnabled(false);

                }
            }
        } catch (Exception e) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAdicionarMercadoriTabelaActionPerformed

    private void jbAdicionarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarDescontoActionPerformed

        if (txtValor.getText().isEmpty()) {

        } else {

            if (jcbTipoDesconto.getSelectedIndex() == 0) {
                String valor_e = txtValor.getText().replace("R$ ", "").replace(",", ".").replace(" ", "");

                double valor = Double.valueOf(valor_e);
                double desconto = Double.valueOf(txtDesconto.getText());

                if (desconto > 98) {
                    JOptionPane.showMessageDialog(null, "O valor de desconto de: " + desconto + "% é inválido!");
                    txtDesconto.setText("0");
                } else {

                    double um = valor * desconto;
                    double dois = um / 100;

                    double descontoC = valor - dois;

                    txtValorFinal.setText("R$ " + String.format("%.2f", descontoC));
                    txtValorFinal.setEnabled(true);
                    txtValorFinal.setEditable(false);
                }
            }
            if (jcbTipoDesconto.getSelectedIndex() == 1) {
                String valor_e = txtValor.getText().replace("R$ ", "").replace(",", ".").replace(" ", "");

                double valor = Double.valueOf(valor_e);
                double desconto = Double.valueOf(txtDesconto.getText());

                if (desconto >= valor) {
                    JOptionPane.showMessageDialog(null, "O valor de desconto de: R$ " + desconto + " é inválido!");
                    txtDesconto.setText("0");
                } else {

                    txtValorFinal.setText("R$ " + String.format("%.2f", (valor - desconto)));
                    txtValorFinal.setEnabled(true);
                    txtValorFinal.setEditable(false);
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAdicionarDescontoActionPerformed

    private void jcbFormaPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFormaPagamentoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFormaPagamentoMouseClicked

    private void jcbQuantidadeParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbQuantidadeParcelasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jcbQuantidadeParcelasActionPerformed

    private void jbFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarVendaActionPerformed
        if (txtDesconto.getText().isEmpty() || jtMercadoria.getRowCount() == 0
                || txtValor.getText().isEmpty()
                || txtValorFinal.getText().isEmpty()
                || txtNome.getText().isEmpty() || txtObservacao.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os dados do formulário!", "Atenção", NORMAL);

        } else {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();

                Date data = new Date();

                FuncionarioDAO daoFuncionario = new FuncionarioDAO(con);
                List<Funcionario> fun = daoFuncionario.retrieveNome(String.valueOf(jcbFuncionario.getSelectedItem()));
                Funcionario funcionario = new Funcionario();
                funcionario.setId(fun.get(0).getId());

                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(txtID.getText()));

                String mercadorias = fazerVetorMercadoria();

                String valorTotal = txtValor.getText();

                String valorDesconto = null;

                if (jcbTipoDesconto.getSelectedIndex() == 0) {
                    valorDesconto = txtDesconto.getText() + "%";
                } else {
                    valorDesconto = "R$ " + txtDesconto.getText();
                }

                String valorFinal = txtValorFinal.getText();

                String quantidades = fazerVetorQuantidade();

                String observacao = txtObservacao.getText();
                String modoPagamento = String.valueOf(jcbFormaPagamento.getSelectedItem());
                int parcelas = jcbQuantidadeParcelas.getSelectedIndex() + 1;
                int status = 1;

                VendaDAO daoVenda = new VendaDAO(con);
                Venda venda = new Venda(1, data, funcionario, cliente, mercadorias, valorTotal, valorDesconto, valorFinal, quantidades, observacao, modoPagamento, parcelas, status);
                daoVenda.create(venda);

                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");

                controlarEstoque(mercadorias, quantidades);

                AcaoVenda vendaa = new AcaoVenda();
                getParent().add(vendaa);
                vendaa.setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {

                AcaoVenda vendaa = new AcaoVenda();
                getParent().add(vendaa);
                vendaa.setVisible(true);
                this.setVisible(false);

                JOptionPane.showMessageDialog(null, "A venda não foi realizada com sucesso!", "Atenção", NORMAL);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbFinalizarVendaActionPerformed

    private void jbPesquisarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarMercadoriaActionPerformed

        AcaoAdicionarMercadoria mercadoriaAdd = new AcaoAdicionarMercadoria();

        Main main = new Main();

        getParent().add(mercadoriaAdd);

        mercadoriaAdd.setVisible(true);

        int lDesk = getParent().getWidth();
        int aDesk = getParent().getHeight();
        int lIFrame = mercadoriaAdd.getWidth();
        int aIFrame = mercadoriaAdd.getHeight();

        mercadoriaAdd.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesquisarMercadoriaActionPerformed

    private void jtMercadoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMercadoriaMouseClicked

        jbRemoverMercadoriaTabela.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtMercadoriaMouseClicked

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void jbMaisMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMaisMercadoriaActionPerformed

        int conta = Integer.parseInt(txtQuantidade.getText()) + 1;

        String quantidade = String.valueOf(conta);

        txtQuantidade.setText(quantidade);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbMaisMercadoriaActionPerformed

    private void jbMenosMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenosMercadoriaActionPerformed

        if (Integer.parseInt(txtQuantidade.getText()) <= 1) {
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser inferior a 1ª unidade", "Atenção", NORMAL);
            txtQuantidade.setText("1");
        } else {

            int conta = Integer.parseInt(txtQuantidade.getText()) - 1;

            String quantidade = String.valueOf(conta);

            txtQuantidade.setText(quantidade);
        } // TODO add your handling code here:
    }//GEN-LAST:event_jbMenosMercadoriaActionPerformed

    private void txtObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacaoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacaoActionPerformed

    private void txtObservacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtObservacaoMouseClicked

        txtObservacao.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacaoMouseClicked

    private void txtDescontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescontoMouseClicked

        txtDesconto.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoMouseClicked

    private void txtDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoKeyTyped

        if (jcbTipoDesconto.getSelectedIndex() == 0) {
            String caracteres = "0987654321";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else {

            String caracteres = "0987654321,.";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoKeyTyped

    private void jbAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarClienteActionPerformed

        jbBuscarClienteID.setEnabled(true);
        jbBuscarClienteNome.setEnabled(true);
        jbAlterarCliente.setEnabled(false);
        txtID.setEditable(true);
        txtNome.setEditable(true);
        txtID.setText(null);
        txtNome.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbAlterarClienteActionPerformed

    private void jbBuscarClienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarClienteIDActionPerformed

        if (txtID.getText().isEmpty() || txtID.getText().equals(null)) {

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

            String cliente = txtID.getText();

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

                txtID.setText(null);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível Localizar o cliente com ID: " + txtID.getText(), "Atencão", NORMAL);
                txtID.setText(null);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarClienteIDActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyTyped

    private void jbBuscarClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarClienteNomeActionPerformed

        if (txtNome.getText().isEmpty() || txtNome.getText().equals(null)) {

            String cliente = txtNome.getText();

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
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarClienteNomeActionPerformed

    private void jtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClienteMouseClicked

        int linhaSelecionada = jtCliente.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelCliente tbCliente = (TableModelCliente) jtCliente.getModel();
            Cliente cliente = tbCliente.getCliente(jtCliente.getSelectedRow());

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                ClienteDAO daoCliente = new ClienteDAO(con);
                Cliente clienteR = daoCliente.retrieve(cliente.getId());

                txtID.setText(String.valueOf(clienteR.getId()));
                txtNome.setText(clienteR.getNome());

            } catch (Exception e) {
            }
            jbBuscarClienteID.setEnabled(false);
            jbBuscarClienteNome.setEnabled(false);
            jbAlterarCliente.setEnabled(true);
            txtID.setEditable(false);
            txtNome.setEditable(false);

            int linhas = jtCliente.getRowCount();
            for (int i = linhas - 1; i >= 0; i--) {

                tbCliente.removeLinha(i);

            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtClienteMouseClicked

    private void txtValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorKeyPressed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost

        if (Integer.parseInt(txtQuantidade.getText()) == 0) {
            txtQuantidade.setText("1");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void jbRemoverMercadoriaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverMercadoriaTabelaActionPerformed
        int linhaSelecionada = jtMercadoria.getSelectedRow();
        if (JOptionPane.showConfirmDialog(null, "Você realmente deseja retirar a mercadoria? ", "Atenção!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            if (linhaSelecionada != -1) {
                TableModelMercadoriaVenda model = (TableModelMercadoriaVenda) jtMercadoria.getModel();

                MercadoriaVenda mercadorias = model.getMercadoria(linhaSelecionada);

                String valor_e = txtValor.getText().replace("R$ ", "").replace(",", ".").replace(" ", "");
                String valor_a = mercadorias.getValor_venda().replace("R$ ", "").replace(",", ".").replace(" ", "");

                double conta = Double.valueOf(valor_e) - Double.valueOf(valor_a);

                txtValor.setText(String.valueOf("R$ " + conta));

                model.removeLinha(linhaSelecionada);

            }

            jbRemoverMercadoriaTabela.setEnabled(false);
        } else {
            jbRemoverMercadoriaTabela.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbRemoverMercadoriaTabelaActionPerformed

    private void txtValorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtValorPropertyChange

        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPropertyChange

    private void txtMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMercadoriaActionPerformed
      
        
        

// TODO add your handling code here:
    }//GEN-LAST:event_txtMercadoriaActionPerformed

    private void txtMercadoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMercadoriaMouseClicked
AcaoAdicionarMercadoria mercadoriaAdd = new AcaoAdicionarMercadoria();

        Main main = new Main();

        getParent().add(mercadoriaAdd);
        
        mercadoriaAdd.setVisible(true);

        int lDesk = getParent().getWidth();
        int aDesk = getParent().getHeight();
        int lIFrame = mercadoriaAdd.getWidth();
        int aIFrame = mercadoriaAdd.getHeight();

        mercadoriaAdd.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMercadoriaMouseClicked

    private void txtMercadoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMercadoriaKeyPressed

        
        AcaoAdicionarMercadoria mercadoriaAdd = new AcaoAdicionarMercadoria();

        Main main = new Main();

        getParent().add(mercadoriaAdd);

        mercadoriaAdd.setVisible(true);

        int lDesk = getParent().getWidth();
        int aDesk = getParent().getHeight();
        int lIFrame = mercadoriaAdd.getWidth();
        int aIFrame = mercadoriaAdd.getHeight();

        mercadoriaAdd.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtMercadoriaKeyPressed

    public void removerMer() {
        TableModelMercadoria tbMercadoria = (TableModelMercadoria) jtMercadoria.getModel();

        int linhas = jtMercadoria.getRowCount();

        for (int i = 0; i < linhas; i++) {

            tbMercadoria.removeLinha(0);

        }

        b = 1;

    }

    public void pegarValor() {
        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);

            Mercadoria mercadoria = daoMercadoria.retrieveValor(txtMercadoria.getText());

            txtValor.setText(String.valueOf(mercadoria.getValor_venda()));

        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbAdicionarDesconto;
    private javax.swing.JButton jbAdicionarMercadoriTabela;
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbBuscarClienteID;
    private javax.swing.JButton jbBuscarClienteNome;
    private javax.swing.JButton jbFinalizarVenda;
    private javax.swing.JButton jbLimparVenda;
    private javax.swing.JButton jbMaisMercadoria;
    private javax.swing.JButton jbMenosMercadoria;
    private javax.swing.JButton jbPesquisarMercadoria;
    private javax.swing.JButton jbRemoverMercadoriaTabela;
    private javax.swing.JComboBox<String> jcbFormaPagamento;
    private javax.swing.JComboBox<String> jcbFuncionario;
    private javax.swing.JComboBox<String> jcbQuantidadeParcelas;
    private javax.swing.JComboBox<String> jcbTipoDesconto;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtMercadoria;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMercadoria;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidadeParcelas;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorFinal;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMercadoria;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValor;
    private javax.swing.JTextField txtValorFinal;
    // End of variables declaration//GEN-END:variables
}
