package com.github.guiphilippsen.view.ViewsEstoque;


import javax.swing.*;
import java.awt.*;

public class AddProductView extends JFrame {
    private JTextField txtNome;
    private JTextField txtQtdEstoque;
    private JTextField txtValor;
    private JButton btnAddEstoque;


    public AddProductView() {
        setTitle("Adicionar Produto");
        setSize(300, 200);

        txtNome = new JTextField(15);
        txtQtdEstoque = new JTextField(15);
        txtValor = new JTextField(15);
        btnAddEstoque = new JButton("Adicionar");

        setLayout(new FlowLayout());
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Quantidade:"));
        add(txtQtdEstoque);
        add(new JLabel("Valor: "));
        add(txtValor);
        add(btnAddEstoque);
    }

    public JTextField getTxtNome() {
        return txtNome;
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
