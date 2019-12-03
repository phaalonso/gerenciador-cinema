/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleTipoIngresso;
import br.edu.ifsp.pep.modelo.Assento;
import br.edu.ifsp.pep.modelo.Ingresso;
import br.edu.ifsp.pep.modelo.Sessao;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import br.edu.ifsp.pep.modelo.Venda;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class AdicionarIngresso extends javax.swing.JDialog {

    private List<Ingresso> listaIngresso;
    
    private ControleTipoIngresso controleTipoIngresso;
    
    private Sessao sessao;
    private Venda venda;
    
    public AdicionarIngresso(java.awt.Frame parent, boolean modal, 
            List<Ingresso> lista, Sessao s, Venda v) {
        super(parent, modal);
        initComponents();
        controleTipoIngresso = new ControleTipoIngresso();
        listaIngresso = lista;
        
        for(TipoIngresso ti : controleTipoIngresso.findAll())
            cbTipoIngressoVenda.addItem(ti);
        
        boolean naLista;
        for(Assento a : s.verificarAssentosDisponiveis()){
            naLista = false;
            for(Ingresso i : listaIngresso){
                if(i.getAssento().equals(a))
                    naLista = true;
            }
            if(!naLista)
                cbAssentoVenda.addItem(a);
        }
        
        this.sessao = s;
        this.venda = v;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mbAdicionarIngressoVenda = new com.hq.swingmaterialdesign.materialdesign.MButton();
        lbTipoIngressoVenda = new javax.swing.JLabel();
        cbTipoIngressoVenda = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbSairIngressoVenda = new com.hq.swingmaterialdesign.materialdesign.MButton();
        cbAssentoVenda = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        lbAssentoVenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

        mbAdicionarIngressoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbAdicionarIngressoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbAdicionarIngressoVenda.setText("Adicionar");
        mbAdicionarIngressoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbAdicionarIngressoVendaActionPerformed(evt);
            }
        });

        lbTipoIngressoVenda.setText("Tipo de ingresso");

        cbTipoIngressoVenda.setAccent(new java.awt.Color(73, 136, 137));

        mbSairIngressoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbSairIngressoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSairIngressoVenda.setText("SAIR");
        mbSairIngressoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSairIngressoVendaActionPerformed(evt);
            }
        });

        cbAssentoVenda.setAccent(new java.awt.Color(73, 136, 137));

        lbAssentoVenda.setText("Assento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTipoIngressoVenda)
                            .addComponent(lbAssentoVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAssentoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mbSairIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mbAdicionarIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipoIngressoVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipoIngressoVenda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAssentoVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAssentoVenda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbSairIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbAdicionarIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbAdicionarIngressoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbAdicionarIngressoVendaActionPerformed
        TipoIngresso tipo = (TipoIngresso) cbTipoIngressoVenda.getSelectedItem();
        Assento assento = (Assento) cbAssentoVenda.getSelectedItem();
        if(tipo != null && assento != null){
            listaIngresso.add(new Ingresso(
                this.sessao, assento, this.venda, tipo, tipo.getValor()
            ));
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione os campos!");
        }
    }//GEN-LAST:event_mbAdicionarIngressoVendaActionPerformed

    private void mbSairIngressoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSairIngressoVendaActionPerformed
        this.dispose();
    }//GEN-LAST:event_mbSairIngressoVendaActionPerformed
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
    private com.hq.swingmaterialdesign.materialdesign.MComboBox cbAssentoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox cbTipoIngressoVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAssentoVenda;
    private javax.swing.JLabel lbTipoIngressoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbAdicionarIngressoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbSairIngressoVenda;
    // End of variables declaration//GEN-END:variables
}
