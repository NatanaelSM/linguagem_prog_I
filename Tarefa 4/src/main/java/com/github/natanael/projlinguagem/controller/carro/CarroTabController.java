package com.github.natanael.projlinguagem.controller.carro;

import com.github.natanael.projlinguagem.model.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CarroTabController implements Initializable {

    public TableView carroTable;
    @FXML
    private TableColumn<Carro, String> modeloColumn;
    @FXML
    private TableColumn<Carro, String> marcaColumn;
    @FXML
    private TableColumn<Carro, String> anoColumn;
    @FXML
    private TextField modeloField;
    @FXML
    private TextField marcaField;
    @FXML
    private TextField anoField;
    private CarroController carroController;
    private int selectedCarroIndex = 0;
    private Boolean isLigado = false;


    public void initialize(URL location, ResourceBundle resources) {
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        anoColumn.setCellValueFactory(new PropertyValueFactory<>("ano"));
        carroController = new CarroController();

        carroTable.setRowFactory(tv -> {
            TableRow<Carro> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    Carro carroController = row.getItem();
                    modeloField.setText(carroController.getModelo());
                    marcaField.setText(carroController.getMarca());
                    String anoString = String.valueOf(carroController.getAno());
                    anoField.setText(anoString);
                    selectedCarroIndex = carroController.getId();
                }
            });
            return row;
        });
        carregarTabela();
    }

    @FXML
    private void onCadastrarCarro(ActionEvent event){
        CarroController carroController = new CarroController();
        int anoInt = Integer.parseInt(anoField.getText());
        carroController.cadastrarCarro(modeloField.getText(), marcaField.getText(), anoInt);
        carregarTabela();
        modeloField.setText("");
        marcaField.setText("");
        anoField.setText("");
    }

    public void onDeletarCarro(ActionEvent actionEvent) {
        CarroController carroController = new CarroController();
        carroController.deletarCarro(selectedCarroIndex);
        modeloField.setText("");
        marcaField.setText("");
        anoField.setText("");
        carregarTabela();
    }

    public void onAtualizarCarro(ActionEvent actionEvent) {
        Carro carro = new Carro();
        carro.setId(selectedCarroIndex);
        carro.setModelo(modeloField.getText());
        carro.setMarca(marcaField.getText());
        int anoInt = Integer.parseInt(anoField.getText());
        carro.setAno(anoInt);

        carroController.updateCarro(carro);
        carregarTabela();

        modeloField.setText("");
        marcaField.setText("");
        anoField.setText("");
    }

    public void carregarTabela() {
        ObservableList<Carro> carros = FXCollections.observableArrayList(carroController.listarCarro());
        carroTable.setItems(carros);
    }

    public void onBuzinar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ação do Carro");
        alert.setHeaderText(null);

        if (selectedCarroIndex != 0) {
            if (isLigado){
                alert.setContentText("O carro " + modeloField.getText() + " da marca " + marcaField.getText() + " buzino!");
                alert.showAndWait();
            } else {
                alert.setContentText("O carro está desligado!");
                alert.showAndWait();
            }
        }else {
            alert.setContentText("Nenhum carro selecionado!");
            alert.showAndWait();
        }
    }

    public void onDesligar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        if (selectedCarroIndex != 0) {
            if (isLigado){
                isLigado = false;
                alert.setContentText("O carro " + modeloField.getText() + " da marca " + marcaField.getText() + " desligou!");
                alert.showAndWait();
            } else {
                alert.setContentText("O carro já está desligado!");
                alert.showAndWait();
            }
        }else {
            alert.setContentText("Nenhum carro selecionado!");
            alert.showAndWait();
        }
    }

    public void onLigar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedCarroIndex != 0) {
            if (isLigado) {
                alert.setContentText("O carro já está ligado!");
            } else {
                isLigado = true;
                alert.setContentText("O carro " + modeloField.getText() + " da marca " + marcaField.getText() + " ligou!");
            }
            alert.showAndWait();
        } else {
            alert.setContentText("Nenhum carro selecionado!");
            alert.showAndWait();
        }
    }

}
