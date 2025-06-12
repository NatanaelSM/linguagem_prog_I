package com.github.natanael.projlinguagem.controller.lutador;

import com.github.natanael.projlinguagem.controller.lutador.LutadorController;
import com.github.natanael.projlinguagem.model.Lutador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LutadorTabController implements Initializable {

    public TableView<Lutador> lutadorTable;
    @FXML private TableColumn<Lutador, String> nomeColumn;
    @FXML private TableColumn<Lutador, Integer> idadeColumn;
    @FXML private TableColumn<Lutador, Double> alturaColumn;
    @FXML private TextField nomeField;
    @FXML private TextField idadeField;
    @FXML private TextField alturaField;

    private LutadorController lutadorController;
    private int selectedLutadorId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        idadeColumn.setCellValueFactory(new PropertyValueFactory<>("idade"));
        alturaColumn.setCellValueFactory(new PropertyValueFactory<>("altura"));

        lutadorController = new LutadorController();
        lutadorTable.setRowFactory(tv -> {
            TableRow<Lutador> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Lutador l = row.getItem();
                    selectedLutadorId = l.getId();
                    nomeField.setText(l.getNome());
                    idadeField.setText(String.valueOf(l.getIdade()));
                    alturaField.setText(String.valueOf(l.getAltura()));
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarLutador(ActionEvent event) {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        double altura = Double.parseDouble(alturaField.getText());

        lutadorController.cadastrarLutador(nome, idade, altura);
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarLutador(ActionEvent event) {
        Lutador l = new Lutador(selectedLutadorId, nomeField.getText(),
                Integer.parseInt(idadeField.getText()), Double.parseDouble(alturaField.getText()));
        lutadorController.atualizarLutador(l);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarLutador(ActionEvent event) {
        lutadorController.deletarLutador(selectedLutadorId);
        limparCampos();
        carregarTabela();
    }

    public void onLutar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedLutadorId != 0) {
            alert.setContentText("Lutador " + nomeField.getText() + " entrou em combate!");
        } else {
            alert.setContentText("Nenhum lutador selecionado!");
        }

        alert.showAndWait();
    }

    public void onBater(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedLutadorId != 0) {
            alert.setContentText("Lutador " + nomeField.getText() + " aplicou um golpe!");
        } else {
            alert.setContentText("Nenhum lutador selecionado!");
        }

        alert.showAndWait();
    }

    public void onTreinar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedLutadorId != 0) {
            alert.setContentText("Lutador " + nomeField.getText() + " está treinando duro!");
        } else {
            alert.setContentText("Nenhum lutador selecionado!");
        }

        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Lutador> lutadores = FXCollections.observableArrayList(lutadorController.listarLutadores());
        lutadorTable.setItems(lutadores);
    }

    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        alturaField.setText("");
        selectedLutadorId = 0;
    }
}
