package com.github.guiphilippsen.model.services;

import com.github.guiphilippsen.model.dao.EstoqueDao;
import com.github.guiphilippsen.model.entities.Estoque;

import java.util.List;

public class EstoqueService {
    private final EstoqueDao estoqueDao;

    public EstoqueService() {
        this.estoqueDao = new EstoqueDao();
    }

    public void addEstoque(Estoque estoque) {
        estoqueDao.save(estoque);
    }
    public List<Estoque> getAllEstoque() {
        return estoqueDao.findAll();
    }

    public void updateEstoque(Estoque estoque) {
        estoqueDao.update(estoque);
    }

    public void deleteEstoque(int id) {
        estoqueDao.delete(id);
    }

    public List<Estoque> searchProductsByName(String nome){
        return estoqueDao.searchByName(nome);
    }

    public Estoque getProductById(int id) {
        return estoqueDao.findById(id);
    }
}
