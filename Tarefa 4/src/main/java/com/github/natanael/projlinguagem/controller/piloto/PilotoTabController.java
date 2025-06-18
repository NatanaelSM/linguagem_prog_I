package com.github.natanael.projlinguagem.controller.piloto;

import com.github.natanael.projlinguagem.model.Piloto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PilotoTabController implements Initializable {

    @FXML private TableView<Piloto> pilotoTable;
    @FXML private TableColumn<Piloto, String> escuderiaColumn;
    @FXML private TableColumn<Piloto, Double> salarioColumn;
    @FXML private TableColumn<Piloto, String> paisOrigemColumn;
    @FXML private TextField escuderiaField;
    @FXML private TextField salarioField;
    @FXML private TextField paisOrigemField;

    private PilotoController pilotoController;
    private int selectedPilotoId = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pilotoController = new PilotoController();

        escuderiaColumn.setCellValueFactory(new PropertyValueFactory<>("escuderia"));
        salarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));
        paisOrigemColumn.setCellValueFactory(new PropertyValueFactory<>("paisOrigem"));

        pilotoTable.setRowFactory(tv -> {
            TableRow<Piloto> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Piloto p = row.getItem();
                    selectedPilotoId = p.getId();
                    escuderiaField.setText(p.getEscuderia());
                    salarioField.setText(String.valueOf(p.getSalario()));
                    paisOrigemField.setText(p.getPaisOrigem());
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarPiloto(ActionEvent event) {
        pilotoController.cadastrarPiloto(
                escuderiaField.getText(),
                Double.parseDouble(salarioField.getText()),
                paisOrigemField.getText()
        );
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarPiloto(ActionEvent event) {
        Piloto p = new Piloto(selectedPilotoId,
                escuderiaField.getText(),
                Double.parseDouble(salarioField.getText()),
                paisOrigemField.getText());
        pilotoController.atualizarPiloto(p);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarPiloto(ActionEvent event) {
        pilotoController.deletarPiloto(selectedPilotoId);
        limparCampos();
        carregarTabela();
    }

    public void onAumentarSalario(ActionEvent event) {
        if (selectedPilotoId != 0) {
            double salario = Double.parseDouble(salarioField.getText());
            salario += salario * 0.10;
            salarioField.setText(String.valueOf(salario));
            onAtualizarPiloto(null);
            mostrarMensagem("Salário aumentado para: R$ " + salario);
        } else {
            mostrarMensagem("Nenhum piloto selecionado!");
        }
    }

    public void onCorrer(ActionEvent event) {
        if (selectedPilotoId != 0) {
            mostrarMensagem("O piloto da escuderia " + escuderiaField.getText() + " está correndo!");
        } else {
            mostrarMensagem("Nenhum piloto selecionado!");
        }
    }

    public void onFolga(ActionEvent event) {
        if (selectedPilotoId != 0) {
            String novaEscuderia = escuderiaField.getText();
            mostrarMensagem("O piloto entrou de folga!");
        } else {
            mostrarMensagem("Nenhum piloto selecionado!");
        }
    }

    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Piloto> pilotos = FXCollections.observableArrayList(pilotoController.listarPilotos());
        pilotoTable.setItems(pilotos);
    }

    private void limparCampos() {
        escuderiaField.clear();
        salarioField.clear();
        paisOrigemField.clear();
        selectedPilotoId = 0;
    }
}
