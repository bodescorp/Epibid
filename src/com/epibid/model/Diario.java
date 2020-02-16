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
public class Diario {
    private Date data;
    private int numeracao;
    private String atividade;
    private String relato;

    public Diario(Date data, int numeracao, String atividade, String relato) {
        this.data = data;
        this.numeracao = numeracao;
        this.atividade = atividade;
        this.relato = relato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }
    
     
    
}
