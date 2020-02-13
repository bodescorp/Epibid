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
public class Relatorio {
    private int cod_relatorio;
    private String atividades;
    private String resultados;

    public Relatorio(int cod_relatorio, String atividades, String resultados) {
        this.cod_relatorio = cod_relatorio;
        this.atividades = atividades;
        this.resultados = resultados;
    }

    public int getCod_relatorio() {
        return cod_relatorio;
    }

    public void setCod_relatorio(int cod_relatorio) {
        this.cod_relatorio = cod_relatorio;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    
    
}
