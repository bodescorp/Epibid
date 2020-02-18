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
public class MenuInternoDiario extends javax.swing.JInternalFrame {
    Connection conectando;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form MenuInternoDiario
     */
    public MenuInternoDiario(int bolsista) throws ClassNotFoundException, SQLException {
        initComponents();
        conectando = Conexao.conectaBD();
        user.setText(Integer.toString(bolsista));
        ListagemDiarios(bolsista);
    }
    
    public void ListagemDiarios(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Select * from Diario where bolsista = "+bolsista+"order by cod_Diario desc ";
        try{
            pst = conectando.prepareStatement(sql);         
            rs = pst.executeQuery();
            tableDiarios.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
            
        }
            
    }
    
    public void cadrastarDiario(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Diario(Data,Relato,Bolsista) values(?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txt_Data.getText());
            pst.setString (2,txt_Relato.getText());
            pst.setInt(3,bolsista);
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemDiarios(bolsista);
            limparCampos();
        }
        
        catch (SQLException error) {
            
             
            JOptionPane.showMessageDialog(null,error);
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Campo Obrigatorio vazio");
    }
            
    }
    public void PesquisarDiario(int bolsista){
        String sql = "Select * from Diario where data like ? and bolsista = "+bolsista;
        
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtBuscar.getText()+"%");
            tableDiarios.setModel(DbUtils.resultSetToTableModel(rs));
            rs = pst.executeQuery();
            
           
        }
        
        catch (SQLException error) {

            JOptionPane.showMessageDialog(null,error);
        }
    
    }
    
    public void MostrarItens(){
        int seleciona = tableDiarios.getSelectedRow();
        
        txtCodDiarios.setText( tableDiarios.getModel().getValueAt(seleciona,0).toString());
        txt_Data.setText(tableDiarios.getModel().getValueAt(seleciona,1).toString());
        txt_Relato.setText(tableDiarios.getModel().getValueAt(seleciona,2).toString());
      
    }
    
    public void EditarDiarios(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Diario set  Data= ? ,Relato = ?   where cod_diario = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (3,Integer.parseInt(txtCodDiarios.getText()));
            pst.setString (1,txt_Data.getText());
            pst.setString (2,txt_Relato.getText());
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemDiarios(bolsista);
           limparCampos();
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Campo Obrigatorio vazio");
    }
    }
    public void Delete(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Delete from Diario where cod_diario = ? and bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(txtCodDiarios.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado com Sucesso","Eliminado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemDiarios(bolsista);
           limparCampos();
        }
        
        catch (SQLException error) {
            
            
            
            JOptionPane.showMessageDialog(null,error);
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Campo Obrigatorio vazio");
    }
    }
   
    public void limparCampos(){
        txtCodDiarios.setText("");
        txt_Data.setText("");
        txt_Relato.setText("");
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDiarios = new javax.swing.JTable();
        cadrastoDiario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodDiarios = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        limparItens = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_Data = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Relato = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        user = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setClosable(true);
        setIconifiable(true);
        setTitle("Diarios");

        tableDiarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDiarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDiariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDiarios);

        cadrastoDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/book_add.png"))); // NOI18N
        cadrastoDiario.setText("Cadastrar");
        cadrastoDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastoDiarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        txtCodDiarios.setBackground(new java.awt.Color(18, 8, 8));
        txtCodDiarios.setEnabled(false);

        jLabel2.setText("Data: ");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/book_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/book_delete.png"))); // NOI18N
        delete.setText("Deletar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        limparItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/page_white_copy.png"))); // NOI18N
        limparItens.setText("Limpar");
        limparItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparItensActionPerformed(evt);
            }
        });

        jLabel4.setText("Relato:");

        txt_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        txt_Relato.setColumns(20);
        txt_Relato.setRows(5);
        jScrollPane2.setViewportView(txt_Relato);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cadrastoDiario)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(limparItens))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodDiarios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(user))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodDiarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadrastoDiario)
                    .addComponent(btnEditar)
                    .addComponent(delete)
                    .addComponent(limparItens))
                .addGap(8, 8, 8)
                .addComponent(user))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadrastoDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastoDiarioActionPerformed
        try {
            cadrastarDiario(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadrastoDiarioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            EditarDiarios(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            Delete(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void limparItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparItensActionPerformed
      limparCampos();
    }//GEN-LAST:event_limparItensActionPerformed

    private void tableDiariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDiariosMouseClicked
         MostrarItens();
    }//GEN-LAST:event_tableDiariosMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
       PesquisarDiario(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       PesquisarDiario(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton cadrastoDiario;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton limparItens;
    private javax.swing.JTable tableDiarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodDiarios;
    private javax.swing.JFormattedTextField txt_Data;
    private javax.swing.JTextArea txt_Relato;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
