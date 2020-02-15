/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.conexao;

;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author glay
 */
public class Conexao {    
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static Connection conectaBD() throws ClassNotFoundException{

        try{
            Class.forName("org.postgresql.Driver");
            Connection conecta = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres","nada");
            return conecta;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null,error);
            
            return null;
        }
    }
        
} 