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
public class Foto {
    private int id_foto;
    private String nome;
    private Date data;

    public Foto(int id_foto, String nome, Date data) {
        this.id_foto = id_foto;
        this.nome = nome;
        this.data = data;
    }

    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
