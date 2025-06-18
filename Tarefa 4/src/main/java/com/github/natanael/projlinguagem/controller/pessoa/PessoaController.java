package com.github.natanael.projlinguagem.controller.pessoa;

import com.github.natanael.projlinguagem.DAO.PessoaDAO;
import com.github.natanael.projlinguagem.model.Pessoa;

import java.util.List;

public class PessoaController {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void cadastrarPessoa(String sexo, double altura, String tipoSanguineo) {
        Pessoa pessoa = new Pessoa(sexo, altura, tipoSanguineo);
        pessoaDAO.cadastrar(pessoa);
    }

    public void deletarPessoa(int id) {
        pessoaDAO.deletar(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaDAO.listar();
    }

    public void atualizarPessoa(Pessoa pessoa) {
        pessoaDAO.atualizar(pessoa);
    }
}