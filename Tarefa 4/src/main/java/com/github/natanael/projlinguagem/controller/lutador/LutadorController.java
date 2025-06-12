package com.github.natanael.projlinguagem.controller.lutador;

import com.github.natanael.projlinguagem.DAO.LutadorDAO;
import com.github.natanael.projlinguagem.model.Lutador;

import java.util.List;

public class LutadorController {

    private LutadorDAO lutadorDAO = new LutadorDAO();

    public void cadastrarLutador(String nome, int idade, double altura) {
        Lutador lutador = new Lutador(nome, idade, altura);
        lutadorDAO.cadastrar(lutador);
    }

    public void deletarLutador(int id) {
        lutadorDAO.deletar(id);
    }

    public List<Lutador> listarLutadores() {
        return lutadorDAO.listar();
    }

    public void atualizarLutador(Lutador lutador) {
        lutadorDAO.atualizar(lutador);
    }
}
