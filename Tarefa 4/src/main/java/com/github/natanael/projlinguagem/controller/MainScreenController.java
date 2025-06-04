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

public class MainScreenController implements Initializable {

    public TextField racaField;
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

    @FXML
    public void onDeletarAnimal(ActionEvent actionEvent) {
        AnimalController animalController = new AnimalController();
        animalController.deletarAnimal(selectedAnimalIndex);
        nomeField.setText("");
        racaField.setText("");
        extintoMenu.setText("");
        carregarTabela();
    }

    @FXML
    public void onAtualizarAnimal(ActionEvent actionEvent) {
        boolean extinto = extintoMenu.getText().equals("Sim");

        Animal animal = new Animal();
        animal.setId(selectedAnimalIndex);
        animal.setNome(nomeField.getText());
        animal.setRaca(racaField.getText());
        animal.setExtinto(extinto);

        animalController.updateAnimal(animal);
        carregarTabela();

        // Limpa campos após atualizar
        nomeField.setText("");
        racaField.setText("");
        extintoMenu.setText("");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void carregarTabela() {
        ObservableList<Animal> animais = FXCollections.observableArrayList(animalController.listarAnimal());
        animalTable.setItems(animais);
    }


}
