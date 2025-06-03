package com.github.natanael.projlinguagem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;

public class MainScreenController {

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
        AnimalController animalController = new AnimalController();
        animalController.cadastrarAnimal("Ops", "tesadste", true);
    }

    @FXML
    public void onDeletarAnimal(ActionEvent actionEvent) {
        AnimalController animalController = new AnimalController();
        animalController.deletarAnimal(11);
    }

}
