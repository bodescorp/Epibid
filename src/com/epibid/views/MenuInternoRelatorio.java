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
public class MenuInternoRelatorio extends javax.swing.JInternalFrame {
    Connection conectando;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * Creates new form MenuInternoRelatorio
     */
    public MenuInternoRelatorio(int bolsista) throws ClassNotFoundException, SQLException {
        initComponents();
        conectando = Conexao.conectaBD(); 
        user.setText(Integer.toString(bolsista));
        ListagemRelatorios(bolsista);
        
    }
    
    public void ListagemRelatorios(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Select * from Relatorio where bolsista = "+bolsista;
        try{
            pst = conectando.prepareStatement(sql);
            rs = pst.executeQuery();
           listagemRelatorios.setModel(DbUtils.resultSetToTableModel(rs));   
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    public void cadrastarRelatorio(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Insert into Relatorio (Nome,Atividades,Resultados,Bolsista) values(?,?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtNome.getText());
            pst.setString (2,txtTrabalhos.getText());
            pst.setString (3,txtResultados.getText());
            pst.setInt (4,bolsista);
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
             ListagemRelatorios(bolsista);           
            limparCampos();
           
        }
        
        catch (SQLException error) {
            
            
            JOptionPane.showMessageDialog(null,error);
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null,"Campo Obrigatorio vazio");
    }
            
    }
    public void PesquisarRelatorio(int bolsista){
        String sql = "Select * from Relatorio where nome like ? and bolsista = "+bolsista;
        
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtBuscar.getText()+"%");
            listagemRelatorios.setModel(DbUtils.resultSetToTableModel(rs));
            rs = pst.executeQuery();
            
           
        }
        
        catch (SQLException error) {

            JOptionPane.showMessageDialog(null,error);
        }
    
    }
    
    public void MostrarItens(){
        int seleciona = listagemRelatorios.getSelectedRow();
        
        CodRelatorio.setText(listagemRelatorios.getModel().getValueAt(seleciona,0).toString());
        txtNome.setText(listagemRelatorios.getModel().getValueAt(seleciona,1).toString());
        txtTrabalhos.setText(listagemRelatorios.getModel().getValueAt(seleciona,2).toString());
        txtResultados.setText(listagemRelatorios.getModel().getValueAt(seleciona,3).toString());
      
    }
    
    public void EditarRelatorio(int bolsista) throws SQLException, ClassNotFoundException{
        String sql = "Update Relatorio set  nome = ?, atividades = ?, resultados = ?  where id_relatorio = ?";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (4,Integer.parseInt(CodRelatorio.getText()));
            pst.setString (1,txtNome.getText());
            pst.setString (2,txtTrabalhos.getText());
            pst.setString (3,txtResultados.getText());
            
           
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Editado com Sucesso","Editado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemRelatorios(bolsista);
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
        String sql = "Delete from Relatorio where id_relatorio = ?";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setInt (1,Integer.parseInt(CodRelatorio.getText()));          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Eliminado com Sucesso","Eliminado com Sucesso",JOptionPane.INFORMATION_MESSAGE);
            ListagemRelatorios(bolsista);
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
        CodRelatorio.setText("");
        txtNome.setText("");
        txtTrabalhos.setText("");
        txtResultados.setText("");
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
        listagemRelatorios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTrabalhos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        cadrastoRelatorio = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        limparcampos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CodRelatorio = new javax.swing.JTextField();
        user = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatorios");

        listagemRelatorios.setModel(new javax.swing.table.DefaultTableModel(
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
        listagemRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listagemRelatoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listagemRelatorios);

        txtTrabalhos.setColumns(20);
        txtTrabalhos.setRows(5);
        jScrollPane2.setViewportView(txtTrabalhos);

        jLabel1.setText("Atividades");

        jLabel2.setText("Resultados: ");

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane3.setViewportView(txtResultados);

        cadrastoRelatorio.setText("Cadastrar");
        cadrastoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastoRelatorioActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        delete.setText("Deletar");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        limparcampos.setText("Limpar");
        limparcampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparcamposActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome: ");

        txtNome.setText(" ");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText(" Id Relatorio:");

        CodRelatorio.setBackground(new java.awt.Color(31, 12, 12));
        CodRelatorio.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cadrastoRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limparcampos)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(182, 182, 182))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)
                                    .addGap(3, 3, 3)
                                    .addComponent(txtNome))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CodRelatorio)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(user))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CodRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadrastoRelatorio)
                    .addComponent(editar)
                    .addComponent(delete)
                    .addComponent(limparcampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadrastoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastoRelatorioActionPerformed
        try {
            cadrastarRelatorio(Integer.parseInt(user.getText()));
        } catch (SQLException error) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, error);
        } catch (ClassNotFoundException error) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, error);
        }
    }//GEN-LAST:event_cadrastoRelatorioActionPerformed

    private void listagemRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listagemRelatoriosMouseClicked
        MostrarItens();
    }//GEN-LAST:event_listagemRelatoriosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        PesquisarRelatorio(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void limparcamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparcamposActionPerformed
      limparCampos();
    }//GEN-LAST:event_limparcamposActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            Delete(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        try {
            EditarRelatorio(Integer.parseInt(user.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PesquisarRelatorio(Integer.parseInt(user.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodRelatorio;
    private javax.swing.JButton cadrastoRelatorio;
    private javax.swing.JButton delete;
    private javax.swing.JButton editar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton limparcampos;
    private javax.swing.JTable listagemRelatorios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtResultados;
    private javax.swing.JTextArea txtTrabalhos;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
