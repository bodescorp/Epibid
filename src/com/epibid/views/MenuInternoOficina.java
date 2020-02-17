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
public final class MenuInternoOficina extends javax.swing.JInternalFrame {
    Connection conectando;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form MenuInternoOficina
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public MenuInternoOficina(int bolsista) throws SQLException, ClassNotFoundException {
        initComponents();
        conectando = Conexao.conectaBD();
        user.setText(Integer.toString(bolsista));
        ListagemOficina(bolsista);
    }
    
    public void ListagemOficina(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Select * from Oficina  where bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            rs = pst.executeQuery();
            listagemOficina.setModel(DbUtils.resultSetToTableModel(rs)); 
            
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    
    public void cadrastarOficina(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Oficina(Tema,Nome,Duracao,Relato,Bolsista) values(?,?,?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtTema.getText());
            pst.setString (2,txtNome.getText());
            pst.setString (3,txtDuracao.getText());
            pst.setString (4,txtRelato.getText());
            pst.setInt (5,bolsista);
            
            rs = pst.executeQuery();
            
            
           
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
             ListagemOficina(bolsista);
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    public void PesquisarOficina(int bolsista){
        String sql = "Select * from Oficina where nome like ?and where bolsista = "+bolsista;
        
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtBuscar.getText()+"%");
            listagemOficina.setModel(DbUtils.resultSetToTableModel(rs));
            rs = pst.executeQuery();
            
           
        }
        
        catch (SQLException error) {

            JOptionPane.showMessageDialog(null,error);
        }
    
    }
    
    public void MostrarItens(){
        int seleciona = listagemOficina.getSelectedRow();
        
        txtCodOficina.setText(listagemOficina.getModel().getValueAt(seleciona,0).toString());
        txtTema.setText(listagemOficina.getModel().getValueAt(seleciona,1).toString());
        txtNome.setText(listagemOficina.getModel().getValueAt(seleciona,2).toString());
        txtDuracao.setText(listagemOficina.getModel().getValueAt(seleciona,3).toString());
        txtRelato.setText(listagemOficina.getModel().getValueAt(seleciona,4).toString());
      
    }
    
    public void EditarOficina(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Oficina set  Tema = ?, nome = ?, duracao = ?,  relato = ?  where cod_oficina = ? and bolsista = "+bolsista;      try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (5,Integer.parseInt(txtCodOficina.getText()));
            pst.setString (1,txtTema.getText());
            pst.setString (2,txtNome.getText());
            pst.setString (3,txtDuracao.getText());
            pst.setString (4,txtRelato.getText());
           
            
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
           ListagemOficina(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
    public void Delete(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Delete from Oficina where cod_oficina = ? and where bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(txtCodOficina.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Removido com Sucesso","Removido com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemOficina(bolsista);
           
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
    }
   
    public void limparCampos(){
        txtCodOficina.setText("");
        txtTema.setText("");
        txtNome.setText("");
        txtDuracao.setText("");
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
        listagemOficina = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        Deleete = new javax.swing.JButton();
        limparcampos = new javax.swing.JButton();
        txtCodOficina = new javax.swing.JTextField();
        txtTema = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRelato = new javax.swing.JTextArea();
        txtBuscar = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        cadrastarOficina = new javax.swing.JButton();
        user = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Oficina");

        listagemOficina.setModel(new javax.swing.table.DefaultTableModel(
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
        listagemOficina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagemOficinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listagemOficina);

        jLabel1.setText("Cod_oficina");

        jLabel2.setText("Tema:");

        jLabel3.setText(" Nome: ");

        jLabel4.setText("Duranção: ");

        jLabel5.setText("Relato: ");

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        Deleete.setText("Deletar");
        Deleete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleeteActionPerformed(evt);
            }
        });

        limparcampos.setText("Limpar");
        limparcampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparcamposActionPerformed(evt);
            }
        });

        txtCodOficina.setBackground(new java.awt.Color(17, 5, 5));
        txtCodOficina.setEnabled(false);

        txtRelato.setColumns(20);
        txtRelato.setRows(5);
        jScrollPane2.setViewportView(txtRelato);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        cadrastarOficina.setText("Cadastrar");
        cadrastarOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastarOficinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodOficina, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cadrastarOficina)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deleete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limparcampos)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(user))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limparcampos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edit)
                        .addComponent(Deleete)
                        .addComponent(cadrastarOficina)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(user))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listagemOficinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagemOficinaMouseClicked
        MostrarItens();
    }//GEN-LAST:event_listagemOficinaMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
     PesquisarOficina(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cadrastarOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastarOficinaActionPerformed
        try {
            cadrastarOficina(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadrastarOficinaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        PesquisarOficina(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_buscarActionPerformed

    private void limparcamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparcamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparcamposActionPerformed

    private void DeleeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleeteActionPerformed
        try {
            Delete(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleeteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            EditarOficina(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deleete;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cadrastarOficina;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limparcampos;
    private javax.swing.JTable listagemOficina;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodOficina;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtRelato;
    private javax.swing.JTextField txtTema;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
