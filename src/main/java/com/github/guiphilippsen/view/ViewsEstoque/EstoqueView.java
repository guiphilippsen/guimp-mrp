package com.github.guiphilippsen.view.ViewsEstoque;

import javax.swing.*;
import java.awt.*;

public class EstoqueView extends JFrame {
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnAddProduct;
    private JButton btnUpProduct;
    private JButton btnDeleteProduct;
    private JTable estoqueTable;

    public EstoqueView() {
        setTitle("Gestão de Estoque");
        setSize(600, 400);

        txtSearch = new JTextField(20);
        btnSearch = new JButton("Buscar");
        btnAddProduct = new JButton("Acicionar");
        btnUpProduct = new JButton("Atualizar");
        btnDeleteProduct = new JButton("Deletar");

        estoqueTable = new JTable();

        setLayout(new FlowLayout());
        add(new JLabel("Buscar produto:"));
        add(txtSearch);
        add(btnSearch);
        add(btnAddProduct);
        add(btnUpProduct);
        add(btnDeleteProduct);
        add(new JScrollPane(estoqueTable));
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnAddProduct() {
        return btnAddProduct;
    }

    public JButton getBtnUpProduct() {
        return btnUpProduct;
    }

    public JButton getBtnDeleteProduct() {
        return btnDeleteProduct;
    }

    public JTable getEstoqueTable() {
        return estoqueTable;
    }
}
