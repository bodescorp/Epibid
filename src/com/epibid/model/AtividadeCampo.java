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
public class AtividadeCampo {
    private int id_atividade;
    private Date data;
    private int hora;
    private String lugar;
    private String relato;

    public AtividadeCampo(int id_atividade, Date data, int hora, String lugar, String relato) {
        this.id_atividade = id_atividade;
        this.data = data;
        this.hora = hora;
        this.lugar = lugar;
        this.relato = relato;
    }

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    
    
    
    
}
