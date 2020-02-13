/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.model;

import java.util.Objects;

/**
 *
 * @author glay
 */
public class Bolsista {
    private String nome;
    private String email;
    private String ies;
    private int matricula;
    private String endereco;
    private String escolaCampo;
    private String senha;
    private String senha2;

    public Bolsista(String nome, String email, String ies, int matricula, String endereco, String escolaCampo, String senha, String senha2) {
        this.nome = nome;
        this.email = email;
        this.ies = ies;
        this.matricula = matricula;
        this.endereco = endereco;
        this.escolaCampo = escolaCampo;
        this.senha = senha;
        this.senha2 = senha2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIes() {
        return ies;
    }

    public void setIes(String ies) {
        this.ies = ies;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEscolaCampo() {
        return escolaCampo;
    }

    public void setEscolaCampo(String escolaCampo) {
        this.escolaCampo = escolaCampo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    
    
}



