package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.DAO.AnimalDAO;
import com.github.natanael.projlinguagem.model.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AnimalController {

    private AnimalDAO animalDAO;
    private Animal animal;
    @FXML
    private Button btnCadastrarAnimal;

    public AnimalController(String nome, String raca, Boolean extinto) {
        this.animal = new Animal(raca, extinto, nome);
        this.animalDAO = new AnimalDAO();
    }

    public void cadastrarAnimal() {
        animalDAO.cadastrar(animal);
    }

}
