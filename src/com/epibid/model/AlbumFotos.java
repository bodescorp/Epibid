/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.model;

import java.util.Date;

/**
 *
 * @author glay
 */
public class AlbumFotos {
    private String nome;
    private int id_album;
    private String atividade;

    public AlbumFotos(String nome, int id_album, String atividade) {
        this.nome = nome;
        this.id_album = id_album;
        this.atividade = atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    
    
}
