package com.github.guiphilippsen.view;

import com.github.guiphilippsen.controller.ClienteController;
import com.github.guiphilippsen.controller.EstoqueController;
import com.github.guiphilippsen.controller.FuncionariosController;
import com.github.guiphilippsen.view.ViewsEstoque.AddProductView;
import com.github.guiphilippsen.view.ViewsEstoque.EstoqueView;
import com.github.guiphilippsen.view.ViewsEstoque.UpEstoqueView;
import com.github.guiphilippsen.view.ViewsFuncionarios.AddFuncionariosView;
import com.github.guiphilippsen.view.ViewsFuncionarios.FuncionariosView;
import com.github.guiphilippsen.view.ViewsFuncionarios.UpFuncionariosView;

public class Main {
    public static void main(String[] args) {
        //Menu Principal
        MainMenu mainMenu = new MainMenu();
        //Painel de Clientes
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(mainMenu, clienteView);
        clienteController.initController();
        //Painel de Funcionarios
        FuncionariosView funcionariosView = new FuncionariosView();
        AddFuncionariosView addFuncionariosView = new AddFuncionariosView();
        UpFuncionariosView upFuncionariosView = new UpFuncionariosView();
        FuncionariosController funcionariosController = new FuncionariosController(funcionariosView, addFuncionariosView, upFuncionariosView, mainMenu);
        funcionariosController.initController();
        //Visualizar Estoque
        EstoqueView estoqueView = new EstoqueView();
        AddProductView addProductView = new AddProductView();
        UpEstoqueView upEstoqueView = new UpEstoqueView();
        EstoqueController estoqueController = new EstoqueController(mainMenu, estoqueView, addProductView, upEstoqueView);
        estoqueController.initController();
    }
}
