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
import java.awt.event.ActionListener;

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
        // Limpa os listeners anteriores antes de adicionar um novo
        for (ActionListener al : addFuncionariosView.getBtnAdd().getActionListeners()) {
            addFuncionariosView.getBtnAdd().removeActionListener(al);
        }
        addFuncionariosView.getBtnAdd().addActionListener(e -> addFuncionario());
        addFuncionariosView.setVisible(true);
    }

    private void showUpdateFuncionariosView() {
        int selectedRow = funcionariosView.getFuncionariosTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) funcionariosView.getFuncionariosTable().getValueAt(selectedRow, 0);
            Funcionarios funcionarios = funcionariosService.getFuncionarioById(id);
            upFuncionariosView.setFuncionarioData(funcionarios);
            upFuncionariosView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(funcionariosView, "Selecione um funcionário para atualizar", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFuncionario() {
        try {
            String nome = addFuncionariosView.getTxtNome().getText();
            String cargo = addFuncionariosView.getTxtCargo().getText();
            Date dataContratacao = addFuncionariosView.getDateContratacao().getDate();

            if (nome.isEmpty() || cargo.isEmpty() || dataContratacao == null) {
                JOptionPane.showMessageDialog(addFuncionariosView, "Todos os campos são obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Funcionarios funcionarios = new Funcionarios(0, nome, cargo, dataContratacao);
            funcionariosService.addFuncionario(funcionarios);
            loadFuncionarios();
            addFuncionariosView.dispose();
            JOptionPane.showMessageDialog(funcionariosView, "Funcionário adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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

            if (nome.isEmpty() || password.isEmpty() || cargo.isEmpty()) {
                JOptionPane.showMessageDialog(upFuncionariosView, "Todos os campos são obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Funcionarios funcionario = new Funcionarios(id, nome, password, cargo);
            funcionariosService.updateFuncionario(funcionario);
            loadFuncionarios();
            upFuncionariosView.dispose();
            JOptionPane.showMessageDialog(funcionariosView, "Funcionário atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(funcionariosView, "Funcionário deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
