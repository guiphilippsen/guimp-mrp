package com.github.guiphilippsen.view;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JButton btnViewClientes;
    private JButton btnViewEstoque;
    private JButton btnViewFuncionarios;

    public MainMenu(){
        setTitle("GUIMP-MRP");
        setSize(510, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);

        btnViewClientes = new JButton("Cadastro de Clientes");
        btnViewEstoque = new JButton("Visualizar Estoque");
        btnViewFuncionarios = new JButton("Cadastro de Funcionarios");

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(btnViewFuncionarios);
        add(btnViewClientes);
        add(btnViewEstoque);
    }

    public JButton getBtnViewClientes() {
        return btnViewClientes;
    }
    public JButton getBtnViewEstoque() {
        return btnViewEstoque;
    }

    public JButton getBtnViewFuncionarios() {
        return btnViewFuncionarios;
    }
}
