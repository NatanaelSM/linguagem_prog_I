package com.github.natanael.projlinguagem.model;

public class Time {
    private int id;
    private String nome;
    private int numJogadores;
    private String estado;

    public Time() {
    }

    public Time(String nome, int numJogadores, String estado) {
        this.nome = nome;
        this.numJogadores = numJogadores;
        this.estado = estado;
    }
    public Time(int id, String nome, int numJogadores, String estado) {
        this.id = id;
        this.nome = nome;
        this.numJogadores = numJogadores;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
