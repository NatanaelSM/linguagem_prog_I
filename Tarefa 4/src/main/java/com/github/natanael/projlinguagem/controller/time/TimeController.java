package com.github.natanael.projlinguagem.controller.time;

import com.github.natanael.projlinguagem.DAO.TimeDAO;
import com.github.natanael.projlinguagem.model.Time;

import java.util.List;

public class TimeController {

    private TimeDAO timeDAO = new TimeDAO();

    public void cadastrarTime(String nome, int numJogadores, String estado) {
        Time time = new Time(nome, numJogadores, estado);
        timeDAO.cadastrar(time);
    }

    public void deletarTime(int id) {
        timeDAO.deletar(id);
    }

    public List<Time> listarTimes() {
        return timeDAO.listar();
    }

    public void atualizarTime(Time time) {
        timeDAO.atualizar(time);
    }
}
