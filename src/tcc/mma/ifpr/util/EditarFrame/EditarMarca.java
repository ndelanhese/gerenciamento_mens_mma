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
import tcc.mma.ifpr.bean.Marca;
import tcc.mma.ifpr.dao.MarcaDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarMarca;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirMarca;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelMarca;
import tcc.mma.ifpr.util.Validar.Texto;

/**
 *
 * @author nnath
 */
public class EditarMarca extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarMarca
     */
    public EditarMarca() {
        initComponents();

    }

    int a = 0;

    public void pegarTabela() {

        if (jcLimite.isSelected()) {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> marc = daoMarca.retrieveAllFull();

                TableModelMarca tableModelMarca = new TableModelMarca();

                jtMarca.setModel(tableModelMarca);

                for (int i = 0; i < marc.size(); i++) {

                    Marca marcas = new Marca();

                    marcas.setId(marc.get(i).getId());
                    marcas.setMarca(marc.get(i).getMarca());
                    marcas.setStatus(marc.get(i).getStatus());
                    tableModelMarca.addRow(marcas);

                }

            } catch (Exception e) {
            }

        } else {
            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> marc = daoMarca.retrieveAll();

                TableModelMarca tableModelMarca = new TableModelMarca();

                jtMarca.setModel(tableModelMarca);

                for (int i = 0; i < marc.size(); i++) {

                    Marca marcas = new Marca();

                    marcas.setId(marc.get(i).getId());
                    marcas.setMarca(marc.get(i).getMarca());
                    marcas.setStatus(marc.get(i).getStatus());
                    tableModelMarca.addRow(marcas);

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

        txtMarca = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jbBuscarCategoria = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMarca = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        jcLimite = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Editar Marca");
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

        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMarcaKeyPressed(evt);
            }
        });

        lblStatus.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
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

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/cadastrar.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar Novo");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jtMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Status"
            }
        ));
        jtMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMarcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMarca);

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

        lblId.setText("ID:");

        txtID.setEditable(false);

        lblCategoria.setText("Marca:");

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
                        .addGap(11, 11, 11)
                        .addComponent(lblId)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus)
                        .addGap(18, 18, 18)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcLimite))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbCadastrar, jbEditar, jbExcluir, jbLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
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

        if (txtMarca.getText().isEmpty()) {
            pegarTabela();
        } else {

            String marca = txtMarca.getText();

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                List<Marca> cat = daoMarca.retrieveNome(marca);

                TableModelMarca tableModelMarca = new TableModelMarca();

                jtMarca.setModel(tableModelMarca);

                for (int i = 0; i < cat.size(); i++) {

                    Marca categorias = new Marca();

                    categorias.setId(cat.get(i).getId());
                    categorias.setMarca(cat.get(i).getMarca());
                    categorias.setStatus(cat.get(i).getStatus());
                    tableModelMarca.addRow(categorias);

                }

            } catch (Exception e) {
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarCategoriaActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Texto texto = new Texto();
        String retorno = texto.textoConverter(txtMarca.getText());
        txtMarca.setText(retorno);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Erro, preencha a marca ",
                    "Atenção", NORMAL);
        } else {

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                MarcaDAO daoMarca = new MarcaDAO(con);
                Marca marca = new Marca(Integer.parseInt(txtID.getText()), txtMarca.getText(), jcbStatus.getSelectedIndex() + 1);
                daoMarca.update(marca);

                JOptionPane.showMessageDialog(null, "Marca: '" + txtMarca.getText() + "' atualizada com sucesso!");

                txtID.setText(null);
                txtMarca.setText(null);
                jcbStatus.setSelectedIndex(0);

                pegarTabela();
                jbCadastrar.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar a Marca ",
                        "Atenção", NORMAL);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        CadastrarMarca marca = new CadastrarMarca();
        getParent().add(marca);
        marca.setVisible(true);
        getParent().remove(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jtMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMarcaMouseClicked

        int linhaSelecionada = jtMarca.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelMarca tbMarca = (TableModelMarca) jtMarca.getModel();
            Marca marca = tbMarca.getMarca(jtMarca.getSelectedRow());

            txtID.setText(String.valueOf(marca.getId()));
            txtMarca.setText(marca.getMarca());

            if (marca.getStatus() == 1) {
                jcbStatus.setSelectedIndex(0);
            }
            if (marca.getStatus() == 2) {
                jcbStatus.setSelectedIndex(1);
            }

            a = 1;

        }

        pegarTabela();

        jbCadastrar.setEnabled(false);
        jbEditar.setEnabled(true);
        jbExcluir.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtMarcaMouseClicked

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        txtID.setText(null);
        txtMarca.setText(null);
        jcbStatus.setSelectedIndex(0);

        pegarTabela();
        jbCadastrar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        ExcluirMarca marca = new ExcluirMarca();
        getParent().add(marca);
        marca.setVisible(true);
        getParent().remove(1);        // TODO add your handling code here:
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
        pegarTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained
        txtMarca.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jcLimiteFocusGained

    private void txtMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCategoria.doClick();

        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtMarca;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables
}
