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
    public MenuInternoOficina() throws SQLException, ClassNotFoundException {
        initComponents();
        conectando = Conexao.conectaBD();   
        ListagemOficina();
    }
    
    public void ListagemOficina() throws SQLException, ClassNotFoundException{
        String sql = "Select * from Oficina ";
        try{
            pst = conectando.prepareStatement(sql);
            rs = pst.executeQuery();
            listagemOficina.setModel(DbUtils.resultSetToTableModel(rs)); 
            
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,error);
        }
            
    }
    
    public void cadrastarOficina() throws SQLException, ClassNotFoundException{
        String sql = "Insert into Oficina(Tema,Nome,Duracao,Relato,Bolsista) values(?,?,?,?,?)";
        try{
            pst = conectando.prepareStatement(sql);
            pst.setString (1,txtTema.getText());
            pst.setString (2,txtNome.getText());
            pst.setString (3,txtDuracao.getText());
            pst.setString (4,txtRelato.getText());
            pst.setInt (5,2001);
            
            rs = pst.executeQuery();
            
            
           
        }
        
        catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"Cadrasto com sucesso","Cadrasto com sucesso",JOptionPane.INFORMATION_MESSAGE);
             ListagemOficina();
            JOptionPane.showMessageDialog(null,error);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listagemOficina = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cadrastarOficina = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtCodOficina = new javax.swing.JTextField();
        txtTema = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRelato = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);

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
        listagemOficina.setEnabled(false);
        jScrollPane1.setViewportView(listagemOficina);

        jLabel1.setText("Cod_oficina");

        jLabel2.setText("Tema:");

        jLabel3.setText(" Nome: ");

        jLabel4.setText("Duranção: ");

        jLabel5.setText("Relato: ");

        cadrastarOficina.setText("Cadastrar");
        cadrastarOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadrastarOficinaActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");

        jButton3.setText("Deletar");

        jButton4.setText("Limpar");

        txtCodOficina.setBackground(new java.awt.Color(17, 5, 5));
        txtCodOficina.setEnabled(false);

        txtRelato.setColumns(20);
        txtRelato.setRows(5);
        jScrollPane2.setViewportView(txtRelato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadrastarOficina)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCodOficina, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTema, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadrastarOficina)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadrastarOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadrastarOficinaActionPerformed
        try {
            cadrastarOficina();
        } catch (SQLException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuInternoOficina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadrastarOficinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadrastarOficina;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listagemOficina;
    private javax.swing.JTextField txtCodOficina;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtRelato;
    private javax.swing.JTextField txtTema;
    // End of variables declaration//GEN-END:variables
}
