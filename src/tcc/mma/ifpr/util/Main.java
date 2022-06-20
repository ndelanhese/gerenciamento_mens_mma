/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JOptionPane;

import javax.swing.Timer;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.dao.MercadoriaDAO;

import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCliente;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCategoria;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFornecedor;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarFuncionario;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMercadoria;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarUsuario;
import tcc.mma.ifpr.util.AcaoFrame.AcaoEncomenda;

import tcc.mma.ifpr.util.EditarFrame.EditarCategoria;
import tcc.mma.ifpr.util.EditarFrame.EditarCliente;
import tcc.mma.ifpr.util.EditarFrame.EditarFornecedor;
import tcc.mma.ifpr.util.EditarFrame.EditarFuncionario;
import tcc.mma.ifpr.util.EditarFrame.EditarMercadoria;
import tcc.mma.ifpr.util.EditarFrame.EditarUsuario;

import tcc.mma.ifpr.util.ExcluirFrame.ExcluirCategoria;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirCliente;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirFornecedor;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirFuncionario;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirMercadoria;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirUsuario;

import tcc.mma.ifpr.util.RelatarFrame.RelatorioVendasDoDia;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioVendasPorData;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioVendas;

import tcc.mma.ifpr.util.AcaoFrame.AcaoVenda;
import tcc.mma.ifpr.util.AcaoFrame.AcaoCondicional;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCidade;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMarca;
import tcc.mma.ifpr.util.ControlarEstoque.ControlarEstoqueNotificacao;
import tcc.mma.ifpr.util.EditarFrame.EditarCidade;
import tcc.mma.ifpr.util.EditarFrame.EditarMarca;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirCidade;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirMarca;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioCondicional;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioCondicionalPorCliente;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioEncomendas;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioEncomendasPorCliente;
import tcc.mma.ifpr.util.RelatarFrame.RelatorioVendasPorCliente;

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form index
     */
    public Main() {

        URL url = this.getClass().getResource("user.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPainel = new javax.swing.JPanel();
        lbluser = new javax.swing.JLabel();
        lblOla = new javax.swing.JLabel();
        jbSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jdAreaTrabalho = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lbldata = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lblcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbVenda = new javax.swing.JButton();
        jbCondicional = new javax.swing.JButton();
        jbEncomenda = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbVenda1 = new javax.swing.JButton();
        jbVenda2 = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jmCadastrar = new javax.swing.JMenu();
        jmCadastrarCliente = new javax.swing.JMenuItem();
        jmCadastrarMercadoria = new javax.swing.JMenuItem();
        jmCadastrarFornecedor = new javax.swing.JMenuItem();
        jmCadastrarCategoria = new javax.swing.JMenuItem();
        jmCadastrarMarca = new javax.swing.JMenuItem();
        jmCadastrarFuncionario = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmCadastrarUsuario = new javax.swing.JMenuItem();
        jmEditar = new javax.swing.JMenu();
        jmEditarCliente = new javax.swing.JMenuItem();
        jmEditarMercadoria = new javax.swing.JMenuItem();
        jmEditarFornecedor = new javax.swing.JMenuItem();
        jmEditarCategoria = new javax.swing.JMenuItem();
        jmEditarMarca = new javax.swing.JMenuItem();
        jmEditarFuncionario = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmEditarUsuario = new javax.swing.JMenuItem();
        jmExcluir = new javax.swing.JMenu();
        jmExcluirCliente = new javax.swing.JMenuItem();
        jmExcluirMercadoria = new javax.swing.JMenuItem();
        jmExcluirFornecedor = new javax.swing.JMenuItem();
        jmExcluirCategoria = new javax.swing.JMenuItem();
        jmExcluirMarca = new javax.swing.JMenuItem();
        jmExcluirFuncionario = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmExcluirUsuario = new javax.swing.JMenuItem();
        jmRelatorio = new javax.swing.JMenu();
        jmRelatorioVendas = new javax.swing.JMenuItem();
        jmRelatorioMaisVendidoDia = new javax.swing.JMenuItem();
        jmRelatorioMaisVendidoMes = new javax.swing.JMenuItem();
        jmReltatorioVendasCliente = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmRelatorioEncomendas = new javax.swing.JMenuItem();
        jmRelatorioEncomendasCliente = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmRelatorioCondicional = new javax.swing.JMenuItem();
        jmRelatorioCondicionalCliente = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MMA MODAS");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbluser.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbluser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblOla.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblOla.setText("Olá:");

        jbSair.setText("Sair");
        jbSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbSairMouseExited(evt);
            }
        });
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPainelLayout = new javax.swing.GroupLayout(jpPainel);
        jpPainel.setLayout(jpPainelLayout);
        jpPainelLayout.setHorizontalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addGroup(jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jbSair))
                    .addGroup(jpPainelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblOla)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPainelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpPainelLayout.setVerticalGroup(
            jpPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPainelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblOla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdAreaTrabalhoLayout = new javax.swing.GroupLayout(jdAreaTrabalho);
        jdAreaTrabalho.setLayout(jdAreaTrabalhoLayout);
        jdAreaTrabalhoLayout.setHorizontalGroup(
            jdAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );
        jdAreaTrabalhoLayout.setVerticalGroup(
            jdAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setEnabled(false);

        lbldata.setFont(new java.awt.Font("sansserif", 1, 45)); // NOI18N
        lbldata.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldata.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbldata.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblhora.setFont(new java.awt.Font("sansserif", 1, 45)); // NOI18N
        lblhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblhora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblcon.setForeground(new java.awt.Color(0, 153, 51));
        lblcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/bd.png"))); // NOI18N
        lblcon.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldata, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbldata, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblhora, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcon, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbVenda.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jbVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/venda.png"))); // NOI18N
        jbVenda.setText("Venda");
        jbVenda.setToolTipText("");
        jbVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVendaActionPerformed(evt);
            }
        });

        jbCondicional.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jbCondicional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/condicional.png"))); // NOI18N
        jbCondicional.setText("Condicional");
        jbCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCondicionalActionPerformed(evt);
            }
        });

        jbEncomenda.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jbEncomenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/encomenda.png"))); // NOI18N
        jbEncomenda.setText("Encomenda");
        jbEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEncomendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCondicional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEncomenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbVenda)
                .addGap(18, 18, 18)
                .addComponent(jbCondicional)
                .addGap(18, 18, 18)
                .addComponent(jbEncomenda)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/logo-mma.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jbVenda1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jbVenda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/notinha.png (2).png"))); // NOI18N
        jbVenda1.setText("Fichário");
        jbVenda1.setToolTipText("");
        jbVenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenda1ActionPerformed(evt);
            }
        });

        jbVenda2.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jbVenda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/mais.png"))); // NOI18N
        jbVenda2.setText("Mercadoria");
        jbVenda2.setToolTipText("");
        jbVenda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenda2ActionPerformed(evt);
            }
        });

        jMenu.setBackground(java.awt.Color.lightGray);
        jMenu.setPreferredSize(new java.awt.Dimension(180, 23));

        jmCadastrar.setText("Cadastrar");

        jmCadastrarCliente.setText("Cliente");
        jmCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarClienteActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarCliente);

        jmCadastrarMercadoria.setText("Mercadoria");
        jmCadastrarMercadoria.setEnabled(false);
        jmCadastrarMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarMercadoriaActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarMercadoria);

        jmCadastrarFornecedor.setText("Fornecedor");
        jmCadastrarFornecedor.setEnabled(false);
        jmCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarFornecedorActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarFornecedor);

        jmCadastrarCategoria.setText("Categoria");
        jmCadastrarCategoria.setEnabled(false);
        jmCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarCategoriaActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarCategoria);

        jmCadastrarMarca.setText("Marca");
        jmCadastrarMarca.setEnabled(false);
        jmCadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarMarcaActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarMarca);

        jmCadastrarFuncionario.setText("Funcionário");
        jmCadastrarFuncionario.setEnabled(false);
        jmCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarFuncionarioActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarFuncionario);

        jMenuItem6.setText("Cidade");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmCadastrar.add(jMenuItem6);

        jmCadastrarUsuario.setText("Usuário");
        jmCadastrarUsuario.setEnabled(false);
        jmCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarUsuarioActionPerformed(evt);
            }
        });
        jmCadastrar.add(jmCadastrarUsuario);

        jMenu.add(jmCadastrar);

        jmEditar.setText("Editar");

        jmEditarCliente.setText("Cliente");
        jmEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarClienteActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarCliente);

        jmEditarMercadoria.setText("Mercadoria");
        jmEditarMercadoria.setEnabled(false);
        jmEditarMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarMercadoriaActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarMercadoria);

        jmEditarFornecedor.setText("Fornecedor");
        jmEditarFornecedor.setEnabled(false);
        jmEditarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarFornecedorActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarFornecedor);

        jmEditarCategoria.setText("Categoria");
        jmEditarCategoria.setEnabled(false);
        jmEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarCategoriaActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarCategoria);

        jmEditarMarca.setText("Marca");
        jmEditarMarca.setEnabled(false);
        jmEditarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarMarcaActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarMarca);

        jmEditarFuncionario.setText("Funcionário");
        jmEditarFuncionario.setEnabled(false);
        jmEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarFuncionarioActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarFuncionario);

        jMenuItem7.setText("Cidade");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmEditar.add(jMenuItem7);

        jmEditarUsuario.setText("Usuário");
        jmEditarUsuario.setEnabled(false);
        jmEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarUsuarioActionPerformed(evt);
            }
        });
        jmEditar.add(jmEditarUsuario);

        jMenu.add(jmEditar);

        jmExcluir.setText("Excluir");
        jmExcluir.setEnabled(false);

        jmExcluirCliente.setText("Cliente");
        jmExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirClienteActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirCliente);

        jmExcluirMercadoria.setText("Mercadoria");
        jmExcluirMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirMercadoriaActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirMercadoria);

        jmExcluirFornecedor.setText("Fornecedor");
        jmExcluirFornecedor.setEnabled(false);
        jmExcluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirFornecedorActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirFornecedor);

        jmExcluirCategoria.setText("Categoria");
        jmExcluirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirCategoriaActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirCategoria);

        jmExcluirMarca.setText("Marca");
        jmExcluirMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirMarcaActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirMarca);

        jmExcluirFuncionario.setText("Funcionário");
        jmExcluirFuncionario.setEnabled(false);
        jmExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirFuncionarioActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirFuncionario);

        jMenuItem8.setText("Cidade");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmExcluir.add(jMenuItem8);

        jmExcluirUsuario.setText("Usuário");
        jmExcluirUsuario.setEnabled(false);
        jmExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExcluirUsuarioActionPerformed(evt);
            }
        });
        jmExcluir.add(jmExcluirUsuario);

        jMenu.add(jmExcluir);

        jmRelatorio.setText("Relatório");
        jmRelatorio.setEnabled(false);

        jmRelatorioVendas.setText("Vendas");
        jmRelatorioVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioVendasActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioVendas);

        jmRelatorioMaisVendidoDia.setText("Vendas do Dia");
        jmRelatorioMaisVendidoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioMaisVendidoDiaActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioMaisVendidoDia);

        jmRelatorioMaisVendidoMes.setText("Vendas por Data");
        jmRelatorioMaisVendidoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioMaisVendidoMesActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioMaisVendidoMes);

        jmReltatorioVendasCliente.setText("Vendas por Cliente");
        jmReltatorioVendasCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReltatorioVendasClienteActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmReltatorioVendasCliente);
        jmRelatorio.add(jSeparator2);

        jmRelatorioEncomendas.setText("Encomendas");
        jmRelatorioEncomendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioEncomendasActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioEncomendas);

        jmRelatorioEncomendasCliente.setText("Encomendas por Cliente");
        jmRelatorioEncomendasCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioEncomendasClienteActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioEncomendasCliente);
        jmRelatorio.add(jSeparator3);

        jmRelatorioCondicional.setText("Condicionais");
        jmRelatorioCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioCondicionalActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioCondicional);

        jmRelatorioCondicionalCliente.setText("Condicionais por Cliente");
        jmRelatorioCondicionalCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRelatorioCondicionalClienteActionPerformed(evt);
            }
        });
        jmRelatorio.add(jmRelatorioCondicionalCliente);
        jmRelatorio.add(jSeparator4);

        jMenuItem1.setText("Produtos com Estoque Baixo");
        jmRelatorio.add(jMenuItem1);

        jMenuItem2.setText("Produtos com Muito Estoque");
        jmRelatorio.add(jMenuItem2);
        jmRelatorio.add(jSeparator5);

        jMenuItem3.setText("Itens Mais Vendidos");
        jmRelatorio.add(jMenuItem3);

        jMenuItem4.setText("Itens Mais Vendidos por dia");
        jmRelatorio.add(jMenuItem4);

        jMenuItem5.setText("Itens Mais Vendidos por Data");
        jmRelatorio.add(jMenuItem5);
        jmRelatorio.add(jSeparator6);

        jMenuItem9.setText("Financeiro");
        jmRelatorio.add(jMenuItem9);

        jMenu.add(jmRelatorio);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdAreaTrabalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbVenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbVenda1)
                        .addGap(18, 18, 18)
                        .addComponent(jbVenda2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jdAreaTrabalho)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int tipoUsuario = 2;

//    private int bd() {
//        
//        int a = 0;
//        try {
//new Thread().sleep(5000);
//            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
//
//            a = FabricaDeConexoes.conec();
//
//        } catch (Exception e) {
//
//            a = 0;
//        }
//        return a;
//    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        

        this.setExtendedState(MAXIMIZED_BOTH);

        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lbldata.setText(formato.format(data));

        Timer timer = new Timer(1000, new hora());
        timer.start();

        if (verificaUser() != 0) {
            lbluser.setForeground(Color.red);

            jmCadastrarFornecedor.setEnabled(true);
            jmCadastrarFuncionario.setEnabled(true);
            jmCadastrarUsuario.setEnabled(true);
            jmCadastrarMercadoria.setEnabled(true);
            jmCadastrarCategoria.setEnabled(true);
            jmCadastrarMarca.setEnabled(true);

            jmEditarFornecedor.setEnabled(true);
            jmEditarFuncionario.setEnabled(true);
            jmEditarUsuario.setEnabled(true);
            jmEditarMercadoria.setEnabled(true);
            jmEditarMarca.setEnabled(true);
            jmEditarCategoria.setEnabled(true);

            //mercadoria, categoria e marca
            jmExcluir.setEnabled(true);
            jmExcluirFornecedor.setEnabled(true);
            jmExcluirFuncionario.setEnabled(true);
            jmExcluirUsuario.setEnabled(true);

            jmRelatorio.setEnabled(true);
        }

        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    public void controlarEstoque() {
        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
            List<Mercadoria> mer = daoMercadoria.retrieveAll1Full();

            ArrayList<Integer> lista = new ArrayList<>();
            for (int i = 0; i < mer.size(); i++) {

                if (mer.get(i).getQuantide() <= 2 && mer.get(i).getStatus() != 3) {

                    lista.add(mer.get(i).getId());

                }
            }

            if (!lista.isEmpty()) {
                jdAreaTrabalho.removeAll();
                ControlarEstoqueNotificacao controlar = new ControlarEstoqueNotificacao();
                jdAreaTrabalho.add(controlar);
                controlar.setVisible(true);
                controlar.setLocation(150, 100);
            }

        } catch (Exception e) {
        }
    }

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed

        LoginMma loginmma = new LoginMma();
        setVisible(false);
        loginmma.setVisible(true);

    }//GEN-LAST:event_jbSairActionPerformed

    private void jmCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarClienteActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarCliente cliente = new CadastrarCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        cliente.setSize(a, b);
        jdAreaTrabalho.add(cliente);
        cliente.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarClienteActionPerformed

    private void jmCadastrarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarMercadoriaActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarMercadoria mercadoria = new CadastrarMercadoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        mercadoria.setSize(a, b);
        jdAreaTrabalho.add(mercadoria);
        mercadoria.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarMercadoriaActionPerformed

    private void jmCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarFornecedorActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarFornecedor fornecedor = new CadastrarFornecedor();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        fornecedor.setSize(a, b);
        jdAreaTrabalho.add(fornecedor);
        fornecedor.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarFornecedorActionPerformed

    private void jmCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarCategoriaActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarCategoria categoria = new CadastrarCategoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        categoria.setSize(a, b);
        jdAreaTrabalho.add(categoria);
        categoria.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarCategoriaActionPerformed

    private void jmCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarFuncionarioActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarFuncionario funcionario = new CadastrarFuncionario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        funcionario.setSize(a, b);
        jdAreaTrabalho.add(funcionario);
        funcionario.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarFuncionarioActionPerformed

    private void jmCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarUsuarioActionPerformed
        jdAreaTrabalho.removeAll();
        CadastrarUsuario usuario = new CadastrarUsuario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        usuario.setSize(a, b);
        jdAreaTrabalho.add(usuario);
        usuario.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarUsuarioActionPerformed

    private void jmEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarClienteActionPerformed
        jdAreaTrabalho.removeAll();
        EditarCliente cliente = new EditarCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        cliente.setSize(a, b);
        jdAreaTrabalho.add(cliente);
        cliente.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarClienteActionPerformed

    private void jmExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirClienteActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirCliente cliente = new ExcluirCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        cliente.setSize(a, b);
        jdAreaTrabalho.add(cliente);
        cliente.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirClienteActionPerformed

    private void jmEditarMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarMercadoriaActionPerformed
        jdAreaTrabalho.removeAll();
        EditarMercadoria mercadoria = new EditarMercadoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        mercadoria.setSize(a, b);
        jdAreaTrabalho.add(mercadoria);
        mercadoria.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarMercadoriaActionPerformed

    private void jmExcluirMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirMercadoriaActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirMercadoria mercadoria = new ExcluirMercadoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        mercadoria.setSize(a, b);
        jdAreaTrabalho.add(mercadoria);
        mercadoria.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirMercadoriaActionPerformed

    private void jmEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarFornecedorActionPerformed
        jdAreaTrabalho.removeAll();
        EditarFornecedor fornecedor = new EditarFornecedor();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        fornecedor.setSize(a, b);
        jdAreaTrabalho.add(fornecedor);
        fornecedor.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarFornecedorActionPerformed

    private void jmExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirFornecedorActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirFornecedor fornecedor = new ExcluirFornecedor();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        fornecedor.setSize(a, b);
        jdAreaTrabalho.add(fornecedor);
        fornecedor.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirFornecedorActionPerformed

    private void jmEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarCategoriaActionPerformed
        jdAreaTrabalho.removeAll();
        EditarCategoria categoria = new EditarCategoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        categoria.setSize(a, b);
        jdAreaTrabalho.add(categoria);
        categoria.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarCategoriaActionPerformed

    private void jmEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarFuncionarioActionPerformed
        jdAreaTrabalho.removeAll();
        EditarFuncionario funcionario = new EditarFuncionario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        funcionario.setSize(a, b);
        jdAreaTrabalho.add(funcionario);
        funcionario.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarFuncionarioActionPerformed

    private void jmEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarUsuarioActionPerformed
        jdAreaTrabalho.removeAll();
        EditarUsuario usuario = new EditarUsuario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        usuario.setSize(a, b);
        jdAreaTrabalho.add(usuario);
        usuario.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarUsuarioActionPerformed

    private void jmExcluirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirCategoriaActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirCategoria categoria = new ExcluirCategoria();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        categoria.setSize(a, b);
        jdAreaTrabalho.add(categoria);
        categoria.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirCategoriaActionPerformed

    private void jmExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirFuncionarioActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirFuncionario funcionario = new ExcluirFuncionario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        funcionario.setSize(a, b);
        jdAreaTrabalho.add(funcionario);
        funcionario.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirFuncionarioActionPerformed

    private void jmExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirUsuarioActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirUsuario usuario = new ExcluirUsuario();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        usuario.setSize(a, b);
        jdAreaTrabalho.add(usuario);
        usuario.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirUsuarioActionPerformed

    private void jmRelatorioVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioVendasActionPerformed
        jdAreaTrabalho.removeAll();
        RelatorioVendas vendas = new RelatorioVendas();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        vendas.setSize(a, b);
        jdAreaTrabalho.add(vendas);
        vendas.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioVendasActionPerformed

    private void jmRelatorioMaisVendidoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioMaisVendidoDiaActionPerformed
        jdAreaTrabalho.removeAll();
        RelatorioVendasDoDia maisVendidoDia = new RelatorioVendasDoDia();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        maisVendidoDia.setSize(a, b);
        jdAreaTrabalho.add(maisVendidoDia);
        maisVendidoDia.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioMaisVendidoDiaActionPerformed

    private void jmRelatorioMaisVendidoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioMaisVendidoMesActionPerformed
        jdAreaTrabalho.removeAll();
        RelatorioVendasPorData maisVendidoMes = new RelatorioVendasPorData();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        maisVendidoMes.setSize(a, b);
        jdAreaTrabalho.add(maisVendidoMes);
        maisVendidoMes.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioMaisVendidoMesActionPerformed

    private void jbSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSairMouseEntered

        jbSair.setBackground(Color.red);
        jbSair.setForeground(Color.black);

// TODO add your handling code here:
    }//GEN-LAST:event_jbSairMouseEntered

    private void jbSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSairMouseExited

        jbSair.setBackground(Color.LIGHT_GRAY);
        jbSair.setForeground(Color.black);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbSairMouseExited

    private void jbVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVendaActionPerformed
        jdAreaTrabalho.removeAll();
        AcaoVenda venda = new AcaoVenda();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        venda.setSize(a, b);
        jdAreaTrabalho.add(venda);
        venda.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jbVendaActionPerformed

    private void jbCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCondicionalActionPerformed

        jdAreaTrabalho.removeAll();
        AcaoCondicional condicional = new AcaoCondicional();

        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        condicional.setSize(a, b);

        jdAreaTrabalho.add(condicional);
        condicional.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCondicionalActionPerformed

    private void jbEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEncomendaActionPerformed

        jdAreaTrabalho.removeAll();
        AcaoEncomenda encomenda = new AcaoEncomenda();

        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        encomenda.setSize(a, b);

        jdAreaTrabalho.add(encomenda);
        encomenda.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jbEncomendaActionPerformed

    private void jmCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarMarcaActionPerformed

        jdAreaTrabalho.removeAll();
        CadastrarMarca marca = new CadastrarMarca();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        marca.setSize(a, b);
        jdAreaTrabalho.add(marca);
        marca.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jmCadastrarMarcaActionPerformed

    private void jmEditarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarMarcaActionPerformed

        jdAreaTrabalho.removeAll();
        EditarMarca marca = new EditarMarca();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        marca.setSize(a, b);
        jdAreaTrabalho.add(marca);
        marca.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmEditarMarcaActionPerformed

    private void jmExcluirMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExcluirMarcaActionPerformed

        jdAreaTrabalho.removeAll();
        ExcluirMarca marca = new ExcluirMarca();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        marca.setSize(a, b);
        jdAreaTrabalho.add(marca);
        marca.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmExcluirMarcaActionPerformed

    private void jmRelatorioEncomendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioEncomendasActionPerformed

        jdAreaTrabalho.removeAll();
        RelatorioEncomendas relatorioEncomendas = new RelatorioEncomendas();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        relatorioEncomendas.setSize(a, b);
        jdAreaTrabalho.add(relatorioEncomendas);
        relatorioEncomendas.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioEncomendasActionPerformed

    private void jmRelatorioEncomendasClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioEncomendasClienteActionPerformed

        jdAreaTrabalho.removeAll();
        RelatorioEncomendasPorCliente relatorioEncomendas = new RelatorioEncomendasPorCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();

        relatorioEncomendas.setSize(a, b);
        jdAreaTrabalho.add(relatorioEncomendas);
        relatorioEncomendas.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioEncomendasClienteActionPerformed

    private void jmReltatorioVendasClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReltatorioVendasClienteActionPerformed
        jdAreaTrabalho.removeAll();
        RelatorioVendasPorCliente relatorioVendas = new RelatorioVendasPorCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        relatorioVendas.setSize(a, b);
        jdAreaTrabalho.add(relatorioVendas);
        relatorioVendas.setVisible(true);
    }//GEN-LAST:event_jmReltatorioVendasClienteActionPerformed

    private void jmRelatorioCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioCondicionalActionPerformed
        jdAreaTrabalho.removeAll();
        RelatorioCondicional relatorioCondicional = new RelatorioCondicional();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        relatorioCondicional.setSize(a, b);
        jdAreaTrabalho.add(relatorioCondicional);
        relatorioCondicional.setVisible(true);
    }//GEN-LAST:event_jmRelatorioCondicionalActionPerformed

    private void jmRelatorioCondicionalClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRelatorioCondicionalClienteActionPerformed

        jdAreaTrabalho.removeAll();
        RelatorioCondicionalPorCliente relatorioCondicional = new RelatorioCondicionalPorCliente();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        relatorioCondicional.setSize(a, b);
        jdAreaTrabalho.add(relatorioCondicional);
        relatorioCondicional.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jmRelatorioCondicionalClienteActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        jdAreaTrabalho.removeAll();
        CadastrarCidade cidade = new CadastrarCidade();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        cidade.setSize(a, b);
        jdAreaTrabalho.add(cidade);
        cidade.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        jdAreaTrabalho.removeAll();
        EditarCidade cidade = new EditarCidade();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        cidade.setSize(a, b);
        jdAreaTrabalho.add(cidade);
        cidade.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jdAreaTrabalho.removeAll();
        ExcluirCidade cidade = new ExcluirCidade();
        int a = jdAreaTrabalho.getWidth();
        int b = jdAreaTrabalho.getHeight();
        cidade.setSize(a, b);
        jdAreaTrabalho.add(cidade);
        cidade.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jbVenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVenda1ActionPerformed

    private void jbVenda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenda2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVenda2ActionPerformed

    public int verificaUser() {

        if (tipoUsuario != 0) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JButton jbCondicional;
    private javax.swing.JButton jbEncomenda;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbVenda;
    private javax.swing.JButton jbVenda1;
    private javax.swing.JButton jbVenda2;
    public javax.swing.JDesktopPane jdAreaTrabalho;
    private javax.swing.JMenu jmCadastrar;
    private javax.swing.JMenuItem jmCadastrarCategoria;
    private javax.swing.JMenuItem jmCadastrarCliente;
    private javax.swing.JMenuItem jmCadastrarFornecedor;
    private javax.swing.JMenuItem jmCadastrarFuncionario;
    private javax.swing.JMenuItem jmCadastrarMarca;
    private javax.swing.JMenuItem jmCadastrarMercadoria;
    private javax.swing.JMenuItem jmCadastrarUsuario;
    private javax.swing.JMenu jmEditar;
    private javax.swing.JMenuItem jmEditarCategoria;
    private javax.swing.JMenuItem jmEditarCliente;
    private javax.swing.JMenuItem jmEditarFornecedor;
    private javax.swing.JMenuItem jmEditarFuncionario;
    private javax.swing.JMenuItem jmEditarMarca;
    private javax.swing.JMenuItem jmEditarMercadoria;
    private javax.swing.JMenuItem jmEditarUsuario;
    private javax.swing.JMenu jmExcluir;
    private javax.swing.JMenuItem jmExcluirCategoria;
    private javax.swing.JMenuItem jmExcluirCliente;
    private javax.swing.JMenuItem jmExcluirFornecedor;
    private javax.swing.JMenuItem jmExcluirFuncionario;
    private javax.swing.JMenuItem jmExcluirMarca;
    private javax.swing.JMenuItem jmExcluirMercadoria;
    private javax.swing.JMenuItem jmExcluirUsuario;
    private javax.swing.JMenu jmRelatorio;
    private javax.swing.JMenuItem jmRelatorioCondicional;
    private javax.swing.JMenuItem jmRelatorioCondicionalCliente;
    private javax.swing.JMenuItem jmRelatorioEncomendas;
    private javax.swing.JMenuItem jmRelatorioEncomendasCliente;
    private javax.swing.JMenuItem jmRelatorioMaisVendidoDia;
    private javax.swing.JMenuItem jmRelatorioMaisVendidoMes;
    private javax.swing.JMenuItem jmRelatorioVendas;
    private javax.swing.JMenuItem jmReltatorioVendasCliente;
    private javax.swing.JPanel jpPainel;
    private javax.swing.JLabel lblOla;
    public javax.swing.JLabel lblcon;
    public javax.swing.JLabel lbldata;
    public javax.swing.JLabel lblhora;
    public javax.swing.JLabel lbluser;
    // End of variables declaration//GEN-END:variables
 class hora implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            DateFormat df = new SimpleDateFormat("HH:mm:ss ");
            df.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));

            lblhora.setText(df.format(new Date()));
        }
    }
}
