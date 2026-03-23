/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda_Ingresso.services;

import Venda_Ingresso.entities.Ingresso;
import Venda_Ingresso.exceptions.SetorEsgotadoException;
import Venda_Ingresso.enums.SetorEnum;


import java.util.ArrayList;
import java.util.List;

public class GerenciadorIngresso {

    private List<Ingresso> ingressos = new ArrayList<>();
    private int prox = 0;


    private static final int LIMITE_SETOR = 10;

    public synchronized boolean comprarIngresso(Ingresso ingresso){


        long totalSetor = ingressos.stream()
                .filter(i -> i.getSetor().equals(ingresso.getSetor()))
                .count();

        if(totalSetor >= SetorEnum.LIMITE_SETOR.getValor()){
            throw new SetorEsgotadoException("Setor esgotado");
        }



        ingresso.setCodigo(++prox);

        ingresso.setThreadOrigem(Thread.currentThread().getName());

        ingressos.add(ingresso);

        return true;
    }

    public List<Ingresso> getIngressos(){
        return ingressos;
    }

}

    
    
    
    

