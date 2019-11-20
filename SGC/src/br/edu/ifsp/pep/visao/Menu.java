/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.modelo.UsuarioComum;

/**
 *
 * @author pedro
 */
public class Menu extends javax.swing.JFrame {

    private UsuarioComum usuario;
    
    public Menu(UsuarioComum usuario) {
        this.usuario = usuario;
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PMain = new javax.swing.JPanel();
        gPMenu = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        mButton1 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton6 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton7 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton8 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton9 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton10 = new com.hq.swingmaterialdesign.materialdesign.MButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PMain.setBackground(java.awt.Color.gray);

        gPMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gPMenu.setBorderRadius(0);
        gPMenu.setEndColor(new java.awt.Color(73, 136, 137));
        gPMenu.setStartColor(new java.awt.Color(73, 136, 137));
        gPMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("SGC");
        gPMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 54, -1, -1));

        mButton1.setBackground(new java.awt.Color(73, 136, 137));
        mButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton1.setText("VENDA");
        gPMenu.add(mButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 199, 192, 70));

        mButton6.setBackground(new java.awt.Color(73, 136, 137));
        mButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton6.setText("SAIR");
        mButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mButton6MouseClicked(evt);
            }
        });
        mButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButton6ActionPerformed(evt);
            }
        });
        gPMenu.add(mButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 463, 192, 70));

        mButton7.setBackground(new java.awt.Color(37, 157, 218));
        mButton7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton7.setText("Menu");
        gPMenu.add(mButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 133, 192, 70));

        mButton8.setBackground(new java.awt.Color(73, 136, 137));
        mButton8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton8.setText("SESSÕES");
        gPMenu.add(mButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 265, 192, 70));

        mButton9.setBackground(new java.awt.Color(73, 136, 137));
        mButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton9.setText("FILMES");
        gPMenu.add(mButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 331, 192, 70));

        mButton10.setBackground(new java.awt.Color(73, 136, 137));
        mButton10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mButton10.setText("PRODUTOS");
        gPMenu.add(mButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 397, 192, 70));

        javax.swing.GroupLayout PMainLayout = new javax.swing.GroupLayout(PMain);
        PMain.setLayout(PMainLayout);
        PMainLayout.setHorizontalGroup(
            PMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMainLayout.createSequentialGroup()
                .addComponent(gPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 582, Short.MAX_VALUE))
        );
        PMainLayout.setVerticalGroup(
            PMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gPMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mButton6ActionPerformed

    private void mButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton6MouseClicked
        dispose();
    }//GEN-LAST:event_mButton6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PMain;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel gPMenu;
    private javax.swing.JLabel jLabel1;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton1;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton10;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton6;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton7;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton8;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton9;
    // End of variables declaration//GEN-END:variables
}
