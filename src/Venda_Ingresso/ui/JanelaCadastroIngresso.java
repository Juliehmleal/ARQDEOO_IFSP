/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venda_Ingresso.ui;

import Venda_Ingresso.services.GerenciadorIngresso;
import Venda_Ingresso.entities.Ingresso;
import Venda_Ingresso.enums.SetorEnum;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junior
 */
public class JanelaCadastroIngresso extends JDialog {

    private JTextField txtNome;
    private JTextField txtQtde;

    private JComboBox<String> cbxSetor;
    private JComboBox<String> cbxTipo;

    private GerenciadorIngresso gerenciador;

    public JanelaCadastroIngresso(JDialog parent,
                                  boolean modal,
                                  GerenciadorIngresso gerenciador){

        super(parent,modal);

        this.gerenciador = gerenciador;

        criarComponentes();
    }

    private void criarComponentes(){

        txtNome = new JTextField(10);
        txtQtde = new JTextField(5);

        cbxSetor = new JComboBox<>(new String[]{
                "Amarelo","Azul","Branco","Verde"});

        cbxTipo = new JComboBox<>(new String[]{
                "Inteira","Meia"});

        JButton salvar = new JButton("Salvar");

        salvar.addActionListener(e -> comprarIngresso());

        JPanel painel = new JPanel();

        painel.add(new JLabel("Nome:"));
        painel.add(txtNome);
        painel.add(new JLabel("Quantidade:"));
        painel.add(txtQtde);
        painel.add(cbxSetor);
        painel.add(cbxTipo);
        painel.add(salvar);

        add(painel);

        pack();
        setVisible(true);
    }

    private double CalcularMeia(double ValorIngresso)
    {
        return ValorIngresso/2;
    }

    private void comprarIngresso(){

        try{

            Ingresso ingresso = new Ingresso();

            ingresso.setNome(txtNome.getText());

            int qtd = Integer.parseInt(txtQtde.getText());

            ingresso.setQuantidade(qtd);

            String setorSelecionado =
                    cbxSetor.getSelectedItem().toString();

            SetorEnum setor =
                    SetorEnum.valueOf(setorSelecionado.toUpperCase());

            double valor = setor.getValor();

            if(cbxTipo.getSelectedItem().equals("Meia")){
                valor = CalcularMeia(valor);
            }

            ingresso.setSetor(setor.getNome());
            ingresso.setValor(valor);

            ingresso.setValorTotal(valor * qtd);

            ingresso.setDataHora(LocalDateTime.now());

            gerenciador.comprarIngresso(ingresso);

            JOptionPane.showMessageDialog(null,"Ingresso comprado!");

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(null,
                    "Digite apenas números na quantidade.");

        }
    }
}
