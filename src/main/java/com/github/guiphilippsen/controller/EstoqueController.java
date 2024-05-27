package com.github.guiphilippsen.controller;

import com.github.guiphilippsen.model.entities.Estoque;
import com.github.guiphilippsen.model.services.EstoqueService;
import com.github.guiphilippsen.view.*;
import com.github.guiphilippsen.view.ViewsEstoque.AddProductView;
import com.github.guiphilippsen.view.ViewsEstoque.EstoqueView;
import com.github.guiphilippsen.view.ViewsEstoque.UpEstoqueView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EstoqueController {
    private MainMenu mainMenu;
    private EstoqueService estoqueService;
    private EstoqueView estoqueView;
    private AddProductView addProductView;
    private UpEstoqueView upEstoqueView;

    public EstoqueController(MainMenu mainMenu, EstoqueView estoqueView, AddProductView addProductView, UpEstoqueView upEstoqueView) {
        this.estoqueService = new EstoqueService();
        this.mainMenu = mainMenu;
        this.estoqueView = estoqueView;
        this.addProductView = addProductView;
        this.upEstoqueView = upEstoqueView;
        initController();
    }

    public void initController() {
        mainMenu.getBtnViewEstoque().addActionListener(e -> showEstoqueView());
        estoqueView.getBtnSearch().addActionListener(e -> searchProducts());
        estoqueView.getBtnAddProduct().addActionListener(e -> showAddProductView());
        estoqueView.getBtnUpProduct().addActionListener(e -> showUpEstoqueView());
        estoqueView.getBtnDeleteProduct().addActionListener(e -> deleteProduct());
        addProductView.getBtnAddEstoque().addActionListener(e -> addProduct());
        upEstoqueView.getBtnAddEstoque().addActionListener(e -> updateEstoque());
        estoqueView.getEstoqueTable().setModel(new DefaultTableModel(new Object[]{"ID", "Nome", "Quantidade", "Valor"}, 0));
        loadProducts();
    }

    private void showEstoqueView() {
        estoqueView.setVisible(true);
    }
    private void showAddProductView() {
        addProductView.setVisible(true);
    }
    private void showUpEstoqueView() {
        int selectedRow = estoqueView.getEstoqueTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) estoqueView.getEstoqueTable().getValueAt(selectedRow, 0);
            Estoque estoque = estoqueService.getProductById(id);
            upEstoqueView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(estoqueView, "Selecione um produto para atualizar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProduct() {
        try {

            String nome = addProductView.getTxtNome().getText();
            if (nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(addProductView, "Nome do produto não pode ser vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Double qtdEstoque = null;
            try {
                qtdEstoque = Double.valueOf(addProductView.getTxtQtdEstoque().getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(addProductView, "Quantidade Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Double valor = null;
            try {
                valor = Double.valueOf(addProductView.getTxtValor().getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(addProductView, "Valor Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            Estoque estoque = new Estoque(nome, qtdEstoque, valor);
            estoqueService.addEstoque(estoque);
            loadProducts();

            addProductView.getTxtNome().setText("");
            addProductView.getTxtValor().setText("");
            addProductView.getTxtQtdEstoque().setText("");

            JOptionPane.showMessageDialog(addProductView, "Produto adicionado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(addProductView, "Erro ao adicionar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateEstoque(){
        int selectedRow = estoqueView.getEstoqueTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(upEstoqueView, "Nenhum produto selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(estoqueView.getEstoqueTable().getValueAt(selectedRow, 0).toString());
            Double newValor;
            Double newEstoque;

            try {
                newValor = Double.parseDouble(upEstoqueView.getTxtValor().getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(upEstoqueView, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                newEstoque = Double.parseDouble(upEstoqueView.getTxtQtdEstoque().getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(upEstoqueView, "Quantidade inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Estoque existingProduct = estoqueService.getProductById(id);

            if (newValor == null || newValor.toString().trim().isEmpty()) {
                newValor = existingProduct.getValor();
            }
            if (newEstoque == null || newEstoque.toString().trim().isEmpty()) {
                newEstoque = existingProduct.getQtdEstoque();
            }

            Estoque estoque = new Estoque(existingProduct.getNome(), newEstoque, newValor);
            estoque.setId(id);
            estoqueService.updateEstoque(estoque);
            loadProducts();

            upEstoqueView.getTxtValor().setText("");
            upEstoqueView.getTxtQtdEstoque().setText("");

            JOptionPane.showMessageDialog(upEstoqueView, "Produto atualizado com sucesso");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(upEstoqueView, "Formato de ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private  void deleteProduct() {
        int selectedRow = estoqueView.getEstoqueTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) estoqueView.getEstoqueTable().getValueAt(selectedRow, 0);
            estoqueService.deleteEstoque(id);
            loadProducts();
        }
    }
    private void loadProducts() {
        List<Estoque> produtos = estoqueService.getAllEstoque();
        DefaultTableModel model = (DefaultTableModel) estoqueView.getEstoqueTable().getModel();
        model.setRowCount(0);
        for (Estoque produto : produtos) {
            model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getQtdEstoque(), produto.getValor()});
        }
    }

    private void searchProducts() {
        String searchTerm = estoqueView.getTxtSearch().getText();
        List<Estoque> produtos = estoqueService.searchProductsByName(searchTerm);
        DefaultTableModel model = (DefaultTableModel) estoqueView.getEstoqueTable().getModel();
        model.setRowCount(0);
        for (Estoque produto : produtos) {
            model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getQtdEstoque(), produto.getValor()});
        }
    }
}
