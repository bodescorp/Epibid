/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import com.epibid.model.Bolsista;

/**
 *
 * @author glay
 */
public interface BolsistaDao {
    boolean salvar(Bolsista bolsista) throws SQLException,
            ClassNotFoundException, IOException;
    Bolsista buscarPorEmail(String email) throws SQLException,
            ClassNotFoundException, IOException;
    Set<Bolsista> getBolsista() throws SQLException,
            ClassNotFoundException, IOException;

    
}
