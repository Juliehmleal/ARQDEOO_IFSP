/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda_Ingresso.ui;

import Venda_Ingresso.entities.Ingresso;
import Venda_Ingresso.services.GerenciadorIngresso;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junior
 */
public class JanelaGrafica extends JDialog {

    private JTable tabela;
    private DefaultTableModel modelo;

    public JanelaGrafica(){

        modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Setor");
        modelo.addColumn("Qtd");
        modelo.addColumn("Valor");
        modelo.addColumn("Total");
        modelo.addColumn("Data");

        tabela = new JTable(modelo);

        add(new JScrollPane(tabela));

        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void imprimirRelatorio(ArrayList<Ingresso> ingressos){

        modelo.setRowCount(0);

        for(Ingresso i : ingressos){

            modelo.addRow(new Object[]{
                    i.getCodigo(),
                    i.getNome(),
                    i.getSetor(),
                    i.getQuantidade(),
                    i.getValor(),
                    i.getValorTotal(),
                    i.getDataHora()
            });
        }
    }
}
