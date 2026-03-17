package Venda_Ingresso.services;

public class CompradorRuannable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100); // aguarda 100 milissegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  Thread interrompida: " + Thread.currentThread().getName());
            return;
        }
    }
}
