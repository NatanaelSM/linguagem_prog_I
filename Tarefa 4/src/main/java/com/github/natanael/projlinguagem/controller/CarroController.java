package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.DAO.CarroDao;
import com.github.natanael.projlinguagem.model.Carro;

import java.util.List;

public class CarroController {

    private CarroDao carroDao = new CarroDao();

    public void cadastrarCarro(String modelo, String marca, int ano) {
        Carro carro = new Carro(modelo, marca, ano);
        carroDao.cadastrar(carro);
    }

    public void deletarCarro(int id) {
        carroDao.deletar(id);
    }

    public List<Carro> listarCarro() {
        return carroDao.listar();
    }

    public void updateCarro(Carro carro) {
        carroDao.atualizar(carro);
    }

}
