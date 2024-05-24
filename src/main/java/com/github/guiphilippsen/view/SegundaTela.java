package com.github.guiphilippsen.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SegundaTela extends JFrame {

    private DefaultTableModel modeloMateriaPrima;
    private DefaultTableModel modeloProdutoFinal;

    public SegundaTela() {
        super("Estoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane abas = new JTabbedPane();

        // Aba de estoque de matéria-prima
        JPanel painelMateriaPrima = new JPanel();
        painelMateriaPrima.setLayout(new BorderLayout());

        // Tabela de estoque de matéria-prima
        String[] colunasMateriaPrima = {"ID", "Nome", "Quantidade"};
        Object[][] dadosMateriaPrima = {
                {1, "Ferro", 100},
                {2, "Cobre", 150},
                {3, "Aluminio", 200}
        };
        modeloMateriaPrima = new DefaultTableModel(dadosMateriaPrima, colunasMateriaPrima);
        JTable tabelaMateriaPrima = new JTable(modeloMateriaPrima);
        JScrollPane scrollMateriaPrima = new JScrollPane(tabelaMateriaPrima);
        painelMateriaPrima.add(scrollMateriaPrima, BorderLayout.CENTER);

        // Botões de ação para matéria-prima
        JPanel botoesMateriaPrima = new JPanel();
        JButton btnAdicionarMateriaPrima = new JButton("Adicionar");
        JButton btnEditarMateriaPrima = new JButton("Editar");
        JButton btnExcluirMateriaPrima = new JButton("Excluir");

        btnAdicionarMateriaPrima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto(modeloMateriaPrima);
            }
        });

        btnEditarMateriaPrima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarProduto(tabelaMateriaPrima, modeloMateriaPrima);
            }
        });

        btnExcluirMateriaPrima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirProduto(tabelaMateriaPrima, modeloMateriaPrima);
            }
        });

        botoesMateriaPrima.add(btnAdicionarMateriaPrima);
        botoesMateriaPrima.add(btnEditarMateriaPrima);
        botoesMateriaPrima.add(btnExcluirMateriaPrima);

        painelMateriaPrima.add(botoesMateriaPrima, BorderLayout.SOUTH);
        abas.addTab("Estoque de Matéria-prima", painelMateriaPrima);

        // Aba de estoque de produto final
        JPanel painelProdutoFinal = new JPanel();
        painelProdutoFinal.setLayout(new BorderLayout());

        // Tabela de estoque de produto final
        String[] colunasProdutoFinal = {"ID", "Nome", "Quantidade"};
        Object[][] dadosProdutoFinal = {
                {1, "Vergalhão", 50},
                {2, "Fio de Cobre", 75},
                {3, "Copo de Aluminio", 100}
        };
        modeloProdutoFinal = new DefaultTableModel(dadosProdutoFinal, colunasProdutoFinal);
        JTable tabelaProdutoFinal = new JTable(modeloProdutoFinal);
        JScrollPane scrollProdutoFinal = new JScrollPane(tabelaProdutoFinal);
        painelProdutoFinal.add(scrollProdutoFinal, BorderLayout.CENTER);

        // Botões de ação para produto final
        JPanel botoesProdutoFinal = new JPanel();
        JButton btnAdicionarProdutoFinal = new JButton("Adicionar");
        JButton btnEditarProdutoFinal = new JButton("Editar");
        JButton btnExcluirProdutoFinal = new JButton("Excluir");

        btnAdicionarProdutoFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto(modeloProdutoFinal);
            }
        });

        btnEditarProdutoFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarProduto(tabelaProdutoFinal, modeloProdutoFinal);
            }
        });

        btnExcluirProdutoFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirProduto(tabelaProdutoFinal, modeloProdutoFinal);
            }
        });

        botoesProdutoFinal.add(btnAdicionarProdutoFinal);
        botoesProdutoFinal.add(btnEditarProdutoFinal);
        botoesProdutoFinal.add(btnExcluirProdutoFinal);

        painelProdutoFinal.add(botoesProdutoFinal, BorderLayout.SOUTH);
        abas.addTab("Estoque de Produto Final", painelProdutoFinal);

        // Adiciona as abas à janela
        add(abas);

        // Configura o tamanho da janela
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarProduto(DefaultTableModel modelo) {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade do produto:");
        if (nome != null && quantidadeStr != null) {
            try {
                int quantidade = Integer.parseInt(quantidadeStr);
                modelo.addRow(new Object[]{modelo.getRowCount() + 1, nome, quantidade});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Quantidade inválida!");
            }
        }
    }

    private void editarProduto(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow != -1) {
            String nome = JOptionPane.showInputDialog(this, "Digite o novo nome do produto:", modelo.getValueAt(selectedRow, 1));
            String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a nova quantidade do produto:", modelo.getValueAt(selectedRow, 2));
            if (nome != null && quantidadeStr != null) {
                try {
                    int quantidade = Integer.parseInt(quantidadeStr);
                    modelo.setValueAt(nome, selectedRow, 1);
                    modelo.setValueAt(quantidade, selectedRow, 2);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar!");
        }
    }

    private void excluirProduto(JTable tabela, DefaultTableModel modelo) {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow != -1) {
            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                modelo.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }
    }


}
