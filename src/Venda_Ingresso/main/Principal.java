/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda_Ingresso.main;

import Venda_Ingresso.enums.SetorEnum;
import Venda_Ingresso.services.CompradorRunnable;
import Venda_Ingresso.services.GerenciadorArquivo;
import Venda_Ingresso.services.GerenciadorIngresso;
import Venda_Ingresso.ui.TelaInicial;

/**
 *
 * @author Junior
 */
public class Principal {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        TelaInicial telaInicial = new TelaInicial();

        GerenciadorIngresso gerenciador = new GerenciadorIngresso();

        Thread t1 = new Thread(
                new CompradorRunnable("Ana", SetorEnum.AMARELO, 2, gerenciador),
                "Thread-Ana");

        Thread t2 = new Thread(
                new CompradorRunnable("Bruno", SetorEnum.AZUL, 1, gerenciador),
                "Thread-Bruno");

        Thread t3 = new Thread(
                new CompradorRunnable("Carlos", SetorEnum.VERDE, 3, gerenciador),
                "Thread-Carlos");

        Thread t4 = new Thread(
                new CompradorRunnable("Diana", SetorEnum.BRANCO, 1, gerenciador),
                "Thread-Diana");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        GerenciadorArquivo arquivo = new GerenciadorArquivo();

        Thread salvamentoAutomatico = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {

                try {
                    Thread.sleep(500);

                    arquivo.serializar(
                            gerenciador.getIngressos(),
                            "ingressos.ser"
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        });

        salvamentoAutomatico.setDaemon(true);
        salvamentoAutomatico.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Todas as compras finalizadas.");
        salvamentoAutomatico.interrupt();
    }


    
}
