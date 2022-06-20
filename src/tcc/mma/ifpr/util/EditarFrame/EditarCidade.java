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
import tcc.mma.ifpr.bean.Cidade;
import tcc.mma.ifpr.bean.Estado;
import tcc.mma.ifpr.dao.CidadeDAO;
import tcc.mma.ifpr.dao.EstadoDAO;
import tcc.mma.ifpr.util.CadastrarFrame.CadastrarCidade;
import tcc.mma.ifpr.util.ExcluirFrame.ExcluirCidade;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelCidade;
import tcc.mma.ifpr.util.Validar.Texto;

/**
 *
 * @author nnath
 */
public class EditarCidade extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarCidade
     */
    public EditarCidade() {
        initComponents();
    }

    public void pegarTabela() {

        if (jcLimite.isSelected()) {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CidadeDAO daoCidade = new CidadeDAO(con);
                List<Cidade> cat = daoCidade.retrieveAllFull();

                TableModelCidade tableModelCidade = new TableModelCidade();

                jtCidade.setModel(tableModelCidade);

                for (int i = 0; i < cat.size(); i++) {

                    Cidade cidades = new Cidade();

                    cidades.setId(cat.get(i).getId());
                    cidades.setNome(cat.get(i).getNome());
                    cidades.setEstado(cat.get(i).getEstado());
                    tableModelCidade.addRow(cidades);

                }

            } catch (Exception e) {
            }

        } else {

            try {

                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CidadeDAO daoCidade = new CidadeDAO(con);
                List<Cidade> cat = daoCidade.retrieveAll();

                TableModelCidade tableModelCidade = new TableModelCidade();

                jtCidade.setModel(tableModelCidade);

                for (int i = 0; i < cat.size(); i++) {

                    Cidade cidades = new Cidade();

                    cidades.setId(cat.get(i).getId());
                    cidades.setNome(cat.get(i).getNome());
                    cidades.setEstado(cat.get(i).getEstado());
                    tableModelCidade.addRow(cidades);

                }

            } catch (Exception e) {
            }

        }
    }

    public void estado() {
        try {
            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            EstadoDAO daoEstado = new EstadoDAO(con);

            for (int i = 1; i < 28; i++) {
                Estado estado = daoEstado.retrieve(i);

                jcbEstado.addItem(estado.getNome() + " - " + estado.getUf());
            }

            jcbEstado.setSelectedIndex(17);

        } catch (Exception e) {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtID = new javax.swing.JTextField();
        lblCategoria1 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jcLimite = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCidade = new javax.swing.JTable();
        jbBuscarCategoria = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        lblId1 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jbEditar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setClosable(true);
        setTitle("Editar Cidade");
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

        txtID.setEditable(false);

        lblCategoria1.setText("Cidade:");

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidadeKeyPressed(evt);
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

        jtCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cidade", "Estado"
            }
        ));
        jtCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCidade);

        jbBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/buscar.png"))); // NOI18N
        jbBuscarCategoria.setText("Buscar");
        jbBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCategoriaActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado:");

        lblId1.setText("ID:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcLimite))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblId1)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCategoria1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscarCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstado)
                                .addGap(18, 18, 18)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbEditar)
                                .addGap(18, 18, 18)
                                .addComponent(jbCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpar)))
                        .addGap(0, 100, Short.MAX_VALUE)))
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
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria1)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarCategoria)
                    .addComponent(lblId1)
                    .addComponent(lblEstado)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbCadastrar)
                    .addComponent(jbExcluir)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        setBounds(0, 0, 963, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jcLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcLimiteFocusGained

        txtCidade.requestFocus();

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

    private void jtCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCidadeMouseClicked

        int linhaSelecionada = jtCidade.getSelectedRow();

        if (linhaSelecionada != -1) {
            TableModelCidade tbCidade = (TableModelCidade) jtCidade.getModel();
            Cidade cidade = tbCidade.getCidade(jtCidade.getSelectedRow());

            txtID.setText(String.valueOf(cidade.getId()));
            txtCidade.setText(cidade.getNome());
            jcbEstado.setSelectedIndex(cidade.getEstado().getId() - 1);

            jbCadastrar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtCidadeMouseClicked

    private void jbBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCategoriaActionPerformed

        String cidadeNome = txtCidade.getText();

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            CidadeDAO daoCidade = new CidadeDAO(con);
            List<Cidade> cit = daoCidade.retrieveNome(cidadeNome);

            TableModelCidade tableModelCidade = new TableModelCidade();

            jtCidade.setModel(tableModelCidade);

            for (int i = 0; i < cit.size(); i++) {

                Cidade cidade = new Cidade();

                cidade.setId(cit.get(i).getId());
                cidade.setNome(cit.get(i).getNome());
                cidade.setEstado(cit.get(i).getEstado());
                tableModelCidade.addRow(cidade);

            }

        } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarCategoriaActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Texto texto = new Texto();
        String retorno = texto.textoConverter(txtCidade.getText());
        txtCidade.setText(retorno);

        if (txtCidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro, preencha a categoria ",
                    "Atenção", NORMAL);
        } else {

            try {
                Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
                CidadeDAO daoCidade = new CidadeDAO(con);
                EstadoDAO daoEstado = new EstadoDAO(con);
                Estado estado = daoEstado.retrieve(jcbEstado.getSelectedIndex() + 1);
                Cidade cidade = new Cidade(Integer.parseInt(txtID.getText()), txtCidade.getText(), estado);
                daoCidade.update(cidade);

                JOptionPane.showMessageDialog(null, "A categoria: '" + txtCidade.getText() + "' foi atualizada com sucesso!");

                txtID.setText(null);
                txtCidade.setText(null);
                estado();

                pegarTabela();

                jbCadastrar.setEnabled(true);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar a categoria ",
                        "Atenção", NORMAL);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed

        CadastrarCidade cidade = new CadastrarCidade();
        getParent().add(cidade);
        cidade.setVisible(true);
        getParent().remove(1);
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        ExcluirCidade categoria = new ExcluirCidade();
        getParent().add(categoria);
        categoria.setVisible(true);
        getParent().remove(1);
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed

        txtID.setText(null);
        txtCidade.setText(null);

        pegarTabela();
        estado();
        jbCadastrar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimparActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        pegarTabela();
        estado();
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyPressed
 if (evt.getKeyCode() == evt.VK_ENTER) {
            jbBuscarCategoria.doClick();

        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbBuscarCategoria;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JCheckBox jcLimite;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTable jtCidade;
    private javax.swing.JLabel lblCategoria1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblId1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
