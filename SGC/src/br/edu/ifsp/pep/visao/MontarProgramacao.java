/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleFilme;
import br.edu.ifsp.pep.controle.ControleSala;
import br.edu.ifsp.pep.controle.ControleSessao;
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Sala;
import br.edu.ifsp.pep.modelo.Sessao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class MontarProgramacao extends javax.swing.JDialog {
    private ControleSessao controleSessao;
    private ControleSala controleSala;
    private ControleFilme controleFilme;    
    
    private List<Filme> listaFilmes;
    private List<Sala> listaSala;
    
    public MontarProgramacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.controleSessao = new ControleSessao();
        this.controleSala = new ControleSala();
        this.controleFilme = new ControleFilme();
        this.listaFilmes = controleFilme.findAll();
        this.listaSala = controleSala.findAll();
        atualizarFilme();
        atualizarSala();
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
        mbSair = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbCadastrar = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfDataInicial = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        lbDescricao = new javax.swing.JLabel();
        mcSala = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mcFilme = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfHorario = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();
        tfDataFinal = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpPrincipal.setBackground(java.awt.Color.white);
        jpPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(410, 360));

        mbSair.setBackground(new java.awt.Color(73, 136, 137));
        mbSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSair.setText("Sair");
        mbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSairActionPerformed(evt);
            }
        });

        mbCadastrar.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrar.setText("Cadastrar");
        mbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarActionPerformed(evt);
            }
        });

        tfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        tfDataInicial.setLabel("Data inicial");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        taDescricao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(taDescricao);

        lbDescricao.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbDescricao.setText("Descrição");

        mcSala.setAccent(new java.awt.Color(73, 136, 137));

        mcFilme.setAccent(new java.awt.Color(73, 136, 137));

        jLabel1.setText("Filme");

        jLabel2.setText("Sala");

        tfHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        tfHorario.setLabel("Horário");

        tfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        tfDataFinal.setLabel("Data final");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(mcFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(mcSala, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(mbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(lbDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcSala, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSairActionPerformed
        dispose();
    }//GEN-LAST:event_mbSairActionPerformed

    private void atualizarFilme(){
        mcFilme.removeAllItems();
        for(Filme f: this.listaFilmes){
            mcFilme.addItem(f);
        }  
        mcFilme.setSelectedIndex(-1);
    }
    
    private void atualizarSala(){
        mcSala.removeAllItems();
        for(Sala s: this.listaSala){
            mcSala.addItem(s);
        }
        mcSala.setSelectedIndex(-1);
    }
    
    private void mbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarActionPerformed
        try{
            Sala s = (Sala) mcSala.getSelectedItem();
            Filme f = (Filme) mcFilme.getSelectedItem();
            
            if(!tfHorario.getText().isEmpty()){
                if(!tfDataInicial.getText().isEmpty() && !tfDataFinal.getText().isEmpty()){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    Date dataInicial = sdf.parse(tfDataInicial.getText() + " " + tfHorario.getText().trim() + ":00");
                    if(f != null){
                        long milisegundos = f.getDuracao() * 60 * 1000;
                        Date dataFinal = new Date(sdf.parse(tfDataFinal.getText() + " " + tfHorario.getText().trim() + ":00").getTime() 
                                + milisegundos);
                        String descricao = taDescricao.getText();
                        if(s != null){
                                if(dataInicial.after(new Date())){
                                    if(dataFinal.after(dataInicial)){
                                        List<Sessao> conflito = controleSessao.localizarConflito(s, dataInicial, dataFinal);
                                        if(conflito.isEmpty()){
                                            Sessao sessao = null;

                                            Calendar cad = Calendar.getInstance();
                                            while(dataInicial.compareTo(dataFinal) <= 0){
                                                System.out.println(dataInicial);
                                                sessao = new Sessao(descricao, dataInicial, f, s);
                                                controleSessao.persist(sessao);
                                                cad.setTime(dataInicial);
                                                cad.add(Calendar.DATE, 1);
                                                dataInicial = cad.getTime();
                                            }                        
                                                JOptionPane.showMessageDialog(null, "Programação cadastrada!");
                                                dispose();
                                        }else{                        
                                            JOptionPane.showMessageDialog(null, "A sala esta ocupada nesse horário!");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "A data final deve vir depois da inicial");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Não é possível cadadastrar sessões no passado");
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "Por favor selecione uma sala");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Por favor selecione um filme");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "As datas não podem estar vazias!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "O horário não pode estar vazio!");
            }                        
        } catch (ParseException ex) {
            Logger.getLogger(MontarProgramacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mbCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lbDescricao;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrar;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbSair;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mcFilme;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mcSala;
    private javax.swing.JTextArea taDescricao;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField tfDataFinal;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField tfDataInicial;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField tfHorario;
    // End of variables declaration//GEN-END:variables
}
