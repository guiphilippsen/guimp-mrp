package com.github.guiphilippsen.view;

import javax.swing.*;
import java.awt.*;

public class ClienteView extends JFrame {

    private static JTextField txtNome;
    private static JTextField txtContato;
    private static JTextField txtEndereco;
    private static JButton btnSave;
    private static JButton btnUpdate;
    private JButton btnDelete;
    private JTable clienteTable;
    private JTextField txtBusca;
    private JButton btnBusca;

    public ClienteView() {
        setTitle("Painel de Clientes");
        setSize(1350, 620);

        txtNome = new JTextField(15);
        txtContato = new JTextField(15);
        txtEndereco = new JTextField(15);
        btnUpdate = new JButton("Atualizar");
        btnDelete = new JButton("Excluir");
        btnSave = new JButton("Adicionar");
        clienteTable = new JTable();
        txtBusca = new JTextField(15);
        btnBusca = new JButton("Consultar");

        setLayout(new FlowLayout());
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Contato:"));
        add(txtContato);
        add(new JLabel("Endereco:"));
        add(txtEndereco);
        add(btnSave);
        add(btnUpdate);
        add(btnDelete);
        add(new JLabel("Consultar"));
        add(txtBusca);
        add(btnBusca);
        add(new JScrollPane(clienteTable));

    }

    public static JTextField getTxtNome() {
        return txtNome;
    }

    public static JTextField getTxtContato() {
        return txtContato;
    }

    public static JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public static JButton getBtnSave() {
        return btnSave;
    }

    public static JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JTable getClienteTable() {
        return clienteTable;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JTextField getTxtBusca() {
        return txtBusca;
    }

    public JButton getBtnBusca() {
        return btnBusca;
    }
}
