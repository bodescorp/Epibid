/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epibid.modelenumm;

/**
 *
 * @author glay
 */
public enum BimestreType {
    
    bimestre1 ("1bimes")
    ,bimestre2 ("2bimes")
    ,bimestre3 ("3bimes")
    ,bimestre4 ("4bimes");
   
    private String descricao;
    
    private BimestreType(String descricao){
    
        this.descricao = descricao;
    
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
