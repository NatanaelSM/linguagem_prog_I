package com.github.natanael.projlinguagem.controller;

import com.github.natanael.projlinguagem.DAO.PagamentoDAO;
import com.github.natanael.projlinguagem.model.Pagamento;

import java.util.List;

public class PagamentoController {

    private PagamentoDAO pagamentoDAO = new PagamentoDAO();

    public void cadastrarPagamento(double valor, String formaPagamento, int parcelas) {
        Pagamento pagamento = new Pagamento(valor, formaPagamento, parcelas);
        pagamentoDAO.cadastrar(pagamento);
    }

    public void deletarPagamento(int id) {
        pagamentoDAO.deletar(id);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoDAO.listar();
    }

    public void atualizarPagamento(Pagamento pagamento) {
        pagamentoDAO.atualizar(pagamento);
    }

    public Pagamento buscarPagamentoPorId(int id) {
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        List<Pagamento> pagamentos = pagamentoDAO.listar();
        for (Pagamento p : pagamentos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
