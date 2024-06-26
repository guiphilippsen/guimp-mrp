package com.github.guiphilippsen.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField passField;
    private JButton btnAcessar;

    public LoginView() {
        setTitle("GUIMP-MRP");
        setSize(420, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtUsuario = new JTextField();
        passField = new JPasswordField();
        btnAcessar = new JButton("Acessar");

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Código de acesso:"));
        add(txtUsuario);
        add(new JLabel("Senha:"));
        add(passField);

        // Crear un panel con FlowLayout centrado y agregar el botón al panel
        JPanel panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotao.add(btnAcessar);

        // Agregar el panel en lugar del botón directamente
        add(panelBotao);

        setVisible(true);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public JButton getBtnAcessar() {
        return btnAcessar;
    }
}
