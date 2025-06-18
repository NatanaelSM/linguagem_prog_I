package com.github.natanael.projlinguagem.controller.vestimenta;

import com.github.natanael.projlinguagem.model.Vestimenta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class VestimentaTabController implements Initializable {

    @FXML private TableView<Vestimenta> vestimentaTable;
    @FXML private TableColumn<Vestimenta, String> tipoColumn;
    @FXML private TableColumn<Vestimenta, Integer> unidadesColumn;
    @FXML private TableColumn<Vestimenta, Double> precoColumn;
    @FXML private TextField tipoField;
    @FXML private TextField unidadesField;
    @FXML private TextField precoField;

    private VestimentaController vestimentaController;
    private int selectedVestimentaId = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vestimentaController = new VestimentaController();

        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        unidadesColumn.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        precoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));

        vestimentaTable.setRowFactory(tv -> {
            TableRow<Vestimenta> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Vestimenta v = row.getItem();
                    selectedVestimentaId = v.getId();
                    tipoField.setText(v.getTipo());
                    unidadesField.setText(String.valueOf(v.getUnidades()));
                    precoField.setText(String.valueOf(v.getPreco()));
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarVestimenta(ActionEvent event) {
        vestimentaController.cadastrarVestimenta(
                tipoField.getText(),
                Integer.parseInt(unidadesField.getText()),
                Double.parseDouble(precoField.getText())
        );
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarVestimenta(ActionEvent event) {
        Vestimenta v = new Vestimenta(selectedVestimentaId,
                tipoField.getText(),
                Integer.parseInt(unidadesField.getText()),
                Double.parseDouble(precoField.getText()));
        vestimentaController.atualizarVestimenta(v);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarVestimenta(ActionEvent event) {
        vestimentaController.deletarVestimenta(selectedVestimentaId);
        limparCampos();
        carregarTabela();
    }

    public void onAumentarEstoque(ActionEvent event) {
        if (selectedVestimentaId != 0) {
            int unidades = Integer.parseInt(unidadesField.getText());
            unidades++;
            unidadesField.setText(String.valueOf(unidades));
            onAtualizarVestimenta(null);
            mostrarMensagem("Estoque aumentado para: " + unidades + " unidades.");
        } else {
            mostrarMensagem("Nenhuma vestimenta selecionada!");
        }
    }

    public void onPromocao(ActionEvent event) {
        if (selectedVestimentaId != 0) {
            double preco = Double.parseDouble(precoField.getText());
            preco *= 0.9; // desconto de 10%
            precoField.setText(String.valueOf(preco));
            onAtualizarVestimenta(null);
            mostrarMensagem("Preço com desconto aplicado: R$ " + preco);
        } else {
            mostrarMensagem("Nenhuma vestimenta selecionada!");
        }
    }

    public void onRemoverUnidade(ActionEvent event) {
        if (selectedVestimentaId != 0) {
            int unidades = Integer.parseInt(unidadesField.getText());
            if (unidades > 0) {
                unidades--;
                unidadesField.setText(String.valueOf(unidades));
                onAtualizarVestimenta(null);
                mostrarMensagem("Uma unidade foi removida. Estoque agora: " + unidades);
            } else {
                mostrarMensagem("Estoque já está vazio!");
            }
        } else {
            mostrarMensagem("Nenhuma vestimenta selecionada!");
        }
    }

    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Vestimenta> vestimentas = FXCollections.observableArrayList(vestimentaController.listarVestimentas());
        vestimentaTable.setItems(vestimentas);
    }

    private void limparCampos() {
        tipoField.clear();
        unidadesField.clear();
        precoField.clear();
        selectedVestimentaId = 0;
    }
}