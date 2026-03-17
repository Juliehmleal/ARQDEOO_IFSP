/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda_Ingresso.ui;

import Venda_Ingresso.services.GerenciadorArquivo;
import Venda_Ingresso.ui.JanelaGrafica;
import Venda_Ingresso.entities.Ingresso;
import Venda_Ingresso.services.GerenciadorIngresso;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Junior
 */
public class TelaInicial extends JDialog {

    private JButton btnComprar;
    private JButton btnRelatorio;

    private GerenciadorIngresso gerenciador;
    private GerenciadorArquivo arquivo;

    public TelaInicial(){

        gerenciador = new GerenciadorIngresso();
        arquivo = new GerenciadorArquivo();

        criarComponentes();
    }

    private void criarComponentes(){

        btnComprar = new JButton("Comprar Ingresso");
        btnRelatorio = new JButton("Gerar Relatório");

        btnComprar.addActionListener(e ->
                new JanelaCadastroIngresso(this,true,gerenciador));

        btnRelatorio.addActionListener(e -> {

            JanelaGrafica grafica = new JanelaGrafica();
            grafica.imprimirRelatorio(
                    (java.util.ArrayList) gerenciador.getIngressos());
        });

        JPanel painel = new JPanel();

        painel.add(btnComprar);
        painel.add(btnRelatorio);

        add(painel);

        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
