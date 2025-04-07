package com.tarefa3.tarefa3.Pagamento;

public class Pagamento {

    private double valor;
    private String formaPagamento;
    private int parcelas;

    public Pagamento(double valor, String formaPagamento, int parcelas) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
    }

    public String realizarPagamento() {
        return "Pagamento de R$ " + valor + " realizado via " + formaPagamento + " em " + parcelas + ".";
    }

    public String cancelarPagamento() {
        return "O pagamento de R$ " + valor + " foi cancelado.";
    }

    public String exibirDetalhes() {
        return "Detalhes do pagamento:\nValor: R$ " + valor + "\nForma de pagamento: " + formaPagamento + "\nData: " + parcelas;
    }
}