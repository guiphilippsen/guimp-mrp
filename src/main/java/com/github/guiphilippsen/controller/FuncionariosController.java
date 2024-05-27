package com.github.guiphilippsen.controller;

import com.github.guiphilippsen.model.entities.Funcionarios;
import com.github.guiphilippsen.model.services.FuncionariosService;
import com.github.guiphilippsen.view.MainMenu;
import com.github.guiphilippsen.view.ViewsFuncionarios.AddFuncionariosView;
import com.github.guiphilippsen.view.ViewsFuncionarios.FuncionariosView;
import com.github.guiphilippsen.view.ViewsFuncionarios.UpFuncionariosView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;

public class FuncionariosController {
    private MainMenu mainMenu;
    private FuncionariosService funcionariosService;
    private FuncionariosView funcionariosView;
    private AddFuncionariosView addFuncionariosView;
    private UpFuncionariosView upFuncionariosView;

    public FuncionariosController(FuncionariosView funcionariosView, AddFuncionariosView addFuncionariosView, UpFuncionariosView upFuncionariosView, MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.funcionariosService = new FuncionariosService();
        this.funcionariosView = funcionariosView;
        this.addFuncionariosView = addFuncionariosView;
        this.upFuncionariosView = upFuncionariosView;
        initController();
    }

    public void initController() {
        mainMenu.getBtnViewFuncionarios().addActionListener(e -> showFuncionariosView());
        funcionariosView.getBtnAdd().addActionListener(e -> showAddFuncionariosView());
        funcionariosView.getBtnUpdate().addActionListener(e -> showUpdateFuncionariosView());
        funcionariosView.getBtnDelete().addActionListener(e -> deleteFuncionario());
        funcionariosView.getBtnSearch().addActionListener(e -> searchFuncionario());
        addFuncionariosView.getBtnAdd().addActionListener(e -> addFuncionario());
        upFuncionariosView.getBtnUpdate().addActionListener(e -> updateFuncionario());

        loadFuncionarios();
    }

    private void showFuncionariosView() {
        funcionariosView.setVisible(true);
    }
    private void showAddFuncionariosView() {
        addFuncionariosView.setVisible(true);
    }

    private void showUpdateFuncionariosView() {
        int selectedRow = funcionariosView.getFuncionariosTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) funcionariosView.getFuncionariosTable().getValueAt(selectedRow, 0);
            Funcionarios funcionarios = funcionariosService.getFuncionarioById(id);
            upFuncionariosView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(funcionariosView, "Selecione um funcionário para atualizar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFuncionario() {
        try {
            String nome = addFuncionariosView.getTxtNome().getText();
            String password = new String(addFuncionariosView.getTxtPassword().getPassword());
            String cargo = addFuncionariosView.getTxtCargo().getText();
            Date dataContratacao = addFuncionariosView.getDateContratacao().getDate();

            Funcionarios funcionarios = new Funcionarios(0, nome, password, cargo, dataContratacao);
            funcionariosService.addFuncionario(funcionarios);
            loadFuncionarios();
            addFuncionariosView.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(addFuncionariosView, "Erro ao adicionar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateFuncionario() {
        try {
            int id = Integer.parseInt(upFuncionariosView.getTxtId().getText());
            String nome = upFuncionariosView.getTxtNome().getText();
            String password = new String(upFuncionariosView.getTxtPassword().getPassword());
            String cargo = upFuncionariosView.getTxtCargo().getText();

            Funcionarios funcionario = new Funcionarios(id, nome, password, cargo);
            funcionariosService.updateFuncionario(funcionario);
            loadFuncionarios();
            upFuncionariosView.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(upFuncionariosView, "Erro ao atualizar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteFuncionario() {
        int selectedRow = funcionariosView.getFuncionariosTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) funcionariosView.getFuncionariosTable().getValueAt(selectedRow, 0);
            funcionariosService.deleteFuncionario(id);
            loadFuncionarios();
        } else {
            JOptionPane.showMessageDialog(funcionariosView, "Selecione um funcionário para deletar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchFuncionario() {
        String name = funcionariosView.getTxtSearch().getText();
        List<Funcionarios> funcionarios = funcionariosService.searchByName(name);
        updateFuncionariosTable(funcionarios);
    }

    private void loadFuncionarios() {
        List<Funcionarios> funcionarios = funcionariosService.getAllFuncionarios();
        updateFuncionariosTable(funcionarios);
    }

    private void updateFuncionariosTable(List<Funcionarios> funcionarios) {
        DefaultTableModel model = (DefaultTableModel) funcionariosView.getFuncionariosTable().getModel();
        model.setRowCount(0);
        for (Funcionarios funcionario : funcionarios) {
            model.addRow(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getDataContratacao()});
        }
    }
}
