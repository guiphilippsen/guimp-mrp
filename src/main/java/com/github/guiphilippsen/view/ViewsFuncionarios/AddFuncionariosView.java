package com.github.guiphilippsen.view.ViewsFuncionarios;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class AddFuncionariosView extends JFrame {
    private JTextField txtNome;
    private JPasswordField txtPassword;
    private JTextField txtCargo;
    private JDateChooser dateContratacao;
    private JButton btnAdd;

    public AddFuncionariosView() {
        super();
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        txtNome = new JTextField();
        txtPassword = new JPasswordField();
        txtCargo = new JTextField();
        dateContratacao = new JDateChooser();
        btnAdd = new JButton("Adicionar");

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Senha:"));
        add(txtPassword);
        add(new JLabel("Cargo:"));
        add(txtCargo);
        add(new JLabel("Data de Contratação:"));
        add(dateContratacao);
        add(new JLabel());
        add(btnAdd);

    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }

    public JDateChooser getDateContratacao() {
        return dateContratacao;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
}
