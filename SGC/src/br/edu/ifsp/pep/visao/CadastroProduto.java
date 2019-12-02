/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleProduto;
import br.edu.ifsp.pep.modelo.Combo;
import br.edu.ifsp.pep.modelo.ComboProduto;
import br.edu.ifsp.pep.modelo.Item;
import br.edu.ifsp.pep.modelo.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CadastroProduto extends javax.swing.JDialog {

    private ControleProduto controleP;
    private Item selecionado;
    private List<ComboProduto> listaCombo;
            
    public CadastroProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.listaCombo = new ArrayList<>();
        this.controleP = new ControleProduto();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        tfDescricao = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        tfEstoque = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        mbSair = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbCadastrar = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfValor = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        mComboBox1 = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbItensCombo = new com.hq.swingmaterialdesign.materialdesign.MButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpPrincipal.setBackground(java.awt.Color.white);
        jpPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(410, 360));

        tfDescricao.setLabel("Descrição");

        tfEstoque.setLabel("Estoque");

        mbSair.setBackground(new java.awt.Color(73, 136, 137));
        mbSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSair.setText("Sair");
        mbSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbSairMouseClicked(evt);
            }
        });
        mbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSairActionPerformed(evt);
            }
        });

        mbCadastrar.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrar.setText("Cadastrar");
        mbCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbCadastrarMouseClicked(evt);
            }
        });
        mbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarActionPerformed(evt);
            }
        });

        tfValor.setLabel("Valor");

        mComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Produto", "Combo" }));
        mComboBox1.setAccent(new java.awt.Color(73, 136, 137));
        mComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mComboBox1ItemStateChanged(evt);
            }
        });

        mbItensCombo.setBackground(new java.awt.Color(73, 136, 137));
        mbItensCombo.setBorder(null);
        mbItensCombo.setText("Items do combo");
        mbItensCombo.setBorderRadius(0);
        mbItensCombo.setEnabled(false);
        mbItensCombo.setNextFocusableComponent(mbSair);
        mbItensCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbItensComboMouseClicked(evt);
            }
        });
        mbItensCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbItensComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(mbItensCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(mComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(mbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(mbItensCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setSelecionado(Item i){
        this.selecionado = i;
        this.tfCodigo.setText(String.valueOf(i.getCodigo()));
        this.tfCodigo.setEditable(false);
        this.tfDescricao.setText(i.getDescricao());
        this.tfValor.setText(String.valueOf(i.getPreco()));
        mComboBox1.setEditable(false);
        if(i instanceof Produto){
            this.tfEstoque.setText((String.valueOf(((Produto) i).getEstoque())));
            mComboBox1.setSelectedIndex(0);
        }else{
            this.listaCombo = ((Combo) i).getProdutos();
            mComboBox1.setSelectedIndex(1);
        }
    }
    
    private void mbSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbSairMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mbSairMouseClicked

    private void mbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSairActionPerformed
        dispose();
    }//GEN-LAST:event_mbSairActionPerformed

    private void mbCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbCadastrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mbCadastrarMouseClicked

    private void mbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarActionPerformed
        try{ 
            Integer codigo = Integer.parseInt(tfCodigo.getText().trim());
            String nome = tfDescricao.getText().trim();
            Double valor = Double.parseDouble(tfValor.getText().trim());
            Integer estoque = Integer.parseInt(tfEstoque.getText().trim());

            if(codigo != null){
                if(valor >= 0){
                    if(codigo >= 0){
                        if(estoque >= 0){

                                Produto p = new Produto();
                                p.setCodigo(codigo);
                                p.setDescricao(nome);
                                p.setPreco(valor);
                                p.setEstoque(estoque);

                                if(this.selecionado == null){
                                    try{
                                        controleP.persist(p);
                                        JOptionPane.showMessageDialog(null, "Produto cadastrado!");
                                        dispose();
                                    }catch(EntityExistsException ex){
                                        JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar!");
                                    }
                                }else{
                                    controleP.merge(p);
                                    JOptionPane.showMessageDialog(null, "Produto atualizado!");
                                    dispose();
                                }

                        }else{
                            JOptionPane.showMessageDialog(null, "Estoque deve ser maior que 0!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "O codigo deve ser maior que 0!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "O valor deve ser acima de 0!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha o campo do código");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Por favor insira apenas numeros nos campos\nvalor e estoque");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_mbCadastrarActionPerformed

    private void mbItensComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbItensComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mbItensComboMouseClicked

    private void mbItensComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbItensComboActionPerformed
        ItensCombo ic = new ItensCombo(null, true, this.listaCombo);
        ic.setModal(true);
        ic.setVisible(true);
    }//GEN-LAST:event_mbItensComboActionPerformed

    private void mComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mComboBox1ItemStateChanged
        switch(mComboBox1.getSelectedIndex()){
            case 1:
                mbItensCombo.setEnabled(true);
                break;
            default:
                mbItensCombo.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_mComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpPrincipal;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mComboBox1;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrar;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbItensCombo;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbSair;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfDescricao;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfEstoque;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
