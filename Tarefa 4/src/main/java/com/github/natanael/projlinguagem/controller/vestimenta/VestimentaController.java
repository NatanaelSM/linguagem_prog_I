package com.github.natanael.projlinguagem.controller.vestimenta;

import com.github.natanael.projlinguagem.DAO.VestimentaDAO;
import com.github.natanael.projlinguagem.model.Vestimenta;

import java.util.List;

public class VestimentaController {

    private VestimentaDAO vestimentaDAO = new VestimentaDAO();

    public void cadastrarVestimenta(String tipo, int unidades, double preco) {
        Vestimenta v = new Vestimenta(tipo, unidades, preco);
        vestimentaDAO.cadastrar(v);
    }

    public void atualizarVestimenta(Vestimenta vestimenta) {
        vestimentaDAO.atualizar(vestimenta);
    }

    public void deletarVestimenta(int id) {
        vestimentaDAO.deletar(id);
    }

    public List<Vestimenta> listarVestimentas() {
        return vestimentaDAO.listar();
    }
}

