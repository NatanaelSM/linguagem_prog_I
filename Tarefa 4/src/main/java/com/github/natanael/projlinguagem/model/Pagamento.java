package com.github.natanael.projlinguagem.model;

public class Pagamento {
    private int id;
    private double valor;
    private String formaPagamento;
    private int parcelas;

    public Pagamento() {}

    public Pagamento(double valor, String formaPagamento, int parcelas) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
    }

    public Pagamento(int id, double valor, String formaPagamento, int parcelas) {
        this.id = id;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }
}
