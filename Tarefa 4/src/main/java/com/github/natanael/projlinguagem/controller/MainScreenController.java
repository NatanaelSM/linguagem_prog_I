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
    @FXML
    private Tab funcionarioTab;
    @FXML
    private Tab pagamentoTab;
    @FXML
    private Tab lutadorTab;
    @FXML
    private Tab timeTab;
    @FXML
    private Tab pessoaTab;
    @FXML
    private Tab pilotoTab;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane animalContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/AnimalTab.fxml"));
            AnchorPane carroContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/CarroTab.fxml"));
            AnchorPane funcionarioContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/FuncionarioTab.fxml"));
            AnchorPane pagamentoContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/PagamentoTab.fxml"));
            AnchorPane lutadorContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/LutadorTab.fxml"));
            AnchorPane timeContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/TimeTab.fxml"));
            AnchorPane pessoaContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/PessoaTab.fxml"));
            AnchorPane pilotoContent = FXMLLoader.load(getClass().getResource("/com/github/natanael/projlinguagem/view/PilotoTab.fxml"));

            animalTab.setContent(animalContent);
            carroTab.setContent(carroContent);
            funcionarioTab.setContent(funcionarioContent);
            pagamentoTab.setContent(pagamentoContent);
            lutadorTab.setContent(lutadorContent);
            timeTab.setContent(timeContent);
            pessoaTab.setContent(pessoaContent);
            pilotoTab.setContent(pilotoContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
