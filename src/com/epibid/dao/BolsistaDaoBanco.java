/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.dao;

import com.epibid.conexao.Conexao;
import com.epibid.model.Bolsista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author glay
 */
public class BolsistaDaoBanco implements BolsistaDao {
    
    private Conexao conexao;

    public BolsistaDaoBanco(){
        conexao = new Conexao();
    }


    @Override
    public boolean salvar(Bolsista bolsista) throws SQLException,ClassNotFoundException {
        try(Connection connection = Conexao.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO usuario(email, nome, nascimento, senha)" +
                    "VALUES (?,?,?,?)");
            pstmt.setString(1, bolsista.getEmail());
            pstmt.setString(2, bolsista.getNome());
            pstmt.setDate(3,
                    java.sql.Date.valueOf(bolsista.getNascimento()));
            pstmt.setString(4, bolsista.getSenha());

            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public Bolsista buscarPorEmail(String email) throws SQLException, ClassNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Bolsista> getBolsista() throws SQLException, ClassNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
