/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.pep.visao;

import br.edu.ifsp.pep.controle.ControleFilme;
import br.edu.ifsp.pep.controle.ControleItem;
import br.edu.ifsp.pep.controle.ControleProduto;
import br.edu.ifsp.pep.controle.ControleSala;
import br.edu.ifsp.pep.controle.ControleSessao;
import br.edu.ifsp.pep.controle.ControleTipoIngresso;
import br.edu.ifsp.pep.controle.ControleUsuario;
import br.edu.ifsp.pep.controle.ControleVenda;
import br.edu.ifsp.pep.modelo.Combo;
import br.edu.ifsp.pep.modelo.Filme;
import br.edu.ifsp.pep.modelo.Ingresso;
import br.edu.ifsp.pep.modelo.Item;
import br.edu.ifsp.pep.modelo.ItemVenda;
import br.edu.ifsp.pep.modelo.Produto;
import br.edu.ifsp.pep.modelo.Sessao;
import br.edu.ifsp.pep.modelo.TipoIngresso;
import br.edu.ifsp.pep.modelo.TipoUsuario;
import br.edu.ifsp.pep.modelo.Usuario;
import br.edu.ifsp.pep.modelo.Venda;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class Menu extends javax.swing.JFrame {
    
    private List<Item> listaItens;
    private List<Filme> listaFilmes;
    private List<Sessao> listaSessoes;
    private List<Ingresso> listaIngresso;
    private List<ItemVenda> listaItemVenda;
    private List<Usuario> listaUsuarios;
    
    private Usuario usuario;
    private ControleItem controleItem;
    private ControleProduto controleProduto;
    private ControleFilme controleFilme;
    private ControleSessao controleSessao;
    private ControleSala controleSala;
    private ControleVenda controleVenda;
    private ControleTipoIngresso controleTipoIngresso;
    private ControleUsuario controleUsuario;
    
    private Venda venda;
    
    public Menu(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        this.setResizable(false);
        
        this.controleItem = new ControleItem();
        this.controleProduto = new ControleProduto();
        this.controleFilme = new ControleFilme();
        this.controleSessao = new ControleSessao();
        this.controleSala = new ControleSala();
        this.controleVenda = new ControleVenda();
        this.controleTipoIngresso = new ControleTipoIngresso();
        this.controleUsuario = new ControleUsuario();
        
        this.listaFilmes = new ArrayList<>();
        this.listaItens = new ArrayList<>();
        this.listaItemVenda = new ArrayList<>();
        this.listaIngresso = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        
        if(usuario.getTipo() == TipoUsuario.COMUM){
            mbSessoes.setVisible(false);
            mbSessoes.setEnabled(false);
            mbFilmes.setVisible(false);
            mbFilmes.setEnabled(false);
            mbCadastrarProduto.setVisible(false);
            mbCadastrarProduto.setEnabled(false);
            mbEditarProduto.setVisible(false);
            mbEditarProduto.setEnabled(false);
            mbRemoverProduto.setVisible(false);
            mbRemoverProduto.setEnabled(false);
        }
        
        this.atualizarCalendarioSessao();
        
        lbBoasVindas.setText("Bem-vindo, "+usuario.getNome()+"!");
        mbFilmes.setSelected(false);
        jpFilmes.setVisible(false);
        
        mbProdutos.setSelected(false);
        jpProdutos.setVisible(false);
        
        mbSessoes.setSelected(false);
        jpSessoes.setVisible(false);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mBHome.setSelected(true);
        jpHome.setVisible(true);
    }
    
    private void atualizarCalendarioSessao(){
        DefaultTableModel modelo = (DefaultTableModel) tbCalendarioSessao.getModel();
        modelo.setNumRows(0);
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horarioFormat = new SimpleDateFormat("HH:mm:ss");
        for(Sessao s: controleSessao.findNotArquivada()){
            modelo.addRow(new Object[]{
                s.getFilme().getTitulo(),
                s.getSala().getCodigo(),
                dataFormat.format(s.getDataInicio()),
                horarioFormat.format(s.getDataInicio())
            });
        }
    }

    private void atualizarTabelaUsuario(){
        DefaultTableModel modelo = (DefaultTableModel) tbUsuario.getModel();
        modelo.setNumRows(0);
        for(Usuario u : this.listaUsuarios){
            modelo.addRow(new Object[] {
                u.getCodigo(), 
                u.getNome(), 
                u.getLogin(), 
                u.getTipo()
            });
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

        PMain = new javax.swing.JPanel();
        jpMenu = new javax.swing.JPanel();
        lbMenu = new javax.swing.JLabel();
        mBHome = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbVendas = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbProdutos = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbFilmes = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbSessoes = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbSair = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbUsuarios = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        jpPrincipal = new javax.swing.JPanel();
        jpVenda = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbItensVenda = new javax.swing.JTable();
        lbBoasVindas1 = new javax.swing.JLabel();
        lbBoasVindas2 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbIngressosVenda = new javax.swing.JTable();
        mbAdicionarIngressoVenda = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbAdicionarProdutoVenda = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        lbSessaoVenda = new javax.swing.JLabel();
        mbRemoverIngressoVenda = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        mbRemoverProdutoVenda = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        cbSessaoVenda = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbEfetuarVenda = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        jpHome = new javax.swing.JPanel();
        lbBoasVindas = new javax.swing.JLabel();
        mbGerarRelatorio = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCalendarioSessao = new javax.swing.JTable();
        lbCalendario = new javax.swing.JLabel();
        jpSessoes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSessoes = new javax.swing.JTable();
        mbCadastrarSessoes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbEditarSessoes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbRemoverSessoes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mCPesquisaSessoes = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbPesquisarSessoes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfPesquisaSessoes = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        mbMontarProgramacao = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbGereciarSalas = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbArquivarSessao = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jpProdutos = new javax.swing.JPanel();
        mbCadastrarProduto = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbEditarProduto = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbRemoverProduto = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mCPesquisaProduto = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbPesquisarProdutos = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfPesquisaProduto = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItems = new javax.swing.JTable();
        jpFilmes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbFilmes = new javax.swing.JTable();
        mbCadastrarFilmes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbEditarFilmes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbRemoverFilmes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mcPesquisaFilmes = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbPesquisarFilmes = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfPesquisaFilmes = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        jpUsuario = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        mbCadastrarUsuario = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbEditarUsuario = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mbRemoverUusuario = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mcPesquisarUsuario = new com.hq.swingmaterialdesign.materialdesign.MComboBox();
        mbPesquisarUsuario = new com.hq.swingmaterialdesign.materialdesign.MButton();
        tfPesquisaFilmes1 = new com.hq.swingmaterialdesign.materialdesign.MTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PMain.setBackground(java.awt.Color.white);
        PMain.setPreferredSize(new java.awt.Dimension(960, 720));

        jpMenu.setBackground(new java.awt.Color(73, 136, 137));
        jpMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lbMenu.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbMenu.setText("SGC");

        mBHome.setBackground(new java.awt.Color(73, 136, 137));
        mBHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mBHome.setText("Home");
        mBHome.setEndColor(new java.awt.Color(73, 136, 137));
        mBHome.setFocusPainted(false);
        mBHome.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mBHome.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mBHome.setSelected(true);
        mBHome.setSelectedColor(new java.awt.Color(37, 157, 218));
        mBHome.setStartColor(new java.awt.Color(73, 136, 137));
        mBHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBHomeActionPerformed(evt);
            }
        });

        mbVendas.setBackground(new java.awt.Color(73, 136, 137));
        mbVendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbVendas.setText("Vendas");
        mbVendas.setEndColor(new java.awt.Color(73, 136, 137));
        mbVendas.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbVendas.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbVendas.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbVendas.setStartColor(new java.awt.Color(73, 136, 137));
        mbVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbVendasActionPerformed(evt);
            }
        });

        mbProdutos.setBackground(new java.awt.Color(73, 136, 137));
        mbProdutos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbProdutos.setText("Produtos");
        mbProdutos.setEndColor(new java.awt.Color(73, 136, 137));
        mbProdutos.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbProdutos.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbProdutos.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbProdutos.setStartColor(new java.awt.Color(73, 136, 137));
        mbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbProdutosActionPerformed(evt);
            }
        });

        mbFilmes.setBackground(new java.awt.Color(73, 136, 137));
        mbFilmes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbFilmes.setText("Filmes");
        mbFilmes.setEndColor(new java.awt.Color(73, 136, 137));
        mbFilmes.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbFilmes.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbFilmes.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbFilmes.setStartColor(new java.awt.Color(73, 136, 137));
        mbFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbFilmesActionPerformed(evt);
            }
        });

        mbSessoes.setBackground(new java.awt.Color(73, 136, 137));
        mbSessoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSessoes.setText("SESSÕES");
        mbSessoes.setEndColor(new java.awt.Color(73, 136, 137));
        mbSessoes.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbSessoes.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbSessoes.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbSessoes.setStartColor(new java.awt.Color(73, 136, 137));
        mbSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSessoesActionPerformed(evt);
            }
        });

        mbSair.setBackground(new java.awt.Color(73, 136, 137));
        mbSair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbSair.setText("Sair");
        mbSair.setEndColor(new java.awt.Color(73, 136, 137));
        mbSair.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbSair.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbSair.setMaximumSize(new java.awt.Dimension(64, 19));
        mbSair.setMinimumSize(new java.awt.Dimension(64, 19));
        mbSair.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbSair.setStartColor(new java.awt.Color(73, 136, 137));
        mbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbSairActionPerformed(evt);
            }
        });
        mbSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbSairKeyPressed(evt);
            }
        });

        mbUsuarios.setBackground(new java.awt.Color(73, 136, 137));
        mbUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbUsuarios.setText("Usuários");
        mbUsuarios.setEndColor(new java.awt.Color(73, 136, 137));
        mbUsuarios.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbUsuarios.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbUsuarios.setMaximumSize(new java.awt.Dimension(64, 19));
        mbUsuarios.setMinimumSize(new java.awt.Dimension(64, 19));
        mbUsuarios.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbUsuarios.setStartColor(new java.awt.Color(73, 136, 137));
        mbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbUsuariosActionPerformed(evt);
            }
        });
        mbUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbUsuariosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mbSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mbUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mBHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(mbVendas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(mbProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(mbFilmes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(mbSessoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbMenu)
                .addGap(62, 62, 62)
                .addComponent(mBHome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(512, Short.MAX_VALUE))
        );

        jpPrincipal.setBackground(java.awt.Color.white);

        jpVenda.setBackground(java.awt.Color.white);

        tbItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItensVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tbItensVenda);

        lbBoasVindas1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbBoasVindas1.setText("Produtos");

        lbBoasVindas2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbBoasVindas2.setText("Ingressos");

        tbIngressosVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assento", "Tipo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbIngressosVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tbIngressosVenda);

        mbAdicionarIngressoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbAdicionarIngressoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbAdicionarIngressoVenda.setText("Adicionar");
        mbAdicionarIngressoVenda.setEndColor(new java.awt.Color(73, 136, 137));
        mbAdicionarIngressoVenda.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbAdicionarIngressoVenda.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbAdicionarIngressoVenda.setMaximumSize(new java.awt.Dimension(64, 19));
        mbAdicionarIngressoVenda.setMinimumSize(new java.awt.Dimension(64, 19));
        mbAdicionarIngressoVenda.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbAdicionarIngressoVenda.setStartColor(new java.awt.Color(73, 136, 137));
        mbAdicionarIngressoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbAdicionarIngressoVendaActionPerformed(evt);
            }
        });
        mbAdicionarIngressoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbAdicionarIngressoVendaKeyPressed(evt);
            }
        });

        mbAdicionarProdutoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbAdicionarProdutoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbAdicionarProdutoVenda.setText("Adicionar");
        mbAdicionarProdutoVenda.setEndColor(new java.awt.Color(73, 136, 137));
        mbAdicionarProdutoVenda.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbAdicionarProdutoVenda.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbAdicionarProdutoVenda.setMaximumSize(new java.awt.Dimension(64, 19));
        mbAdicionarProdutoVenda.setMinimumSize(new java.awt.Dimension(64, 19));
        mbAdicionarProdutoVenda.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbAdicionarProdutoVenda.setStartColor(new java.awt.Color(73, 136, 137));
        mbAdicionarProdutoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbAdicionarProdutoVendaActionPerformed(evt);
            }
        });
        mbAdicionarProdutoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbAdicionarProdutoVendaKeyPressed(evt);
            }
        });

        lbSessaoVenda.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbSessaoVenda.setText("Sessao");

        mbRemoverIngressoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverIngressoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverIngressoVenda.setText("REMOVER");
        mbRemoverIngressoVenda.setEndColor(new java.awt.Color(73, 136, 137));
        mbRemoverIngressoVenda.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbRemoverIngressoVenda.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbRemoverIngressoVenda.setMaximumSize(new java.awt.Dimension(64, 19));
        mbRemoverIngressoVenda.setMinimumSize(new java.awt.Dimension(64, 19));
        mbRemoverIngressoVenda.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbRemoverIngressoVenda.setStartColor(new java.awt.Color(73, 136, 137));
        mbRemoverIngressoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverIngressoVendaActionPerformed(evt);
            }
        });
        mbRemoverIngressoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbRemoverIngressoVendaKeyPressed(evt);
            }
        });

        mbRemoverProdutoVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverProdutoVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverProdutoVenda.setText("REMOVER");
        mbRemoverProdutoVenda.setEndColor(new java.awt.Color(73, 136, 137));
        mbRemoverProdutoVenda.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbRemoverProdutoVenda.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbRemoverProdutoVenda.setMaximumSize(new java.awt.Dimension(64, 19));
        mbRemoverProdutoVenda.setMinimumSize(new java.awt.Dimension(64, 19));
        mbRemoverProdutoVenda.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbRemoverProdutoVenda.setStartColor(new java.awt.Color(73, 136, 137));
        mbRemoverProdutoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverProdutoVendaActionPerformed(evt);
            }
        });
        mbRemoverProdutoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbRemoverProdutoVendaKeyPressed(evt);
            }
        });

        cbSessaoVenda.setAccent(new java.awt.Color(73, 136, 137));
        cbSessaoVenda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSessaoVendaItemStateChanged(evt);
            }
        });

        mbEfetuarVenda.setBackground(new java.awt.Color(73, 136, 137));
        mbEfetuarVenda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbEfetuarVenda.setText("EFETUAR VENDA");
        mbEfetuarVenda.setEndColor(new java.awt.Color(73, 136, 137));
        mbEfetuarVenda.setHoverEndColor(new java.awt.Color(37, 157, 218));
        mbEfetuarVenda.setHoverStartColor(new java.awt.Color(37, 157, 218));
        mbEfetuarVenda.setMaximumSize(new java.awt.Dimension(64, 19));
        mbEfetuarVenda.setMinimumSize(new java.awt.Dimension(64, 19));
        mbEfetuarVenda.setSelectedColor(new java.awt.Color(37, 157, 218));
        mbEfetuarVenda.setStartColor(new java.awt.Color(73, 136, 137));
        mbEfetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbEfetuarVendaActionPerformed(evt);
            }
        });
        mbEfetuarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mbEfetuarVendaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpVendaLayout = new javax.swing.GroupLayout(jpVenda);
        jpVenda.setLayout(jpVendaLayout);
        jpVendaLayout.setHorizontalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVendaLayout.createSequentialGroup()
                .addComponent(lbSessaoVenda)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpVendaLayout.createSequentialGroup()
                .addComponent(cbSessaoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(181, 181, 181))
            .addGroup(jpVendaLayout.createSequentialGroup()
                .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(mbEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpVendaLayout.createSequentialGroup()
                                .addComponent(lbBoasVindas1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mbRemoverProdutoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbAdicionarProdutoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpVendaLayout.createSequentialGroup()
                            .addComponent(lbBoasVindas2)
                            .addGap(317, 317, 317)
                            .addComponent(mbRemoverIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(mbAdicionarIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(91, 91, 91))
        );
        jpVendaLayout.setVerticalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVendaLayout.createSequentialGroup()
                .addComponent(lbSessaoVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSessaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbRemoverIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBoasVindas2)
                    .addComponent(mbAdicionarIngressoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbRemoverProdutoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbAdicionarProdutoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBoasVindas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mbEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(659, 659, 659))
        );

        jpHome.setBackground(java.awt.Color.white);

        lbBoasVindas.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbBoasVindas.setText("Bem vindo, usuário !");

        mbGerarRelatorio.setBackground(new java.awt.Color(73, 136, 137));
        mbGerarRelatorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbGerarRelatorio.setText("GERAR RELATÓRIOS");
        mbGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbGerarRelatorioActionPerformed(evt);
            }
        });

        tbCalendarioSessao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filme", "Sala", "Data", "Horario Inicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCalendarioSessao.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbCalendarioSessao);
        if (tbCalendarioSessao.getColumnModel().getColumnCount() > 0) {
            tbCalendarioSessao.getColumnModel().getColumn(0).setResizable(false);
            tbCalendarioSessao.getColumnModel().getColumn(1).setResizable(false);
            tbCalendarioSessao.getColumnModel().getColumn(2).setResizable(false);
            tbCalendarioSessao.getColumnModel().getColumn(3).setResizable(false);
        }

        lbCalendario.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbCalendario.setText("Verifique o calendário de sessões");

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mbGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addComponent(lbBoasVindas, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 87, Short.MAX_VALUE))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBoasVindas)
                .addGap(46, 46, 46)
                .addComponent(lbCalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mbGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
        );

        jpSessoes.setBackground(java.awt.Color.white);
        jpSessoes.setPreferredSize(new java.awt.Dimension(799, 1057));

        tbSessoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Filme", "Sala", "Data", "Horario Inicio", "Arquivada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSessoes.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbSessoes);
        if (tbSessoes.getColumnModel().getColumnCount() > 0) {
            tbSessoes.getColumnModel().getColumn(0).setHeaderValue("Código");
            tbSessoes.getColumnModel().getColumn(1).setResizable(false);
            tbSessoes.getColumnModel().getColumn(1).setHeaderValue("Filme");
            tbSessoes.getColumnModel().getColumn(2).setResizable(false);
            tbSessoes.getColumnModel().getColumn(2).setHeaderValue("Sala");
            tbSessoes.getColumnModel().getColumn(3).setResizable(false);
            tbSessoes.getColumnModel().getColumn(3).setHeaderValue("Data");
            tbSessoes.getColumnModel().getColumn(4).setResizable(false);
            tbSessoes.getColumnModel().getColumn(4).setHeaderValue("Horario Inicio");
            tbSessoes.getColumnModel().getColumn(5).setResizable(false);
            tbSessoes.getColumnModel().getColumn(5).setHeaderValue("Arquivada");
        }

        mbCadastrarSessoes.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrarSessoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrarSessoes.setText("Cadastrar Sessão");
        mbCadastrarSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarSessoesActionPerformed(evt);
            }
        });

        mbEditarSessoes.setBackground(new java.awt.Color(73, 136, 137));
        mbEditarSessoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbEditarSessoes.setText("Editar sessão");
        mbEditarSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbEditarSessoesActionPerformed(evt);
            }
        });

        mbRemoverSessoes.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverSessoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverSessoes.setText("Remover Sessão");
        mbRemoverSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverSessoesActionPerformed(evt);
            }
        });

        mCPesquisaSessoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Filme" }));
        mCPesquisaSessoes.setAccent(new java.awt.Color(73, 136, 137));

        mbPesquisarSessoes.setBackground(new java.awt.Color(73, 136, 137));
        mbPesquisarSessoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbPesquisarSessoes.setText("Pesquisar");
        mbPesquisarSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbPesquisarSessoesActionPerformed(evt);
            }
        });

        tfPesquisaSessoes.setLabel("Pesquisa");
        tfPesquisaSessoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaSessoesActionPerformed(evt);
            }
        });

        mbMontarProgramacao.setBackground(new java.awt.Color(73, 136, 137));
        mbMontarProgramacao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbMontarProgramacao.setText("Montar Programação");
        mbMontarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbMontarProgramacaoActionPerformed(evt);
            }
        });

        mbGereciarSalas.setBackground(new java.awt.Color(73, 136, 137));
        mbGereciarSalas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbGereciarSalas.setText("SALAS");
        mbGereciarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbGereciarSalasActionPerformed(evt);
            }
        });

        mbArquivarSessao.setBackground(new java.awt.Color(73, 136, 137));
        mbArquivarSessao.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbArquivarSessao.setText("Arquivar sessão");
        mbArquivarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbArquivarSessaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSessoesLayout = new javax.swing.GroupLayout(jpSessoes);
        jpSessoes.setLayout(jpSessoesLayout);
        jpSessoesLayout.setHorizontalGroup(
            jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSessoesLayout.createSequentialGroup()
                .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mbArquivarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpSessoesLayout.createSequentialGroup()
                            .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mbCadastrarSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPesquisaSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpSessoesLayout.createSequentialGroup()
                                    .addComponent(mbEditarSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(mbRemoverSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mbGereciarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpSessoesLayout.createSequentialGroup()
                                    .addComponent(mCPesquisaSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(mbPesquisarSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mbMontarProgramacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jpSessoesLayout.setVerticalGroup(
            jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSessoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mCPesquisaSessoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesquisaSessoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(mbPesquisarSessoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbMontarProgramacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87)
                .addComponent(mbArquivarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSessoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbCadastrarSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbEditarSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbRemoverSessoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbGereciarSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jpProdutos.setBackground(java.awt.Color.white);
        jpProdutos.setPreferredSize(new java.awt.Dimension(799, 1057));

        mbCadastrarProduto.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrarProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrarProduto.setText("Cadastrar produto");
        mbCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarProdutoActionPerformed(evt);
            }
        });

        mbEditarProduto.setBackground(new java.awt.Color(73, 136, 137));
        mbEditarProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbEditarProduto.setText("Editar produto");
        mbEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbEditarProdutoActionPerformed(evt);
            }
        });

        mbRemoverProduto.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverProduto.setText("Remover produto");
        mbRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverProdutoActionPerformed(evt);
            }
        });

        mCPesquisaProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Nome" }));
        mCPesquisaProduto.setAccent(new java.awt.Color(73, 136, 137));
        mCPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCPesquisaProdutoActionPerformed(evt);
            }
        });

        mbPesquisarProdutos.setBackground(new java.awt.Color(73, 136, 137));
        mbPesquisarProdutos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbPesquisarProdutos.setText("Pesquisar");
        mbPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbPesquisarProdutosActionPerformed(evt);
            }
        });

        tfPesquisaProduto.setLabel("Pesquisa");

        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbItems);
        if (tbItems.getColumnModel().getColumnCount() > 0) {
            tbItems.getColumnModel().getColumn(0).setResizable(false);
            tbItems.getColumnModel().getColumn(0).setHeaderValue("Código");
            tbItems.getColumnModel().getColumn(1).setResizable(false);
            tbItems.getColumnModel().getColumn(2).setResizable(false);
            tbItems.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jpProdutosLayout = new javax.swing.GroupLayout(jpProdutos);
        jpProdutos.setLayout(jpProdutosLayout);
        jpProdutosLayout.setHorizontalGroup(
            jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProdutosLayout.createSequentialGroup()
                .addGroup(jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProdutosLayout.createSequentialGroup()
                        .addGroup(jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mbCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProdutosLayout.createSequentialGroup()
                                .addComponent(mbEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpProdutosLayout.createSequentialGroup()
                                .addComponent(mCPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jpProdutosLayout.setVerticalGroup(
            jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mCPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jpProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(521, Short.MAX_VALUE))
        );

        jpFilmes.setBackground(java.awt.Color.white);

        tbFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Titulo", "Idade minima", "Data estreia", "Duração", "Direção"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFilmes.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbFilmes);
        if (tbFilmes.getColumnModel().getColumnCount() > 0) {
            tbFilmes.getColumnModel().getColumn(0).setResizable(false);
            tbFilmes.getColumnModel().getColumn(1).setHeaderValue("Titulo");
            tbFilmes.getColumnModel().getColumn(2).setResizable(false);
            tbFilmes.getColumnModel().getColumn(2).setHeaderValue("Idade minima");
            tbFilmes.getColumnModel().getColumn(3).setResizable(false);
            tbFilmes.getColumnModel().getColumn(3).setHeaderValue("Data estreia");
            tbFilmes.getColumnModel().getColumn(4).setResizable(false);
            tbFilmes.getColumnModel().getColumn(4).setHeaderValue("Duração");
            tbFilmes.getColumnModel().getColumn(5).setHeaderValue("Direção");
        }

        mbCadastrarFilmes.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrarFilmes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrarFilmes.setText("Cadastrar filme");
        mbCadastrarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarFilmesActionPerformed(evt);
            }
        });

        mbEditarFilmes.setBackground(new java.awt.Color(73, 136, 137));
        mbEditarFilmes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbEditarFilmes.setText("Editar filme");
        mbEditarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbEditarFilmesActionPerformed(evt);
            }
        });

        mbRemoverFilmes.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverFilmes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverFilmes.setText("Remover filme");
        mbRemoverFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverFilmesActionPerformed(evt);
            }
        });

        mcPesquisaFilmes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Título" }));
        mcPesquisaFilmes.setAccent(new java.awt.Color(73, 136, 137));

        mbPesquisarFilmes.setBackground(new java.awt.Color(73, 136, 137));
        mbPesquisarFilmes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbPesquisarFilmes.setText("Pesquisar");
        mbPesquisarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbPesquisarFilmesActionPerformed(evt);
            }
        });

        tfPesquisaFilmes.setLabel("Pesquisa");

        javax.swing.GroupLayout jpFilmesLayout = new javax.swing.GroupLayout(jpFilmes);
        jpFilmes.setLayout(jpFilmesLayout);
        jpFilmesLayout.setHorizontalGroup(
            jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilmesLayout.createSequentialGroup()
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFilmesLayout.createSequentialGroup()
                        .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mbCadastrarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFilmesLayout.createSequentialGroup()
                                .addComponent(mcPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbPesquisarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpFilmesLayout.createSequentialGroup()
                                .addComponent(mbEditarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbRemoverFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFilmesLayout.setVerticalGroup(
            jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mcPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesquisaFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbPesquisarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbCadastrarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbEditarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbRemoverFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpUsuario.setBackground(java.awt.Color.white);

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Login", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tbUsuario);
        if (tbUsuario.getColumnModel().getColumnCount() > 0) {
            tbUsuario.getColumnModel().getColumn(0).setResizable(false);
            tbUsuario.getColumnModel().getColumn(1).setResizable(false);
            tbUsuario.getColumnModel().getColumn(2).setResizable(false);
            tbUsuario.getColumnModel().getColumn(3).setResizable(false);
        }

        mbCadastrarUsuario.setBackground(new java.awt.Color(73, 136, 137));
        mbCadastrarUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbCadastrarUsuario.setText("Cadastrar USUÁRIO");
        mbCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbCadastrarUsuarioActionPerformed(evt);
            }
        });

        mbEditarUsuario.setBackground(new java.awt.Color(73, 136, 137));
        mbEditarUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbEditarUsuario.setText("Editar USUÁRIO");
        mbEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbEditarUsuarioActionPerformed(evt);
            }
        });

        mbRemoverUusuario.setBackground(new java.awt.Color(73, 136, 137));
        mbRemoverUusuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbRemoverUusuario.setText("Remover USUÁRIO");
        mbRemoverUusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbRemoverUusuarioActionPerformed(evt);
            }
        });

        mcPesquisarUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Título" }));
        mcPesquisarUsuario.setAccent(new java.awt.Color(73, 136, 137));

        mbPesquisarUsuario.setBackground(new java.awt.Color(73, 136, 137));
        mbPesquisarUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mbPesquisarUsuario.setText("Pesquisar");
        mbPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbPesquisarUsuarioActionPerformed(evt);
            }
        });

        tfPesquisaFilmes1.setLabel("Pesquisa");
        tfPesquisaFilmes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaFilmes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPesquisaFilmes1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mbCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUsuarioLayout.createSequentialGroup()
                                .addComponent(mcPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpUsuarioLayout.createSequentialGroup()
                                .addComponent(mbEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mbRemoverUusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mcPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPesquisaFilmes1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbRemoverUusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpPrincipalLayout.createSequentialGroup()
                    .addComponent(jpSessoes, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpPrincipalLayout.createSequentialGroup()
                    .addComponent(jpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpPrincipalLayout.createSequentialGroup()
                    .addComponent(jpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 271, Short.MAX_VALUE)))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1182, Short.MAX_VALUE)
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpSessoes, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                    .addComponent(jpFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PMainLayout = new javax.swing.GroupLayout(PMain);
        PMain.setLayout(PMainLayout);
        PMainLayout.setHorizontalGroup(
            PMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMainLayout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PMainLayout.setVerticalGroup(
            PMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMainLayout.createSequentialGroup()
                .addGroup(PMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PMain, javax.swing.GroupLayout.PREFERRED_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mbSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbSairKeyPressed
    }//GEN-LAST:event_mbSairKeyPressed

    private void mbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_mbSairActionPerformed

    private void mBHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBHomeActionPerformed
        this.atualizarCalendarioSessao();

        mbFilmes.setSelected(false);
        jpFilmes.setVisible(false);
        
        mbProdutos.setSelected(false);
        jpProdutos.setVisible(false);
        
        mbSessoes.setSelected(false);
        jpSessoes.setVisible(false);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mbUsuarios.setSelected(false);
        jpUsuario.setVisible(false);
        
        mBHome.setSelected(true);
        jpHome.setVisible(true);
    }//GEN-LAST:event_mBHomeActionPerformed

    private void mbVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbVendasActionPerformed
        // Validação inicial pra inteira e meia
        this.validarRegrasNegocioTipoIngresso();
        
        
        listaSessoes = controleSessao.findNotArquivada();
        cbSessaoVenda.removeAllItems();
        if(listaSessoes.size() > 0){
            for(Sessao s : listaSessoes){
                if (s.verificarAssentosDisponiveis().size() > 0){
                    cbSessaoVenda.addItem(s);
                }
            }
            if(cbSessaoVenda.getItemCount() > 0){
                cbSessaoVenda.setSelectedIndex(-1);

                this.venda = new Venda();

                mbFilmes.setSelected(false);
                jpFilmes.setVisible(false);

                mbProdutos.setSelected(false);
                jpProdutos.setVisible(false);

                mbSessoes.setSelected(false);
                jpSessoes.setVisible(false);

                mbVendas.setSelected(true);
                jpVenda.setVisible(true);

                mBHome.setSelected(false);
                jpHome.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Nenhuma sessão disponível!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma sessão disponível!");
            mbVendas.setSelected(false);
        }
    }//GEN-LAST:event_mbVendasActionPerformed

    private void mbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbProdutosActionPerformed
        mbFilmes.setSelected(false);
        jpFilmes.setVisible(false);
        
        mbProdutos.setSelected(true);
        jpProdutos.setVisible(true);
        
        mbSessoes.setSelected(false);
        jpSessoes.setVisible(false);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mbUsuarios.setSelected(false);
        jpUsuario.setVisible(false);
        
        mBHome.setSelected(false);
        jpHome.setVisible(false);     
                        
        this.listaItens = controleItem.findAll();
//        this.listaItens.forEach((i) -> {System.out.println(i);});
        atualizarProdutos();
    }//GEN-LAST:event_mbProdutosActionPerformed

    private void mbFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbFilmesActionPerformed
        mbProdutos.setSelected(false);
        jpProdutos.setVisible(false);
        
        mbSessoes.setSelected(false);
        jpSessoes.setVisible(false);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mBHome.setSelected(false);
        jpHome.setVisible(false);

        mbUsuarios.setSelected(false);
        jpUsuario.setVisible(false);
        
        mbFilmes.setSelected(true);
        jpFilmes.setVisible(true);
        
        this.listaFilmes = controleFilme.findAll();
        atualizarFilmes();
    }//GEN-LAST:event_mbFilmesActionPerformed

    private void mbSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbSessoesActionPerformed
        mbFilmes.setSelected(false);
        jpFilmes.setVisible(false);
        
        mbProdutos.setSelected(false);
        jpProdutos.setVisible(false);
        
        mbSessoes.setSelected(true);
        jpSessoes.setVisible(true);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mbUsuarios.setSelected(false);
        jpUsuario.setVisible(false);
        
        mBHome.setSelected(false);
        jpHome.setVisible(false); 
        
        this.listaSessoes = controleSessao.findAll();
        atualizarSessoes();
    }//GEN-LAST:event_mbSessoesActionPerformed

    private void mbCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarProdutoActionPerformed
        CadastroProduto cp = new CadastroProduto(this, true);
        cp.setModal(true);
        cp.setVisible(true);
        this.listaItens = controleItem.findAll();
        atualizarProdutos();
    }//GEN-LAST:event_mbCadastrarProdutoActionPerformed

    private void mbEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbEditarProdutoActionPerformed
        int row = tbItems.getSelectedRow();
        
        if(row > -1){
            Integer cod = null;
            cod = (Integer) tbItems.getValueAt(row, 0);
            //System.out.println(cod);
            if(cod != null){
                try{
                    Produto p = controleProduto.findByCodigo(cod);
                    CadastroProduto cp = new CadastroProduto(this, true);
                    cp.setSelecionado(p);
                    cp.setVisible(true);
                    this.listaItens = controleItem.findAll();
                    atualizarProdutos();
                }catch(NoResultException ex){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!");
        }
        
    }//GEN-LAST:event_mbEditarProdutoActionPerformed

    private void mbRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverProdutoActionPerformed
        int row = tbItems.getSelectedRow();
        
        if(row > -1){
            Integer cod = null;
            cod = (Integer) tbItems.getValueAt(row, 0);
            //System.out.println(cod);
            if(cod != null){
                try{
                    Produto p = controleProduto.findByCodigo(cod);
                    if(p.getEstoque() == 0){
                        controleProduto.remove(p);
                        JOptionPane.showMessageDialog(null, "Produto removido!");
                        this.listaItens = controleItem.findAll();
                        atualizarProdutos();
                    }else{
                        JOptionPane.showMessageDialog(null, "Para remover o produto ele não deve ter estoque!");
                    }
                }catch(NoResultException ex){
                    JOptionPane.showMessageDialog(null, "Produto não encontrado");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!");
        }
    }//GEN-LAST:event_mbRemoverProdutoActionPerformed

    private void mbPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbPesquisarProdutosActionPerformed
        //System.out.println(mCPesquisaProduto.getSelectedIndex());
        if(tfPesquisaProduto.getText().isEmpty()){
            this.listaItens = controleItem.findAll();
                atualizarProdutos();
        }else{
            switch(mCPesquisaProduto.getSelectedIndex()){
                case -1:
                    this.listaItens = controleItem.findAll();
                    atualizarProdutos();
                    break;
                case 0:
                    try{
                        Integer codigo = Integer.parseInt(tfPesquisaProduto.getText());
                        try{
                            Item i = controleItem.findByCodigo(codigo);
                            this.listaItens.clear();
                            this.listaItens.add(i);   
                            atualizarProdutos();
                        }catch(NoResultException ex){
                            JOptionPane.showMessageDialog(null, "Nenhum resultado com esse código!");
                        }
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Digite apenas número para pesquisar por código");
                    }
                    break;
                case 1:
                    try{
                        this.listaItens = controleItem.findByDesc(tfPesquisaProduto.getText().trim());
                        atualizarProdutos();
                    }catch(NoResultException ex){
                        JOptionPane.showMessageDialog(null, "Nenhum resultado com esse código!");
                    }
                    break;
            }
        }
    }//GEN-LAST:event_mbPesquisarProdutosActionPerformed

    private void mCPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCPesquisaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCPesquisaProdutoActionPerformed

    private void mbCadastrarSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarSessoesActionPerformed
        CadastrarSessao cs = new CadastrarSessao(this, true);
        cs.setModal(true);
        cs.setVisible(true);
        this.listaSessoes = controleSessao.findAll();
        atualizarSessoes();
    }//GEN-LAST:event_mbCadastrarSessoesActionPerformed

    private void mbEditarSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbEditarSessoesActionPerformed
        int row = tbSessoes.getSelectedRow();
        if(row > -1){
            Integer cod = (Integer) tbSessoes.getValueAt(row, 0);
            Sessao s = controleSessao.findByCodigo(cod);
            if(!s.isArquivada()){
                //System.out.println("OI");
                CadastrarSessao cs = new CadastrarSessao(this, true);
                cs.setModal(true);
                cs.setSelecionado(s);
                cs.setVisible(true);
                this.listaSessoes = controleSessao.findAll();
                atualizarSessoes();
            }else{
                JOptionPane.showMessageDialog(null, "Não é possivel editar sessões arquivadas!");
            }
        }
        
    }//GEN-LAST:event_mbEditarSessoesActionPerformed

    private void mbRemoverSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverSessoesActionPerformed
        int row = tbSessoes.getSelectedRow();
        
        if(row > -1){
            Integer cod = null;
            cod = (Integer) tbSessoes.getValueAt(row, 0);
            try{
                Sessao s = controleSessao.findByCodigo(cod);
                if(!s.isArquivada()){
                    try{
                        controleSessao.remove(s);
                        JOptionPane.showMessageDialog(null, "Sessão removida!");
                        this.listaSessoes = controleSessao.findAll();
                        atualizarSessoes();
                    }catch(RollbackException ex){
                        JOptionPane.showMessageDialog(null, "Não é possivel remover ume sessão que possui ingressos!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Não é possivel remover uma sesão arquivada");
                }
            }catch(NoResultException ex){
                JOptionPane.showMessageDialog(null, "Sessão não encontrada");
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma sessão a remover na tabela");
        }
    }//GEN-LAST:event_mbRemoverSessoesActionPerformed

    private void mbPesquisarSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbPesquisarSessoesActionPerformed
        if(tfPesquisaSessoes.getText().isEmpty()){
            this.listaSessoes = controleSessao.findAll();
            atualizarSessoes();
        }else{
            int select = mCPesquisaSessoes.getSelectedIndex();
            if(select > -1){
                if(select == 0){
                    try{
                        Integer codigo = Integer.parseInt(tfPesquisaSessoes.getText().trim());
                        Sessao s = controleSessao.findByCodigo(codigo);
                        this.listaSessoes.clear();
                        this.listaSessoes.add(s);
                        atualizarSessoes();
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Utilize apenas números na busca por código");
                    }catch(NoResultException ex){
                        JOptionPane.showMessageDialog(null, "Código não encontrado");
                    }
                }else if(select == 1){
                    String filme = tfPesquisaSessoes.getText().trim();
                    this.listaSessoes = controleSessao.findByTitulo(filme);
                    atualizarSessoes();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um filtro pra pesquisa");
            }
        }
    }//GEN-LAST:event_mbPesquisarSessoesActionPerformed

    private void mbCadastrarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarFilmesActionPerformed
        CadastroFilme cadastroFilme = new CadastroFilme(this, true);
        cadastroFilme.setModal(true);
        cadastroFilme.setVisible(true);
        this.listaFilmes = controleFilme.findAll();
        atualizarFilmes();
    }//GEN-LAST:event_mbCadastrarFilmesActionPerformed

    private void mbEditarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbEditarFilmesActionPerformed
        int row = tbFilmes.getSelectedRow();
        if(row > -1){
            try{
                Integer codigo = (Integer) tbFilmes.getValueAt(row, 0);
                Filme f = controleFilme.findByCodigo(codigo);
                CadastroFilme cadastroFilme = new CadastroFilme(this, true);
                cadastroFilme.setModal(true);
                cadastroFilme.setSelecionado(f);
                cadastroFilme.setVisible(true);
                this.listaFilmes = controleFilme.findAll();
                atualizarFilmes();
            }catch(NoResultException ex){
                JOptionPane.showMessageDialog(null, "Filme não encontrado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um filme na tabela para editar");
        }   
    }//GEN-LAST:event_mbEditarFilmesActionPerformed

    private void mbRemoverFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverFilmesActionPerformed
        int row = tbFilmes.getSelectedRow();
        if(row > -1){
            try{
                Integer codigo = (Integer) tbFilmes.getValueAt(row, 0);
                Filme f = controleFilme.findByCodigo(codigo);                
                controleFilme.remove(f);
                this.listaFilmes = controleFilme.findAll();
                atualizarFilmes();
                JOptionPane.showMessageDialog(null, "Filme removido");
            }catch(NoResultException ex){
                JOptionPane.showMessageDialog(null, "Filme não encontrado!");
            }catch(RollbackException ex){
                JOptionPane.showMessageDialog(null, "Não é possivel remover esse filme");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selelcione um filme para remover");
        }
    }//GEN-LAST:event_mbRemoverFilmesActionPerformed

    private void mbPesquisarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbPesquisarFilmesActionPerformed
        int index = mcPesquisaFilmes.getSelectedIndex();
        System.out.println(index);
        if(index == -1 || tfPesquisaFilmes.getText().trim().isEmpty()){
            this.listaFilmes = controleFilme.findAll();
            atualizarFilmes();
        }else{
            switch(index){
                case 0:
                    Integer codigo = Integer.parseInt(tfPesquisaFilmes.getText().trim());
                    try{
                        Filme f = controleFilme.findByCodigo(codigo);
                        this.listaFilmes.clear();
                        this.listaFilmes.add(f);
                        atualizarFilmes();
                    }catch(NoResultException ex){
                        JOptionPane.showMessageDialog(null, "Nenhum filme encontrado com esse código");
                    }
                    break;
                case 1:
                    String pesquisa = tfPesquisaFilmes.getText().trim();
                    
                    this.listaFilmes = controleFilme.findByTitulo(pesquisa);
                    atualizarFilmes();
                    break;
            }
        }
    }//GEN-LAST:event_mbPesquisarFilmesActionPerformed

    private void mbGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbGerarRelatorioActionPerformed
        TelaRelatorio telaRelatorio = new TelaRelatorio(this, false);
        telaRelatorio.setVisible(true);
    }//GEN-LAST:event_mbGerarRelatorioActionPerformed

    private void mbMontarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbMontarProgramacaoActionPerformed
        MontarProgramacao mp = new MontarProgramacao(this, true);
        mp.setModal(true);
        mp.setVisible(true);
        this.listaSessoes = controleSessao.findAll();
        atualizarSessoes();
    }//GEN-LAST:event_mbMontarProgramacaoActionPerformed
    
    private void mbAdicionarIngressoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbAdicionarIngressoVendaActionPerformed
        Sessao s = (Sessao) cbSessaoVenda.getSelectedItem();
        if(s == null){
            JOptionPane.showMessageDialog(null, "Selecione uma sessão!");
        }else{
            AdicionarIngresso ai = new AdicionarIngresso(
                this, true, listaIngresso, s, this.venda
            );
            ai.setVisible(true);
            ai.setModal(true);
            this.atualizarTbIngressosVenda();
            
        }
    }//GEN-LAST:event_mbAdicionarIngressoVendaActionPerformed

    private void mbAdicionarIngressoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbAdicionarIngressoVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbAdicionarIngressoVendaKeyPressed

    private void mbAdicionarProdutoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbAdicionarProdutoVendaActionPerformed
        AdicionarItem ai = new AdicionarItem(
                this, true, listaItemVenda, this.venda
            );
            ai.setVisible(true);
            ai.setModal(true);
            this.atualizarTbItemVenda();
    }//GEN-LAST:event_mbAdicionarProdutoVendaActionPerformed

    private void mbAdicionarProdutoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbAdicionarProdutoVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbAdicionarProdutoVendaKeyPressed

    private void mbRemoverIngressoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverIngressoVendaActionPerformed
        int row = tbIngressosVenda.getSelectedRow();
        
        if(row > -1){
            listaIngresso.remove(row);
            this.atualizarTbIngressosVenda();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um ingresso na tabela!");
        }
    }//GEN-LAST:event_mbRemoverIngressoVendaActionPerformed

    private void mbRemoverIngressoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbRemoverIngressoVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbRemoverIngressoVendaKeyPressed

    private void mbRemoverProdutoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverProdutoVendaActionPerformed
        int row = tbItensVenda.getSelectedRow();
        
        if(row > -1){
            listaItemVenda.remove(row);
            this.atualizarTbItemVenda();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!");
        }
    }//GEN-LAST:event_mbRemoverProdutoVendaActionPerformed

    private void mbRemoverProdutoVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbRemoverProdutoVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbRemoverProdutoVendaKeyPressed

    private void mbGereciarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbGereciarSalasActionPerformed
        GerenciarSalas gs = new GerenciarSalas(this, true);
        gs.setModal(true);
        gs.setVisible(true);
    }//GEN-LAST:event_mbGereciarSalasActionPerformed

    private void cbSessaoVendaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSessaoVendaItemStateChanged
        this.listaIngresso.clear();
        this.atualizarTbIngressosVenda();
    }//GEN-LAST:event_cbSessaoVendaItemStateChanged

    private void mbEfetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbEfetuarVendaActionPerformed
        if(listaIngresso.isEmpty() && listaItemVenda.isEmpty())
            JOptionPane.showMessageDialog(null, "Adicione produtos ou ingressos!");
        else{
            if(!listaIngresso.isEmpty())
                this.venda.setIngressos(listaIngresso);
            if(!listaItemVenda.isEmpty())
                this.venda.setItens(listaItemVenda);
            this.venda.setVendedor(usuario);
            this.venda.setData(new Date());
            controleVenda.persist(venda);
            
            JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
            
            listaIngresso.clear();
            listaItemVenda.clear();
            listaSessoes = controleSessao.findNotArquivada();
            cbSessaoVenda.removeAllItems();
            if(listaSessoes.size() > 0){
                for(Sessao s : listaSessoes){
                    if (s.verificarAssentosDisponiveis().size() > 0){
                        cbSessaoVenda.addItem(s);
                    }
                }
                if(cbSessaoVenda.getItemCount() > 0){
                    this.atualizarTbIngressosVenda();
                    this.atualizarTbItemVenda();
                }else{
                    JOptionPane.showMessageDialog(null, "Não há mais sessões disponíveis!");  
                    mBHomeActionPerformed(evt);
                }
            }else{
                  JOptionPane.showMessageDialog(null, "Não há mais sessões disponíveis!");  
                  mBHomeActionPerformed(evt);
            }
            
        }
    }//GEN-LAST:event_mbEfetuarVendaActionPerformed

    private void mbEfetuarVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbEfetuarVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbEfetuarVendaKeyPressed

    private void tfPesquisaSessoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaSessoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaSessoesActionPerformed

    private void mbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbUsuariosActionPerformed
        mbFilmes.setSelected(false);
        jpFilmes.setVisible(false);
        
        mbProdutos.setSelected(false);
        jpProdutos.setVisible(false);
        
        mbSessoes.setSelected(false);
        jpSessoes.setVisible(false);
        
        mbVendas.setSelected(false);
        jpVenda.setVisible(false);
        
        mBHome.setSelected(false);
        jpHome.setVisible(false); 
        
        mbUsuarios.setSelected(true);
        jpUsuario.setVisible(true);
        
        this.listaUsuarios = controleUsuario.findAll();
        atualizarTabelaUsuario();
    }//GEN-LAST:event_mbUsuariosActionPerformed

    private void mbUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mbUsuariosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbUsuariosKeyPressed

    private void mbCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbCadastrarUsuarioActionPerformed

    private void mbEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbEditarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbEditarUsuarioActionPerformed

    private void mbRemoverUusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbRemoverUusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbRemoverUusuarioActionPerformed

    private void mbPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbPesquisarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbPesquisarUsuarioActionPerformed

    private void tfPesquisaFilmes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaFilmes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPesquisaFilmes1ActionPerformed

    private void mbArquivarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbArquivarSessaoActionPerformed
        int row = tbSessoes.getSelectedRow();
        
        if(row > -1){
            try{
                Integer cod = (Integer) tbSessoes.getValueAt(row, 0);
                Sessao s = controleSessao.findByCodigo(cod);
                if(s.isArquivada()){
                    JOptionPane.showMessageDialog(null, "Essa sessão ja está arquivada!");
                }else{
                    s.setArquivada(true);
                    controleSessao.merge(s);
                    JOptionPane.showMessageDialog(null, "Sessão arquivada com sucesso");
                    this.listaSessoes = controleSessao.findAll();
                    atualizarSessoes();
                }                
            }catch(NoResultException ex){
                JOptionPane.showMessageDialog(null, "Nenhuma sessão encontrada com esse código");
            }            
        }
    }//GEN-LAST:event_mbArquivarSessaoActionPerformed

    private void validarRegrasNegocioTipoIngresso(){
        double preco = 20;
        boolean valido;
        TipoIngresso tipo;
        try{
            controleTipoIngresso.findByNome("Inteira");
        }catch(NoResultException ex){
            JOptionPane.showMessageDialog(null, "Será necessário cadastrar um "
                    + "ingresso inteira antes de prosseguir\n");
            valido = false;
            while(!valido){
                try{
                    preco = Float.parseFloat(JOptionPane.showInputDialog("Insira o valor"));
                    if(preco > 0)
                        valido = true;
                    else
                        JOptionPane.showMessageDialog(null, "Valor invalido");
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(null, "Erro no valor");
                }
            }
            controleTipoIngresso.persist(new TipoIngresso("Inteira", preco));
        }
        try{
            controleTipoIngresso.findByNome("Meia");
        }catch(NoResultException ex){
            JOptionPane.showMessageDialog(null, "Será cadastrado um "
                    + "ingresso meia com 50% de desconto da inteira!\n");
            tipo = controleTipoIngresso.findByNome("Inteira");
            preco = tipo.getValor() / 2;
            controleTipoIngresso.persist(new TipoIngresso("Meia", preco));
        }
    }
    
    private void atualizarTbIngressosVenda(){
        DefaultTableModel model = (DefaultTableModel) tbIngressosVenda.getModel();
        model.setRowCount(0);
        for(Ingresso i : listaIngresso){
            model.addRow(new Object[]{
                i.getAssento().getCodigo(),
                i.getTipo().getDescricao(),
                i.getPreco()
            });
        }
    }
    
    private void atualizarTbItemVenda(){
        DefaultTableModel model = (DefaultTableModel) tbItensVenda.getModel();
        model.setRowCount(0);
        for(ItemVenda iv : listaItemVenda){
            model.addRow(new Object[]{
                iv.getItem().getDescricao(),
                Double.toString(iv.getValorUnitario()),
                Integer.toString(iv.getQuantidade()),
                Double.toString(iv.getValorUnitario() * iv.getQuantidade())
            });
        }
    }
    
    public void atualizarProdutos(){        
        DefaultTableModel modelo = (DefaultTableModel) tbItems.getModel();
        modelo.setNumRows(0);
        for(Item i: this.listaItens){
            if(i instanceof Produto){
                //System.out.println(i);
                modelo.addRow(new Object[] {i.getCodigo(), i.getDescricao(), i.getPreco(), ((Produto) i).getEstoque()});
            }else if(i instanceof Combo){
                modelo.addRow(new Object[] {i.getCodigo(), i.getDescricao(), i.getPreco(), null});
            }
        }
    }
    
    public void atualizarFilmes(){
        DefaultTableModel modelo = (DefaultTableModel) tbFilmes.getModel();
        modelo.setNumRows(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Filme f: this.listaFilmes){
            //System.out.println(f);
            modelo.addRow(new Object[] {f.getCodigo(), f.getTitulo(), f.getIdadeMinima(), sdf.format(f.getDataEstreia()), f.getDuracao(), f.getDirecao()});
        }
    }
    
    public void atualizarSessoes(){
        DefaultTableModel modelo = (DefaultTableModel) tbSessoes.getModel();
        modelo.setNumRows(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String arquivada;
        for(Sessao s: this.listaSessoes){
            if(s.isArquivada())
                arquivada = "Sim";
            else
                arquivada = "Não";
            modelo.addRow(new Object[] {s.getCodigo(), s.getFilme().getTitulo(), s.getSala().getCodigo(), 
                sdf.format(s.getDataInicio()), sdf2.format(s.getDataInicio()), arquivada });
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PMain;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox cbSessaoVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpFilmes;
    private javax.swing.JPanel jpHome;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpProdutos;
    private javax.swing.JPanel jpSessoes;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JPanel jpVenda;
    private javax.swing.JLabel lbBoasVindas;
    private javax.swing.JLabel lbBoasVindas1;
    private javax.swing.JLabel lbBoasVindas2;
    private javax.swing.JLabel lbCalendario;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbSessaoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mBHome;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mCPesquisaProduto;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mCPesquisaSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbAdicionarIngressoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbAdicionarProdutoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbArquivarSessao;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrarFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrarProduto;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrarSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbCadastrarUsuario;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbEditarFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbEditarProduto;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbEditarSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbEditarUsuario;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbEfetuarVenda;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbGerarRelatorio;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbGereciarSalas;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbMontarProgramacao;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbPesquisarFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbPesquisarProdutos;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbPesquisarSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbPesquisarUsuario;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbProdutos;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbRemoverFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbRemoverIngressoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbRemoverProduto;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbRemoverProdutoVenda;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbRemoverSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MButton mbRemoverUusuario;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbSair;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbSessoes;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbUsuarios;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton mbVendas;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mcPesquisaFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MComboBox mcPesquisarUsuario;
    private javax.swing.JTable tbCalendarioSessao;
    private javax.swing.JTable tbFilmes;
    private javax.swing.JTable tbIngressosVenda;
    private javax.swing.JTable tbItems;
    private javax.swing.JTable tbItensVenda;
    private javax.swing.JTable tbSessoes;
    private javax.swing.JTable tbUsuario;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfPesquisaFilmes;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfPesquisaFilmes1;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfPesquisaProduto;
    private com.hq.swingmaterialdesign.materialdesign.MTextField tfPesquisaSessoes;
    // End of variables declaration//GEN-END:variables
}
