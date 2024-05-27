package com.github.guiphilippsen.model.services;

import com.github.guiphilippsen.model.dao.ClienteDao;
import com.github.guiphilippsen.model.entities.Cliente;

import java.util.List;

public class ClienteService {
    private ClienteDao clienteDAO;

    public ClienteService(){
        this.clienteDAO = new ClienteDao();
    }
    public void addCliente(Cliente cliente){
        clienteDAO.save(cliente);
    }
    public List<Cliente> getAllClientes(){
        return clienteDAO.findAll();
    }
    public void updateCliente(Cliente cliente){
        clienteDAO.update(cliente);
    }
    public void deleteCliente(int id) {
        clienteDAO.delete(id);
    }

    public List<Cliente> searchClientes(String nome) {
        return clienteDAO.searchByName(nome);
    }

    public Cliente getClienteById(int id) {
        return clienteDAO.findById(id);
    }
}
