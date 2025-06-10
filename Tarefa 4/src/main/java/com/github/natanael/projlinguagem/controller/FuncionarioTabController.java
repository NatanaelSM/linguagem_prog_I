package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FuncionarioTabController implements Initializable {

    public TableView<Funcionario> funcionarioTable;
    @FXML private TableColumn<Funcionario, String> nomeColumn;
    @FXML private TableColumn<Funcionario, Double> salarioColumn;
    @FXML private TableColumn<Funcionario, String> sexoColumn;
    @FXML private TextField nomeField;
    @FXML private TextField salarioField;
    @FXML private TextField sexoField;

    private FuncionarioController funcionarioController;
    private int selectedFuncionarioId = 0;

    private boolean emServico = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        salarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        funcionarioController = new FuncionarioController();
        funcionarioTable.setRowFactory(tv -> {
            TableRow<Funcionario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Funcionario f = row.getItem();
                    selectedFuncionarioId = f.getId();
                    nomeField.setText(f.getNome());
                    salarioField.setText(String.valueOf(f.getSalario()));
                    sexoField.setText(f.getSexo());
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarFuncionario(ActionEvent event) {
        String nome = nomeField.getText();
        double salario = Double.parseDouble(salarioField.getText());
        String sexo = sexoField.getText();

        funcionarioController.cadastrarFuncionario(nome, salario, sexo);
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarFuncionario(ActionEvent event) {
        Funcionario f = new Funcionario(selectedFuncionarioId, nomeField.getText(),
                Double.parseDouble(salarioField.getText()), sexoField.getText());
        funcionarioController.atualizarFuncionario(f);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarFuncionario(ActionEvent event) {
        funcionarioController.deletarFuncionario(selectedFuncionarioId);
        limparCampos();
        carregarTabela();
    }

    public void onEntrarServico(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedFuncionarioId != 0) {
            if (emServico) {
                alert.setContentText("Funcionário já está em serviço!");
            } else {
                emServico = true;
                alert.setContentText("Funcionário entrou em serviço!");
            }
        } else {
            alert.setContentText("Nenhum funcionário selecionado!");
        }

        alert.showAndWait();
    }

    public void onAlmocar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedFuncionarioId != 0) {
            alert.setContentText("Funcionário " + nomeField.getText() + " está almoçando!");
        } else {
            alert.setContentText("Nenhum funcionário selecionado!");
        }

        alert.showAndWait();
    }

    public void onAumentarSalario(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedFuncionarioId != 0) {
            double salario = Double.parseDouble(salarioField.getText());
            salario += 500;
            salarioField.setText(String.valueOf(salario));
            onAtualizarFuncionario(null);
            alert.setContentText("Salário aumentado para R$" + salario);
        } else {
            alert.setContentText("Nenhum funcionário selecionado!");
        }

        alert.showAndWait();
    }

    private void carregarTabela() {
        ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList(funcionarioController.listarFuncionarios());
        funcionarioTable.setItems(funcionarios);
    }

    private void limparCampos() {
        nomeField.setText("");
        salarioField.setText("");
        sexoField.setText("");
        selectedFuncionarioId = 0;
    }
}
