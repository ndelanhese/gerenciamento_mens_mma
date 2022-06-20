/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.mma.ifpr.util.ControlarEstoque;

import java.sql.Connection;
import java.util.List;
import tcc.mma.ifpr.bean.Mercadoria;
import tcc.mma.ifpr.dao.MercadoriaDAO;
import tcc.mma.ifpr.util.FabricaDeConexoes;
import tcc.mma.ifpr.util.TableModel.TableModelControleEstoqueNotificacao;

/**
 *
 * @author nnath
 */
public class ControlarEstoqueNotificacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form ControlarEstoqueNotificacao
     */
    public ControlarEstoqueNotificacao() {
        initComponents();

        pegarTabela();

    }

    public void pegarTabela() {

        try {

            Connection con = FabricaDeConexoes.criarConexaoParaMySQL();
            MercadoriaDAO daoMercadoria = new MercadoriaDAO(con);
            List<Mercadoria> mer = daoMercadoria.retrieveAll1();

            TableModelControleEstoqueNotificacao tableModelMercadoria = new TableModelControleEstoqueNotificacao();

            jtTabela.setModel(tableModelMercadoria);

            if (mer.isEmpty()) {
                this.setVisible(false);
            }else{
            
            for (int i = 0; i < mer.size(); i++) {

                if (mer.get(i).getQuantide() <= 2) {

                    int status = mer.get(i).getStatus();

                    if (status == 3) {

                    } else if(!mer.isEmpty()){

                        Mercadoria mercadorias = new Mercadoria();

                        mercadorias.setId(mer.get(i).getId());
                        mercadorias.setCategoria(mer.get(i).getCategoria());
                        mercadorias.setDescricao(mer.get(i).getDescricao());
                        mercadorias.setQuantide(mer.get(i).getQuantide());

                        tableModelMercadoria.addRow(mercadorias);
                    }
                }

                if (jtTabela.getRowCount() == 1) {
                    lblAviso.setText("A seguinte mercadoria está com estoque Baixo!");
                    this.setTitle("Mercadoria com Estoque Baixo");
                } else {
                    lblAviso.setText("As seguintes mercadorias estão com estoque Baixo!");
                    this.setTitle("Mercadorias com Estoque Baixo");
                }

            }
            }
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

        jLabel1 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mercadorias Com Estoque Baixo");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Atenção!");

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
        jScrollPane1.setViewportView(jtTabela);

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tcc/mma/ifpr/img/bdConect.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabela;
    private javax.swing.JLabel lblAviso;
    // End of variables declaration//GEN-END:variables
}