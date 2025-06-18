package com.github.natanael.projlinguagem.controller.endereco;

import com.github.natanael.projlinguagem.model.Endereco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EnderecoTabController implements Initializable {

    @FXML private TableView<Endereco> enderecoTable;
    @FXML private TableColumn<Endereco, String> ruaColumn;
    @FXML private TableColumn<Endereco, Integer> numeroColumn;
    @FXML private TableColumn<Endereco, String> bairroColumn;
    @FXML private TextField ruaField;
    @FXML private TextField numeroField;
    @FXML private TextField bairroField;

    private EnderecoController controller = new EnderecoController();
    private int selectedId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ruaColumn.setCellValueFactory(new PropertyValueFactory<>("rua"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        bairroColumn.setCellValueFactory(new PropertyValueFactory<>("bairro"));

        enderecoTable.setRowFactory(tv -> {
            TableRow<Endereco> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if (!row.isEmpty()) {
                    Endereco endereco = row.getItem();
                    selectedId = endereco.getId();
                    ruaField.setText(endereco.getRua());
                    numeroField.setText(String.valueOf(endereco.getNumero()));
                    bairroField.setText(endereco.getBairro());
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarEndereco(ActionEvent event) {
        controller.cadastrarEndereco(
                ruaField.getText(),
                Integer.parseInt(numeroField.getText()),
                bairroField.getText()
        );
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarEndereco(ActionEvent event) {
        Endereco endereco = new Endereco(selectedId,
                ruaField.getText(),
                Integer.parseInt(numeroField.getText()),
                bairroField.getText());
        controller.atualizarEndereco(endereco);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarEndereco(ActionEvent event) {
        controller.deletarEndereco(selectedId);
        limparCampos();
        carregarTabela();
    }

    public void onExibirEndereco(ActionEvent event) {
        if (selectedId != 0) {
            mostrarMensagem("Endereço: Rua " + ruaField.getText() + ", Nº " + numeroField.getText() + ", Bairro: " + bairroField.getText());
        } else {
            mostrarMensagem("Nenhum endereço selecionado!");
        }
    }

    public void onAbreviado(ActionEvent event) {
        if (selectedId != 0) {
            mostrarMensagem("End.: " + ruaField.getText() + ", Nº" + numeroField.getText());
        } else {
            mostrarMensagem("Nenhum endereço selecionado!");
        }
    }

    public void onVerificarNacionalidade(ActionEvent event) {
        if (selectedId != 0) {
            String bairro = bairroField.getText().trim().toLowerCase();

            // Lista de bairros brasileiros comuns (pode expandir conforme desejar)
            String[] bairrosBrasileiros = {
                    "copacabana", "ipiranga", "mooca", "pinheiros", "barra da tijuca",
                    "lapa", "botafogo", "tijuca", "grajaú", "liberdade", "bixiga", "perdizes"
            };

            boolean encontrado = false;
            for (String b : bairrosBrasileiros) {
                if (bairro.equals(b)) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                mostrarMensagem("Endereço nacional identificado. Bairro: " + bairroField.getText());
            } else {
                mostrarMensagem("Bairro não reconhecido como nacional. Pode ser internacional.");
            }
        } else {
            mostrarMensagem("Nenhum endereço selecionado!");
        }
    }

    private void carregarTabela() {
        ObservableList<Endereco> lista = FXCollections.observableArrayList(controller.listarEnderecos());
        enderecoTable.setItems(lista);
    }

    private void limparCampos() {
        ruaField.clear();
        numeroField.clear();
        bairroField.clear();
        selectedId = 0;
    }

    private void mostrarMensagem(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
