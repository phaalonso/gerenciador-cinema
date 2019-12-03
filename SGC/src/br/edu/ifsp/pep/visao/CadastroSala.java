/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleSala;
import br.edu.ifsp.pep.modelo.Sala;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CadastroSala extends javax.swing.JDialog {

    private ControleSala controleSala;
    private Sala sala;
    
    /**
     * Creates new form CadastroSala
     */
    public CadastroSala(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.controleSala = new ControleSala();
    }
    
    public void setSelecionado(Sala s){
        this.sala = s;
        cbDisponivel.setSelected(s.isDisponivel());
        mbCadastrar.setText("Salvar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbDisponivel = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        mbCadastrar = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbCancelar = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        cbDisponivel.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        cbDisponivel.setText("Disponível");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro Sala");

        mbCadastrar.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrar.setText("Cadastrar");
        mbCadastrar.setEndColor(new java.awt.Color(73, 136, 137));
        mbCadastrar.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbCadastrar.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbCadastrar.setMaximumSize(new java.awt.Dimension(64, 19));
        mbCadastrar.setMinimumSize(new java.awt.Dimension(64, 19));
        mbCadastrar.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbCadastrar.setStartColor(new java.awt.Color(73, 136, 137));
        mbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarActionPerformed(evt);
            }
        });
        mbCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbCadastrarKeyPressed(evt);
            }
        });

        mbCancelar.setBackground(new java.awt.Color(73, 136, 137));
        mbCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCancelar.setText("Cancelar");
        mbCancelar.setEndColor(new java.awt.Color(73, 136, 137));
        mbCancelar.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbCancelar.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbCancelar.setMaximumSize(new java.awt.Dimension(64, 19));
        mbCancelar.setMinimumSize(new java.awt.Dimension(64, 19));
        mbCancelar.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbCancelar.setStartColor(new java.awt.Color(73, 136, 137));
        mbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCancelarActionPerformed(evt);
            }
        });
        mbCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(cbDisponivel))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDisponivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void mbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarActionPerformed
        try{
            boolean disponivel = cbDisponivel.isSelected();
            if(this.sala == null){
                Sala sala = new Sala(disponivel);
                controleSala.persist(sala);
                JOptionPane.showMessageDialog(null, "Sala cadastrada");
                dispose();
            }else{
                this.sala.setDisponivel(disponivel);
                controleSala.merge(this.sala);
                JOptionPane.showMessageDialog(null, "Sala modificada");
                dispose();
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira apenas números na quantidade!");
        }
    }//GEN-LAST:event_mbCadastrarActionPerformed

    private void mbCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbCadastrarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbCadastrarKeyPressed

    private void mbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_mbCancelarActionPerformed

    private void mbCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbCancelarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbCancelarKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbDisponivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbCadastrar;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbCancelar;
    // End of variables declaration//GEN-END:variables
}
