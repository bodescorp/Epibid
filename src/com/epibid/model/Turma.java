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
public class Turma {
    private int cod_turma;
    private String turma;
    private String supervisor;

    public Turma(int cod_turma, String turma, String supervisor) {
        this.cod_turma = cod_turma;
        this.turma = turma;
        this.supervisor = supervisor;
    }

    public int getCod_turma() {
        return cod_turma;
    }

    public void setCod_turma(int cod_turma) {
        this.cod_turma = cod_turma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    
}
