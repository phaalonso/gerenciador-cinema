/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleGenero;
import br.edu.ifsp.pep.modelo.Genero;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.graalvm.compiler.nodes.NodeView;

/**
 *
 * @author pedro
 */
public class SelecionarGeneros extends javax.swing.JDialog {

    private List<Genero> listGenero;
    private List<Genero> listSelecionado;
    private ControleGenero controleG;
    
    /**
     * Creates new form SelecionarGeneros
     */
    public SelecionarGeneros(java.awt.Frame parent, boolean modal, List<Genero> g) {
        super(parent, modal);
        initComponents();
        this.controleG = new ControleGenero();
        this.listSelecionado = g;
        this.listGenero = this.controleG.findAll();
        atualizarCombo();
        atualizarTabela();
    }    
    
    public void atualizarCombo(){
        this.cbGeneros.removeAllItems();
        for(Genero g: this.listGenero){
            if(!listSelecionado.contains(g)){
                this.cbGeneros.addItem(g.getDescricao());
            }
        }
        this.cbGeneros.setSelectedIndex(-1);
    }
    
    public void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tbSelecionado.getModel();
        modelo.setNumRows(0);
        for(Genero g : this.listSelecionado){
            modelo.addRow(new Object[] {g.getCodigo(), g.getDescricao() });
        }
    }
        

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mbAdicionarGenero = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSelecionado = new javax.swing.JTable();
        mbRemoverGenero = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jLabel1 = new javax.swing.JLabel();
        cbGeneros = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbConcluir = new com.hq.swingmaterialdesign.materialdesign.MButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        mbAdicionarGenero.setBackground(new java.awt.Color(73, 136, 137));
        mbAdicionarGenero.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbAdicionarGenero.setText("Adicionar genero");
        mbAdicionarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbAdicionarGeneroActionPerformed(evt);
            }
        });

        tbSelecionado.setAutoCreateRowSorter(true);
        tbSelecionado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbSelecionado.setColumnSelectionAllowed(true);
        tbSelecionado.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbSelecionado);
        tbSelecionado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        mbRemoverGenero.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverGenero.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverGenero.setText("REMOVER GENERO");
        mbRemoverGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverGeneroActionPerformed(evt);
            }
        });

        jLabel1.setText("Generos");

        cbGeneros.setAccent(new java.awt.Color(73, 136, 137));

        mbConcluir.setBackground(new java.awt.Color(73, 136, 137));
        mbConcluir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbConcluir.setText("Concluir");
        mbConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mbRemoverGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mbAdicionarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mbConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbGeneros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbRemoverGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbAdicionarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbAdicionarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbAdicionarGeneroActionPerformed
        Genero g = controleG.findByDesc((String) cbGeneros.getSelectedItem());
        this.listSelecionado.add(g);
        atualizarCombo();
        atualizarTabela();
    }//GEN-LAST:event_mbAdicionarGeneroActionPerformed

    private void mbRemoverGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverGeneroActionPerformed
        int row = tbSelecionado.getSelectedRow();
        
        if(row > -1){
            Integer cod = null;
            cod = (Integer) tbSelecionado.getValueAt(row, 0);
            Genero g = controleG.findByCodigo(cod);
            this.listSelecionado.remove(g);
            atualizarTabela();
            atualizarCombo();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um genero na tabela!");
        }        
    }//GEN-LAST:event_mbRemoverGeneroActionPerformed

    private void mbConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbConcluirActionPerformed
        dispose();
    }//GEN-LAST:event_mbConcluirActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SelecionarGeneros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SelecionarGeneros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SelecionarGeneros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SelecionarGeneros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SelecionarGeneros dialog = new SelecionarGeneros(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.hq.swingmaterialdesign.materialdesign.MComboBox cbGeneros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbAdicionarGenero;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbConcluir;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbRemoverGenero;
    private javax.swing.JTable tbSelecionado;
    // End of variables declaration//GEN-END:variables
}
