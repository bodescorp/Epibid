/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.views;

import static java.awt.GridBagConstraints.BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.epibid.views.TelaLogin;
import java.sql.SQLException;

/**
 *
 * @author glay
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(int bolsista) {
        initComponents();
        Usertxt.setText(Integer.toString(bolsista));
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        planoFundo = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        Usertxt = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        diarioNovo = new javax.swing.JMenuItem();
        menuOficina = new javax.swing.JMenuItem();
        menuAtividade = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenuItem();
        menuTurma = new javax.swing.JMenuItem();
        Opcoes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Epibid");

        jLabel1.setText("User:");

        jMenuBar1.setName(""); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/application_home.png"))); // NOI18N
        jMenu1.setText("Menu");

        diarioNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        diarioNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epibid/Icones/book.png"))); // NOI18N
        diarioNovo.setText("Diario");
        diarioNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diarioNovoActionPerformed(evt);
            }
        });
        jMenu1.add(diarioNovo);

        menuOficina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuOficina.setText("Oficina");
        menuOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOficinaActionPerformed(evt);
            }
        });
        jMenu1.add(menuOficina);

        menuAtividade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAtividade.setText("Atividades de Campo");
        menuAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtividadeActionPerformed(evt);
            }
        });
        jMenu1.add(menuAtividade);

        menuRelatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuRelatorio.setText("Relatorio");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelatorio);

        menuTurma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuTurma.setText("Turma");
        menuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(menuTurma);

        jMenuBar1.add(jMenu1);

        Opcoes.setText("Opções");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_END, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Opcoes.add(jMenuItem2);

        jMenuBar1.add(Opcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planoFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planoFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void diarioNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diarioNovoActionPerformed
        
       MenuInternoDiario menuDiario = null;
        try {
            menuDiario = new MenuInternoDiario(Integer.parseInt(Usertxt.getText()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuDiario.setVisible(true);
        planoFundo.add(menuDiario);
        
    }//GEN-LAST:event_diarioNovoActionPerformed

    private void menuOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOficinaActionPerformed
        MenuInternoOficina menuOficina = null;
        try {
            menuOficina = new MenuInternoOficina(Integer.parseInt(Usertxt.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuOficina.setVisible(true);
        planoFundo.add(menuOficina);
        
                         
    }//GEN-LAST:event_menuOficinaActionPerformed

    private void menuAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtividadeActionPerformed
     MenuInternoAtividade menuAtividade = null;
        try {
            menuAtividade = new MenuInternoAtividade(Integer.parseInt(Usertxt.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
     menuAtividade.setVisible(true);
     
     planoFundo.add(menuAtividade);
    }//GEN-LAST:event_menuAtividadeActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        MenuInternoRelatorio menuRelatorio = null;
        try {
            menuRelatorio = new MenuInternoRelatorio(Integer.parseInt(Usertxt.getText()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuRelatorio.setVisible(true);
        planoFundo.add(menuRelatorio);
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void menuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTurmaActionPerformed
     MenuInternoTurmas menuTurma = null;
        try {
            menuTurma = new MenuInternoTurmas(Integer.parseInt(Usertxt.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
         menuTurma.setVisible(true);
           planoFundo.add(menuTurma);
    }//GEN-LAST:event_menuTurmaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Opcoes;
    private javax.swing.JLabel Usertxt;
    private javax.swing.JMenuItem diarioNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuAtividade;
    private javax.swing.JMenuItem menuOficina;
    private javax.swing.JMenuItem menuRelatorio;
    private javax.swing.JMenuItem menuTurma;
    private javax.swing.JDesktopPane planoFundo;
    // End of variables declaration//GEN-END:variables
}
