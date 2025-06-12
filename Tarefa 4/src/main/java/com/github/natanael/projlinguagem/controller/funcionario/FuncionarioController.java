package com.github.natanael.projlinguagem.controller.funcionario;

import com.github.natanael.projlinguagem.DAO.FuncionarioDAO;
import com.github.natanael.projlinguagem.model.Funcionario;

import java.util.List;

public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrarFuncionario(String nome, double salario, String sexo) {
        Funcionario funcionario = new Funcionario(nome, salario, sexo);
        funcionarioDAO.cadastrar(funcionario);
    }

    public void deletarFuncionario(int id) {
        funcionarioDAO.deletar(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listar();
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizar(funcionario);
    }
}
