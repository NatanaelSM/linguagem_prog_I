package com.github.natanael.projlinguagem.model;

public class Lutador {
    private int id;
    private String nome;
    private int idade;
    private double altura;

    public Lutador() {}

    public Lutador(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public Lutador(int id, String nome, int idade, double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
