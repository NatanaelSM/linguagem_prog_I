package com.github.natanael.projlinguagem.controller.piloto;

import com.github.natanael.projlinguagem.DAO.PilotoDAO;
import com.github.natanael.projlinguagem.model.Piloto;

import java.util.List;

public class PilotoController {

    private PilotoDAO pilotoDAO = new PilotoDAO();

    public void cadastrarPiloto(String escuderia, double salario, String paisOrigem) {
        Piloto piloto = new Piloto(escuderia, salario, paisOrigem);
        pilotoDAO.cadastrar(piloto);
    }

    public void atualizarPiloto(Piloto piloto) {
        pilotoDAO.atualizar(piloto);
    }

    public void deletarPiloto(int id) {
        pilotoDAO.deletar(id);
    }

    public List<Piloto> listarPilotos() {
        return pilotoDAO.listar();
    }
}

