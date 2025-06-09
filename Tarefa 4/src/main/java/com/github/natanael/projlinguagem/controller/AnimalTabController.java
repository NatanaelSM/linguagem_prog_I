package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.model.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalTabController implements Initializable {

    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn<Animal, String> nomeColumn;
    @FXML
    private TableColumn<Animal, String> racaColumn;
    @FXML
    private TableColumn<Animal, String> extintoColumn;
    @FXML
    private SplitMenuButton extintoMenu;
    @FXML
    private TextField nomeField;
    private AnimalController animalController;
    private int selectedAnimalIndex = 0;
    public TextField racaField;

    public void initialize(URL location, ResourceBundle resources) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        racaColumn.setCellValueFactory(new PropertyValueFactory<>("raca"));
        extintoColumn.setCellValueFactory(new PropertyValueFactory<>("extinto"));
        animalController = new AnimalController();

        animalTable.setRowFactory(tv -> {
            TableRow<Animal> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    Animal animalSelecionado = row.getItem();
                    nomeField.setText(animalSelecionado.getNome());
                    racaField.setText(animalSelecionado.getRaca());
                    if (animalSelecionado.getExtinto() == true) {
                        extintoMenu.setText("Sim");
                    } else {
                        extintoMenu.setText("Não");
                    }
                    selectedAnimalIndex = animalSelecionado.getId();
                }
            });
            return row;
        });
        carregarTabela();
    }

    @FXML
    private void onExtintoSim(ActionEvent event) {
        extintoMenu.setText("Sim");
    }

    @FXML
    private void onExtintoNao(ActionEvent event) {
        extintoMenu.setText("Não");
    }

    @FXML
    private void onCadastrarAnimal(ActionEvent event){
        AnimalController animalController = new AnimalController();
        boolean extinto = (extintoMenu.getText() == "Sim") ? true : false;
        animalController.cadastrarAnimal(nomeField.getText(), racaField.getText(), extinto);
        carregarTabela();
        nomeField.setText("");
        racaField.setText("");
        extintoMenu.setText("");
    }

    public void onDeletarAnimal(ActionEvent actionEvent) {
        AnimalController animalController = new AnimalController();
        animalController.deletarAnimal(selectedAnimalIndex);
        nomeField.setText("");
        racaField.setText("");
        extintoMenu.setText("");
        carregarTabela();
    }

    public void onAtualizarAnimal(ActionEvent actionEvent) {
        boolean extinto = extintoMenu.getText().equals("Sim");

        Animal animal = new Animal();
        animal.setId(selectedAnimalIndex);
        animal.setNome(nomeField.getText());
        animal.setRaca(racaField.getText());
        animal.setExtinto(extinto);

        animalController.updateAnimal(animal);
        carregarTabela();

        nomeField.setText("");
        racaField.setText("");
        extintoMenu.setText("");
    }

    public void carregarTabela() {
        ObservableList<Animal> animais = FXCollections.observableArrayList(animalController.listarAnimal());
        animalTable.setItems(animais);
    }

    public void onComer(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ação do Animal");
        alert.setHeaderText(null);

        if (selectedAnimalIndex != 0) {
            if (extintoMenu.getText().equals("Não")) {
                alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " comeu!");
                alert.showAndWait();
            }else {
                alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " está extinto e não pode comer!");
                alert.showAndWait();
            }
        }else{
            alert.setContentText("Nenhum animal selecionado!");
            alert.showAndWait();
        }

    }

    public void onEmitirSom(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ação do Animal");
        alert.setHeaderText(null);

        if (extintoMenu.getText().equals("Não")) {
            alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " emitiu som!");
            alert.showAndWait();
        }else {
            alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " está extinto e não pode emitir som!");
            alert.showAndWait();
        }
    }

    public void onMover(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ação do Animal");
        alert.setHeaderText(null);

        if (extintoMenu.getText().equals("Não")) {
            alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " se moveu!");
            alert.showAndWait();
        }else {
            alert.setContentText("O animal " + nomeField.getText() + " da raça " + racaField.getText() + " está extinto e não pode se mover!");
            alert.showAndWait();
        }
    }
}
