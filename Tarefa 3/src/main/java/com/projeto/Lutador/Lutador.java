package com.projeto.Lutador;

public class Lutador {

    private String nome;
    private int idade;
    private double altura;

    public Lutador(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String lutar() {
        return nome + " está lutando!";
    }

    public String treinar() {
        return nome + " está treinando para a próxima luta!";
    }

    public String bater() {
        return nome + " deu um golpe no adversário!";
    }
}