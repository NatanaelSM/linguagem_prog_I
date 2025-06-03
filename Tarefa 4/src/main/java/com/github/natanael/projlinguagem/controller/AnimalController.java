package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.DAO.AnimalDAO;
import com.github.natanael.projlinguagem.model.Animal;

public class AnimalController {

    private AnimalDAO animalDAO = new AnimalDAO();

    public void cadastrarAnimal(String nome, String raca, boolean extinto) {
        Animal animal = new Animal(raca, extinto, nome);
        animalDAO.cadastrar(animal);
    }

    public void deletarAnimal(int id) {
        animalDAO.deletar(id);
    }

    public void listarAnimal() {
        animalDAO.listar();
    }
}
