package com.github.natanael.projlinguagem.controller.pessoa;

import com.github.natanael.projlinguagem.model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PessoaTabController implements Initializable {

    public TableView<Pessoa> pessoaTable;
    @FXML private TableColumn<Pessoa, String> sexoColumn;
    @FXML private TableColumn<Pessoa, Double> alturaColumn;
    @FXML private TableColumn<Pessoa, String> tipoSanguineoColumn;

    @FXML private TextField sexoField;
    @FXML private TextField alturaField;
    @FXML private TextField tipoSanguineoField;

    private PessoaController pessoaController;
    private int selectedPessoaId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexoColumn.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        alturaColumn.setCellValueFactory(new PropertyValueFactory<>("altura"));
        tipoSanguineoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));

        pessoaController = new PessoaController();

        pessoaTable.setRowFactory(tv -> {
            TableRow<Pessoa> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Pessoa p = row.getItem();
                    selectedPessoaId = p.getId();
                    sexoField.setText(p.getSexo());
                    alturaField.setText(String.valueOf(p.getAltura()));
                    tipoSanguineoField.setText(p.getTipoSanguineo());
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarPessoa(ActionEvent event) {
        String sexo = sexoField.getText();
        double altura = Double.parseDouble(alturaField.getText());
        String tipo = tipoSanguineoField.getText();

        pessoaController.cadastrarPessoa(sexo, altura, tipo);
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarPessoa(ActionEvent event) {
        Pessoa p = new Pessoa(selectedPessoaId, sexoField.getText(),
                Double.parseDouble(alturaField.getText()), tipoSanguineoField.getText());
        pessoaController.atualizarPessoa(p);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarPessoa(ActionEvent event) {
        pessoaController.deletarPessoa(selectedPessoaId);
        limparCampos();
        carregarTabela();
    }

    public void onComer(ActionEvent event) {
        Pessoa pessoaSelecionada = pessoaTable.getSelectionModel().getSelectedItem();
        if (pessoaSelecionada != null) {
            String mensagem = String.format("A pessoa do sexo %s, com altura %.2f e tipo sanguíneo %s está comendo.",
                    pessoaSelecionada.getSexo(), pessoaSelecionada.getAltura(), pessoaSelecionada.getTipoSanguineo());
            mostrarMensagem(mensagem);
        } else {
            mostrarMensagem("Nenhuma pessoa selecionada.");
        }
    }

    public void onCorrer(ActionEvent event) {
        Pessoa pessoaSelecionada = pessoaTable.getSelectionModel().getSelectedItem();
        if (pessoaSelecionada != null) {
            String mensagem = String.format("A pessoa do sexo %s, com altura %.2f e tipo sanguíneo %s está correndo.",
                    pessoaSelecionada.getSexo(), pessoaSelecionada.getAltura(), pessoaSelecionada.getTipoSanguineo());
            mostrarMensagem(mensagem);
        } else {
            mostrarMensagem("Nenhuma pessoa selecionada.");
        }
    }

    public void onLevantar(ActionEvent event) {
        Pessoa pessoaSelecionada = pessoaTable.getSelectionModel().getSelectedItem();
        if (pessoaSelecionada != null) {
            String mensagem = String.format("A pessoa do sexo %s, com altura %.2f e tipo sanguíneo %s se levantou.",
                    pessoaSelecionada.getSexo(), pessoaSelecionada.getAltura(), pessoaSelecionada.getTipoSanguineo());
            mostrarMensagem(mensagem);
        } else {
            mostrarMensagem("Nenhuma pessoa selecionada.");
        }
    }


    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Pessoa> pessoas = FXCollections.observableArrayList(pessoaController.listarPessoas());
        pessoaTable.setItems(pessoas);
    }

    private void limparCampos() {
        sexoField.setText("");
        alturaField.setText("");
        tipoSanguineoField.setText("");
        selectedPessoaId = 0;
    }
}
