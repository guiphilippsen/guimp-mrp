package com.github.guiphilippsen.view;

import com.github.guiphilippsen.model.dao.FuncionariosDAO;
import com.github.guiphilippsen.model.entities.Funcionarios;

import javax.swing.*;
import java.awt.*;

public class Login extends Component {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 170;
    private static final int LABEL_WIDTH = 80;
    private static final int LABEL_HEIGHT = 25;
    private static final int FIELD_WIDTH = 165;
    private static final int FIELD_HEIGHT = 25;
    private static final int BUTTON_WIDTH = 90;
    private static final int BUTTON_HEIGHT = 25;

    private final FuncionariosDAO funcionariosDAO;

    public Login() {
        funcionariosDAO = new FuncionariosDAO();
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = createFrame();
        JPanel panel = createPanel();
        frame.add(panel);

        JLabel codUserLabel = createLabel("Codigo:", 10, 20);
        panel.add(codUserLabel);

        JTextField usrCodeField = createTextField(70, 20);
        panel.add(usrCodeField);

        JLabel passLabel = createLabel("Senha:", 10, 50);
        panel.add(passLabel);

        JPasswordField passField = createPasswordField(70, 50);
        panel.add(passField);

        JButton loginBtn = createButton("Acessar", 100, 90);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> authenticateUser(frame, usrCodeField, passField));
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        return panel;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, LABEL_WIDTH, LABEL_HEIGHT);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField(20);
        textField.setBounds(x, y, FIELD_WIDTH, FIELD_HEIGHT);
        return textField;
    }

    private JPasswordField createPasswordField(int x, int y) {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(x, y, FIELD_WIDTH, FIELD_HEIGHT);
        return passwordField;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        return button;
    }

    private void authenticateUser(JFrame parentFrame, JTextField usrCodeField, JPasswordField passField) {
        try {
            int id = Integer.parseInt(usrCodeField.getText());
            String password = new String(passField.getPassword());
            Funcionarios funcionarios = funcionariosDAO.findUserByUsernameAndPassword(id, password);

            if (funcionarios != null) {
                JOptionPane.showMessageDialog(parentFrame, "Acesso Concedido");
                parentFrame.dispose();
                new SegundaTela();
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Dados Incorretos! Tente Novamente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentFrame, "Código deve ser um número inteiro");
        }
    }

}
