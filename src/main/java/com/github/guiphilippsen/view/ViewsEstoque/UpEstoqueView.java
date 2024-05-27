package com.github.guiphilippsen.view.ViewsEstoque;

import javax.swing.*;
import java.awt.*;

public class UpEstoqueView extends JFrame{
    private JTextField txtQtdEstoque;
    private JTextField txtValor;
    private JButton btnAddEstoque;

    public UpEstoqueView() {
        setTitle("Atualizar Produto Produto");
        setSize(300, 200);

        txtQtdEstoque = new JTextField(15);
        txtValor = new JTextField(15);
        btnAddEstoque = new JButton("Atualizar");

        setLayout(new FlowLayout());
        add(new JLabel("Quantidade:"));
        add(txtQtdEstoque);
        add(new JLabel("Valor: "));
        add(txtValor);
        add(btnAddEstoque);
    }

    public JTextField getTxtQtdEstoque() {
        return txtQtdEstoque;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public JButton getBtnAddEstoque() {
        return btnAddEstoque;
    }
}
