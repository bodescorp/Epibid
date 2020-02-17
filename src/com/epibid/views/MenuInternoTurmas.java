/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.views;

import com.epibid.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author glay
 */
public class MenuInternoTurmas extends javax.swing.JInternalFrame {
    Connection conectando;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form MenuInternoTurmas
     */
    public MenuInternoTurmas(int bolsista) throws SQLException, ClassNotFoundException {
        initComponents();
        conectando = Conexao.conectaBD();
        user.setText(Integer.toString(bolsista));
        ListagemTurma(bolsista);
        
    }
    
    public void ListagemTurma(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Select * from Turma where bolsista = "+bolsista+"order by id_Turma desc ";
        try{
            pst = conectando.prepareStatement(sql);         
            rs = pst.executeQuery();
            tableTurmas.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
            
        }
            
    }
    
    public void CadrastarTurma(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Turma (Nome,Supervisor,Bolsista) values(?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtNome.getText());
            pst.setString (2,txtSupervisor.getText());
            pst.setInt(3,bolsista);
            
            rs = pst.executeQuery();
            
           
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
             ListagemTurma(bolsista);
            JOptionPane.showMessageDialog(null,error);
        }
       
    
    }
    
    public void PesquisarTurma(int bolsista){
        String sql = "Select * from Turma where nome like ? and bolsista = "+bolsista;
        
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtBuscar.getText()+"%");
            tableTurmas.setModel(DbUtils.resultSetToTableModel(rs));
            rs = pst.executeQuery();
            
           
        }
        
        catch (SQLException error) {

            JOptionPane.showMessageDialog(null,error);
        }
    }
    
    public void MostrarItens(){
        int seleciona = tableTurmas.getSelectedRow();
        
        idTurma.setText( tableTurmas.getModel().getValueAt(seleciona,0).toString());
        txtNome.setText(tableTurmas.getModel().getValueAt(seleciona,1).toString());
        txtSupervisor.setText(tableTurmas.getModel().getValueAt(seleciona,2).toString());
    
    }
    
    public void EditarTurma(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Turma set  Nome= ? ,Supervisor = ?   where Id_Turma = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (3,Integer.parseInt(idTurma.getText()));
            pst.setString (1,txtNome.getText());
            pst.setString (2,txtSupervisor.getText());
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemTurma(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    
    public void Delete(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Delete from Turma where id_Turma = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(idTurma.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado com Sucesso","Eliminado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemTurma(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    
    public void DeleteAluno(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Delete from Aluno where id_Aluno = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(idAluno.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado com Sucesso","Eliminado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemTurma(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    
     public void EditarAluno(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Aluno set  Nome= ? ,Idade = ?   where Id_Aluno = ? ";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (3,Integer.parseInt(idAluno.getText()));
            pst.setString (1,txtNomeAluno.getText());
            pst.setInt (2,Integer.parseInt(idadeAluno.getText()));
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemAluno(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
     
    public void MostrarAluno(){
        int seleciona = tableAlunos.getSelectedRow();
        
        idAluno.setText( tableAlunos.getModel().getValueAt(seleciona,0).toString());
        txtNomeAluno.setText(tableAlunos.getModel().getValueAt(seleciona,1).toString());
        idadeAluno.setText(tableAlunos.getModel().getValueAt(seleciona,2).toString());
    
    }
    public void CadrastarAluno(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Aluno (Nome,Idade,Turma,Bolsista) values(?,?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtNomeAluno.getText());
            pst.setInt (2,Integer.parseInt(idadeAluno.getText()));
            pst.setInt (3,Integer.parseInt(idTurma.getText()));
            pst.setInt(4,bolsista);
            
            
            rs = pst.executeQuery();
            
           
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
             ListagemAluno(bolsista);
            JOptionPane.showMessageDialog(null,error);
        }
       
    
    }
    
    public void ListagemAluno(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "select * from aluno where  turma = ? and bolsista ="+bolsista;
        try{
            pst = conectando.prepareStatement(sql); 
            pst.setInt (1,Integer.parseInt(idTurma.getText()));
            rs = pst.executeQuery();
            tableAlunos.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
            
        }
            
    }
    
    
    
    
    public void limparCampos(){
        idTurma.setText("");
        txtNome.setText("");
        txtSupervisor.setText("");
        
    }
    public void limparCamposAlunos(){
        idAluno.setText("");
        txtNomeAluno.setText("");
        idadeAluno.setText("");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        user = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTurmas = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idTurma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSupervisor = new javax.swing.JTextField();
        cadrasto = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        limparTela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAlunos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cadrastoAluno = new javax.swing.JButton();
        editaraluno = new javax.swing.JButton();
        deleteAluno = new javax.swing.JButton();
        txtNomeAluno = new javax.swing.JTextField();
        idadeAluno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idAluno = new javax.swing.JTextField();
        limparaCamposAlunos = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Turmas");

        tableTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTurmas);

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Id Turma: ");

        idTurma.setBackground(new java.awt.Color(18, 4, 4));
        idTurma.setEnabled(false);

        jLabel2.setText("Nome Turma: ");

        jLabel3.setText("Supervisor: ");

        cadrasto.setText("Cadrasto");
        cadrasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastoActionPerformed(evt);
            }
        });

        editar.setText("Editar Turma");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        delete.setText("Delete Turma");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        limparTela.setText("Limpar");
        limparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparTelaActionPerformed(evt);
            }
        });

        tableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlunosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAlunos);

        jLabel4.setText("Alunos :");

        cadrastoAluno.setText("Cadastrar Aluno");
        cadrastoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastoAlunoActionPerformed(evt);
            }
        });

        editaraluno.setText("Editar Aluno");
        editaraluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaralunoActionPerformed(evt);
            }
        });

        deleteAluno.setText("Deletar Aluno");
        deleteAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAlunoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome Aluno: ");

        jLabel6.setText("Idade: ");

        jLabel7.setText("Id Aluno: ");

        idAluno.setBackground(new java.awt.Color(15, 3, 3));
        idAluno.setEnabled(false);

        limparaCamposAlunos.setText("Limpar");
        limparaCamposAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparaCamposAlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(user))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(limparTela))
                            .addComponent(txtSupervisor)
                            .addComponent(txtNome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cadrasto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(idAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadrastoAluno)
                    .addComponent(editaraluno)
                    .addComponent(deleteAluno)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(limparaCamposAlunos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cadrastoAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editaraluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteAluno))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(idAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limparaCamposAlunos))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(user))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limparTela))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar)
                            .addComponent(cadrasto)
                            .addComponent(delete))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        PesquisarTurma(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTurmasMouseClicked
       MostrarItens();
        try {
            ListagemAluno(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableTurmasMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        PesquisarTurma(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void limparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparTelaActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparTelaActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            Delete(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            EditarTurma(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void cadrastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastoActionPerformed
        try {
            CadrastarTurma(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadrastoActionPerformed

    private void tableAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlunosMouseClicked
     MostrarAluno();
    }//GEN-LAST:event_tableAlunosMouseClicked

    private void cadrastoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastoAlunoActionPerformed
        try {
            CadrastarAluno(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadrastoAlunoActionPerformed

    private void editaralunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaralunoActionPerformed
        try {
            EditarAluno(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editaralunoActionPerformed

    private void deleteAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAlunoActionPerformed
        try {
            DeleteAluno(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteAlunoActionPerformed

    private void limparaCamposAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparaCamposAlunosActionPerformed
        limparCamposAlunos();
    }//GEN-LAST:event_limparaCamposAlunosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton cadrasto;
    private javax.swing.JButton cadrastoAluno;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteAluno;
    private javax.swing.JButton editar;
    private javax.swing.JButton editaraluno;
    private javax.swing.JTextField idAluno;
    private javax.swing.JTextField idTurma;
    private javax.swing.JTextField idadeAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton limparTela;
    private javax.swing.JButton limparaCamposAlunos;
    private javax.swing.JTable tableAlunos;
    private javax.swing.JTable tableTurmas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtSupervisor;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
