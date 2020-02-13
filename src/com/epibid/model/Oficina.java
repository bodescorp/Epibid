/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.model;

/**
 *
 * @author glay
 */
public class Oficina {
    private int cod_oficina;
    private String Tema;
    private int duracao;
    private String nome;
    private String descricao;

    public Oficina(int cod_oficina, String Tema, int duracao, String nome, String descricao) {
        this.cod_oficina = cod_oficina;
        this.Tema = Tema;
        this.duracao = duracao;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCod_oficina() {
        return cod_oficina;
    }

    public void setCod_oficina(int cod_oficina) {
        this.cod_oficina = cod_oficina;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        
}
