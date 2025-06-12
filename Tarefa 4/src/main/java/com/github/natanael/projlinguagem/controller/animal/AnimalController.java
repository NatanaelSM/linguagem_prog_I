package com.github.natanael.projlinguagem.controller.animal;

import com.github.natanael.projlinguagem.DAO.AnimalDAO;
import com.github.natanael.projlinguagem.model.Animal;

import java.util.List;

public class AnimalController {

    private AnimalDAO animalDAO = new AnimalDAO();

    public void cadastrarAnimal(String nome, String raca, boolean extinto) {
        Animal animal = new Animal(raca, extinto, nome);
        animalDAO.cadastrar(animal);
    }

    public void deletarAnimal(int id) {
        animalDAO.deletar(id);
    }

    public List<Animal> listarAnimal() {
        return animalDAO.listar();
    }

    public void updateAnimal(Animal animal) {
        animalDAO.atualizar(animal);
    }
}
