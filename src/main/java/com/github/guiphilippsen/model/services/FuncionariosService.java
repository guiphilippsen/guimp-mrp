package com.github.guiphilippsen.model.services;

import com.github.guiphilippsen.model.dao.FuncionariosDao;
import com.github.guiphilippsen.model.entities.Funcionarios;

import java.util.List;

public class FuncionariosService {
    private FuncionariosDao funcionariosDAO;

    public FuncionariosService() {
        this.funcionariosDAO = new FuncionariosDao();
    }

    public void addFuncionario(Funcionarios funcionario) {
        funcionariosDAO.addFuncionario(funcionario);
    }

    public Funcionarios getFuncionarioById(int id) {
        return funcionariosDAO.getFuncionarioById(id);
    }

    public void updateFuncionario(Funcionarios funcionario) {
        funcionariosDAO.updateFuncionario(funcionario);
    }

    public void deleteFuncionario(int id) {
        funcionariosDAO.deleteFuncionario(id);
    }

    public List<Funcionarios> getAllFuncionarios() {
        return funcionariosDAO.getAllFuncionarios();
    }

    public List<Funcionarios> searchByName(String name) {
        return funcionariosDAO.searchByName(name);
    }
}
