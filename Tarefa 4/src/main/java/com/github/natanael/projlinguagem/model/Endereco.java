package com.github.natanael.projlinguagem.model;

public class Endereco {
    private int id;
    private int numero;
    private String rua;
    private String bairro;

    public Endereco() {}

    public Endereco(String rua, int numero, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public Endereco(int id, String rua, int numero, String bairro) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
}
