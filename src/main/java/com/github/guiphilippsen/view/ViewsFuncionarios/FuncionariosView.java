package com.github.guiphilippsen.view.ViewsFuncionarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FuncionariosView extends JFrame {
    private JTable funcionariosTable;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;

    public FuncionariosView() {
        setTitle("Gerenciamento de Funcionários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAdd = new JButton("Adicionar");
        btnUpdate = new JButton("Atualizar");
        btnDelete = new JButton("Deletar");

        topPanel.add(new JLabel("Buscar por nome:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAdd);
        topPanel.add(btnUpdate);
        topPanel.add(btnDelete);

        panel.add(topPanel, BorderLayout.NORTH);

        funcionariosTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Nome", "Cargo", "Data de Contratação"}, 0));
        JScrollPane scrollPane = new JScrollPane(funcionariosTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public JTable getFuncionariosTable() {
        return funcionariosTable;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
}
