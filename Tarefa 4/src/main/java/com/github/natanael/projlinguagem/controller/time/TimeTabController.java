package com.github.natanael.projlinguagem.controller.time;

import com.github.natanael.projlinguagem.model.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TimeTabController implements Initializable {

    public TableView<Time> timeTable;
    @FXML private TableColumn<Time, String> nomeColumn;
    @FXML private TableColumn<Time, Integer> numJogadoresColumn;
    @FXML private TableColumn<Time, String> estadoColumn;
    @FXML private TextField nomeField;
    @FXML private TextField numJogadoresField;
    @FXML private TextField estadoField;

    private TimeController timeController;
    private int selectedTimeId = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        numJogadoresColumn.setCellValueFactory(new PropertyValueFactory<>("numJogadores"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

        timeController = new TimeController();

        timeTable.setRowFactory(tv -> {
            TableRow<Time> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Time t = row.getItem();
                    selectedTimeId = t.getId();
                    nomeField.setText(t.getNome());
                    numJogadoresField.setText(String.valueOf(t.getNumJogadores()));
                    estadoField.setText(t.getEstado());
                }
            });
            return row;
        });

        carregarTabela();
    }

    public void onCadastrarTime(ActionEvent event) {
        String nome = nomeField.getText();
        int numJogadores = Integer.parseInt(numJogadoresField.getText());
        String estado = estadoField.getText();

        timeController.cadastrarTime(nome, numJogadores, estado);
        limparCampos();
        carregarTabela();
    }

    public void onAtualizarTime(ActionEvent event) {
        Time t = new Time(selectedTimeId, nomeField.getText(),
                Integer.parseInt(numJogadoresField.getText()), estadoField.getText());
        timeController.atualizarTime(t);
        limparCampos();
        carregarTabela();
    }

    public void onDeletarTime(ActionEvent event) {
        timeController.deletarTime(selectedTimeId);
        limparCampos();
        carregarTabela();
    }

    public void onJogar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedTimeId != 0) {
            alert.setContentText("O time \"" + nomeField.getText() + "\" está jogando!");
        } else {
            alert.setContentText("Nenhum time selecionado!");
        }

        alert.showAndWait();
    }

    public void onComprarJogador(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedTimeId != 0) {
            // Recupera os dados atuais
            String nome = nomeField.getText();
            String estado = estadoField.getText();
            int numJogadores = Integer.parseInt(numJogadoresField.getText());

            // Incrementa o número de jogadores
            numJogadores++;

            // Atualiza o campo de texto na interface
            numJogadoresField.setText(String.valueOf(numJogadores));

            // Atualiza o objeto e salva no banco
            Time timeAtualizado = new Time(selectedTimeId, nome, numJogadores, estado);
            timeController.atualizarTime(timeAtualizado);

            // Atualiza a tabela
            carregarTabela();

            alert.setContentText("Um jogador foi comprado. O número de jogadores agora é " + numJogadores + "!");
        } else {
            alert.setContentText("Nenhum time selecionado!");
        }

        alert.showAndWait();
    }


    public void onVenderJogador(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);

        if (selectedTimeId != 0) {
            // Recupera os dados atuais
            String nome = nomeField.getText();
            String estado = estadoField.getText();
            int numJogadores = Integer.parseInt(numJogadoresField.getText());

            // Garante que não fique abaixo de zero
            if (numJogadores > 0) {
                numJogadores--;

                // Atualiza o campo de texto na interface
                numJogadoresField.setText(String.valueOf(numJogadores));

                // Atualiza o objeto e salva no banco
                Time timeAtualizado = new Time(selectedTimeId, nome, numJogadores, estado);
                timeController.atualizarTime(timeAtualizado);

                // Atualiza a tabela
                carregarTabela();

                alert.setContentText("Um jogador foi vendido. O número de jogadores agora é " + numJogadores + "!");
            } else {
                alert.setContentText("O time \"" + nome + "\" já não tem jogadores para vender.");
            }
        } else {
            alert.setContentText("Nenhum time selecionado!");
        }

        alert.showAndWait();
    }



    private void carregarTabela() {
        ObservableList<Time> times = FXCollections.observableArrayList(timeController.listarTimes());
        timeTable.setItems(times);
    }

    private void limparCampos() {
        nomeField.setText("");
        numJogadoresField.setText("");
        estadoField.setText("");
        selectedTimeId = 0;
    }
}
