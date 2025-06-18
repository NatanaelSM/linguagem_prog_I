package com.github.natanael.projlinguagem.controller.endereco;

import com.github.natanael.projlinguagem.DAO.EnderecoDAO;
import com.github.natanael.projlinguagem.model.Endereco;

import java.util.List;

public class EnderecoController {
    private EnderecoDAO dao = new EnderecoDAO();

    public void cadastrarEndereco(String rua, int numero, String bairro) {
        dao.cadastrar(new Endereco(rua, numero, bairro));
    }

    public void atualizarEndereco(Endereco e) {
        dao.atualizar(e);
    }

    public void deletarEndereco(int id) {
        dao.deletar(id);
    }

    public List<Endereco> listarEnderecos() {
        return dao.listar();
    }
}
