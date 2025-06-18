package com.github.natanael.projlinguagem.model;

public class Piloto {
    private int id;
    private String escuderia;
    private double salario;
    private String paisOrigem;

    public Piloto() {}

    public Piloto(String escuderia, double salario, String paisOrigem) {
        this.escuderia = escuderia;
        this.salario = salario;
        this.paisOrigem = paisOrigem;
    }

    public Piloto(int id, String escuderia, double salario, String paisOrigem) {
        this.id = id;
        this.escuderia = escuderia;
        this.salario = salario;
        this.paisOrigem = paisOrigem;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEscuderia() { return escuderia; }
    public void setEscuderia(String escuderia) { this.escuderia = escuderia; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }
}
