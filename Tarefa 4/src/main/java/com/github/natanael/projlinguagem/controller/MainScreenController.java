package com.github.natanael.projlinguagem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;

public class MainScreenController {

    private AnimalController animalController;
    @FXML
    private SplitMenuButton extintoMenu;

    @FXML
    private void onExtintoSim(ActionEvent event) {
        extintoMenu.setText("Sim");
        System.out.println("Extinto: Sim");
    }

    @FXML
    private void onExtintoNao(ActionEvent event) {
        extintoMenu.setText("Não");
        System.out.println("Extinto: Não");
    }

    @FXML
    private void onCadastrarAnimal(ActionEvent event){
        this.animalController = new AnimalController("Teste", "teste", false);
        animalController.cadastrarAnimal();
    }
}
