/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.conexao;

;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author glay
 */
public class Conexao {    
    private String url;
    private String usuario;
    private String senha;

    
    public Conexao(){
        url = "jdbc:postgresql://localhost:5432";
        usuario = "postgres";
        senha = "nada";
    }
    
    public Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, usuario,senha);
    }
    
}
