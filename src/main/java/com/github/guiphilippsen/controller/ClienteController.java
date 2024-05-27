package com.github.guiphilippsen.controller;

import com.github.guiphilippsen.model.entities.Cliente;
import com.github.guiphilippsen.model.services.ClienteService;
import com.github.guiphilippsen.view.ClienteView;

import com.github.guiphilippsen.view.MainMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClienteController {
    private final ClienteService clienteService;
    private final MainMenu mainMenu;
    private final ClienteView clienteView;

    public ClienteController(MainMenu mainMenu, ClienteView clienteView){
        this.clienteService = new ClienteService();
        this.mainMenu = mainMenu;
        this.clienteView = clienteView;
        initView();
    }

    public void initView(){
        mainMenu.setVisible(true);
    }
    public void initController() {
        mainMenu.getBtnViewClientes().addActionListener(e -> showClienteView());
        ClienteView.getBtnSave().addActionListener(e -> addCliente());
        ClienteView.getBtnUpdate().addActionListener(e -> updateCliente());
        clienteView.getBtnDelete().addActionListener(e -> deleteCliente());
        clienteView.getBtnBusca().addActionListener(e -> searchClientesByName());
        clienteView.getClienteTable().setModel(new DefaultTableModel(new Object[]{"ID", "Nome", "Contato", "Endereco"}, 0));
        loadClientes();
    }

    private void showClienteView() {
        clienteView.setVisible(true);
    }

    private void addCliente() {
        String nome = ClienteView.getTxtNome().getText();
        String contato = ClienteView.getTxtContato().getText();
        String endereco = ClienteView.getTxtEndereco().getText();
        Cliente cliente = new Cliente(nome, contato, endereco);
        clienteService.addCliente(cliente);
        loadClientes();
    }

    private void updateCliente() {
        int selectedRow = clienteView.getClienteTable().getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int id = Integer.parseInt(clienteView.getClienteTable().getValueAt(selectedRow, 0).toString());
                String newNome = ClienteView.getTxtNome().getText();
                String newContato = ClienteView.getTxtContato().getText();
                String newEndereco = ClienteView.getTxtEndereco().getText();

                Cliente existingCliente = clienteService.getClienteById(id);

                if (newNome == null || newNome.trim().isEmpty()){
                    newNome = existingCliente.getNome();
                }
                if (newContato == null || newContato.trim().isEmpty()){
                    newContato = existingCliente.getContato();
                }
                if (newEndereco == null || newEndereco.trim().isEmpty()){
                    newEndereco = existingCliente.getEndereco();
                }
                Cliente cliente = new Cliente(newNome, newContato, newEndereco);
                cliente.setId(id);
                clienteService.updateCliente(cliente);
                loadClientes();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(clienteView, "Invalid ID Format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteCliente() {
        int selectedRow = clienteView.getClienteTable().getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) clienteView.getClienteTable().getValueAt(selectedRow, 0);
            clienteService.deleteCliente(id);
            loadClientes();
        }
    }

    private void loadClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        DefaultTableModel model = (DefaultTableModel) clienteView.getClienteTable().getModel();
        model.setRowCount(0);
        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{cliente.getId(),cliente.getNome(), cliente.getContato(), cliente.getEndereco()});
        }
    }

    private void searchClientesByName() {
        String termoBusca = clienteView.getTxtBusca().getText();
        List<Cliente> clientes = clienteService.searchClientes(termoBusca);
        DefaultTableModel model = (DefaultTableModel) clienteView.getClienteTable().getModel();
        model.setRowCount(0);
        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getContato(), cliente.getEndereco()});
        }
    }
}
