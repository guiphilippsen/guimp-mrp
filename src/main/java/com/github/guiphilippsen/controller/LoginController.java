package com.github.guiphilippsen.controller;

import com.github.guiphilippsen.view.LoginView;
import com.github.guiphilippsen.view.MainMenu;

public class LoginController {
    private MainMenu mainMenu;
    private LoginView loginView;

    public LoginController(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        initController();
    }

    public void initController(){
        loginView.getBtnAcessar().addActionListener(e -> auth());
    }

    private void auth() {
            int usuario = Integer.parseInt(loginView.getTxtUsuario().getText());
            String senha = String.valueOf(loginView.getPassField());

    }
}
