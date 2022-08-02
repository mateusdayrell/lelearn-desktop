/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.VideoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.VideoMODEL;

/**
 *
 * @author Italo
 */
public class FrmVideo extends javax.swing.JFrame {
    
    //Antigo CPF para editar
    private String antigoCod = "";
    
    public boolean verificarCampos(){
        if(txtCodigo.getText().replaceAll("[^0-9]", "").equals("") || 
           ((String) txtCurso.getSelectedItem()).equals("Selecione um curso") ||
           txtTitulo.getText().equals("") || txtLink.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Campo obgratório não preenchido detectado! \nPara prosseguir, preencha os seguintes campos:"
                                                                    + "\nCodigo, Curso, Título e Link."); 
                return false;
        }
        return true;
    }
    
    public boolean verificarChavePrimaria() {
        String codigo = txtCodigo.getText().replaceAll("[^0-9]", "");
        if("".equals(codigo)){
            JOptionPane.showMessageDialog(null, "Nenhum vídeo selecionado!");
            txtCodigo.setText(antigoCod);
            return false;
        }
        if(!codigo.equals(antigoCod)){
            JOptionPane.showMessageDialog(null, "O código do vídeo não pode ser modificado!");
            txtCodigo.setText(antigoCod);
            return false;
        }
        else{
            return true;
        }
    }
    
    //Metodo listar tabela
    public void listar() {
        VideoDAO dao = new VideoDAO();
        
        List<VideoMODEL> lista = dao.ListarVideos();
        DefaultTableModel dados = (DefaultTableModel) tabelaVideos.getModel();
        
        dados.setNumRows(0); //limpar dados da tabela
        
        //inserir dados da lista na tabela
        for(VideoMODEL u: lista) {
            System.out.println("listar()" + u.getNomeCurso());
            dados.addRow(new Object[]{
                u.getCOD_VIDEO(),
                u.getNomeCurso(),  
                u.getTITULO_VIDEO(),
                u.getDESC_VIDEO(),
                u.getLINK(),
            });
        }        
    }
    
    public void LimparAbaConsulta(){
        txtPesqCodigo.setText("");
        txtPesqTitulo.setText("");
    }
    
    public void limparAbaDados(){
        txtCodigo.setText("");
        txtCurso.setSelectedItem("Selecione um curso");
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtLink.setText("");
    }

    /**
     * Creates new form fmrVideo
     */
    public FrmVideo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtPesqTitulo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVideos = new javax.swing.JTable();
        txtPesqCodigo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtCurso = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(94, 23, 235));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/video-camera-64.png"))); // NOI18N
        jLabel1.setText("Videos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel14.setText("Codigo: ");

        txtPesqTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqTituloActionPerformed(evt);
            }
        });
        txtPesqTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqTituloKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel15.setText("Titulo :");

        btnPesquisar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar-16.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tabelaVideos.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabelaVideos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "CURSO", "TITULO", "DESCRICAO", "LINK"
            }
        ));
        tabelaVideos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVideosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVideos);
        if (tabelaVideos.getColumnModel().getColumnCount() > 0) {
            tabelaVideos.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabelaVideos.getColumnModel().getColumn(0).setMaxWidth(35);
            tabelaVideos.getColumnModel().getColumn(1).setMinWidth(120);
        }

        txtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqCodigoActionPerformed(evt);
            }
        });
        txtPesqCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqCodigoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(8, 8, 8)
                        .addComponent(txtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(txtPesqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Código:");

        jLabel3.setText("Curso:");

        jLabel4.setText("Título:");

        jLabel5.setText("Descrição:");

        jLabel9.setText("Link:");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLinkActionPerformed(evt);
            }
        });

        try {
            txtCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        txtCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um curso", "0001 | Desenvolvimento web básico", "0002 | Curso completo NodeJS", "0003 | Curso React Native", "0004 | Curso Laravel", "0005 | Curso CSS avançado" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLink)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                            .addComponent(txtTitulo))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel5))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados", jPanel3);

        btnCadastrar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastrar-24.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apagar-24.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar-24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limpar-24.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Consulta");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesqTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqTituloActionPerformed
    
    
    //botao pesquisar
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String cod = "%" + txtPesqCodigo.getText().replaceAll("[^0-9]", "") + "%";
        String titulo = "%" + txtPesqTitulo.getText() + "%";
        
        VideoDAO dao = new VideoDAO();
        
        List<VideoMODEL> lista = null; 
        
        if("%%".equals(cod)){
            lista = dao.buscarPorTitulo(titulo);
        } else {
            txtPesqTitulo.setText("");
            lista = dao.buscarPorCod(cod);
        }
        
        DefaultTableModel dados = (DefaultTableModel) tabelaVideos.getModel();
        
        dados.setNumRows(0); //limpar dados da tabela
     
        //inserir dados da lista na tabela
        for(VideoMODEL u: lista) {
            dados.addRow(new Object[]{
                u.getCOD_VIDEO(),
                u.getCOD_CURSO(),
                u.getTITULO_VIDEO(),
                u.getDESC_VIDEO(),
                u.getLINK()
                
            });
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    //botao salvar
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            Integer tela = jTabbedPane1.getSelectedIndex();
            
            if(tela.equals(1)){
                if(verificarCampos()){
                    VideoMODEL obj = new VideoMODEL();
            
                    obj.setCOD_VIDEO(txtCodigo.getText());
                    obj.setCOD_CURSO(((String) txtCurso.getSelectedItem()).substring(0,4));
                    obj.setTITULO_VIDEO(txtTitulo.getText());
                    obj.setDESC_VIDEO(txtDescricao.getText());
                    obj.setLINK(txtLink.getText());


                    VideoDAO dao = new VideoDAO();
                    dao.cadastrarVideo(obj);
                    limparAbaDados();
                }
            } else {
                jTabbedPane1.setSelectedIndex(1);
            }      
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    //botao excluir
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            Integer tela = jTabbedPane1.getSelectedIndex();
            if(tela.equals(1)){
                if(!txtCodigo.getText().replaceAll("[^0-9]", "").equals("")) {
                    VideoMODEL obj = new VideoMODEL();

                    VideoDAO dao = new VideoDAO();
                    dao.excluirVideo(obj);
                    limparAbaDados();
                } else {
                    JOptionPane.showMessageDialog(null, "Para excluir um vídeo você deve informar o seu código no campo CÓDIGO!");
                }  
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum vídeo selecionado!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    //botao editar
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            Integer tela = jTabbedPane1.getSelectedIndex();
            
            if(tela.equals(1)){
                if(verificarCampos()){
                    if(verificarChavePrimaria()){
                        VideoMODEL obj = new VideoMODEL();
            
                        obj.setCOD_VIDEO(txtCodigo.getText());
                        obj.setCOD_CURSO(((String) txtCurso.getSelectedItem()).substring(0,4));
                        obj.setTITULO_VIDEO(txtTitulo.getText());
                        obj.setDESC_VIDEO(txtDescricao.getText());
                        obj.setLINK(txtLink.getText());

                        VideoDAO dao = new VideoDAO();
                        dao.editarVideo(obj);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum vídeo selecionado!");
            }
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparAbaDados();
        LimparAbaConsulta();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Carregar Lista
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void tabelaVideosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVideosMouseClicked
        //Seleciona os dados da tabela e envia para aba de "DADOS"
        jTabbedPane1.setSelectedIndex(1);
        
        antigoCod = tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 0).toString();
        
        txtCodigo.setText(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 0).toString());
//        txtCurso.setText(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 1).toString());
        txtTitulo.setText(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 2).toString());
        txtDescricao.setText(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 3).toString());
        txtLink.setText(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 4).toString());
        
        txtCurso.setSelectedItem(tabelaVideos.getValueAt(tabelaVideos.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tabelaVideosMouseClicked

    private void txtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqCodigoActionPerformed

    private void txtPesqCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqCodigoKeyPressed
        String cod = "%" + txtPesqCodigo.getText().replaceAll("[^0-9]", "") + "%";
                
        VideoDAO dao = new VideoDAO();
        
        List<VideoMODEL> lista = null; 
        
        lista = dao.buscarPorCod(cod);
        
        DefaultTableModel dados = (DefaultTableModel) tabelaVideos.getModel();
        
        dados.setNumRows(0); //limpar dados da tabela
     
        //inserir dados da lista na tabela
        for(VideoMODEL u: lista) {
            dados.addRow(new Object[]{
                u.getCOD_VIDEO(),
                u.getCOD_CURSO(),
                u.getTITULO_VIDEO(),
                u.getDESC_VIDEO(),
                u.getLINK()
            });
        }
    }//GEN-LAST:event_txtPesqCodigoKeyPressed

    private void txtPesqTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqTituloKeyPressed
        String titulo = "%" + txtPesqTitulo.getText() + "%";
        
        VideoDAO dao = new VideoDAO();
        
        List<VideoMODEL> lista = null; 
        
        lista = dao.buscarPorTitulo(titulo);
        
        DefaultTableModel dados = (DefaultTableModel) tabelaVideos.getModel();
        
        dados.setNumRows(0); //limpar dados da tabela
     
        //inserir dados da lista na tabela
        for(VideoMODEL u: lista) {
            dados.addRow(new Object[]{
                u.getCOD_VIDEO(),
                u.getCOD_CURSO(),
                u.getTITULO_VIDEO(),
                u.getDESC_VIDEO(),
                u.getLINK()
            });
        }
    }//GEN-LAST:event_txtPesqTituloKeyPressed

    private void txtLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLinkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVideo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabelaVideos;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JComboBox<String> txtCurso;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtPesqCodigo;
    private javax.swing.JTextField txtPesqTitulo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
