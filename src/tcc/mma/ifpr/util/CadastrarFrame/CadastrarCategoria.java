/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.CadastrarFrame;

import static java.awt.Frame.NORMAL;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import tcc.mma.ifpr.bean.Categoria;
import tcc.mma.ifpr.dao.CategoriaDAO;
import tcc.mma.ifpr.util.EditarFrame.EditarCategoria;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirCategoria;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCategoriaFull;
import tcc.mma.ifpr.util.Validar.Texto;

/**
 *
 * @author nnath
 */
public class CadastrarCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastrarCategoria
     */
    public CadastrarCategoria() {
        initComponents();

    }

    public void pegarTabela() {

        if (jcLimite.isSelected()) {

            if (txtCategoria.getText().isEmpty() || txtCategoria.getText().equals(null)) {

                try {

                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                    CategoriaDAO daoCategoria = new CategoriaDAO(con);
                    List<Categoria> cat = daoCategoria.retrieveAllFull();

                    TableModelCategoriaFull tableModelCategoria = new TableModelCategoriaFull();

                    jtCategoria.setModel(tableModelCategoria);

                    for (int i = 0; i < cat.size(); i++) {

                        Categoria categorias = new Categoria();

                        categorias.setId(cat.get(i).getId());
                        categorias.setCategoria(cat.get(i).getCategoria());
                        categorias.setStatus(cat.get(i).getStatus());
                        tableModelCategoria.addRow(categorias);

                    }

                } catch (Exception e) {
                }

            }

        } else {

            if (txtCategoria.getText().isEmpty() || txtCategoria.getText().equals(null)) {

                try {

                    Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                    CategoriaDAO daoCategoria = new CategoriaDAO(con);
                    List<Categoria> cat = daoCategoria.retrieveAll();

                    TableModelCategoriaFull tableModelCategoria = new TableModelCategoriaFull();

                    jtCategoria.setModel(tableModelCategoria);

                    for (int i = 0; i < cat.size(); i++) {

                        Categoria categorias = new Categoria();

                        categorias.setId(cat.get(i).getId());
                        categorias.setCategoria(cat.get(i).getCategoria());
                        categorias.setStatus(cat.get(i).getStatus());
                        tableModelCategoria.addRow(categorias);

                    }

                } catch (Exception e) {
                }

            }

        }
    }

    public void pegarId() {

        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            CategoriaDAO daoCategoria = new CategoriaDAO(con);
            Categoria categoria = daoCategoria.takeLastId();
            txtID.setText(String.valueOf(categoria.getId() + 1));

        } catch (Exception e) {
            txtID.setText("1");
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

        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbBuscarCategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();
        lblId1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCategoria1 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jcLimite = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Cadastrar Categoria");
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

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
            }
        });

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Status"
            }
        ));
        jtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCategoria);

        lblId1.setText("ID:");

        txtID.setEditable(false);

        lblCategoria1.setText("Categoria:");

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyPressed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcLimite))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblId1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCategoria1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscarCategoria)
                                .addGap(0, 302, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastrar)
                .addGap(18, 18, 18)
                .addComponent(jbEditar)
                .addGap(18, 18, 18)
                .addComponent(jbExcluir)
                .addGap(18, 18, 18)
                .addComponent(jbLimpar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbEditar, jbExcluir, jbLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria1)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarCategoria)
                    .addComponent(lblId1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents


    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        Texto texto = new Texto();
        String retorno = texto.textoConverter(txtCategoria.getText());
        txtCategoria.setText(retorno);

        if (txtCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro, preencha a categoria ",
                    "Atenção", NORMAL);
        } else {

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CategoriaDAO daoCategoria = new CategoriaDAO(con);
                Categoria categoria = new Categoria(1, txtCategoria.getText(), 1);
                daoCategoria.create(categoria);

                JOptionPane.showMessageDialog(null, "Categoria: '" + txtCategoria.getText() + "' cadastrada com sucesso!");
                pegarId();
                txtCategoria.setText(null);
                jbCadastrar.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

                pegarTabela();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a categoria ",
                        "Atenção", NORMAL);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCategoriaActionPerformed

        String categoria = txtCategoria.getText();

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            CategoriaDAO daoCategoria = new CategoriaDAO(con);
            List<Categoria> cat = daoCategoria.retrieveNome(categoria);

            TableModelCategoriaFull tableModelCategoria = new TableModelCategoriaFull();

            jtCategoria.setModel(tableModelCategoria);

            for (int i = 0; i < cat.size(); i++) {

                Categoria categorias = new Categoria();

                categorias.setId(cat.get(i).getId());
                categorias.setCategoria(cat.get(i).getCategoria());
                categorias.setStatus(cat.get(i).getStatus());
                tableModelCategoria.addRow(categorias);
                pegarTabela();
            }

        } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarCategoriaActionPerformed

    private void jtCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriaMouseClicked

        int linhaSelecionada = jtCategoria.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelCategoriaFull tbCategoria = (TableModelCategoriaFull) jtCategoria.getModel();
            Categoria categoria = tbCategoria.getCategoria(jtCategoria.getSelectedRow());

            txtID.setText(String.valueOf(categoria.getId()));
            txtCategoria.setText(categoria.getCategoria());

            jbCadastrar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtCategoriaMouseClicked

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        pegarTabela();
        pegarId();

        txtCategoria.setText(null);

        jbCadastrar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        EditarCategoria categoria = new EditarCategoria();
        getParent().add(categoria);
        categoria.setVisible(true);
        getParent().remove(1);

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

        ExcluirCategoria categoria = new ExcluirCategoria();
        getParent().add(categoria);
        categoria.setVisible(true);
        getParent().remove(1);

// TODO add your handling code here:
    }//GEN-LAST:event_jbExcluirActionPerformed

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

        pegarId();

        pegarTabela();

        txtCategoria.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained

        txtCategoria.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCategoria.doClick();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JLabel lblCategoria1;
    private javax.swing.JLabel lblId1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
