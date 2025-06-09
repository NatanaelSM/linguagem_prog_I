package com.github.natanael.projlinguagem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Tab animalTab;
    @FXML
    private Tab carroTab;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane animalContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/AnimalTab.fxml"));
            AnchorPane carroContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/CarroTab.fxml"));

            animalTab.setContent(animalContent);
            carroTab.setContent(carroContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
