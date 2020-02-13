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
public class Aluno {
    private int id_Aluno;
    private String nome;
    private int idade;

    public Aluno(int id_Aluno, String nome, int idade) {
        this.id_Aluno = id_Aluno;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId_Aluno() {
        return id_Aluno;
    }

    public void setId_Aluno(int id_Aluno) {
        this.id_Aluno = id_Aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    

    
    
     
}

