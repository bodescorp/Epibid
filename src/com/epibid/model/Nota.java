/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.model;

import com.epibid.modelenumm.BimestreType;

/**
 *
 * @author glay
 */
public class Nota {
    private int id_nota;
    private BimestreType bimestre;
    private int valor;

    public Nota(int id_nota, BimestreType bimestre, int valor) {
        this.id_nota = id_nota;
        this.bimestre = bimestre;
        this.valor = valor;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public BimestreType getBimestre() {
        return bimestre;
    }

    public void setBimestre(BimestreType bimestre) {
        this.bimestre = bimestre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}