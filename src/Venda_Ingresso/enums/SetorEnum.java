package Venda_Ingresso.enums;

public enum SetorEnum {

    AMARELO("Amarelo",180.0),
    AZUL("Azul",100.0),
    BRANCO("Branco",60.0),
    VERDE("Verde",350.0),
    LIMITE_SETOR("Limite_Setor",10);

    private String nome;
    private double valor;

    SetorEnum(String nome, double valor){
        this.nome = nome;
        this.valor = valor;

    }

    public String getNome(){
        return nome;
    }

    public double getValor(){
        return valor;
    }
}