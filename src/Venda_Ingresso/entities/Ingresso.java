package Venda_Ingresso.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ingresso implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nome;
    private String setor;
    private double valor;
    private int quantidade;
    private double valorTotal;
    private String dataHora;

    public Ingresso() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        if(quantidade <= 0){
            throw new RuntimeException("Quantidade inválida");
        }

        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {

        DateTimeFormatter formatterData =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        this.dataHora = formatterData.format(dataHora);
    }
}