package Venda_Ingresso.services;

import Venda_Ingresso.entities.Ingresso;
import Venda_Ingresso.enums.SetorEnum;

public class CompradorRunnable implements Runnable {

    private String nomeComprador;
    private SetorEnum setor;
    private int quantidade;
    private GerenciadorIngresso gerenciador;

    public CompradorRunnable(String bruno, SetorEnum setorEnum, int i, GerenciadorIngresso gerenciador) {
    }

    public void CompradorRunnable(String nomeComprador, SetorEnum setor, int quantidade,
                                  GerenciadorIngresso gerenciador) {

        this.nomeComprador = nomeComprador;
        this.setor = setor;
        this.quantidade = quantidade;
        this.gerenciador = gerenciador;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100); // aguarda 100 milissegundos

            Ingresso ingresso = new Ingresso();
            gerenciador.comprarIngresso(ingresso);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  Thread interrompida: " + Thread.currentThread().getName());
            return;
        } catch (Exception e)
        {
            System.out.println("Erro na compra:" + e.getMessage());
        }
    }
}
