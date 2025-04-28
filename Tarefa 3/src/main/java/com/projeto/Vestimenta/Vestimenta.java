package com.projeto.Vestimenta;

public class Vestimenta {

    private String tipo;
    private int unidades;
    private double preco;

    public Vestimenta(String tipo, int unidades, double preco) {
        this.tipo = tipo;
        this.unidades = unidades;
        this.preco = preco;
    }

    public String aumentarPrecos(double percentual) {
        this.preco += this.preco * (percentual / 100);
        return "O preço da vestimenta aumentou para: " + preco;
    }

    public int getUnidades() {
        return unidades;
    }

    public String vender(int quantidade) {
        if (quantidade > unidades) {
            return "Não há unidades suficientes para venda.";
        } else {
            unidades -= quantidade;
            return "Foram vendidas " + quantidade + " unidades. Restam " + unidades + " unidades.";
        }
    }

    Object aumentarSalario(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
