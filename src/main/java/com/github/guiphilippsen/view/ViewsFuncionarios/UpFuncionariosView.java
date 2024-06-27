package com.github.guiphilippsen.view.ViewsFuncionarios;

import com.github.guiphilippsen.model.entities.Funcionarios;

import javax.swing.*;
import java.awt.*;

public class UpFuncionariosView extends JFrame {
    private JTextField txtId;
    private JTextField txtNome;
    private JPasswordField txtPassword;
    private JTextField txtCargo;
    private JButton btnUpdate;

    public UpFuncionariosView() {
        super();
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtNome = new JTextField();
        txtPassword = new JPasswordField();
        txtCargo = new JTextField();
        btnUpdate = new JButton("Atualizar");

        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Senha:"));
        add(txtPassword);
        add(new JLabel("Cargo:"));
        add(txtCargo);
        add(new JLabel());
        add(btnUpdate);
    }

    public void setFuncionarioData(Funcionarios funcionario) {
        txtId.setText(String.valueOf(funcionario.getId()));
        txtNome.setText(funcionario.getNome());
        txtCargo.setText(funcionario.getCargo());
    }

    public JTextField getTxtId() {
        return txtId;
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


    public JButton getBtnUpdate() {
        return btnUpdate;
    }
}
