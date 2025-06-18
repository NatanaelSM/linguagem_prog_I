package com.github.natanael.projlinguagem.model;

public class Vestimenta {
    private int id;
    private String tipo;
    private int unidades;
    private double preco;

    public Vestimenta() {}

    public Vestimenta(String tipo, int unidades, double preco) {
        this.tipo = tipo;
        this.unidades = unidades;
        this.preco = preco;
    }

    public Vestimenta(int id, String tipo, int unidades, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.unidades = unidades;
        this.preco = preco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
