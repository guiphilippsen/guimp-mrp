package com.github.guiphilippsen.view;

import com.github.guiphilippsen.model.dao.MateriaPrimaDAO;
import com.github.guiphilippsen.model.entities.MateriaPrima;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SegundaTela extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 300;

    private JTable materiaPrimaTable;
    private MateriaPrimaDAO materiaPrimaDAO;

    public SegundaTela() {
        materiaPrimaDAO = new MateriaPrimaDAO();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Segunda Tela");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar o painel de abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Painel para estoque de matéria-prima
        JPanel materiaPrimaPanel = new JPanel(new BorderLayout());

        // Obter dados do banco de dados
        List<MateriaPrima> materiaPrimaList = materiaPrimaDAO.getAllMateriaPrima();

        // Criar modelo de tabela com dados da lista
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nome");
        model.addColumn("Quantidade");
        for (MateriaPrima materiaPrima : materiaPrimaList) {
            model.addRow(new Object[]{materiaPrima.getId(), materiaPrima.getNome(), materiaPrima.getQtdestoque()});
        }

        // Criar a tabela com o modelo de dados
        materiaPrimaTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(materiaPrimaTable);
        materiaPrimaPanel.add(scrollPane, BorderLayout.CENTER);

        // Painel para botões de ação
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton adicionarButton = new JButton("Adicionar");
        JButton removerButton = new JButton("Remover");
        JButton editarButton = new JButton("Editar");

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um novo material
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover um material selecionado
                int selectedRow = materiaPrimaTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Remover o material da tabela
                    ((DefaultTableModel) materiaPrimaTable.getModel()).removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(SegundaTela.this, "Selecione um material para remover.");
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar um material selecionado
            }
        });

        buttonPanel.add(adicionarButton);
        buttonPanel.add(removerButton);
        buttonPanel.add(editarButton);
        materiaPrimaPanel.add(buttonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Matéria-Prima", materiaPrimaPanel);

        // Adicionar o painel de abas à janela
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SegundaTela();
    }
}


