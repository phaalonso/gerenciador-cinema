/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleItem;
import br.edu.ifsp.pep.modelo.ItemVenda;
import br.edu.ifsp.pep.modelo.Item;
import br.edu.ifsp.pep.modelo.Venda;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class AdicionarItem extends javax.swing.JDialog {

    private List<ItemVenda> listaItemVenda;
    
    private ControleItem controleItem;
    
    private Venda venda;
    
    public AdicionarItem(java.awt.Frame parent, boolean modal, 
            List<ItemVenda> lista, Venda venda) {
        super(parent, modal);
        initComponents();
        controleItem = new ControleItem();
        listaItemVenda = lista;
        spQtdItem.setValue(1);
        
        this.venda = venda;
        
        boolean naLista;
        for(Item i : controleItem.findAll()){
            naLista = false;
            for(ItemVenda iv : listaItemVenda){
                if(iv.getItem().equals(i))
                    naLista = true;
            }
            if(!naLista && i.verificaEstoque(0))
                cbItem.addItem(i);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mbAdicionarItemVenda = new com.hq.swingmaterialdesign.materialdesign.MButton();
        lbItemVenda = new javax.swing.JLabel();
        cbItem = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbSairItemVenda = new com.hq.swingmaterialdesign.materialdesign.MButton();
        lbQuantidadeVenda = new javax.swing.JLabel();
        spQtdItem = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        mbAdicionarItemVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbAdicionarItemVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbAdicionarItemVenda.setText("Adicionar");
        mbAdicionarItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbAdicionarItemVendaActionPerformed(evt);
            }
        });

        lbItemVenda.setText("Item");

        cbItem.setAccent(new java.awt.Color(73, 136, 137));

        mbSairItemVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbSairItemVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSairItemVenda.setText("SAIR");
        mbSairItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSairItemVendaActionPerformed(evt);
            }
        });

        lbQuantidadeVenda.setText("Quantidade");

        spQtdItem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQtdItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbItemVenda)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(lbQuantidadeVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spQtdItem, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mbSairItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mbAdicionarItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbItemVenda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuantidadeVenda)
                    .addComponent(spQtdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbSairItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbAdicionarItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void mbAdicionarItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbAdicionarItemVendaActionPerformed
        Item item = (Item) cbItem.getSelectedItem();
        int qtd = (int) spQtdItem.getValue();
        if(item != null){
            if(item.verificaEstoque(qtd)){
                listaItemVenda.add(new ItemVenda(
                    this.venda, item, qtd, item.getPreco()
                ));
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Superior ao estoque!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item!");
        }
    }//GEN-LAST:event_mbAdicionarItemVendaActionPerformed

    private void mbSairItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSairItemVendaActionPerformed
        this.dispose();
    }//GEN-LAST:event_mbSairItemVendaActionPerformed

    private void spQtdItemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQtdItemStateChanged
        if((int) spQtdItem.getValue() < 1)
            spQtdItem.setValue(1);
    }//GEN-LAST:event_spQtdItemStateChanged
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
    private com.hq.swingmaterialdesign.materialdesign.MComboBox cbItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbItemVenda;
    private javax.swing.JLabel lbQuantidadeVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbAdicionarItemVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbSairItemVenda;
    private javax.swing.JSpinner spQtdItem;
    // End of variables declaration//GEN-END:variables
}
