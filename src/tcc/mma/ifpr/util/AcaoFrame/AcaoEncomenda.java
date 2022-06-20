/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.AcaoFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Cliente;
import tcc.mma.ifpr.bean.Encomenda;
import tcc.mma.ifpr.bean.Funcionario;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.bean.MercadoriaEncomenda;
import tcc.mma.ifpr.dao.ClienteDAO;
import tcc.mma.ifpr.dao.EncomendaDAO;
import tcc.mma.ifpr.dao.FuncionarioDAO;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.dao.MercadoriaEncomendaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.Main;
import tcc.mma.ifpr.util.TableModel.TableModelCliente;
import tcc.mma.ifpr.util.TableModel.TableModelMercadoriaEncomenda;

/**
 *
 * @author nnath
 */
public class AcaoEncomenda extends javax.swing.JInternalFrame {

    public AcaoEncomenda() {
        initComponents();
        pegarFun();
        pegarData();
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

    public void pegarData() {
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jftDataEncomenda.setText(formato.format(data));

    }

    public void prepararMerc(int id) {
        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaEncomendaDAO daoMercadoria = new MercadoriaEncomendaDAO(con);

            MercadoriaEncomenda mercadoria = daoMercadoria.retrieve(id);

            txtMercadoria.setText(mercadoria.getDescricao());
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

        TableModelMercadoriaEncomenda tbMercadoria = (TableModelMercadoriaEncomenda) jtMercadoria.getModel();

        for (int i = tamanhoTabela - 1; i >= 0; i--) {
            MercadoriaEncomenda mercadoriaEncomenda = tbMercadoria.getMercadoria(i);

            if (i != 0) {
                mercadoria[i] = mercadoriaEncomenda.getId() + ", ";
            } else {
                mercadoria[i] = mercadoriaEncomenda.getId() + ".";
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

        TableModelMercadoriaEncomenda tbMercadoria = (TableModelMercadoriaEncomenda) jtMercadoria.getModel();

        for (int i = tamanhoTabela - 1; i >= 0; i--) {
            MercadoriaEncomenda mercadoriaEncomenda = tbMercadoria.getMercadoria(i);

            if (i != 0) {
                mercadoriaQuantidade[i] = mercadoriaEncomenda.getQuantidade() + ", ";
            } else {
                mercadoriaQuantidade[i] = mercadoriaEncomenda.getQuantidade() + ".";
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

    int idMercadoria = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        jbBuscarClienteNome = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jbBuscarClienteID = new javax.swing.JButton();
        jbAlterarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblDataRetirada = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblMercadoria = new javax.swing.JLabel();
        txtMercadoria = new javax.swing.JTextField();
        jbPesquisarMercadoria = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMercadoria = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jbMaisMercadoria = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jbAdicionarMercadoriTabela = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbMenosMercadoria = new javax.swing.JButton();
        jcbFuncionario = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jbFinalizarEncomenda = new javax.swing.JButton();
        jbLimparEncomenda = new javax.swing.JButton();
        jftDataEncomenda = new javax.swing.JFormattedTextField();
        jbRemoverMercadoriaTabela = new javax.swing.JButton();

        setClosable(true);
        setTitle("Encomenda");

        jbBuscarClienteNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarClienteNome.setText("Buscar");
        jbBuscarClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteNomeActionPerformed(evt);
            }
        });

        lblID.setText("ID:");

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

        jLabel4.setText("Quantidade:");

        lblDataRetirada.setText("Data da encomenda:");

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

        lblMercadoria.setText("Mercadoria:");

        txtMercadoria.setEditable(false);

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
                "ID", "Mercadoria", "Cor", "Tamanho", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
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

        jbMaisMercadoria.setText("+");
        jbMaisMercadoria.setEnabled(false);
        jbMaisMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMaisMercadoriaActionPerformed(evt);
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

        jLabel2.setText("Funcionário:");

        jbMenosMercadoria.setText("-");
        jbMenosMercadoria.setEnabled(false);
        jbMenosMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenosMercadoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Observação:");

        txtObservacao.setText("Sem Observações");
        txtObservacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtObservacaoMouseClicked(evt);
            }
        });

        lblNome.setText("Cliente:");

        jbFinalizarEncomenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/bdConect.png"))); // NOI18N
        jbFinalizarEncomenda.setText("Finalizar Encomenda");
        jbFinalizarEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarEncomendaActionPerformed(evt);
            }
        });

        jbLimparEncomenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/limpar.png"))); // NOI18N
        jbLimparEncomenda.setText("Limpar Encomenda");
        jbLimparEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparEncomendaActionPerformed(evt);
            }
        });

        jftDataEncomenda.setEditable(false);
        try {
            jftDataEncomenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMercadoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMercadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbPesquisarMercadoria)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
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
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
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
                            .addComponent(jSeparator4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataRetirada)
                                .addGap(18, 18, 18)
                                .addComponent(jftDataEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbFinalizarEncomenda)
                .addGap(18, 18, 18)
                .addComponent(jbLimparEncomenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMercadoria)
                    .addComponent(txtMercadoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisarMercadoria)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdicionarMercadoriTabela)
                    .addComponent(jbMaisMercadoria)
                    .addComponent(jbMenosMercadoria)
                    .addComponent(jbRemoverMercadoriaTabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataRetirada)
                    .addComponent(jftDataEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizarEncomenda)
                    .addComponent(jbLimparEncomenda))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyTyped

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

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped

        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void jbPesquisarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarMercadoriaActionPerformed

        AcaoAdicionarMercadoriaEncomenda mercadoriaAdd = new AcaoAdicionarMercadoriaEncomenda();

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

    private void jbMaisMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMaisMercadoriaActionPerformed

        int conta = Integer.parseInt(txtQuantidade.getText()) + 1;

        String quantidade = String.valueOf(conta);

        txtQuantidade.setText(quantidade);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbMaisMercadoriaActionPerformed

    private void jbAdicionarMercadoriTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarMercadoriTabelaActionPerformed

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaEncomendaDAO daoMercadoria = new MercadoriaEncomendaDAO(con);
            MercadoriaEncomenda mer = daoMercadoria.retrieve(idMercadoria);

            if (jtMercadoria.getRowCount() == 0) {
                TableModelMercadoriaEncomenda tableModelMercadoriaEncomenda = new TableModelMercadoriaEncomenda();
                jtMercadoria.setModel(tableModelMercadoriaEncomenda);

                MercadoriaEncomenda mercadorias = new MercadoriaEncomenda();
                mercadorias.setId(mer.getId());
                mercadorias.setDescricao(mer.getDescricao());
                mercadorias.setCor(mer.getCor());
                mercadorias.setTamanho(mer.getTamanho());
                mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

                tableModelMercadoriaEncomenda.addRow(mercadorias);

                txtMercadoria.setText(null);
                txtQuantidade.setText("");
                jbMaisMercadoria.setEnabled(false);
                jbMenosMercadoria.setEnabled(false);
                jbAdicionarMercadoriTabela.setEnabled(false);

            } else {
                TableModelMercadoriaEncomenda tableModelMercadoriaEncomenda = (TableModelMercadoriaEncomenda) jtMercadoria.getModel();
                jtMercadoria.setModel(tableModelMercadoriaEncomenda);

                MercadoriaEncomenda mercadorias = new MercadoriaEncomenda();
                mercadorias.setId(mer.getId());
                mercadorias.setDescricao(mer.getDescricao());
                mercadorias.setCor(mer.getCor());
                mercadorias.setTamanho(mer.getTamanho());
                mercadorias.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

                tableModelMercadoriaEncomenda.addRow(mercadorias);

                txtMercadoria.setText(null);
                txtQuantidade.setText("");
                jbMaisMercadoria.setEnabled(false);
                jbMenosMercadoria.setEnabled(false);
                jbAdicionarMercadoriTabela.setEnabled(false);

            }

        } catch (Exception e) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbAdicionarMercadoriTabelaActionPerformed

    private void jbMenosMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenosMercadoriaActionPerformed

        if (Integer.parseInt(txtQuantidade.getText()) <= 1) {
            JOptionPane.showMessageDialog(null, "A quantidade não pode ser inferior a 1ª unidade", "Atenção", NORMAL);
            txtQuantidade.setText("1");
        } else {

            int conta = Integer.parseInt(txtQuantidade.getText()) - 1;

            String quantidade = String.valueOf(conta);

            txtQuantidade.setText(quantidade);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbMenosMercadoriaActionPerformed

    private void txtObservacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtObservacaoMouseClicked

        txtObservacao.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacaoMouseClicked

    private void jbFinalizarEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarEncomendaActionPerformed
        if (jtMercadoria.getRowCount() == 0
                || jftDataEncomenda.getText().isEmpty()
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

                String quantidades = fazerVetorQuantidade();

                String observacao = txtObservacao.getText();

                int status = 1;

                EncomendaDAO daoEncomenda = new EncomendaDAO(con);
                Encomenda encomenda = new Encomenda(1, data, funcionario, cliente, mercadorias, quantidades, observacao, status);
                daoEncomenda.create(encomenda);

                JOptionPane.showMessageDialog(null, "Encomenda cadastrada com sucesso!");

                controlarEstoque(mercadorias, quantidades);

                AcaoEncomenda vendaa = new AcaoEncomenda();

                getParent().add(vendaa);
                vendaa.setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {

                AcaoVenda venda = new AcaoVenda();

                getParent().add(venda);
                venda.setVisible(true);
                this.setVisible(false);

                JOptionPane.showMessageDialog(null, "A venda não foi realizada com sucesso!", "Atenção", NORMAL);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbFinalizarEncomendaActionPerformed

    private void jbLimparEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparEncomendaActionPerformed

        AcaoEncomenda encomenda = new AcaoEncomenda();

        getParent().add(encomenda);
        encomenda.setVisible(true);
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparEncomendaActionPerformed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        if (Integer.parseInt(txtQuantidade.getText()) == 0) {
            txtQuantidade.setText("1");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void jbRemoverMercadoriaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverMercadoriaTabelaActionPerformed
        int linhaSelecionada = jtMercadoria.getSelectedRow();
        if (JOptionPane.showConfirmDialog(null, "Você realmente deseja retirar a mercadoria da tabela? ", "Atenção!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            if (linhaSelecionada != -1) {
                TableModelMercadoriaEncomenda model = (TableModelMercadoriaEncomenda) jtMercadoria.getModel();

                MercadoriaEncomenda mercadorias = model.getMercadoria(linhaSelecionada);

                model.removeLinha(linhaSelecionada);

            }

            jbRemoverMercadoriaTabela.setEnabled(false);
        } else {
            jbRemoverMercadoriaTabela.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbRemoverMercadoriaTabelaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbAdicionarMercadoriTabela;
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbBuscarClienteID;
    private javax.swing.JButton jbBuscarClienteNome;
    private javax.swing.JButton jbFinalizarEncomenda;
    private javax.swing.JButton jbLimparEncomenda;
    private javax.swing.JButton jbMaisMercadoria;
    private javax.swing.JButton jbMenosMercadoria;
    private javax.swing.JButton jbPesquisarMercadoria;
    private javax.swing.JButton jbRemoverMercadoriaTabela;
    private javax.swing.JComboBox<String> jcbFuncionario;
    private javax.swing.JFormattedTextField jftDataEncomenda;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtMercadoria;
    private javax.swing.JLabel lblDataRetirada;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMercadoria;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMercadoria;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
