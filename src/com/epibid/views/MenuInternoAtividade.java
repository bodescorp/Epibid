/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.views;
import  java.sql.*;
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
public class MenuInternoAtividade extends javax.swing.JInternalFrame {
    Connection conectando;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form MenuInternoAtividade
     */
    public MenuInternoAtividade(int bolsista) throws SQLException, ClassNotFoundException {
        initComponents();
        conectando = Conexao.conectaBD(); 
        user.setText(Integer.toString(bolsista));
        ListagemAtividades(bolsista);
    }
    
    public void ListagemAtividades(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Select * from Atividade  where bolsista = "+bolsista+ " order by cod_Atividade desc ";
        try{
            pst = conectando.prepareStatement(sql);
            rs = pst.executeQuery();
            listagemAtividade.setModel(DbUtils.resultSetToTableModel(rs)); 
            
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    public void cadrastarAtividade(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Atividade(data,nome,hora,lugar,relato,bolsista) values(?,?,?,?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtData.getText());
            pst.setString (2,txtNome.getText());
            pst.setString (3,txtCargaHoraria.getText());
            pst.setString (4,txtLocal.getText());
            pst.setString (5,txtRelato.getText());
            pst.setInt (6,bolsista);
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemAtividades(bolsista);
            limparCampos();
           
        }
        
        catch (SQLException error) {
            
            
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    public void PesquisarAtividade(int bolsista){
        String sql = "Select * from Atividade where nome like ? and bolsista = "+bolsista;
        
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtBuscar.getText()+"%");
            listagemAtividade.setModel(DbUtils.resultSetToTableModel(rs));
            rs = pst.executeQuery();
            
           
        }
        
        catch (SQLException error) {

            JOptionPane.showMessageDialog(null,error);
        }
    
    }
    
    public void MostrarItens(){
        int seleciona = listagemAtividade.getSelectedRow();
        
        txtCodAtividade.setText(listagemAtividade.getModel().getValueAt(seleciona,0).toString());
        txtData.setText(listagemAtividade.getModel().getValueAt(seleciona,2).toString());
        txtNome.setText(listagemAtividade.getModel().getValueAt(seleciona,1).toString());
        txtCargaHoraria.setText(listagemAtividade.getModel().getValueAt(seleciona,3).toString());
        txtLocal.setText(listagemAtividade.getModel().getValueAt(seleciona,4).toString());
        txtRelato.setText(listagemAtividade.getModel().getValueAt(seleciona,5).toString());
      
    }
    
    public void EditarAtividades(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Atividade set  data = ?, nome = ?, hora = ?, lugar = ?, relato = ?  where cod_atividade = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (6,Integer.parseInt(txtCodAtividade.getText()));
            pst.setString (1,txtData.getText());
            pst.setString (2,txtNome.getText());
            pst.setString (3,txtCargaHoraria.getText());
            pst.setString (4,txtLocal.getText());
            pst.setString (5,txtRelato.getText());
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemAtividades(bolsista);
            limparCampos();
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    public void Delete(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Delete from Atividade where cod_atividade = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(txtCodAtividade.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deletado com Sucesso","Deletado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemAtividades(bolsista);
            limparCampos();
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }catch(Exception error){
            JOptionPane.showMessageDialog(null,"Campo Obrigatorio vazio");
    }
        
    }
   
    public void limparCampos(){
        txtCodAtividade.setText("");
        txtData.setText("");
        txtNome.setText("");
        txtCargaHoraria.setText("");
        txtLocal.setText("");
        txtRelato.setText("");
    }
    
    
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listagemAtividade = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCadrastoAtividade = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRelato = new javax.swing.JTextArea();
        txtData = new javax.swing.JTextField();
        txtCargaHoraria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodAtividade = new javax.swing.JTextField();
        txtLocal = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        user = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Atividades");
        setToolTipText("");

        listagemAtividade.setModel(new javax.swing.table.DefaultTableModel(
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
        listagemAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagemAtividadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listagemAtividade);

        jLabel1.setText("Data: ");

        jLabel2.setText("Carga Horaria: ");

        jLabel3.setText("Local da Atividade: ");

        btnCadrastoAtividade.setText("Cadrasto");
        btnCadrastoAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadrastoAtividadeActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        limparCampos.setText("Limpar");
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposActionPerformed(evt);
            }
        });

        jLabel5.setText("Relato:");

        txtRelato.setColumns(20);
        txtRelato.setRows(5);
        jScrollPane2.setViewportView(txtRelato);

        jLabel4.setText("Cod_Atividade");

        txtCodAtividade.setBackground(new java.awt.Color(19, 7, 7));
        txtCodAtividade.setEnabled(false);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnCadrastoAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparCampos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodAtividade))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(user)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadrastoAtividade)
                    .addComponent(btnEditar)
                    .addComponent(btnDelete)
                    .addComponent(limparCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadrastoAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadrastoAtividadeActionPerformed
        try {
            cadrastarAtividade(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadrastoAtividadeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        PesquisarAtividade(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        PesquisarAtividade(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void listagemAtividadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagemAtividadeMouseClicked
    MostrarItens();
    }//GEN-LAST:event_listagemAtividadeMouseClicked

    private void limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposActionPerformed
     limparCampos();
    }//GEN-LAST:event_limparCamposActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            EditarAtividades(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Delete(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadrastoAtividade;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparCampos;
    private javax.swing.JTable listagemAtividade;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtCodAtividade;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtRelato;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
